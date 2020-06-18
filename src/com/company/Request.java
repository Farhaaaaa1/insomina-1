package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * create request here
 * and also give them detailes
 */
public class Request extends Files {
    Insomina insomina;
    String headerTxt = "";
    String jsonTxt = "-j ";
    String uploadTxt = " --upload ";
    String formTxt = "-d ";
    JLabel label;
    GetResponsRequirement getResponsRequirement;
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
        getResponsRequirement = new GetResponsRequirement();
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
                linkToRightPanel();
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
        System.out.println();
        System.out.println(messageBody + "  messege body");
        messageBody = messageBody.replaceAll("\\s{2,}", " ");
        System.out.println(messageBody.split(" ").length);
        if (messageBody.split(" ").length > 1)
            request = request + messageBody;
        if (!headerTxt.equals(""))
            return request + " --headers " + headerTxt;
        else
            return request;
    }

    /**
     * here we link our requests to right panel
     */
    public void linkToRightPanel() {
        String code = "";
        Color color = new Color(0xEBEBE6);
          try {
        if (getResponsRequirement.getCode() == -1) {
            code = "Error";
            color = Coloring.tomato();
        } else if (getResponsRequirement.getCode() < 300) {
            code = "OK";
            color = Coloring.shinyGreen();
        } else if (getResponsRequirement.getCode() == 999) {
            code = "linkdn";
            color = new Color(0x51D4EA);
        } else {
            code = "Error";
            color = Coloring.tomato();
        }
        insomina.rightPanel.setCb(color, " " + getResponsRequirement.getCode() + " " + code, insomina.rightPanel.cb);
        insomina.rightPanel.time.setText(" " + getResponsRequirement.getTime() + " ms");
        insomina.rightPanel.speed.setText(" " + getResponsRequirement.getBytee() + " KB");
        System.out.println(getResponsRequirement.getCode() + "   codddde");
        System.out.println(insomina.rightPanel.midBar.middleBar.getComponents().length+" length");
        Raw.textArea.setText(getResponsRequirement.getBody());
        RightHeader.myStr = convertMapTo2DArray(getResponsRequirement.getHeaderMap());
        insomina.rightPanel.midBar.repaint();
        insomina.rightPanel.midBar.revalidate();
        insomina.rightPanel.midBar.updateUI();
        System.out.println(getResponsRequirement.getBody());
        insomina.repaint();
        insomina.revalidate();
           } catch (NullPointerException ignored) {
           }
    }
    /**
     * convert maps to 2d array to use for header
     * @param map respons header map
     * @return a 2d array
     */
    public String[][] convertMapTo2DArray(Map<String, java.util.List<String>> map) {
        String[][] myString = new String[map.size()][2];
        int i = 0;
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            myString[i][0]= String.valueOf(entry.getKey());
            myString[i][1]= String.valueOf(entry.getValue().get(0));
            i++;
        }
        return myString;
    }
}