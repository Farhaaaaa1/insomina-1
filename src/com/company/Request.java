package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

/**
 * creat request here
 * and also give them detailes
 */
public class Request extends Files {
    Insomina insomina;
    String headerTxt = "";
    String jsonTxt = "-j ";
    String uploadTxt = " --upload ";
    String formTxt = "-d ";
    JLabel label;
    String messageBody = "";
    String url = "http://apapi.haditabatabaei.ir/docs";
    int kind;
    JLabel labelTxt;
    String noNumber;
    JPanel panel = new JPanel();
    JPanel temp = new JPanel();
    Header header;
    Form form;
    JsonPanel jsonPanel;
    BinaryPanel binaryPanel;
    // image of kinds of requests
    int x = 27;
    int y = 14;
    Image[] icons = {changSize(new ImageIcon("src/del.png"), x - 2, y), changSize(new ImageIcon("src/get.png"), x - 2, y),
            changSize(new ImageIcon("src/post.png"), x + 5, y), changSize(new ImageIcon("src/put.png"), x, y),
            changSize(new ImageIcon("src/patc.png"), 27, y)};
    Color color;

    public Request(LeftPanel leftPanel, String txt, int kind, Color color, Insomina insomina, String noNumber) {
        super(leftPanel);
        this.kind = kind;
        this.noNumber = noNumber;
        header = new Header("", "", insomina);
        form = new Form("", "", insomina);
        jsonPanel = new JsonPanel(insomina);
        binaryPanel = new BinaryPanel(insomina);
        text = txt;
        this.insomina = insomina;
        this.color = color;
        panel.setVisible(true);
        label = new JLabel(new ImageIcon(icons[kind]));
        label.setBackground(color);
        labelTxt = new JLabel(txt);
        labelTxt.setFont(new Font("hell", Font.PLAIN, 11));
        labelTxt.setForeground(Color.WHITE);
        JButton btn = new JButton(new ImageIcon(changSize(new ImageIcon("src/Garbage.png"), 11, 13)));
        comouflage(btn, color);
        panel.setLayout(new BorderLayout());
        panel.add(label, BorderLayout.WEST);
        addActions(btn);
        temp.setBackground(color);
        btn.setBorder(BorderFactory.createCompoundBorder(btn.getBorder(), BorderFactory.createEmptyBorder(1, 8, 1, 8)));
        panel.add(temp, BorderLayout.CENTER);
        temp.setLayout(new BorderLayout());
        label.setBorder(BorderFactory.createCompoundBorder(label.getBorder(), BorderFactory.createEmptyBorder(8, 7, 8, 8)));
        temp.add(labelTxt, BorderLayout.WEST);
        panel.setBackground(color);
        panel.add(btn, BorderLayout.EAST);
        generalPanel.add(panel);
    }

    /**
     * @param btn our aim button
     *            add action to button
     *            we implemet  all the actions on what we want here
     */
    public void addActions(JButton btn) {
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                btn.setBackground(new Color(0x514822));
                panel.setBackground(new Color(0x514822));
                temp.setBackground(new Color(0x514822));
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println("1");
                System.out.println("comp");
                generalPanel.remove(panel);
                generalPanel.updateUI();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                panel.setBackground(color);
                temp.setBackground(color);
                btn.setBackground(color);
            }
        });
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                btn.setBackground(new Color(0x514822));
                panel.setBackground(new Color(0x514822));
                temp.setBackground(new Color(0x514822));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                panel.setBackground(color);
                temp.setBackground(color);
                btn.setBackground(color);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                insomina.key = noNumber;
                JPanel m = new JPanel();
                m.setBackground(new Color(0x282828));
                m.setLayout(new BorderLayout());
                JLabel hand = new JLabel(new ImageIcon("src/hand.png"));
                m.add(hand, BorderLayout.CENTER);
                insomina.middlePanel.setCb(getColor(kind), getText(kind));
                insomina.middlePanel.revalidate();
                insomina.middlePanel.midBar.middleBar.removeAll();
                insomina.middlePanel.midBar.middleBar.add("hand", m);
                insomina.middlePanel.midBar.middleBar.add("binary", binaryPanel);
                insomina.middlePanel.midBar.middleBar.add("JSON", jsonPanel);
                insomina.middlePanel.midBar.middleBar.add("form", form);
                insomina.middlePanel.midBar.middleBar.add("Head", header);
                System.out.println(Arrays.toString(new int[]{insomina.middlePanel.midBar.middleBar.getComponents().length}) + "  size");
                System.out.println("json " + jsonTxt + " header " + headerTxt + "  upload " + uploadTxt + "  form  " + formTxt);
                System.out.println(createGUIRequest());
                insomina.middlePanel.midBar.updateUI();
            }
        });
    }

    public Color getColor(int kind) {
        switch (kind) {
            case 0:
                return Coloring.red();
            case 1:
                return Coloring.blue();
            case 2:
                return Coloring.purple();
            case 3:
                return Coloring.green();
            case 4:
                return Coloring.orange();
            default:
                return Coloring.bone();
        }
    }

    public String getText(int kind) {
        switch (kind) {
            case 0:
                return "DELETE";
            case 1:
                return "GET";
            case 2:
                return "POST";
            case 3:
                return "PUT";
            case 4:
                return "PATCH";
            default:
                return "";
        }
    }

    public String createGUIRequest() {
        String request = url + " --method " + getText(this.kind) + " ";
        System.out.println("");
        System.out.println(messageBody + "  messege body");
        messageBody=messageBody.replaceAll("\\s{2,}", " ");
        System.out.println(messageBody.split(" ").length);
        if(messageBody.split(" ").length>1)
            request = request+messageBody;
        if (!headerTxt.equals(""))
            return request + " --headers " + headerTxt;
        else
            return request;
    }
}