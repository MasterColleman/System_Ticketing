package com.sergio.TicketSystemApp.model;

import java.time.LocalDateTime;

public class ItemReplicaBox {


    private String boxTitle;
    private String boxSubtitle;
    private String boxTitleDescription;
    private String boxNewsDateAndTime;
    private String boxContent;

    public ItemReplicaBox(String boxTitle, String boxSubtitle, String boxTitleDescription, String boxNewsDateAndTime, String boxContent) {
        this.boxTitle = boxTitle;
        this.boxSubtitle = boxSubtitle;
        this.boxTitleDescription = boxTitleDescription;
        this.boxNewsDateAndTime = boxNewsDateAndTime;
        this.boxContent = boxContent;
    }

    public ItemReplicaBox() {
        this.boxTitle = "";
        this.boxSubtitle = "";
        this.boxTitleDescription = "";
        this.boxNewsDateAndTime = "";
        this.boxContent = "";
    }

    public String getBoxTitle() {
        return boxTitle;
    }

    public String getBoxSubtitle() {
        return boxSubtitle;
    }

    public String getBoxTitleDescription() {
        return boxTitleDescription;
    }

    public String getBoxNewsDateAndTime() {
        return boxNewsDateAndTime;
    }

    public String getBoxContent() {
        return boxContent;
    }

    public void setBoxTitle(String boxTitle) {
        this.boxTitle = boxTitle;
    }

    public void setBoxSubtitle(String boxSubtitle) {
        this.boxSubtitle = boxSubtitle;
    }

    public void setBoxTitleDescription(String boxTitleDescription) {
        this.boxTitleDescription = boxTitleDescription;
    }

    public void setBoxNewsDateAndTime() {
        String boxNewsDateAndTime = "Novedad creada a las ";
        LocalDateTime dateTimeActual = LocalDateTime.now();
        int hour = dateTimeActual.getHour(), minute = dateTimeActual.getMinute(), day = dateTimeActual.getDayOfMonth();
        String dayOfWeek = String.valueOf(dateTimeActual.getDayOfWeek()), monthOfYear = String.valueOf(dateTimeActual.getMonth());
        int year = dateTimeActual.getYear();
        boxNewsDateAndTime += hour + ":" + minute;
            if(hour>=12)
                boxNewsDateAndTime+= " PM";
            else
                boxNewsDateAndTime+= " AM";
        boxNewsDateAndTime+= " el " + dayOfWeek + " " + day + " de " + monthOfYear + " del " + year;
        this.boxNewsDateAndTime = boxNewsDateAndTime;
    }

    public void setBoxContent(String boxContent) {
        this.boxContent = boxContent;
    }

}
