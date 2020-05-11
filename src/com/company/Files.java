package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public abstract class Files  {

    public JPanel generalPannel = new JPanel();
    public String text;
    public JButton down = new JButton(new ImageIcon("src/down1.png"));
    public static final Color myColor = new Color(0x353535);
    protected LeftPanel leftPanel;
    public Files(LeftPanel leftPanel) {
        this.leftPanel = leftPanel;
        generalPannel.setLayout(new BoxLayout(generalPannel,BoxLayout.Y_AXIS));
        down.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                down.setBackground(myColor.brighter());
                //label.setBackground(myColor.brighter());

            }

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("1");

            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                //label.setBackground(myColor);
                down.setBackground(myColor);


            }
        });
    }

    protected Image changSize(ImageIcon icon, int x, int y) {
        JLabel a = new JLabel();
        return icon.getImage().getScaledInstance(x, y, Image.SCALE_DEFAULT);

    }
    public void comouflage(JButton btn, Color color) {
        btn.setPreferredSize(new Dimension(38, 5));
        btn.setBackground(color);
        btn.setOpaque(true);
        btn.setBorderPainted(false);
        btn.setEnabled(false);
    }
}
