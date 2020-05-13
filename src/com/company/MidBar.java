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
    JPanel middleBar = new JPanel();
    Color color = new Color(0x2D2D2D);
    Boolean isFirst = true;
    BinaryPanel binaryPanel = new BinaryPanel();
    JsonPanel jsonPanel = new JsonPanel();
    Header header = new Header("","");
    JPanel m3 = new JPanel();

    public MidBar() {
        setLayout(new BorderLayout());
        add(upBar, BorderLayout.NORTH);
        add(middleBar, BorderLayout.CENTER);
        middleBar.setLayout(new CardLayout());
        JPanel m = new JPanel();
        m.setBackground(Color.RED);



        m3.setBackground(Color.PINK);

        middleBar.add("hell", m);
        middleBar.add("binary", binaryPanel);
        middleBar.add("JSON", jsonPanel);
        middleBar.add("Head", header);
        middleBar.add("hell3", m3);
        createPopUp();
        Body.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                popupMenu.show(Body, e.getX(), e.getY());
            }
        });
        upBar.setBackground(new Color(0x2D2D2D));
        upBar.setLayout(new GridLayout(1, 3));
        upBar.add(Body);
        upBar.add(Header);
        upBar.add(Query);
        upBar.add(Auth);
        createButtons(Body, "Body");
        createButtons(Header, "Header");
        createButtons(Query, "Query");
        createButtons(Auth, "Auth");
        Header.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((CardLayout) middleBar.getLayout()).show(middleBar, "Head");
            }
        });
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
        popupMenu.setBorder(BorderFactory.createCompoundBorder(this.getBorder(), BorderFactory.createEmptyBorder(3, 0, 0, -4)));
        JMenuItem INSOMNIA = new JMenuItem("STRUCTURED  _____________________________");
        INSOMNIA.setBorder(BorderFactory.createCompoundBorder(INSOMNIA.getBorder(), BorderFactory.createEmptyBorder(3, 2, 3, 0)));
        INSOMNIA.setFont(title);
        INSOMNIA.setBackground(new Color(0xFFFFFF));
        popupMenu.add(INSOMNIA);
        INSOMNIA.setEnabled(false);
        JMenuItem form = new JMenuItem("FORM");
        form.setBorder(BorderFactory.createCompoundBorder(form.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 0)));
        form.setFont(menu);
        form.setBackground(new Color(0xFFFFFF));
        popupMenu.add(form);
        form.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Body.setText(form.getText());
            }
        });


        JMenuItem INSOMNIA1 = new JMenuItem("TEXT  _____________________________");
        INSOMNIA1.setBorder(BorderFactory.createCompoundBorder(INSOMNIA1.getBorder(), BorderFactory.createEmptyBorder(3, 2, 3, 0)));
        INSOMNIA1.setFont(title);
        INSOMNIA1.setBackground(new Color(0xFFFFFF));
        popupMenu.add(INSOMNIA1);
        INSOMNIA1.setEnabled(false);
        JMenuItem json = new JMenuItem("JSON");
        json.setBorder(BorderFactory.createCompoundBorder(json.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 0)));
        json.setFont(menu);
        json.setBackground(new Color(0xFFFFFF));
        popupMenu.add(json);
        json.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Body.setText(json.getText());
                ((CardLayout) middleBar.getLayout()).show(middleBar, "JSON");
            }

        });


        JMenuItem INSOMNIA2 = new JMenuItem("OTHER  _____________________________");
        INSOMNIA2.setBorder(BorderFactory.createCompoundBorder(INSOMNIA2.getBorder(), BorderFactory.createEmptyBorder(3, 2, 3, 0)));
        INSOMNIA2.setFont(title);
        INSOMNIA2.setBackground(new Color(0xFFFFFF));
        popupMenu.add(INSOMNIA2);
        INSOMNIA2.setEnabled(false);

        JMenuItem binary = new JMenuItem("BINARY");
        binary.setBorder(BorderFactory.createCompoundBorder(binary.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 0)));
        binary.setFont(menu);
        binary.setBackground(new Color(0xFFFFFF));
        popupMenu.add(binary);
        binary.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Body.setText(binary.getText());
                ((CardLayout) middleBar.getLayout()).show(middleBar, "binary");
            }
        });

    }

}
