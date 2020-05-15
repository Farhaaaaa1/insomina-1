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

/**
 * creat request here
 * and also give them detailes
 */
public class Request extends Files {
    JLabel label;
    int kind;
    JLabel labelTxt;
    JPanel innerFolders = new JPanel();
    public JPanel panel = new JPanel();
    JPanel temp = new JPanel();
    // image of kinds of requests
    Image[] icons = {changSize(new ImageIcon("src/del.png"), 23, 14), changSize(new ImageIcon("src/get.png"), 23, 14),
            changSize(new ImageIcon("src/post.png"), 23, 14), changSize(new ImageIcon("src/put.png"), 23, 14),
            changSize(new ImageIcon("src/patc.png"), 23, 14)};
    LinkedList<Files> myFiles = new LinkedList<>();
    Color color;
    public Request(LeftPanel leftPanel, String txt, int kind, Color color) {
        super(leftPanel);
        this.kind = kind;
        this.color = color;
        panel.setVisible(true);
        label = new JLabel(new ImageIcon(icons[kind]));
        label.setBackground(color);
        labelTxt = new JLabel(txt);
        labelTxt.setFont(new Font("hell", Font.PLAIN, 11));
        labelTxt.setForeground(Color.WHITE);
        JButton btn = new JButton(new ImageIcon(changSize(new ImageIcon("src/Garbage.png"), 11, 13)));
        comouflage(btn, color);
        panel.setLayout(new BorderLayout());
        panel.add(label, BorderLayout.WEST);
        addActions(btn);
        innerFolders.setBackground(color);
        temp.setBackground(color);
        btn.setBorder(BorderFactory.createCompoundBorder(btn.getBorder(), BorderFactory.createEmptyBorder(1, 8, 1, 8)));
        panel.add(temp, BorderLayout.CENTER);
        temp.setLayout(new BorderLayout());
        label.setBorder(BorderFactory.createCompoundBorder(label.getBorder(), BorderFactory.createEmptyBorder(8, 7, 8, 8)));
        temp.add(labelTxt, BorderLayout.WEST);
        panel.setBackground(color);
        panel.add(btn, BorderLayout.EAST);
        generalPannel.add(panel);
    }
    /**
     * @param btn out aim button
     * add action to button
     *   we implemet  all the actions on what we want here
     */
    public void addActions(JButton btn) {
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                btn.setBackground(new Color(0x514822));
                panel.setBackground(new Color(0x514822));
                temp.setBackground(new Color(0x514822));
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
                btn.setBackground(new Color(0x514822));
                panel.setBackground(new Color(0x514822));
                temp.setBackground(new Color(0x514822));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                panel.setBackground(color);
                temp.setBackground(color);
                btn.setBackground(color);
            }

        });
    }
}