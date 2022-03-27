package com.sergio.TicketSystemApp.views.home;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class HomeListener extends MouseAdapter {

    private static HomeListener instance;

    public static HomeListener getInstance() {
        if (instance == null) {
            instance = new HomeListener();
        }
        return instance;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        switch (e.getComponent().getName()) {
            case "btnSystem" -> JPanelHome.getInstance().setVisibleSystemPanel();
            case "btnCreate" -> JPanelHome.getInstance().setVisibleCreatePanel();
            case "btnSearch" -> JPanelHome.getInstance().setVisibleSearchPanel();
        }

    }
}
