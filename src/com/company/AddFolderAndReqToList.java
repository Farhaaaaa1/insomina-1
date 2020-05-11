package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddFolderAndReqToList extends MouseAdapter {
    JButton plus = new JButton();
    Color color;
    Boolean isFirst = true ;
    JPopupMenu popupMenu = new JPopupMenu();
    public AddFolderAndReqToList(JButton plus) {
        this.plus = plus;
        color = plus.getBackground();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        if(isFirst)
        popUpCreating(popupMenu);
        popupMenu.show(plus,e.getX(),e.getY());
        // String name = JOptionPane.showInputDialog("enter your name bro ") ;
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

    public void popUpCreating(JPopupMenu popupMenu) {
        popupMenu.setBackground(new Color(0xFFFAFA));
        Font menu = new Font("myFont", Font.PLAIN, 12);
        JMenuItem INSOMNIA = new JMenuItem("isjdcosjvok");
        INSOMNIA.setBorder(BorderFactory.createCompoundBorder(INSOMNIA.getBorder(), BorderFactory.createEmptyBorder(3, 12, 3, 10)));
        INSOMNIA.setFont(menu);
        INSOMNIA.setBackground(new Color(0xFFFFFF));
        popupMenu.add(INSOMNIA);
        isFirst = false ;
    }
}
