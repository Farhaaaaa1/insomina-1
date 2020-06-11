package com.company;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIInlineBinaryData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

/**
 * creat request here
 * and also give them detailes
 */
public class Request extends Files {
    Insomina insomina;
    JLabel label;
    int kind;
    JLabel labelTxt;
    String noNumber;
    JPanel header = new JPanel();
    JPanel panel = new JPanel();
    JPanel temp = new JPanel();
    // image of kinds of requests
    int x = 27;
    int y = 14;
    Image[] icons = {changSize(new ImageIcon("src/del.png"), x-2, y), changSize(new ImageIcon("src/get.png"), x-2, y),
            changSize(new ImageIcon("src/post.png"), x+5, y), changSize(new ImageIcon("src/put.png"), x, y),
            changSize(new ImageIcon("src/patc.png"), 27, y)};
    Color color;

    public Request(LeftPanel leftPanel, String txt, int kind, Color color, Insomina insomina, String noNumber) {
        super(leftPanel);
        this.kind = kind;
        this.noNumber = noNumber;
        text = txt;
        this.insomina = insomina;
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
        temp.setBackground(color);
        btn.setBorder(BorderFactory.createCompoundBorder(btn.getBorder(), BorderFactory.createEmptyBorder(1, 8, 1, 8)));
        panel.add(temp, BorderLayout.CENTER);
        temp.setLayout(new BorderLayout());
        label.setBorder(BorderFactory.createCompoundBorder(label.getBorder(), BorderFactory.createEmptyBorder(8, 7, 8, 8)));
        temp.add(labelTxt, BorderLayout.WEST);
        panel.setBackground(color);
        panel.add(btn, BorderLayout.EAST);
        generalPanel.add(panel);
    }

    /**
     * @param btn our aim button
     *            add action to button
     *            we implemet  all the actions on what we want here
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
                generalPanel.remove(panel);
                generalPanel.updateUI();
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

            @Override
            public void mouseClicked(MouseEvent e) {
                insomina.key = noNumber;
                insomina.middlePanel.setCb(color, text);
                insomina.middlePanel.revalidate();
                super.mouseClicked(e);
            }
        });
    }
}