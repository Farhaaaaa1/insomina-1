package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
/**
 * all thing here are about middle panel
 * wich have 1,2 classes
 * and also some component
 */
public class LeftPanel extends JPanel {
    JButton mb = new JButton();
    public LinkedList<Files> files = new LinkedList<>();
    JPanel req = new JPanel();
    String requestTxt;
    String folderTxt;
    boolean a = true;
    JPanel p = new JPanel();
    Insomina frame;
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

    /**
     * createleft pannel here
     * @param frame Insomnia frame (base)
     */
    public LeftPanel(Insomina frame) {
        this.frame = frame ;
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
        show.addMouseListener(new AddFolderAndReqToList(show, this,frame));
        show.setEnabled(false);
        req.add(txt, BorderLayout.CENTER);
        req.add(show, BorderLayout.EAST);
        temp.setLayout(new BorderLayout());
        show.setBorder(BorderFactory.createCompoundBorder(mb.getBorder(), BorderFactory.createEmptyBorder(3, 3, 3, 2)));
        add(temp, BorderLayout.CENTER);
        temp.add(req, BorderLayout.NORTH);
        JPanel temp1 = new JPanel();
        temp.add(temp1, BorderLayout.CENTER);
        temp.setBackground(new Color(0x3E3E3E));
        temp1.setBackground(new Color(0x3E3E3E));
        temp1.setLayout(new BorderLayout());
        temp1.add(p, BorderLayout.NORTH);
        p.updateUI();
        addToReq();
        repaint();
        revalidate();
        setBackground(new Color(0x3E3E3E));
        new InsomButton();
    }

    /**
     * show file with "p" jpanel
     */
    public void addToReq() {
        for (Files F :
                files) {
            p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
            p.add(F.generalPanel);
        }
        repaint();
        revalidate();
    }

    /**
     * here we create search area
     * @param txt
     */
    public void prepareText(JTextField txt) {
        txt.setPreferredSize(new Dimension(110, 30));
        txt.setBorder(BorderFactory.createCompoundBorder(txt.getBorder(), BorderFactory.createEmptyBorder(0, 3, 0, 40)));
        txt.setBackground(new Color(0x2D2D2D));
        txt.setFont(new Font("WTF", Font.ROMAN_BASELINE, 11));
        txt.setForeground(new Color(0xFFFFFA));
        txt.setText("Filter...");
        txt.addMouseListener(new Hover(txt,Color.WHITE));
        revalidate();
        repaint();
        txt.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                if (txt.getText().equals(""))
                    txt.setText("Filter...");
            }
        });
        revalidate();
        repaint();
    }

    /**
     * create insomnia button wich is top right
     * @param mb our aim button
     */
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

    /**
     * comoflage button with their apce
     * @param btn our aim button
     * @param color color of buttons space
     */
    public void comouflage(JButton btn, Color color) {
        btn.setPreferredSize(new Dimension(38, 5));
        btn.setBackground(color);
        btn.setOpaque(true);
        btn.setBorderPainted(false);
        btn.setEnabled(false);
    }


}
