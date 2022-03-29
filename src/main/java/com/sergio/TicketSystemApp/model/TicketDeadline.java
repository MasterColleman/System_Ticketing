package com.sergio.TicketSystemApp.model;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class TicketDeadline {

    private int deadLineTime;
    private int deadLineTimeDays;
    //Horario Laborable
    private static final LocalTime startTimeOfDay =  LocalTime.of(8, 00);
    private static final LocalTime endTimeOfDay =  LocalTime.of(20, 00);
    private static final int laborableHoursOfDay = 12;

    //Este metodo solo se USA UNA VEZ AL PRINCIPIO y UNA SOLA VEZ MAS AL REINICIO DEL PLAZO DE ENTREGA
    public void setDeadLineTime(TicketPriority ticketPriority) {
        this.deadLineTime = ticketPriority.getTimeForPriority();
    }

    //>>>>Este Metodo solo debe FUNCIONAR o EJECUTARSE cuando se oprima el boton ACTUALIZAR del ticket o del tablero de tickets<<<
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

    /*public int validateDeadLineTimeDays(int deadLineTimeDaysNow){
        if(deadLineTimeDaysNow==0){
            deadLineTimeDaysNow = -1;
        }
        return deadLineTimeDaysNow;
    }


    public int getDeadlineTimeDaysAtAnyTime(LocalDateTime ticketCreationDate) {
        int i=0;
        return i;
    }

    public void setDaysOfdeadLineTime(){
        int days = (int)(deadLineTime/laborableHoursOfDay);
        this.deadLineTimeDays = days;
    }*/

}
