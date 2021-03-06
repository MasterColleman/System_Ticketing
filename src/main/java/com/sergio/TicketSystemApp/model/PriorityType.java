package com.sergio.TicketSystemApp.model;

public enum PriorityType {

    low("Baja"),
    medium("Media"),
    high("Alta"),
    urgent("Urgente");

    private final String priorityType;

    PriorityType(String priorityType) {
        this.priorityType = priorityType;
    }

    public String getPriorityType() {
        return priorityType;
    }

    @Override
    public String toString() {
        return getPriorityType();
    }

}
