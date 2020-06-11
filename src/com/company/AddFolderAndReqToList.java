package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddFolderAndReqToList extends MouseAdapter {
    JButton plus = new JButton();
    Color color;
    Boolean isFirst = true;
    JPopupMenu popupMenu = new JPopupMenu();
    LeftPanel leftPanel;
    String openOrNot = "Close";
    Insomina insomina;

    public AddFolderAndReqToList(JButton plus, LeftPanel leftPanel, Insomina insomina) {
        this.plus = plus;
        this.leftPanel = leftPanel;
        this.insomina = insomina;
        color = plus.getBackground();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
        if (isFirst)
            popUpCreating(popupMenu);
        popupMenu.show(plus, e.getX(), e.getY());
//         String name1 = JOptionPane.showInputDialog("enter your name bro ") ;
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
        JMenuItem folder = createItem("New Folder");
        JMenuItem request = createItem("New Request");
        popupMenu.add(folder);
        folder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leftPanel.folderTxt = JOptionPane.showInputDialog("enter name of the folder  ");
                leftPanel.files.add(new Folder(leftPanel, leftPanel.folderTxt, new Color(0x2D2D2D),insomina));
                leftPanel.addToReq();
                leftPanel.p.updateUI();
            }
        });

        popupMenu.addSeparator();
        popupMenu.add(request);
        request.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                leftPanel.requestTxt = JOptionPane.showInputDialog("enter name of the request ");
                String kind;
                do {
                    kind = JOptionPane.showInputDialog("type nnumber of what you want " +
                            "\n1-delete\t2-Get\t3-Post\t4-Put\n5-patc ");
                } while (!(kind.equals("2") || kind.equals("1") || kind.equals("3") || kind.equals("4") || kind.equals("5")));
                String noNumber = String.valueOf(System.currentTimeMillis());
                Request request =new Request(leftPanel, leftPanel.requestTxt, Integer.parseInt(kind) - 1, new Color(0x2D2D2D),insomina,noNumber);
                leftPanel.files.add(request);
                leftPanel.addToReq();
                insomina.requestDictionary.put(noNumber,request);
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
}
