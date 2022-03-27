package com.sergio.TicketSystemApp.utils;

public class StringUtils {

    // transform simple string to html string
    public static String toHtml(String text) {
        return "<html>" + text.replace("\n", "<br>") + "</html>";
    }
}
