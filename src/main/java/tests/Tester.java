package tests;

import com.sergio.TicketSystemApp.model.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


public class Tester {

    //private TicketPriority ticketPriority;
    private int deadLineTime;
    private int deadLineTimeDays;
    private List<String> timeByState;
    //Horario Laborable
    private static final LocalTime startTimeOfDay =  LocalTime.of(8, 00);
    private static final LocalTime endTimeOfDay =  LocalTime.of(20, 00);
    private static final int laborableHoursOfDay = 12;

    public void setDeadLineTime(com.sergio.TicketSystemApp.model.TicketPriority ticketPriority) {
        this.deadLineTime = ticketPriority.getTimeForPriority();
    }

    public int getDeadlineTimeAtAnyTime(LocalDateTime ticketCreationDate, TicketPriority ticketPriority, StateType stateTypeIn) {
        int time = 0; int count = 0;
        if(((validateDeadLineTime(this.deadLineTime)!=-1) )){
            LocalDateTime dateTimeNow = LocalDateTime.now();//Fecha-Tiempo en este instante
            LocalTime timeNow = LocalTime.ofSecondOfDay(dateTimeNow.getHour());//Hora de la Fecha-Tiempo instantanea
            if ((dateTimeNow != ticketCreationDate) && (timeNow.getHour() >= startTimeOfDay.getHour() && timeNow.getHour() <= endTimeOfDay.getHour())) {
                time -= (Math.abs(startTimeOfDay.getHour() - timeNow.getHour()));
                this.deadLineTime = time;
            } else {
                if ((ticketCreationDate == dateTimeNow) && (timeNow.getHour() >= startTimeOfDay.getHour() && timeNow.getHour() <= endTimeOfDay.getHour())) {
                    time -= (Math.abs(ticketCreationDate.getHour() - timeNow.getHour()));
                    this.deadLineTime = time;
                }
            }
        }else
        if(count<1){//Aqui se resetea el plazo de entrega una sola vez de ser necesario
            count++;
            ticketPriority.setTimePriorityByState(stateTypeIn, this.deadLineTime);
            setDeadLineTime(ticketPriority);
            getDeadlineTimeAtAnyTime(ticketCreationDate, ticketPriority, stateTypeIn);
        }
        return time;
    }

    public int validateDeadLineTime(int deadLineTimeNow){
        if(deadLineTimeNow==0){
            deadLineTimeNow = -1;
        }
        return deadLineTimeNow;
    }
    public void setTimeByState(TicketStatus ticketStatus, TicketDeadline ticketDeadline,
                            LocalDateTime ticketCreationDate, TicketPriority ticketPriority, StateType stateTypeIn){
        timeByState = new ArrayList<>();
        int totalTime =0;
        int timeStop = (ticketPriority.getTimeForPriority()
                - ticketDeadline.getDeadlineTimeAtAnyTime(ticketCreationDate, ticketPriority, stateTypeIn));
        switch (ticketStatus.getActualState()) {
            case openByUser-> timeByState.set(0,timeStop + " h");
            case inProcessing-> timeByState.set(1,timeStop + " h");
            case awaitingAssignmentAndResponse-> timeByState.set(2,timeStop + " h");
            case atReceptionDiagnosis-> timeByState.set(3,timeStop + " h");
            case inTestingReview-> timeByState.set(4,timeStop + " h");
        }
        totalTime += timeStop;
    }
}
