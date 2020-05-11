package com.company;

import com.sun.xml.internal.ws.encoding.ImageDataContentHandler;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class LeftPanel extends JPanel {
    JButton mb = new JButton();
    private LinkedList<Files> files = new LinkedList<>();
    JPanel req = new JPanel();
    Folder folder = new Folder(this);

    private class InsomButton {
        public InsomButton() {
            mb.setLayout(new BorderLayout());
            mb.setBorder(BorderFactory.createCompoundBorder(mb.getBorder(), BorderFactory.createEmptyBorder(0, 0, 0, 2)));
            InsomniaPopUp popupMenu = new InsomniaPopUp();
            JLabel down = new JLabel(new ImageIcon("src/down1.png"));
            mb.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    super.mousePressed(e);
                    popupMenu.show(mb, e.getX(), e.getY());
                }
            });
            mb.add(down, BorderLayout.EAST);
            JLabel insomnia = new JLabel("Insomnia  ");
            insomnia.setForeground(new Color(0xFFFAFA).brighter().brighter().brighter());
            insomnia.setFont(new Font("farhan", Font.BOLD, 18));
            mb.add(insomnia, BorderLayout.WEST);
            mb.setOpaque(true);
            mb.setBorderPainted(false);
            mb.setBackground(new Color(0x6860B4));
            mb.setForeground(Color.WHITE);
            mb.add(Box.createRigidArea(new Dimension(5, 35)));
            popupMenu.setBorder(BorderFactory.createCompoundBorder(popupMenu.getBorder(), BorderFactory.createEmptyBorder(0, 0, 0, -38)));

            add(mb, BorderLayout.NORTH);

        }
    }

    public LeftPanel(Insomina frame) {
        setLayout(new BorderLayout());
        JPanel temp = new JPanel();
        temp.setBackground(Color.RED);
        req.setBackground(Color.DARK_GRAY);
        req.setLayout(new BorderLayout());
        JTextField txt = new JTextField();
        txt.setPreferredSize(new Dimension(110, 23));
        req.setBorder(BorderFactory.createCompoundBorder(req.getBorder(), BorderFactory.createEmptyBorder(5, 4, 5, 2)));
        txt.setBorder(BorderFactory.createCompoundBorder(txt.getBorder(), BorderFactory.createEmptyBorder(0, 3, 0, 40)));
        txt.setBackground(Color.darkGray);
        txt.setOpaque(true);
        txt.setFont(new Font("WTF", Font.ROMAN_BASELINE, 11));
        txt.setForeground(new Color(0xFFFFFA));
        req.add(Box.createRigidArea(new Dimension(10, 20)));
        JLabel btn = new JLabel();
        btn.setIcon(new ImageIcon("src/1.png"));
        req.add(txt, BorderLayout.CENTER);
        req.add(btn, BorderLayout.EAST);
        temp.setLayout(new BorderLayout());
        btn.setBorder(BorderFactory.createCompoundBorder(mb.getBorder(), BorderFactory.createEmptyBorder(0, 3, 0, 2)));
        add(temp, BorderLayout.CENTER);
        temp.add(req, BorderLayout.NORTH);
        new InsomButton();
    }

    public void addToReq() {
        for (Object f :
                files) {
            // req.setLayout(new BoxLayout(req, BoxLayout.Y_AXIS));
            //  req.add(f.label);
        }
    }

    public void addList() {

    }

}
