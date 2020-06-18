package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * our jason panel that include textfield
 */
public class JsonPanel extends JPanel {
    Insomina insomina;
    JTextArea textField = new JTextArea();
    Color myColor = new Color(0x2D2D2D);
    public JsonPanel(Insomina insomina) {
        this.insomina = insomina;
        textField.setBorder(BorderFactory.createCompoundBorder(textField.getBorder(), BorderFactory.createEmptyBorder(25, 15, 0, 0)));
        setLayout(new BorderLayout());
        setBackground(myColor);
        textField.setBackground(myColor);
        textField.setForeground(Coloring.orange());
        textField.setFont(new Font("WTF",Font.PLAIN,15));
        try{
            textField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyTyped(KeyEvent e) {
                    super.keyTyped(e);
                    try{
                    insomina.requestDictionary.get(insomina.key).jsonTxt= "-j " +textField.getText();
                    insomina.requestDictionary.get(insomina.key).messageBody = insomina.requestDictionary.get(insomina.key).jsonTxt;}
                    catch (NullPointerException ignored){}
                }
            });
        }
        catch (NullPointerException ignored){}
        add(textField,BorderLayout.CENTER);
    }
}
