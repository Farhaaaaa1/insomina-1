package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MidBar extends JPanel {
    JPopupMenu popupMenu = new JPopupMenu();
    JButton Body = new JButton();
    JButton Header = new JButton();
    JButton Query = new JButton();
    JButton Auth = new JButton();
    JPanel upBar = new JPanel();
    Color color = new Color(0x2D2D2D);
    Boolean isFirst = true;

    public MidBar() {
        setLayout(new BorderLayout());
        add(upBar, BorderLayout.NORTH);
        createPopUp();
     Body.addMouseListener(new MouseAdapter() {
         @Override
         public void mousePressed(MouseEvent e) {
             super.mousePressed(e);
             popupMenu.show(Body,e.getX(),e.getY());
         }
     });
        upBar.setBackground(new Color(0x2D2D2D));
        upBar.setLayout(new GridLayout(1, 3));
        upBar.add(Body);
        upBar.add(Header);
        upBar.add(Query);
        upBar.add(Auth);
        createButtons(Body ,"Body");
        createButtons(Header,"Header");
        createButtons(Query,"Query");
        createButtons(Auth , "Auth");
    }

    public void createButtons(JButton button, String text) {
        button.setBackground(color);
        button.setText(text);
        button.setForeground(Color.WHITE);
        button.setPreferredSize(new Dimension(20, 40));
    }

    public void createPopUp() {
        this.setBackground(new Color(0xFFFAFA));
        Font title = new Font("myFont", Font.ITALIC, 10);
        Font menu = new Font("myFont", Font.PLAIN, 12);
        setBorder(BorderFactory.createCompoundBorder(this.getBorder(), BorderFactory.createEmptyBorder(3, 0, 0, 0)));
        JMenuItem INSOMNIA = new JMenuItem("STRUCTURED  _____________________________");
        INSOMNIA.setBorder(BorderFactory.createCompoundBorder(INSOMNIA.getBorder(), BorderFactory.createEmptyBorder(3, 2, 3, 0)));
        INSOMNIA.setFont(title);
        INSOMNIA.setBackground(new Color(0xFFFFFF));
        popupMenu.add(INSOMNIA);
        INSOMNIA.setEnabled(false);
        JMenuItem work = new JMenuItem("Workspace Setting");
        work.setBorder(BorderFactory.createCompoundBorder(work.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 0)));
        work.setFont(menu);
        work.setBackground(new Color(0xFFFFFF));
        popupMenu.add(work);



        JMenuItem INSOMNIA1 = new JMenuItem("TEXT  _____________________________");
        INSOMNIA1.setBorder(BorderFactory.createCompoundBorder(INSOMNIA1.getBorder(), BorderFactory.createEmptyBorder(3, 2, 3, 0)));
        INSOMNIA1.setFont(title);
        INSOMNIA1.setBackground(new Color(0xFFFFFF));
        popupMenu.add(INSOMNIA1);
        INSOMNIA1.setEnabled(false);
        JMenuItem work1 = new JMenuItem("Workspace Setting");
        work1.setBorder(BorderFactory.createCompoundBorder(work1.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 0)));
        work1.setFont(menu);
        work1.setBackground(new Color(0xFFFFFF));
        popupMenu.add(work1);



        JMenuItem INSOMNIA2 = new JMenuItem("OTHER  _____________________________");
        INSOMNIA2.setBorder(BorderFactory.createCompoundBorder(INSOMNIA2.getBorder(), BorderFactory.createEmptyBorder(3, 2, 3, 0)));
        INSOMNIA2.setFont(title);
        INSOMNIA2.setBackground(new Color(0xFFFFFF));
        popupMenu.add(INSOMNIA2);
        INSOMNIA2.setEnabled(false);

        JMenuItem work2 = new JMenuItem("Workspace Setting");
        work2.setBorder(BorderFactory.createCompoundBorder(work2.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 0)));
        work2.setFont(menu);
        work2.setBackground(new Color(0xFFFFFF));
        popupMenu.add(work2);

    }

}
