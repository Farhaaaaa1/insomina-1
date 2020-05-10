package com.company;

import com.sun.xml.internal.ws.encoding.ImageDataContentHandler;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
public class LeftPanel extends JPanel {
    JButton mb = new JButton();

    public LeftPanel() {
        mb.setLayout(new BorderLayout());
        JMenu myString = new JMenu(" Insomnia");
        mb.setBorder(BorderFactory.createCompoundBorder(mb.getBorder(),BorderFactory.createEmptyBorder(0, 0, 0, 2)));

      //  mb.add(myString,BorderLayout.WEST);
        InsomniaPopUp popupMenu = new InsomniaPopUp();
        mb.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("hello");
                super.mousePressed(e);
                popupMenu.show(mb , e.getX(), e.getY());
            }
        });
        mb.add(new JLabel(new ImageIcon("src/down1.png")),BorderLayout.EAST);
        JLabel insomnia =new JLabel("insomnia  ");
        insomnia.setForeground(new Color(0xFFFAFA).brighter().brighter().brighter());
        insomnia.setFont(new Font("farhan",Font.BOLD,18));
        mb.add(insomnia,BorderLayout.WEST);
        setLayout(new BorderLayout());
        mb.setOpaque(true);
        mb.setBorderPainted(false);
        mb.setBackground(new Color(0x6860B4));
        mb.setForeground(Color.WHITE);
        add(mb, BorderLayout.NORTH);
        mb.add(Box.createRigidArea(new Dimension(5, 35)));
       // mb1.add(mb);
    }
}
