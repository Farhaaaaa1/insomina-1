package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BinaryPanel extends JPanel {
    public BinaryPanel(JFileChooser file , Insomina insomina) {
        setBackground(Coloring.darkBack());
        setLayout(new BorderLayout());
        JTextField path = new JTextField();
        path.setCaretColor(Coloring.darkBack());
        path.setBackground(Coloring.darkBack());
        add(path,BorderLayout.NORTH);
        path.setBorder(BorderFactory.createCompoundBorder(path.getBorder(), BorderFactory.createEmptyBorder(0, 5, 0, 0)));
        path.setForeground(Coloring.bone());
        path.setFont(new Font("hjhk",Font.ITALIC,14));
        if(file.getSelectedFile()!=null)
        { path.setText(file.getSelectedFile().getPath());
            System.out.println("anjam shod");
        }
        repaint();
        revalidate();
        updateUI();
        path.setPreferredSize(new Dimension(40,40));
    }
}
