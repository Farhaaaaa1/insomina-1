package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddFolderAndReqToList extends MouseAdapter {
    JButton plus = new JButton();
    Color color;

    public AddFolderAndReqToList(JButton plus) {
        this.plus = plus;
        color = plus.getBackground();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        String name = JOptionPane.showInputDialog("enter your name bro ") ;

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        super.mouseEntered(e);
        plus.setBackground(color.brighter().brighter());
    }

    @Override
    public void mouseExited(MouseEvent e) {
        super.mouseExited(e);
        plus.setBackground(color);

    }
}
