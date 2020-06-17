package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * create hover action
 */
public class Hover extends MouseAdapter {

    private JTextField textField;
    private Color color ;
    public Hover(JTextField textField , Color color) {
        this.textField = textField;
        this.color = color ;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        if(textField.isEnabled())
        textField.setText("");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        super.mouseExited(e);
        textField.setForeground(color);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        super.mouseEntered(e);
        textField.setForeground(new Color(255, 127, 80));
    }
}


