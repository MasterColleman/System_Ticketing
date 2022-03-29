package com.sergio.TicketSystemApp.views.ticketInfo.components;

import javax.swing.*;
import java.awt.*;

public class RectInfo extends JPanel {
    private final JLabel label;
    private Color color;
    private Color colorDisabled;
    private Color colorEnabled;

    public RectInfo(String text, Color color) {
        setBackground(Color.WHITE);
        colorDisabled = Color.LIGHT_GRAY;
        colorEnabled = color;
        label = new JLabel(text);
        label.setForeground(new Color(0x47546A));
        this.color = color;
        setLayout(new GridLayout(1, 1));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        this.disableComponent();
        add(label);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        int[] xPoints = {0, getWidth() - 10, getWidth(),getWidth()-10,0, 10};
        int[] yPoints = {0, 0, getHeight()/2, getHeight(), getHeight(), getHeight()/2};
        g.fillPolygon(xPoints, yPoints, 6);
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