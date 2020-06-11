package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * abstract class for fiels
 */

public abstract class Files  {
    // our general panel that we show it
    public JPanel generalPanel = new JPanel();
    // name of the files
    public String text;
    public JButton down = new JButton(new ImageIcon("src/down1.png"));
    public static final Color myColor = new Color(0x353535);
    protected LeftPanel leftPanel;

    public Files(LeftPanel leftPanel) {
        this.leftPanel = leftPanel;
        generalPanel.setLayout(new BoxLayout(generalPanel,BoxLayout.Y_AXIS));
        down.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                down.setBackground(myColor.brighter());
                //label.setBackground(myColor.brighter());
            }
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                //label.setBackground(myColor);
                down.setBackground(myColor);
            }
        });
    }

    /**
     * method to change size of the image
     * @return our image at preferrd size
     */
    protected Image changSize(ImageIcon icon, int x, int y) {
        return icon.getImage().getScaledInstance(x, y, Image.SCALE_DEFAULT);
    }
    /**
     * @param btn our aim button
     * @param color color of space
     */
    public void comouflage(JButton btn, Color color) {
        btn.setPreferredSize(new Dimension(38, 5));
        btn.setBackground(color);
        btn.setOpaque(true);
        btn.setBorderPainted(false);
        btn.setEnabled(false);
    }
}
