package com.sergio.TicketSystemApp.views.ticketInfo.components;

import javax.swing.*;
import java.awt.*;

public class RectInfo extends JPanel {
    private final JLabel label;
    private Color color;
    private Color colorDisabled;
    private Color colorEnabled;

    public RectInfo(String text, Color color) {
        colorDisabled = Color.LIGHT_GRAY;
        colorEnabled = color;
        label = new JLabel(text);
        this.color = color;
        setLayout(new GridLayout(1, 1));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        add(label);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        g.fillRect(0, 0, getWidth(), getHeight());
    }

    public void disableComponent() {
        label.setEnabled(false);
        color = colorDisabled;
        repaint();
    }

    public void enableComponent() {
        label.setEnabled(true);
        this.color = colorEnabled;
        repaint();
    }
}