package com.company;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * in this class we will create headers that we
 * put into the headers panel in middle panel .
 */
public class Header extends JPanel {
    String header = "  ";
    String value = "   ";
    int count = 0;
    private JPanel panel = new JPanel();
    private Boolean isAble = false;
    JPanel general = new JPanel();
    public Header(String first, String sec) {
        general.setLayout(new BoxLayout(general, BoxLayout.Y_AXIS));
        general.add(create());
        add(general);
        setBackground(new Color(0x282828));
    }

    public JPanel getPanel() {
        return panel;
    }

    public Boolean getAble() {
        return isAble;
    }

    public JPanel create() {
        JPanel panel = new JPanel();
        JCheckBox ch = new JCheckBox();
        ch.setFocusable(false);
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JTextField headers = new JTextField();
        headers.setText(header);
        headers.setColumns(10);
        JLabel garbage = new JLabel(new ImageIcon(new ImageIcon("src/garbage.png").getImage().getScaledInstance(16, 14, Image.SCALE_DEFAULT)));
        panel.setBorder(BorderFactory.createCompoundBorder(panel.getBorder(), BorderFactory.createEmptyBorder(10, 5, 5, 0)));
        panel.add(headers);
        headers.setForeground(new Color(0x8B8B8B));
        headers.setBackground(new Color(0x282828));
        headers.setBorder(BorderFactory.createCompoundBorder(headers.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 0)));
        JTextField values = new JTextField();
        values.setText(value);
        values.setColumns(10);
        values.setForeground(new Color(0x8B8B8B));
        values.setBackground(new Color(0x282828));
        values.setBorder(BorderFactory.createCompoundBorder(values.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 0)));

        panel.add(values);
        panel.add(ch);

        garbage.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println(count);
                super.mousePressed(e);
                if (count > 1) {
                    general.remove(panel);
                    count--;
                }
                general.updateUI();
                updateUI();
            }
        });

        ch.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (headers.getForeground().equals(new Color(0x8B8B8B))) {
                    headers.setForeground(new Color(0x3E3E3E));
                    values.setForeground(new Color(0x3E3E3E));
                    isAble = true;
                } else {
                    headers.setForeground(new Color(0x8B8B8B));
                    values.setForeground(new Color(0x8B8B8B));
                    isAble = false;
                }
            }
        });
        headers.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                if (headers.getText().replaceAll(" ", "").equals("") && values.getText().replaceAll(" ", "").equals(""))
                    general.add(create());
                general.updateUI();
                updateUI();
            }
        });
        values.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                if (headers.getText().replaceAll(" ", "").equals("") && values.getText().replaceAll(" ", "").equals(""))
                    general.add(create());
                general.updateUI();
                updateUI();
            }
        });
        panel.add(garbage);
        panel.setBackground(new Color(0x282828));
        count++;
        return panel;
    }
}
