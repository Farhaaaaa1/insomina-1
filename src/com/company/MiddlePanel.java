package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MiddlePanel extends JPanel {
    JButton cb = new JButton();
    JLabel send = new JLabel("SEND");
    JTextField textField = new JTextField();
    String text = "option";
    Color colorr;
    Boolean isFirst = true;
    JPanel upBar = new JPanel();
    JPopupMenu popupMenu = new JPopupMenu();

    public MiddlePanel(Insomina frame) {
        setLayout(new BorderLayout());
        add(upBar, BorderLayout.NORTH);
        MidBar midBar = new MidBar();
        add(midBar, BorderLayout.CENTER);

        prepareText(textField);
        upBar.setLayout(new BorderLayout());
        setSendBtn(send);
        setCb(new Color(0xD4D4D4), "option");
        cb.setBorder(BorderFactory.createCompoundBorder(cb.getBorder(), BorderFactory.createEmptyBorder(0, -20, 0, 0)));
        send.setBorder(BorderFactory.createCompoundBorder(send.getBorder(), BorderFactory.createEmptyBorder(0, 15, 0, 0)));
        setPopupMenu();
        upBar.add(Box.createRigidArea(new Dimension(5, 45)));
        upBar.add(textField, BorderLayout.CENTER);
        upBar.add(cb, BorderLayout.WEST);
        upBar.add(send, BorderLayout.EAST);

    }

    public void setCb(Color c, String s) {
        cb.setPreferredSize(new Dimension(70, 5));
        cb.setFont(new Font("WTD", Font.LAYOUT_NO_LIMIT_CONTEXT, 15));
        cb.setOpaque(true);
        cb.setBorderPainted(false);
        cb.setBackground(c);
        cb.setText(s);
        cb.setEnabled(false);
        cb.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                popupMenu.show(cb, e.getX(), e.getY());
            }
        });
    }

    public void setSendBtn(JLabel btn) {
        btn.setPreferredSize(new Dimension(75, 5));
        btn.setBackground(new Color(0xE3E3E3));
        btn.setFont(new Font("WTF", Font.LAYOUT_NO_LIMIT_CONTEXT, 15));
        btn.setOpaque(true);
        btn.setEnabled(false);
    }

    public void setPopupMenu() {
        Color color = Color.WHITE;

        JMenuItem del = new JMenuItem("DEL");
        del.setBackground(color);
        del.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text = del.getText();
                colorr = new Color(0x9A252A);
                setCb(colorr, text);
                upBar.updateUI();
                updateUI();
            }
        });
        JMenuItem get = new JMenuItem("GET");
        get.setBackground(color);
        get.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text = get.getText();
                colorr = new Color(0x1D3284);
                setCb(colorr, text);
                upBar.updateUI();
                updateUI();
            }
        });
        JMenuItem post = new JMenuItem("POST");
        post.setBackground(color);
        post.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text = post.getText();
                colorr = new Color(0x641183);
                setCb(colorr, text);
                upBar.updateUI();
                updateUI();
            }
        });
        JMenuItem put = new JMenuItem("PUT");
        put.setBackground(color);
        put.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text = put.getText();
                colorr = new Color(0x50833F);
                setCb(colorr, text);
                upBar.updateUI();
                updateUI();
            }
        });
        JMenuItem pats = new JMenuItem("PATC");
        pats.setBackground(color);
        pats.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text = pats.getText();
                colorr = new Color(0xBE501F);
                setCb(colorr, text);
                upBar.updateUI();
                updateUI();
            }
        });


        if (isFirst) {
            addToPup(del, new Color(0x9A252A));
            addToPup(get, new Color(0x1D3284));
            addToPup(post, new Color(0x641183));
            addToPup(put, new Color(0x50833F));
            addToPup(pats, new Color(0xBE501F));

            isFirst = false;
        }

        System.out.println("3");
    }

    public void addToPup(JMenuItem a, Color col) {
        popupMenu.add(a);
        a.setForeground(col);
        a.setBorder(BorderFactory.createCompoundBorder(a.getBorder(), BorderFactory.createEmptyBorder(8, 5, 8, 12)));
        a.setFont(new Font("hell", Font.ITALIC, 12));
    }

    public void prepareText(JTextField txt) {
        txt.setPreferredSize(new Dimension(110, 45));
        txt.setBorder(BorderFactory.createCompoundBorder(upBar.getBorder(), BorderFactory.createEmptyBorder(8, 3, 8, 10)));
        txt.setBackground(new Color(0xFFFFFA));
        txt.setFont(new Font("WTF", Font.ROMAN_BASELINE, 15));
        txt.setForeground(Color.gray);
        txt.setText("https://wtf.myfucking.com");
        txt.addMouseListener(new Hover(txt, Color.gray));
        revalidate();
        repaint();
        txt.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                if (txt.getText().equals(""))
                    txt.setText("https://wtf.myfucking.com");
            }
        });
        revalidate();
        repaint();

    }
}
