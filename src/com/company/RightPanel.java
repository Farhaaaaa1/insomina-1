package com.company;

import com.company.Insomina;
import com.company.MidBar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 * all thing here are about middle panel
 * wich have 1,2 class in it
 */
public class RightPanel extends JPanel {
    JLabel cb = new JLabel();
    JLabel time = new JLabel("4.45 s");
    JLabel speed = new JLabel("85 KB");
    JTextField textField = new JTextField();
    String text = "option";
    Color colorr;
    Boolean isFirst = true;
    JPanel upBar = new JPanel();

    /**
     * creat base of right panel here
     * @param frame
     */
    public RightPanel(Insomina frame) {
        setLayout(new BorderLayout());
        add(upBar, BorderLayout.NORTH);
        MidBarForRight midBar = new MidBarForRight();
        add(midBar, BorderLayout.CENTER);

        upBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        setSendBtn(time);
        setSendBtn(speed);
        setCb(new Color(0x58D438), "200 OK");
        time.setBorder(BorderFactory.createCompoundBorder(time.getBorder(), BorderFactory.createEmptyBorder(0, 19, 0, 0)));
        speed.setBorder(BorderFactory.createCompoundBorder(speed.getBorder(), BorderFactory.createEmptyBorder(0, 19, 0, 0)));
        cb.setBorder(BorderFactory.createCompoundBorder(cb.getBorder(), BorderFactory.createEmptyBorder(0, 16, 0, 0)));

        upBar.add(Box.createRigidArea(new Dimension(40, 35)));
        upBar.add(cb);
        upBar.add(time);
        upBar.add(speed);

    }

    /**
     * create cb lable
     * @param c color of lable
     * @param s
     */
    public void setCb(Color c, String s) {
        cb.setPreferredSize(new Dimension(70, 30));
        cb.setFont(new Font("WTD", Font.BOLD, 11));
        cb.setOpaque(true);
        cb.setForeground(Color.WHITE);
        cb.setBackground(c);
        cb.setText(s);
       // cb.setEnabled(false);
    }

    /**
     * creat send blable
     * @param btn
     */
    public void setSendBtn(JLabel btn) {
        btn.setPreferredSize(new Dimension(70, 30));
        btn.setBackground(new Color(0xBDCABD));
        btn.setFont(new Font("WTF", Font.BOLD, 11));
        btn.setOpaque(true);
        btn.setForeground(new Color(0x494949));
    }
}
