package com.company;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Folder {
    public JPanel label = new JPanel();
    public JPanel temp = new JPanel();
    public JButton down = new JButton(new ImageIcon("src/down1.png"));

    Color myColor = new Color(0x353535);

    public Folder() {
        label.setLayout(new BorderLayout());
        label.setBackground(myColor);
        down.setBackground(myColor);
        down.setOpaque(true);
        down.setFocusable(false);
        down.setBorderPainted(false);
        down.setEnabled(false);
        label.add(down,BorderLayout.EAST);
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
        {

            JLabel open = new JLabel(new ImageIcon("src/close.png"));
            label.add(open, BorderLayout.WEST);
            label.setVisible(true);
            label.add(temp, BorderLayout.CENTER);
            label.setBorder(BorderFactory.createCompoundBorder(label.getBorder(), BorderFactory.createEmptyBorder(8, 8, 8, 10)));
            label.add(Box.createRigidArea(new Dimension(5, 20)));
            label.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    super.mouseEntered(e);
                    down.setBackground(myColor.brighter());
                    label.setBackground(myColor.brighter());
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    super.mouseExited(e);
                    label.setBackground(myColor);
                    down.setBackground(myColor);
                }
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                }
            });
        }
    }

}
