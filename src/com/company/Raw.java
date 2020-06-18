package com.company;

import javax.swing.*;
import java.awt.*;

/**
 * panel of raw that show the raw panel
 */
public class Raw extends JPanel {
    Insomina insomina;
   static JTextArea textArea = new JTextArea();
    public Raw(Insomina insomina) {
        JScrollPane scrollPane = new JScrollPane(textArea);
        this.insomina = insomina;
        setLayout(new BorderLayout());
        setBackground(Coloring.darkBack());
        add(scrollPane,BorderLayout.CENTER);
        textArea.setBackground(Coloring.darkBack());
        textArea.setForeground(Coloring.bone());
        textArea.setEditable(false);
    }
}
