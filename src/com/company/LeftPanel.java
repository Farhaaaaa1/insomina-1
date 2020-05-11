package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

public class LeftPanel extends JPanel {
    JButton mb = new JButton();
    private LinkedList<Files> files = new LinkedList<>();
    JPanel req = new JPanel();
    String requestTxt ;
    String folderTxt ;
    private class InsomButton {
        public InsomButton() {
            prepareInsomniaButton(mb);
            InsomniaPopUp popupMenu = new InsomniaPopUp();
            mb.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    super.mousePressed(e);
                    popupMenu.show(mb, e.getX(), e.getY());
                }
            });
            JLabel insomnia = new JLabel("Insomnia  ");
            insomnia.setForeground(new Color(0xFFFAFA).brighter().brighter().brighter());
            insomnia.setFont(new Font("farhan", Font.BOLD, 18));
            mb.add(insomnia, BorderLayout.WEST);
            popupMenu.setBorder(BorderFactory.createCompoundBorder(popupMenu.getBorder(), BorderFactory.createEmptyBorder(0, 0, 0, -38)));
            add(mb, BorderLayout.NORTH);

        }
    }

    public LeftPanel(Insomina frame) {
        setLayout(new BorderLayout());
        JPanel temp = new JPanel();
        temp.setBackground(Color.RED);
        req.setBackground(new Color(0x2D2D2D));
        req.setLayout(new BorderLayout());
        JTextField txt = new JTextField();
        prepareText(txt);
        req.setBorder(BorderFactory.createCompoundBorder(req.getBorder(), BorderFactory.createEmptyBorder(5, 4, 5, 2)));
        req.add(Box.createRigidArea(new Dimension(10, 20)));
        JButton show = new JButton(new ImageIcon("src/1.png"));
        comouflage(show, new Color(0x2D2D2D));
        show.addMouseListener(new AddFolderAndReqToList(show , this));
        show.setEnabled(false);
        req.add(txt, BorderLayout.CENTER);
        req.add(show, BorderLayout.EAST);
        temp.setLayout(new BorderLayout());
        show.setBorder(BorderFactory.createCompoundBorder(mb.getBorder(), BorderFactory.createEmptyBorder(0, 3, 0, 2)));
        add(temp, BorderLayout.CENTER);
        temp.add(req, BorderLayout.NORTH);
        Folder folder = new Folder(this);
        JPanel p = new JPanel();
        JPanel temp1 = new JPanel();
        p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
        temp.add(temp1,BorderLayout.CENTER);
        temp1.setLayout(new BorderLayout());
        temp1.add(p,BorderLayout.NORTH);
        p.add(folder.generalPannel);
        new InsomButton();
    }

    public void addToReq() {
        for (Files F :
                files) {
            // req.setLayout(new BoxLayout(req, BoxLayout.Y_AXIS));
            //  req.add(f.label);
        }
    }

    public void addList() {

    }

    public void prepareText(JTextField txt) {
        txt.setPreferredSize(new Dimension(110, 23));
        txt.setBorder(BorderFactory.createCompoundBorder(txt.getBorder(), BorderFactory.createEmptyBorder(0, 3, 0, 40)));
        txt.setBackground(new Color(0x2D2D2D));
        txt.setFont(new Font("WTF", Font.ROMAN_BASELINE, 11));
        txt.setForeground(new Color(0xFFFFFA));
        txt.setText("Filter...");
        txt.addMouseListener(new Hover(txt));
        revalidate();
        repaint();
        txt.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                if(txt.getText().equals(""))
                    txt.setText("Filter...");
            }
        });
        revalidate();
        repaint();

    }

    public void prepareInsomniaButton(JButton mb) {
        JLabel down = new JLabel(new ImageIcon("src/down1.png"));
        mb.setLayout(new BorderLayout());
        mb.setBorder(BorderFactory.createCompoundBorder(mb.getBorder(), BorderFactory.createEmptyBorder(0, 0, 0, 2)));
        mb.setOpaque(true);
        mb.setBorderPainted(false);
        mb.setBackground(new Color(0x6860B4));
        mb.setForeground(Color.WHITE);
        mb.add(down, BorderLayout.EAST);
        mb.add(Box.createRigidArea(new Dimension(5, 35)));
            }

    public void comouflage(JButton btn, Color color) {
        btn.setPreferredSize(new Dimension(38, 5));
        btn.setBackground(color);
        btn.setOpaque(true);
        btn.setBorderPainted(false);
        btn.setEnabled(false);
    }


}
