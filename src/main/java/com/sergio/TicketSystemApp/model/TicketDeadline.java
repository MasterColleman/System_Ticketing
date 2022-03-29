package com.sergio.TicketSystemApp.model;

public class TicketDeadline {

    private int deadLineTime;
    //private PriorityType priorityType;

    public void setDeadLineTime(TicketPriority ticketPriority) {
        this.deadLineTime = ticketPriority.getTimeForPriority();
    }



    public int getDeadLineTime() {
        return deadLineTime;
    }

}
