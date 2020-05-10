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

    private class insomButton {
        public insomButton() {
            mb.setLayout(new BorderLayout());
            mb.setBorder(BorderFactory.createCompoundBorder(mb.getBorder(), BorderFactory.createEmptyBorder(0, 0, 0, 2)));
            InsomniaPopUp popupMenu = new InsomniaPopUp();
            mb.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    super.mousePressed(e);
                    popupMenu.show(mb, e.getX(), e.getY());
                }
            });
            mb.add(new JLabel(new ImageIcon("src/down1.png")), BorderLayout.EAST);
            JLabel insomnia = new JLabel("insomnia  ");
            insomnia.setForeground(new Color(0xFFFAFA).brighter().brighter().brighter());
            insomnia.setFont(new Font("farhan", Font.BOLD, 18));
            mb.add(insomnia, BorderLayout.WEST);
            mb.setOpaque(true);
            mb.setBorderPainted(false);
            mb.setBackground(new Color(0x6860B4));
            mb.setForeground(Color.WHITE);
            mb.add(Box.createRigidArea(new Dimension(5, 35)));
            add(mb, BorderLayout.NORTH);

        }
    }

    public LeftPanel() {
        setLayout(new BorderLayout());
        Folder folder = new Folder();
        Folder folder1 = new Folder();
        Folder folder2 = new Folder();
        Folder folder3 = new Folder();
        JPanel temp = new JPanel();
        JPanel req = new JPanel();
        temp.setBackground(Color.darkGray);
        req.setBackground(Color.darkGray);
        temp.setLayout(new BorderLayout());
        add(temp, BorderLayout.CENTER);
        temp.add(req, BorderLayout.NORTH);
        req.setLayout(new BoxLayout(req, BoxLayout.Y_AXIS));
        req.add(folder.label);
        req.add(folder1.label);
        req.add(folder2.label);
        req.add(folder3.label);
        new insomButton();

    }
}
