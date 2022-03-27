package com.sergio.TicketSystemApp.controllers;

import java.util.List;

public class Controller {
    private static Controller instance;

    private Controller() {
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public List<?> getTickets() {
        // TODO: implement
        return null;
    }
}
