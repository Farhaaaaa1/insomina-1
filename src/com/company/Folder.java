package com.company;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;

/**
 *creat folders here
 */
public class Folder extends Files {
    JLabel label;
    String openOrNot = "close";
    JLabel labelTxt;
    Boolean isFirst = true;
    JPanel innerFolders = new JPanel();
    public JPanel panel = new JPanel();
    JPanel temp = new JPanel();
    JPopupMenu popupMenu = new JPopupMenu();
    Image[] icons = {changSize(new ImageIcon("src/close.png"), 14, 14), changSize(new ImageIcon("src/open.png"), 14, 14)};
    LinkedList<Files> myFiles = new LinkedList<>();
    Insomina Frame ;
    Color color;

    public Folder(LeftPanel leftPanel, String txt, Color color) {
        super(leftPanel);
        this.color = color;
        this.Frame = Frame ;
        popUpCreating(popupMenu, this);
        panel.setVisible(true);
        label = new JLabel(new ImageIcon(icons[0]));
        label.setBackground(color);
        labelTxt = new JLabel(txt);
        labelTxt.setFont(new Font("hell", Font.PLAIN, 11));
        labelTxt.setForeground(Color.WHITE);
        JButton btn = new JButton(new ImageIcon("src/down1.png"));
        comouflage(btn, color);
        panel.setLayout(new BorderLayout());
        panel.add(label, BorderLayout.WEST);
        addActions(btn);
        innerFolders.setBackground(color);
        innerFolders.setLayout(new BoxLayout(innerFolders, BoxLayout.Y_AXIS));
        temp.setBackground(color);
        btn.setBorder(BorderFactory.createCompoundBorder(btn.getBorder(), BorderFactory.createEmptyBorder(1, 8, 1, 8)));
        panel.add(temp, BorderLayout.CENTER);
        temp.setLayout(new BorderLayout());
        label.setBorder(BorderFactory.createCompoundBorder(label.getBorder(), BorderFactory.createEmptyBorder(8, 7, 8, 8)));
        temp.add(labelTxt, BorderLayout.WEST);
        panel.setBackground(color);
        panel.add(btn, BorderLayout.EAST);
        generalPannel.add(panel);
    }

    /**
     * add all actions for button
     * @param btn
     */
    public void addActions(JButton btn) {
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                btn.setBackground(new Color(0x514822));
                panel.setBackground(new Color(0x514822));
                temp.setBackground(new Color(0x514822));
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("1");
                System.out.println("comp");
                popupMenu.show(btn, e.getX(), e.getY());
                generalPannel.updateUI();

            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                panel.setBackground(color);
                temp.setBackground(color);
                btn.setBackground(color);
            }
        });
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                btn.setBackground(new Color(0x514822));
                panel.setBackground(new Color(0x514822));
                temp.setBackground(new Color(0x514822));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                panel.setBackground(color);
                temp.setBackground(color);
                btn.setBackground(color);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (openOrNot.equals("close")) {
                    generalPannel.add(innerFolders);
                    label.setIcon(new ImageIcon(icons[1]));
                    panel.updateUI();
                    openOrNot = "open";
                } else {
                    generalPannel.remove(innerFolders);
                    label.setIcon(new ImageIcon(icons[0]));
                    panel.updateUI();
                    openOrNot = "close";
                }
                generalPannel.updateUI();

            }
        });
    }

    /**
     * creat pop up here
     */
    public void popUpCreating(JPopupMenu popupMenu, Folder folder1) {
        popupMenu.setBackground(new Color(0xFFFAFA));
        JMenuItem folder = createItem("New Folder");
        JMenuItem request = createItem("New Request");
        JMenuItem remove = createItem("Remove");
        popupMenu.add(folder);
        folder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String foderName = JOptionPane.showInputDialog("enter your name bro ");
                folder1.myFiles.add(new Folder(leftPanel, foderName,color.brighter()));
                addToInner();
                leftPanel.p.updateUI();
            }
        });
        popupMenu.addSeparator();
        popupMenu.add(request);
        request.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String requestName = JOptionPane.showInputDialog("enter your name bro ");
                String kind ;
                do {
                    kind = JOptionPane.showInputDialog("type nnumber of what you want " +
                            "\n1-delete\t2-Get\t3-Post\t4-Put\n5-patc ");
                } while (!(kind.equals("2")||kind.equals("1")||kind.equals("3")||kind.equals("4")||kind.equals("5")));

                folder1.myFiles.add(new Request(leftPanel, requestName,Integer.parseInt(kind)-1,color.brighter()));
                addToInner();
                leftPanel.p.updateUI();
            }
        });
        popupMenu.addSeparator();
        popupMenu.add(remove);
        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generalPannel.remove(panel);
                leftPanel.p.updateUI();
            }
        });
        request.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
        isFirst = false;
    }

    public JMenuItem createItem(String text) {
        Font menu = new Font("myFont", Font.PLAIN, 12);
        JMenuItem INSOMNIA = new JMenuItem(text);
        INSOMNIA.setBorder(BorderFactory.createCompoundBorder(INSOMNIA.getBorder(), BorderFactory.createEmptyBorder(3, 12, 3, 10)));
        INSOMNIA.setFont(menu);
        INSOMNIA.setBackground(new Color(0xFFFFFF));
        return INSOMNIA;
    }

    /**
     * here we add item to folders
     */
    public void addToInner() {
        for (Files f :
                myFiles) {
            innerFolders.add(f.generalPannel);
        }
    }
}