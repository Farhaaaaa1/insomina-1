package com.company;

import javax.swing.*;
import java.awt.*;

public class Panels3  extends JPanel {
    public Panels3(Insomina frame) {
        BorderLayout layout = new BorderLayout();
        this.setLayout(new GridLayout(1,1));
        frame.middlePanel.setBackground(new Color(0x282828));
        frame.leftPanel.setBackground(new Color(0x2D2D2D));
        frame.rightPanel.setBackground(new Color(0x282828));
       // frame.midPanel.add(hand,BorderLayout.CENTER);
         JSplitPane s = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,frame.leftPanel,frame.middlePanel);
         JSplitPane s1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,s,frame.rightPanel);
         add(s1);
    }
}
