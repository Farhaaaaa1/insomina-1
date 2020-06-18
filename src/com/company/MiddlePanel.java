package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * all thing here are about middle panel
 * wich have 3,4 class
 */
public class MiddlePanel extends JPanel {
    JButton cb = new JButton();
    JLabel send = new JLabel("SEND");
    JTextField textField = new JTextField();
    String text = "option";
    Color colorr;
    MidBar midBar;
    Boolean isFirst = true;
    JPanel upBar = new JPanel();
    JPopupMenu popupMenu = new JPopupMenu();
    Insomina insomina;
    int x = 27;
    int y = 14;
    Image[] icons = {changSize(new ImageIcon("src/del.png"), x - 2, y), changSize(new ImageIcon("src/get.png"), x - 2, y),
            changSize(new ImageIcon("src/post.png"), x + 5, y), changSize(new ImageIcon("src/put.png"), x, y),
            changSize(new ImageIcon("src/patc.png"), x, y), changSize(new ImageIcon("src/clock.png"), 500, 600)};

    /**
     * create base of the middle pannel
     *
     * @param insomina our main frame
     */
    public MiddlePanel(Insomina insomina) {
        this.insomina = insomina;
        setLayout(new BorderLayout());
        add(upBar, BorderLayout.NORTH);
        midBar = new MidBar(insomina);
        add(midBar, BorderLayout.CENTER);
        prepareText(textField);
        upBar.setLayout(new BorderLayout());
        setSendBtn(send);
        setCb(Coloring.bone(), "Opt");
        cb.setBorder(BorderFactory.createCompoundBorder(cb.getBorder(), BorderFactory.createEmptyBorder(0, -20, 0, 0)));
        send.setBorder(BorderFactory.createCompoundBorder(send.getBorder(), BorderFactory.createEmptyBorder(0, 15, 0, 0)));
        setPopupMenu();
        upBar.add(Box.createRigidArea(new Dimension(5, 45)));
        upBar.add(textField, BorderLayout.CENTER);
        upBar.add(cb, BorderLayout.WEST);
        upBar.add(send, BorderLayout.EAST);
        // updateUI();
    }

    /**
     * with this method we prepare CB button
     *
     * @param c color that we want to colord the button with
     * @param s Text that we want to put it in this component
     */
    public void setCb(Color c, String s) {
        cb.setPreferredSize(new Dimension(70, 5));
        cb.setFont(new Font("WTD", Font.LAYOUT_NO_LIMIT_CONTEXT, 15));
        cb.setOpaque(true);
        cb.setBorderPainted(false);
        cb.setBackground(c);
        cb.setText(s);
        cb.setEnabled(false);
        upBar.repaint();
        upBar.revalidate();
        upBar.updateUI();
        cb.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                popupMenu.show(cb, e.getX(), e.getY());
            }
        });
    }

    /**
     * with this method we prepare CB button
     *
     * @param btn labale that we want to costumize it
     */
    public void setSendBtn(JLabel btn) {
        btn.setPreferredSize(new Dimension(75, 5));
        btn.setBackground(Coloring.bone());
        btn.setFont(new Font("WTF", Font.LAYOUT_NO_LIMIT_CONTEXT, 15));
        btn.setOpaque(true);
        btn.setEnabled(false);
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                try {
                    createResponse();
                } catch (NullPointerException ignored) {
                }
            }
        });

    }

    /**
     * finally we will create popUpmenu with all details
     */
    public void setPopupMenu() {
        Color color = Color.WHITE;
        JMenuItem del = new JMenuItem("DEL");
        del.setBackground(color);
        del.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text = del.getText();
                colorr = Coloring.red();
                setCb(colorr, text);
                linkToRequest(0);
            }
        });
        JMenuItem get = new JMenuItem("GET");
        get.setBackground(color);
        get.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text = get.getText();
                colorr = Coloring.blue();
                setCb(colorr, text);
                linkToRequest(1);
            }
        });
        JMenuItem post = new JMenuItem("POST");
        post.setBackground(color);
        post.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text = post.getText();
                colorr = Coloring.purple();
                setCb(colorr, text);
                linkToRequest(2);
            }
        });
        JMenuItem put = new JMenuItem("PUT");
        put.setBackground(color);
        put.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text = put.getText();
                colorr = Coloring.green();
                setCb(colorr, text);
                linkToRequest(3);
            }
        });
        JMenuItem pats = new JMenuItem("PATC");
        pats.setBackground(color);
        pats.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text = pats.getText();
                colorr = Coloring.orange();
                setCb(colorr, text);
                linkToRequest(4);
            }
        });


        if (isFirst) {
            addToPup(del, Coloring.red());
            addToPup(get, Coloring.blue());
            addToPup(post, Coloring.purple());
            addToPup(put, Coloring.green());
            addToPup(pats, Coloring.orange());
            isFirst = false;
        }

        System.out.println("3");
    }

    /**
     * add item to pop up
     * http://apapi.haditabatabaei.ir/docs
     *
     * @param a   what we want to add
     * @param col color of item
     */
    public void addToPup(JMenuItem a, Color col) {
        popupMenu.add(a);
        a.setForeground(col);
        a.setBorder(BorderFactory.createCompoundBorder(a.getBorder(), BorderFactory.createEmptyBorder(8, 5, 8, 12)));
        a.setFont(new Font("hell", Font.ITALIC, 12));
    }

    /**
     * we will prepare text field hare
     * with all details
     *
     * @param txt our text field
     */
    public void prepareText(JTextField txt) {
        txt.setPreferredSize(new Dimension(110, 45));
        txt.setBorder(BorderFactory.createCompoundBorder(upBar.getBorder(), BorderFactory.createEmptyBorder(8, 3, 8, 10)));
        txt.setBackground(Coloring.white());
        txt.setFont(new Font("WTF", Font.ROMAN_BASELINE, 15));
        txt.setForeground(Color.gray);
        txt.setText("http://apapi.haditabatabaei.ir");
        txt.addMouseListener(new Hover(txt, Color.gray));
        revalidate();
        repaint();
        txt.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                if (txt.getText().equals(""))
                    txt.setText("http://apapi.haditabatabaei.ir");
            }
        });
        revalidate();
        repaint();
        txt.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                try {
                    insomina.requestDictionary.get(insomina.key).url = txt.getText();
                } catch (NullPointerException ignored) {
                }
            }
        });
    }

    /**
     * with this method we can change the size of image easiely
     * @param icon our icon
     * @param x width
     * @param y height
     * @return our image in new size
     */
    public Image changSize(ImageIcon icon, int x, int y) {
        return icon.getImage().getScaledInstance(x, y, Image.SCALE_DEFAULT);
    }

    /**
     * with this method we link middle pannel to our request
     * @param kind kind of method
     */
    public void linkToRequest(int kind) {
        insomina.requestDictionary.get(insomina.key).label.setIcon(new ImageIcon(icons[kind]));
        insomina.requestDictionary.get(insomina.key).kind = kind;
    }

    public void createResponse() {
        new SwingWorker<String, Object>() {
            @Override
            protected String doInBackground() throws Exception {
                insomina.rightPanel.removeAll();
                insomina.rightPanel.setLayout(new BorderLayout());
                JLabel label = new JLabel();
                label.setIcon(new ImageIcon(icons[5]));
                insomina.rightPanel.add(label, BorderLayout.CENTER);
                insomina.repaint();
                insomina.revalidate();
                RequestModel requestModel = new RequestModel(insomina.requestDictionary.get(insomina.key).createGUIRequest());
                if (requestModel.getSendable())
                    new RequestSending(requestModel, insomina).sendRequest();
                else {
                    JOptionPane.showMessageDialog(insomina, " you put sth wrong ");
                    insomina.requestDictionary.get(insomina.key).getResponsRequirement.setCode(-1);
                    insomina.requestDictionary.get(insomina.key).getResponsRequirement.setBytee(null);
                    insomina.requestDictionary.get(insomina.key).getResponsRequirement.setBytee(null);
                    insomina.requestDictionary.get(insomina.key).getResponsRequirement.setTime(null);

                }
                return "";
            }

            @Override
            protected void done() {
                super.done();
                insomina.rightPanel.removeAll();
                createRightPanel();
                System.out.println();
                insomina.rightPanel.repaint();
                insomina.rightPanel.revalidate();
                // } catch (InterruptedException | NullPointerException | ExecutionException ignored) {
                //  }

            }
        }.execute();
    }

    /**
     * create right panel here after we remove all of them
     */
    public void createRightPanel() {
        String code = "";
        Color color = new Color(0xEBEBE6);
        Request myRequest = insomina.requestDictionary.get(insomina.key);
        insomina.rightPanel.setLayout(new BorderLayout());
        insomina.rightPanel.add(insomina.rightPanel.upBar, BorderLayout.NORTH);
        MidBarForRight midBar = new MidBarForRight(insomina);
        insomina.rightPanel.add(midBar, BorderLayout.CENTER);
        insomina.rightPanel.upBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        insomina.rightPanel.setBtn(insomina.rightPanel.time);
        insomina.rightPanel.setBtn(insomina.rightPanel.speed);
        try {
            if (insomina.requestDictionary.get(insomina.key).getResponsRequirement.getCode() == -1) {
                code = "Error";
                color = Coloring.tomato();
            } else if (myRequest.getResponsRequirement.getCode() < 300) {
                code = "OK";
                color = Coloring.shinyGreen();
            } else if (myRequest.getResponsRequirement.getCode() == 999) {
                code = "linkdn";
                color = new Color(0x51D4EA);
            } else {
                code = "Error";
                color = Coloring.tomato();
            }
            insomina.rightPanel.setCb(color, " " + myRequest.getResponsRequirement.getCode() + " " + code, insomina.rightPanel.cb);
            System.out.println(" " + myRequest.getResponsRequirement.getCode() + "  code");
            insomina.rightPanel.time.setText(" " + myRequest.getResponsRequirement.getTime() + " ms");
            insomina.rightPanel.speed.setText(" " + myRequest.getResponsRequirement.getBytee() + " KB");
            Raw.textArea.setText(myRequest.getResponsRequirement.getBody());
        } catch (NullPointerException ignored) {
        }
    }



}
