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
    String openOrNot = "close";
    JLabel labelTxt;
    JPanel innerFolders = new JPanel();
    public JPanel panel = new JPanel();
    JPanel temp = new JPanel();
    Image[] icons = {changSize(new ImageIcon("src/close.png"), 14, 14), changSize(new ImageIcon("src/open.png"), 14, 14)};
    LinkedList<Files> myFiles = new LinkedList<>();
    Color color = new Color(0x2D2D2D);

    public Folder(LeftPanel leftPanel, String txt) {
        super(leftPanel);
        panel.setVisible(true);
        label = new JLabel(new ImageIcon(icons[0]));
        label.setBackground(color);
        labelTxt = new JLabel(txt);
        labelTxt.setFont(new Font("hell",Font.PLAIN,11));
        labelTxt.setForeground(Color.WHITE);
        JButton btn = new JButton(new ImageIcon("src/down1.png"));
        comouflage(btn, color);
        panel.setLayout(new BorderLayout());
        panel.add(label, BorderLayout.WEST);
        addActions(btn);
        innerFolders.setBackground(myColor);
        temp.setBackground(color);
        btn.setBorder(BorderFactory.createCompoundBorder(btn.getBorder(), BorderFactory.createEmptyBorder(1, 8, 1, 8)));
        panel.add(temp, BorderLayout.CENTER);
        temp.setLayout(new BorderLayout());
        label.setBorder(BorderFactory.createCompoundBorder(label.getBorder(), BorderFactory.createEmptyBorder(8, 7, 8, 8)));
        temp.add(labelTxt, BorderLayout.WEST);
        panel.setBackground(myColor);
        panel.add(btn, BorderLayout.EAST);
        generalPannel.add(panel);
    }

    public void addActions(JButton btn) {
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                btn.setBackground(myColor.brighter());
                panel.setBackground(myColor.brighter());
                temp.setBackground(myColor.brighter());
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("1");
                System.out.println("comp");
                generalPannel.remove(panel);
                generalPannel.updateUI();

            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                panel.setBackground(color);
                temp.setBackground(color);
                btn.setBackground(color);
            }
        });
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                btn.setBackground(color.brighter());
                panel.setBackground(color.brighter());
                temp.setBackground(color.brighter());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                panel.setBackground(color);
                temp.setBackground(color);
                btn.setBackground(color);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (openOrNot.equals("close")) {
                    generalPannel.add(innerFolders);
                    label.setIcon(new ImageIcon(icons[1]));
                    panel.updateUI();
                    openOrNot = "open" ;
                } else {
                    generalPannel.remove(innerFolders);
                    label.setIcon(new ImageIcon(icons[0]));
                    panel.updateUI();
                    openOrNot = "close" ;
                }
                generalPannel.updateUI();

            }
        });
    }
}