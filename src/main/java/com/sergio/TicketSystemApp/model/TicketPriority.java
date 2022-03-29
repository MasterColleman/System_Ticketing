package com.sergio.TicketSystemApp.model;

public class TicketPriority {

    private PriorityType priority;
    private int timeForPriority;//medida en horas
    private StateType stateType;
    private int count = 0;

    public void setTimePriorityAuto(){//setea el tiempo de prioridad del plazo de entrega (en horas) de acuerdo a la prioridad
        PriorityType priority = this.priority;
        switch (priority) {
            case low -> this.timeForPriority = 32;
            case medium -> this.timeForPriority = 24;
            case high -> this.timeForPriority = 16;
            case urgent -> this.timeForPriority = 6;
        }
    }

    public void setPriority(PriorityType priority) {
        this.priority = priority;
    }

    public PriorityType getPriority() {
        return priority;
    }

    public void setTimeForPriority(int timeForPriority) {//seteo del tiempo de prioridad para el plazo de entrega manualmente
        PriorityType priority = this.priority;
        if(count<1)
            switch (priority) {
                case low:
                    if(timeForPriority<=32)
                        this.timeForPriority = timeForPriority;
                case medium:
                    if(timeForPriority<=24)
                        this.timeForPriority = timeForPriority;
                case high:
                    if(timeForPriority<=16)
                        this.timeForPriority = timeForPriority;
                case urgent:
                    if(timeForPriority<=6)
                        this.timeForPriority = timeForPriority;
            }
    }

    public void setTimePriorityByState(StateType stateTypeIn, int deadlineTime){//TRY CATCH
        //Expange el tiempo de prioridad para el plazo de entrega cuando este ya se ha cumplido (0h restantes)
        this.count++;
        if(stateTypeIn != stateType.concluded && deadlineTime == 0 && count < 2){
            this.setTimePriorityAuto();
        }
    }

    public int getTimeForPriority() {
        return timeForPriority;
    }

}
