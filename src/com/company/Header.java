package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * in this class we will create sth like headers that we
 * put into the headers panel in middle panel .
 */
public class Header extends JPanel {
    Insomina insomina;
    String header = "  ";
    EachHeader focousHeader;
    String value = "  ";
    int count = 0;
    private Boolean isAble = false;
    JPanel general = new JPanel();
    LinkedHashMap<JPanel, String> headerDictionary = new LinkedHashMap<>();
    /**
     * here we have our every each of kind headers
     * that we create them
     */
    public Header(String first, String sec, Insomina insomina) {
        general.setLayout(new BoxLayout(general, BoxLayout.Y_AXIS));
        general.add(create());
        add(general);
        setBackground(Coloring.darkBack());
        this.insomina = insomina;
    }

    public class EachHeader {
        JPanel panel = new JPanel();
        Boolean isDeletable = true;
        JCheckBox ch = new JCheckBox();
        /**
         * here we create them (each of header)
         */
        public EachHeader() {
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
            addHover(headers, "header...");
            panel.add(values);
            ch.setBackground(Coloring.darkBack());
            panel.add(ch);
            garbage.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    System.out.println("pak kon");
                    System.out.println(count);
                    System.out.println(isDeletable);
                    super.mousePressed(e);
                    if (count > 1 && isDeletable && !isLast(panel)) {
                        System.out.println("we remove");
                        if (headerDictionary.size() > 1) {
                            headerDictionary.remove(panel);
                            addToGeneral();
                            count--;
                        }
                    }
                    panel.updateUI();
                    general.repaint();
                    general.revalidate();
                    general.updateUI();
                    updateUI();
                }
            });
            ch.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    super.mouseClicked(e);
                    if (headers.getBackground().equals(Coloring.darkBack())) {
                        headers.setBackground(Coloring.insomniaPurple());
                        values.setBackground(Coloring.insomniaPurple());
                        isDeletable = false;
                        headers.setEnabled(false);
                        values.setEnabled(false);
                        try {
                            insomina.requestDictionary.get(insomina.key).headerTxt += headers.getText() + ":" + values.getText() + ";";
                        } catch (NullPointerException e1) {
                            System.out.println("ieosfjsiogjhsoi");
                        }
                        isAble = true;
                        System.out.println("next :");
                        System.out.println(insomina.requestDictionary.get(insomina.key).headerTxt + "      header trxt");
                    }
                    // off
                    else {
                        headers.setBackground(Coloring.darkBack());
                        values.setBackground(Coloring.darkBack());
                        isDeletable = true;
                        isAble = false;
                        values.setEnabled(true);
                        headers.setEnabled(true);
                        System.out.println("removing");
                        try {
                            insomina.requestDictionary.get(insomina.key).headerTxt = insomina.requestDictionary.get(insomina.key).headerTxt
                                    .replace(headers.getText() + ":" + values.getText() + ";", "");
                        } catch (NullPointerException e1) {
                            System.out.println("ieosfjsiogjhsoi");
                        }
                        System.out.println(insomina.requestDictionary.get(insomina.key).headerTxt + "   removing");
                    }
                }
            });
            headers.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    super.mousePressed(e);
                    String newText = headers.getText().replaceAll(" ", "");
                    String newText1 = values.getText().replaceAll(" ", "");
                    newText = newText.replaceAll("header...", "");
                    newText1 = newText1.replaceAll("value...", "");
                    if (newText.equals("") && newText1.equals(""))
                        general.add(create());
                    general.updateUI();
                    updateUI();
                }
            });
            values.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    super.mousePressed(e);
                    String newText = headers.getText().replaceAll(" ", "");
                    String newText1 = values.getText().replaceAll(" ", "");
                    newText = newText.replaceAll("header...", "");
                    newText1 = newText1.replaceAll("value...", "");
                    System.out.println(newText + "   " + newText1);
                    if (newText.equals("") && newText1.equals("")) {
                        general.add(create());
                        System.out.println("here");
                    }
                    general.updateUI();
                    updateUI();
                }
            });
            panel.add(garbage);
            panel.setBackground(Coloring.darkBack());
            count++;
        }
    }
    /**
     * with this method we create another each form
     * @return a header pannel
     */
    public JPanel create() {
        EachHeader header = new EachHeader();
        headerDictionary.put(header.panel, String.valueOf(System.currentTimeMillis()));
        return header.panel;
    }

    /**
     * with this method we put
     * hover action on them
     * @param txt      our text field
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

    /**
     * here we add them to the general pannel
     */
    public void addToGeneral() {
        general.removeAll();
        for (Map.Entry<JPanel, String> A :
                headerDictionary.entrySet()) {
            general.add((JPanel) A.getKey());
        }
    }
    /**
     * a method to get this each form is last one or not
     * @param panel our pannel (key in this way)
     * @return
     */
    public boolean isLast(JPanel panel) {
        long maxTime = 0;
        for (Map.Entry<JPanel, String> A :
                headerDictionary.entrySet()) {
            if (Long.parseLong(A.getValue()) > maxTime)
                maxTime = Long.parseLong(A.getValue());
        }
        return maxTime == Long.parseLong(headerDictionary.get(panel));
    }
}
