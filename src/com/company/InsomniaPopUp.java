package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InsomniaPopUp extends JPopupMenu {
    public InsomniaPopUp() {
        JMenuItem workspace = new JMenuItem("what");
        setBorder(BorderFactory.createCompoundBorder(this.getBorder(),BorderFactory.createEmptyBorder(10, 5, 0, 2)));
        //workspace.setBackground();
        JMenuItem workspace0 = new JMenuItem("what");
        JMenuItem workspace1 = new JMenuItem(new ImageIcon("src/down1.png"));
        workspace1.setText("djcoksjc");
        JMenuItem workspace2 = new JMenuItem("  what   __________________________________");
        workspace2.setFocusable(false);
        workspace1.setBorder(BorderFactory.createCompoundBorder(workspace1.getBorder(),BorderFactory.createEmptyBorder(4, 5, 4, 2)));
        workspace2.setEnabled(false);
        workspace2.setFont(new Font("farhan",Font.ITALIC,10));
        JMenuItem workspace3 = new JMenuItem("what");
        JMenuItem workspace4 = new JMenuItem("what");
        JMenuItem workspace5 = new JMenuItem("what");
        add(workspace);
        add(workspace1);
        add(workspace0);
        add(workspace2);
        add(workspace3);
        add(workspace4);
        add(workspace5);

    }
}
