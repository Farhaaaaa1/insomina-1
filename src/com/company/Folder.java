package com.company;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

public class Folder extends Files {
    JLabel label;
    JLabel labelTxt;
    public JPanel panel = new JPanel();
    Image[] icons = {changSize(new ImageIcon("src/close.png"), 14, 14), changSize(new ImageIcon("src/open.png"), 14, 14)};
    // LinkedList<Req> reqs = new LinkedList<>();
    Color color = new Color(0x2D2D2D);

    public Folder(LeftPanel leftPanel) {
        super(leftPanel);
        panel.setVisible(true);
        label = new JLabel(new ImageIcon(icons[0]));
        label.setBackground(color);
        labelTxt = new JLabel("hello");
        labelTxt.setForeground(Color.WHITE);
        JButton btn = new JButton(new ImageIcon("src/down1.png"));
        comouflage(btn, color);
        panel.setLayout(new BorderLayout());
        panel.add(label, BorderLayout.WEST);
        JPanel temp = new JPanel();
        JPanel temp1 = new JPanel();
        temp1.setBackground(Color.magenta);
        temp.setBackground(Color.CYAN);
        btn.setBorder(BorderFactory.createCompoundBorder(btn.getBorder(), BorderFactory.createEmptyBorder(1, 8, 1, 8)));
        panel.add(temp, BorderLayout.CENTER);
        temp.setLayout(new BorderLayout());
        label.setBorder(BorderFactory.createCompoundBorder(label.getBorder(), BorderFactory.createEmptyBorder(8, 7, 8, 8)));
        temp.add(labelTxt, BorderLayout.WEST);
        panel.setBackground(Color.YELLOW);
        panel.add(btn, BorderLayout.EAST);
        generalPannel.add(panel);
        generalPannel.add(temp1);
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                repaint();
                revalidate();
            }
        });
    }

    public void addActions() {
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