package com.company;

import javax.swing.*;
import java.awt.*;

public class Panels3  extends JPanel {
    public Panels3(Insomina frame) {
        BorderLayout layout = new BorderLayout();
        frame.midPanel.setLayout(layout);
        this.setLayout(new GridLayout(1,1));
        frame.midPanel.setBackground(new Color(0x282828));
        frame.leftPanel.setBackground(new Color(0x2D2D2D));
        JLabel hand = new JLabel(new ImageIcon("src/hand.png"));
        JLabel hand1 = new JLabel(new ImageIcon("src/hand.png"));
        frame.rightPanel.setBackground(new Color(0x282828));
        frame.midPanel.add(hand,BorderLayout.CENTER);
         JSplitPane s = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,frame.leftPanel,frame.midPanel);
         JSplitPane s1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,s,frame.rightPanel);
         add(s1);
    }
}
