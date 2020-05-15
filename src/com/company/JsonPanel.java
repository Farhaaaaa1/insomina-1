package com.company;

import javax.swing.*;
import java.awt.*;

/**
 * our jason panel that include textfield
 */
public class JsonPanel extends JPanel {
    Color myColor = new Color(0x2D2D2D);
    public JsonPanel() {
        JTextArea textField = new JTextArea();
        textField.setText("<<  ");
        textField.setBorder(BorderFactory.createCompoundBorder(textField.getBorder(), BorderFactory.createEmptyBorder(25, 15, 0, 0)));
        setLayout(new BorderLayout());
        setBackground(myColor);
        textField.setBackground(myColor);
        textField.setForeground(new Color(0xBE501F));
        textField.setFont(new Font("WTF",Font.PLAIN,15));
        add(textField,BorderLayout.CENTER);
    }
}
