package com.company;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class BinaryPanel extends JPanel {
    Insomina insomina;
    File file;
    JFrame frame = new JFrame();
    JFileChooser fileChooser = new JFileChooser();
    JTextField path = new JTextField();
    public BinaryPanel(Insomina insomina) {
        this.insomina = insomina;
        frame.add(fileChooser);
        frame.setVisible(false);
        frame.setBounds(320, 203, 370, 290);
        fileChooser.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                return true;
            }

            @Override
            public String getDescription() {
                return null;
            }
        });

        setBackground(Coloring.darkBack());
        setLayout(new BorderLayout());
        //frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        path.setCaretColor(Coloring.darkBack());
        path.setBackground(Coloring.darkBack());
        add(path, BorderLayout.NORTH);
        path.setBorder(BorderFactory.createCompoundBorder(path.getBorder(), BorderFactory.createEmptyBorder(0, 5, 0, 0)));
        path.setForeground(Coloring.bone());
        path.setFont(new Font("hjhk", Font.ITALIC, 14));
        JButton button = new JButton("CHOOSE you'r file");
        JButton button1 = new JButton("CHOOSE you'r file");
        createFileButton(button, " choose");
        createFileButton(button1, "refresh");
        button1.setEnabled(false);
        JPanel temp = new JPanel();
        temp.setBackground(Coloring.darkBack());
        add(temp);
        temp.setLayout(new BorderLayout());
        JPanel refreshAndChooser = new JPanel();
        refreshAndChooser.setLayout(new GridLayout(1, 2));
        refreshAndChooser.add(button);
        refreshAndChooser.add(button1);
        temp.add(refreshAndChooser, BorderLayout.NORTH);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(true);
                button1.setEnabled(true);
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    file = fileChooser.getSelectedFile();
                    path.setText(file.getPath());
                    insomina.requestDictionary.get(insomina.key).uploadTxt ="--upload  "+ path.getText();
                    insomina.requestDictionary.get(insomina.key).messageBody = insomina.requestDictionary.get(insomina.key).uploadTxt;
                } catch (NullPointerException r) {

                }
            }
        });
        repaint();
        revalidate();
        updateUI();
        path.setPreferredSize(new Dimension(50, 50));
    }

    public void createFileButton(JButton button, String string) {
        button.setBorder(BorderFactory.createCompoundBorder(button.getBorder(), BorderFactory.createEmptyBorder(8, 0, 8, 0)));
        button.setForeground(Coloring.darkBack());
        button.setBackground(Coloring.bone());
        button.setText(string);
    }
}
