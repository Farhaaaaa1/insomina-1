package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public abstract class Files {

    public JLabel label;
    public String text;
    public JButton down = new JButton(new ImageIcon("src/down1.png"));
    public static final Color myColor = new Color(0x353535);

    public Files(JLabel label, String text, JButton down) {
        this.label = label;
        this.text = text;
        this.down = down;
        down.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                down.setBackground(myColor.brighter());
                label.setBackground(myColor.brighter());

            }

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("1");

            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                label.setBackground(myColor);
                down.setBackground(myColor);


            }
        });
    }
}
