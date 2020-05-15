package com.company;

import sun.font.GraphicComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * here we crear our nice pop up LOL
 * creat each of item one by one
 */
public class InsomniaPopUp extends JPopupMenu {

    public InsomniaPopUp() {

        this.setBackground(new Color(0xFFFAFA));
        Font title = new Font("myFont", Font.ITALIC, 10);
        Font menu = new Font("myFont", Font.PLAIN, 12);
        setBorder(BorderFactory.createCompoundBorder(this.getBorder(), BorderFactory.createEmptyBorder(3, 0, 0, 0)));
        JMenuItem INSOMNIA = new JMenuItem("INSOMNIA  _____________________________");
        INSOMNIA.setBorder(BorderFactory.createCompoundBorder(INSOMNIA.getBorder(), BorderFactory.createEmptyBorder(3, 2, 3, 0)));
        INSOMNIA.setFont(title);
        INSOMNIA.setBackground(new Color(0xFFFFFF));
        add(INSOMNIA);
        INSOMNIA.setEnabled(false);

        JMenuItem work = new JMenuItem("Workspace Setting");
        work.setBorder(BorderFactory.createCompoundBorder(work.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 0)));
        work.setFont(menu);
        work.setBackground(new Color(0xFFFFFF));
        add(work);

        JMenuItem share = new JMenuItem("Share Insomnia");
        share.setBorder(BorderFactory.createCompoundBorder(share.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 0)));
        share.setFont(menu);
        add(share);
        share.setBackground(new Color(0xFFFFFF));

        JMenuItem switchh = new JMenuItem("SWITCH WORKSPACE  ___________________");
        switchh.setBorder(BorderFactory.createCompoundBorder(switchh.getBorder(), BorderFactory.createEmptyBorder(3, 2, 3, 0)));
        switchh.setFont(title);
        switchh.setEnabled(false);
        add(switchh);
        switchh.setBackground(new Color(0xFFFFFF));

        JMenuItem create = new JMenuItem("Create Workspace");
        create.setBorder(BorderFactory.createCompoundBorder(create.getBorder(), BorderFactory.createEmptyBorder(10, 30, 10, 0)));
        create.setFont(menu);
        create.setBackground(new Color(0xFFFFFF));

        add(create);
        JMenuItem INS = new JMenuItem("INSOMNIA V7.1.1  ______________________");
        INS.setBorder(BorderFactory.createCompoundBorder(INS.getBorder(), BorderFactory.createEmptyBorder(3, 0, 3, 0)));
        INS.setFont(title);
        add(INS);
        INS.setBackground(new Color(0xFFFFFF));
        INS.setEnabled(false);

        JMenuItem pre = new JMenuItem("Preference");
        pre.setBorder(BorderFactory.createCompoundBorder(pre.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 0)));
        pre.setFont(menu);
        pre.setBackground(new Color(0xFFFFFF));
        add(pre);

        JMenuItem Imp = new JMenuItem("Import/Export");
        Imp.setBorder(BorderFactory.createCompoundBorder(Imp.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 0)));
        Imp.setFont(menu);
        Imp.setBackground(new Color(0xFFFFFF));
        add(Imp);

        JMenuItem Log = new JMenuItem("Log In");
        Log.setBorder(BorderFactory.createCompoundBorder(Log.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 0)));
        Log.setFont(menu);
        add(Log);
        Log.setBackground(new Color(0xFFFFFF));
    }
}
