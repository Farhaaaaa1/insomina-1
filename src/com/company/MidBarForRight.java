package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * creat mid bar for right panel here
 */
public class MidBarForRight extends JPanel {
    JPopupMenu popupMenu = new JPopupMenu();
    JButton Body = new JButton();
    JButton Header = new JButton();
    JButton Query = new JButton();
    JButton Auth = new JButton();
    JPanel upBar = new JPanel();
    JPanel middleBar = new JPanel();
    Color color = new Color(0x2D2D2D);
    Boolean isFirst = true;
  //  BinaryPanel binaryPanel = new BinaryPanel();
    JsonPanel jsonPanel = new JsonPanel();
    JsonPanel jsonPanel1 = new JsonPanel();
    JsonPanel jsonPanel2 = new JsonPanel();
    Form formPanel = new Form("","");
    //Header header = new Header("","");
    JPanel m3 = new JPanel();
    RightHeader table = new RightHeader();

    public MidBarForRight() {
        setLayout(new BorderLayout());
        add(upBar, BorderLayout.NORTH);
        add(middleBar, BorderLayout.CENTER);
        JLabel Farbod = new JLabel(new ImageIcon("src/download.png"));
        middleBar.setLayout(new CardLayout());
        middleBar.add(Farbod,BorderLayout.CENTER);
        middleBar.setBackground(new Color(0x2D2D2D));
        JPanel m = new JPanel();
        m.setBackground(new Color(0x282828));
        m3.setBackground(new Color(0x282828));
        middleBar.add("hell", m);
        middleBar.add("JSON", jsonPanel);
        middleBar.add("JSON1", jsonPanel1);
        middleBar.add("JSON2", jsonPanel2);
        middleBar.add("Head", table);
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
        createButtons(Query, "Cookie");
        createButtons(Auth, "Timeline");
        Header.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ((CardLayout) middleBar.getLayout()).show(middleBar, "Head");
            }
        });
    }

    /**
     * creat or costomize our button
     * @param button our aim button
     * @param text text that will be appred on it
     */
    public void createButtons(JButton button, String text) {
        button.setBackground(color);
        button.setText(text);
        button.setForeground(Color.WHITE);
        button.setPreferredSize(new Dimension(20, 40));
    }

    /**
     * creat our pop up here
     */
    public void createPopUp() {
        this.setBackground(new Color(0xFFFAFA));
        Font title = new Font("myFont", Font.ITALIC, 10);
        Font menu = new Font("myFont", Font.PLAIN, 12);
        popupMenu.setBorder(BorderFactory.createCompoundBorder(this.getBorder(), BorderFactory.createEmptyBorder(3, 0, 0, -4)));
        JMenuItem INSOMNIA = new JMenuItem("Priview Mode  _____________________________");
        INSOMNIA.setBorder(BorderFactory.createCompoundBorder(INSOMNIA.getBorder(), BorderFactory.createEmptyBorder(3, 2, 3, 0)));
        INSOMNIA.setFont(title);
        INSOMNIA.setBackground(new Color(0xFFFFFF));
        popupMenu.add(INSOMNIA);
        INSOMNIA.setEnabled(false);

        JMenuItem form = new JMenuItem("RAW");
        form.setBorder(BorderFactory.createCompoundBorder(form.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 0)));
        form.setFont(menu);
        form.setBackground(new Color(0xFFFFFF));
        popupMenu.add(form);
        form.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Body.setText(form.getText());
                ((CardLayout) middleBar.getLayout()).show(middleBar, "JSON");

            }
        });

        JMenuItem json = new JMenuItem("JSON");
        json.setBorder(BorderFactory.createCompoundBorder(json.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 0)));
        json.setFont(menu);
        json.setBackground(new Color(0xFFFFFF));
        popupMenu.add(json);
        json.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Body.setText(json.getText());
                ((CardLayout) middleBar.getLayout()).show(middleBar, "JSON1");
            }

        });
        JMenuItem binary = new JMenuItem("MESSEGE");
        binary.setBorder(BorderFactory.createCompoundBorder(binary.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 0)));
        binary.setFont(menu);
        binary.setBackground(new Color(0xFFFFFF));
        popupMenu.add(binary);
        binary.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Body.setText(binary.getText());
                ((CardLayout) middleBar.getLayout()).show(middleBar, "JSON2");
            }
        });

    }

}
