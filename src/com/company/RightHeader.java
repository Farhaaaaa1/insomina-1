package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * create the table here
 */
public class RightHeader extends JPanel {
    Insomina insomina;
   static String[][] myStr = null;
   static JTable table;
    /**
     * just creat one example
     */
    public RightHeader(Insomina insomina) {
        this.insomina = insomina;
        Request myRequest = insomina.requestDictionary.get(insomina.key);
        String data[][] = {{"  Farhan", "  Farsi"},
                {"  SERVER", "  ENGINEX",},
                {"  Etag", "  435"}, {"  Sootoon", "  Gang"},
                {"  Soltan", "  Qalb ha",},
                {"  Hazrat", "  Eshq"}, {"  Farhan", "  Farsi"},
                {"  Soltan", "  Farhan",},
                {"  Salatin", "  AUT"}};
        myStr = data;
        String column[] = {"NAME", "VALUE"};
        table = new JTable(myStr, column);
        table.setEnabled(false);
        JScrollPane sp = new JScrollPane(table);
        sp.setBackground(new Color(0x282828));
        table.setBackground(new Color(0x282828));
        table.setForeground(Color.WHITE);
        setLayout(new BorderLayout());
        table.setRowHeight(50);
        setBackground(new Color(0x282828));
        add(sp, BorderLayout.NORTH);
        JButton btn = new JButton("copy to clip board");
        add(btn, BorderLayout.SOUTH);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String myString = " ";
                StringSelection stringSelection = new StringSelection(myString);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, null);
            }
        });


    }
}
