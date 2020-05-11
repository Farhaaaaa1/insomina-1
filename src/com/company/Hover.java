package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Hover extends MouseAdapter {

    private JTextField textField;

    public Hover(JTextField textField) {
        this.textField = textField;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        textField.setText("");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        super.mouseExited(e);
        textField.setForeground(new Color(255, 255, 255));
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        super.mouseEntered(e);
        textField.setForeground(new Color(255, 127, 80));
    }
}


