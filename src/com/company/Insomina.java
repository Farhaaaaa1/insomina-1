package com.company;
import javax.swing.*;
import java.awt.*;

public class Insomina extends JFrame {
    LeftPanel leftPanel = new LeftPanel(this);
    MiddlePanel middlePanel= new MiddlePanel(this);
    JPanel rightPanel = new JPanel();
    public Insomina(){
        Panels3 panels3 = new Panels3(this) ;
        setLayout(new GridLayout(1,1));
        add(panels3);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,500);
    }
}
//UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());

