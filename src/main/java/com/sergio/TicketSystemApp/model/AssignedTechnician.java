package com.sergio.TicketSystemApp.model;

public enum AssignedTechnician {

    AgentOne("Sergio Suarez"),
    AgentTwo("David Rodriguez"),
    AgentThree("Ivan Samael"),
    AgentFour("Cristian Sanchez"),
    AgentFive("Leonardo Suarez"),
    ;

    private final String assignedTechnician;

    AssignedTechnician(String assignedTechnician) {
        this.assignedTechnician = assignedTechnician;
    }

    public String getAssignedTechnician() {
        return assignedTechnician;
    }

    @Override
    public String toString() {
        return getAssignedTechnician();
    }
}
