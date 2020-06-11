package com.company;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

/**
 * in this class we will create headers that we
 * put into the headers panel in middle panel .
 */
public class Header extends JPanel {
    LinkedList <EachCell> CellList = new LinkedList<>();
    class EachCell extends JPanel {
        public EachCell() {
            setLayout(new BorderLayout());
            JLabel open = new JLabel(new ImageIcon("src/1.png"));
            JTextField headerTxt = new JTextField();
            headerTxt.setColumns(20);
            JTextField valueTxt = new JTextField();
            add(headerTxt,BorderLayout.EAST);
            add(valueTxt,BorderLayout.WEST);
            add(open);
            setBackground(new Color(43434));
            this.setBorder(BorderFactory.createCompoundBorder(this.getBorder(), BorderFactory.createEmptyBorder(5, 0, 5, 0)));
        }
    }

    public Header() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        EachCell hello = new EachCell();
        EachCell hello1 = new EachCell();
        EachCell hello2 = new EachCell();
        JPanel temp = new JPanel();
        setLayout(new BorderLayout());
        add(temp, BorderLayout.NORTH);
        temp.setLayout(new BoxLayout(temp, BoxLayout.Y_AXIS));
        hello1.setBackground(new Color(32453567));
        hello2.setBackground(new Color(153567));
        temp.add(hello1);
        temp.add(hello);
        temp.add(hello2);
        temp.setBackground(new Color(0x57D42C));
    }
}
