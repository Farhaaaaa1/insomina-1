package com.company;
import javax.swing.*;
import java.awt.*;

public class Insomina extends JFrame {
    JPanel leftPanel = new JPanel() ;
    JPanel midPanel= new JPanel() ;
    JPanel rightPanel = new JPanel();
    public Insomina(){
        Panels3 panels3 = new Panels3(this) ;
        setLayout(new GridLayout(1,1));
        add(panels3);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700,300);
    }
}
