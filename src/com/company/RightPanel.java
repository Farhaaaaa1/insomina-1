package com.company;

import javax.swing.*;
import java.awt.*;

/**
 * all thing here are about middle panel
 * wich have 1,2 class in it
 */
public class RightPanel extends JPanel {
    JLabel cb = new JLabel();
    JLabel time = new JLabel("000");
    JLabel speed = new JLabel("000");
    JTextField textField = new JTextField();
    String text = "option";
    Color colorr;
    Boolean isFirst = true;
    JPanel upBar = new JPanel();
    Insomina insomina;
    MidBarForRight midBar;
    /**
     * creat base of right panel here
     *
     * @param frame
     */
    public RightPanel(Insomina insomina) {
        this.insomina = insomina;
        setLayout(new BorderLayout());
        add(upBar, BorderLayout.NORTH);
         midBar = new MidBarForRight(insomina);
        add(midBar, BorderLayout.CENTER);
        upBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        setBtn(time);
        setBtn(speed);
        setCb(Coloring.shinyGreen(), "200 OK" , cb);
        time.add(Box.createRigidArea(new Dimension(30, 40)));
        speed.add(Box.createRigidArea(new Dimension(0, 40)));
        cb.add(Box.createRigidArea(new Dimension(30, 40)));
        upBar.setBorder(BorderFactory.createCompoundBorder( upBar.getBorder(), BorderFactory.createEmptyBorder(0, 16, 0, 0)));
        upBar.add(cb);
        upBar.add(time);
        upBar.add(speed);
    }

    /**
     * create cb lable
     *
     * @param c color of lable
     * @param s
     */
    public void setCb(Color c, String s ,JLabel cb) {
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
     *
     * @param btn
     */
    public void setBtn(JLabel btn) {
        btn.setPreferredSize(new Dimension(70, 30));
        btn.setBackground(new Color(0xBDCABD));
        btn.setFont(new Font("WTF", Font.BOLD, 11));
        btn.setOpaque(true);
        btn.setForeground(new Color(0x494949));
    }
}
