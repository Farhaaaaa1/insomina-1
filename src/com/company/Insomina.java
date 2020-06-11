package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.HashMap;

/**
 * in this project we want to simulation
 * of insomina application
 * @author Farhan Farsi
 * @version 0.0
 */
public class Insomina extends JFrame {
    HashMap<String,Request> requestDictionary = new HashMap<>();
    Menus menu = new Menus() ;
    LeftPanel leftPanel = new LeftPanel(this);
    String key = "";
    MiddlePanel middlePanel = new MiddlePanel(this);
    RightPanel rightPanel = new RightPanel(this);


    /**
     * create one inner class to create menu and menu bar
     */
    public class Menus extends JMenuBar {
        public Menus() {
            add(initAppMenu());
            add(initViewMenu());
            add(initHelpMenu());
        }

        /**
         * create application menu
         * @return application menu
         */
        public JMenu initAppMenu() {
            JMenu app = new JMenu("Application");
            JMenuItem exit = new JMenuItem("Exit");
            exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
            JMenuItem option = new JMenuItem("Option");
            option.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
            option.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JDialog dialog = new JDialog();
                    dialog.setLayout(new GridLayout(2,1));
                    JCheckBox first = new JCheckBox("follow redirect");
                    JCheckBox seccond = new JCheckBox("exit ?");
                    dialog.add(first);
                    dialog.add(seccond);
                    dialog.setSize(new Dimension(200,200));
                    dialog.setVisible(true);

                }
            });
            exit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                }
            });
            app.add(exit);
            app.add(option);
            return app;
        }
        /**
         * create help menu
         * @return Help menu
         */
        public JMenu initHelpMenu() {
            JMenu Help = new JMenu("Help");
            JMenuItem help = new JMenuItem("Help");
            help.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
            JMenuItem about = new JMenuItem("About");
            about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
            help.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(Insomina.this, "nothing right now", "Help", JOptionPane.INFORMATION_MESSAGE);

                }
            });
            about.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(Insomina.this, "Farhan Farsi , NO 9831094 , known as sootoon e gang", "About", JOptionPane.INFORMATION_MESSAGE);

                }
            });
            Help.add(help);
            Help.add(about);
            return Help;
        }

        /**
         * create view menu
         * @return View menu
         */
        public JMenu initViewMenu() {
            JMenu view = new JMenu("View");
            JMenuItem full = new JMenuItem("Toggle Full Screen");
            full.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
            JMenuItem side = new JMenuItem("Toggle Sidebar");
            side.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()));
            full.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (Insomina.this.getExtendedState() != JFrame.MAXIMIZED_BOTH)
                        Insomina.this.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    else
                        Insomina.this.setExtendedState(JFrame.NORMAL);
                }
            });
            side.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (Insomina.this.leftPanel.isVisible())
                        Insomina.this.leftPanel.setVisible(false);
                    else if (!Insomina.this.leftPanel.isVisible())
                        Insomina.this.leftPanel.setVisible(true);
                    updateUI();
                }
            });
            view.add(full);
            view.add(side);
            return view;
        }
    }
    /**
     * first class that have all 3 paanel and combine them to
     * getter with Panel3 class.
     */
    public Insomina() {
        setLocation(240,260);
        Panels3 panels3 = new Panels3(this);
        this.setJMenuBar(menu);
        setLayout(new GridLayout(1, 1));
        add(panels3);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
    }
}

