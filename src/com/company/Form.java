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
 * in this class we will create sth like headers that we
 * put into the headers panel in middle panel .
 */
public class Form extends JPanel {
    String header = "  ";
    String value = "   ";
    int count = 0;
    private JPanel panel = new JPanel();
    private Boolean isAble = false;
    JPanel general = new JPanel();
    public Form(String first, String sec) {
        general.setLayout(new BoxLayout(general, BoxLayout.Y_AXIS));
        general.add(create());
        add(general);
        setBackground(Coloring.darkBack());
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
        headers.setForeground(Coloring.fadeWhite());
        headers.setBackground(Coloring.darkBack());
        headers.setBorder(BorderFactory.createCompoundBorder(headers.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 0)));
        JTextField values = new JTextField();
        values.setText(value);
        values.setColumns(10);
        values.setForeground(Coloring.fadeWhite());
        values.setBackground(Coloring.darkBack());
        values.setBorder(BorderFactory.createCompoundBorder(values.getBorder(), BorderFactory.createEmptyBorder(5, 5, 5, 0)));
        addHover(values, "value...");
        addHover(headers, "name...");
        panel.add(values);
        ch.setBackground(Coloring.darkBack());
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
                if (headers.getBackground().equals(Coloring.darkBack())) {
                    headers.setBackground(Coloring.insomniaPurple());
                    values.setBackground(Coloring.insomniaPurple());
                    isAble = true;
                } else {
                    headers.setBackground(Coloring.darkBack());
                    values.setBackground(Coloring.darkBack());
                    isAble = false;
                }
            }
        });
        headers.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                String newText = headers.getText().replaceAll(" ", "") ;
                String newText1 = values.getText().replaceAll(" ", "") ;
                newText = newText.replaceAll("name...","");
                newText1 = newText1.replaceAll("value...","");
                if (newText.equals("")&&newText1.equals(""))
                    general.add(create());
                general.updateUI();
                updateUI();
            }
        });
        values.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                String newText = headers.getText().replaceAll(" ", "") ;
                String newText1 = values.getText().replaceAll(" ", "") ;
                newText = newText.replaceAll("name...","");
                newText1 = newText1.replaceAll("value...","");
                if (newText.equals("")&&newText1.equals(""))
                    general.add(create());
                general.updateUI();
                updateUI();
            }
        });
        panel.add(garbage);
        panel.setBackground(Coloring.darkBack());
        count++;
        return panel;
    }

    /**
     * with this method we put
     * hover action on them
     * @param txt our textfield
     * @param defaultt whats our default text
     */
    public void addHover(JTextField txt, String defaultt) {
        txt.setText(defaultt);
        txt.addMouseListener(new Hover(txt, Color.WHITE));
        revalidate();
        repaint();
        txt.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                if (txt.getText().equals(""))
                    txt.setText(defaultt);
            }
        });
        revalidate();
        repaint();
    }
}
