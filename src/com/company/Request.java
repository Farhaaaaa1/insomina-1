package com.company;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIInlineBinaryData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.util.LinkedList;

/**
 * creat request here
 * and also give them detailes
 */
public class Request extends Files {
    Insomina insomina;
    String headerTxt = "";
    JLabel label;
    int kind;
    JLabel labelTxt;
    String noNumber;
    JPanel panel = new JPanel();
    JPanel temp = new JPanel();
    Header header;
    // image of kinds of requests
    int x = 27;
    int y = 14;
    Image[] icons = {changSize(new ImageIcon("src/del.png"), x - 2, y), changSize(new ImageIcon("src/get.png"), x - 2, y),
            changSize(new ImageIcon("src/post.png"), x + 5, y), changSize(new ImageIcon("src/put.png"), x, y),
            changSize(new ImageIcon("src/patc.png"), 27, y)};
    Color color;

    public Request(LeftPanel leftPanel, String txt, int kind, Color color, Insomina insomina, String noNumber) {
        super(leftPanel);
        this.kind = kind;
        this.noNumber = noNumber;
        header = new Header("", "", insomina);
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
                insomina.middlePanel.setCb(getColor(kind), getText(kind));
                insomina.middlePanel.revalidate();
                insomina.middlePanel.midBar.middleBar.remove(4);
                insomina.middlePanel.midBar.middleBar.add("Head", header);
                insomina.middlePanel.midBar.updateUI();
                super.mouseClicked(e);
            }
        });
    }

    public Color getColor(int kind) {
        switch (kind) {
            case 0:
                return Coloring.red();
            case 1:
                return Coloring.blue();
            case 2:
                return Coloring.purple();
            case 3:
                return Coloring.green();
            case 4:
                return Coloring.orange();
            default:
                return Coloring.bone();
        }
    }

    public String getText(int kind) {
        switch (kind) {
            case 0:
                return "DEL";
            case 1:
                return "GET";
            case 2:
                return "POST";
            case 3:
                return "PUT";
            case 4:
                return "PATC";
            default:
                return "";
        }
    }
}