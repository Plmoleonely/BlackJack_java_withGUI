import java.awt.Color;

import javax.management.openmbean.OpenDataException;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.DimensionUIResource;

import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextField;

import java.awt.*;
import java.awt.event.*;
import java.io.InputStream;
import java.util.Scanner;

public class MyFrame  {
    protected JButton button;
    protected JButton button2;
    protected JOptionPane jOptionPane;
    protected JLabel label2;
    protected JLabel label3;
    protected JLabel label4;
    protected JLabel label5;
    protected JLabel label6;
    protected JLabel label7;
    protected JLabel label8;
    protected JLabel label9;
    protected JLabel label10;
    protected JLabel label11;
    // JTextField textField;

    public MyFrame(){

        // JTextArea textArea = new JTextArea(10, 50);
        // textArea.setBounds(603, 0, 997, 600);
        // textArea.setFont(new Font("標楷體", Font.BOLD, 25));
        // textArea.setOpaque(true);
        // textArea.setLayout(new BorderLayout());
        // textArea.setVisible(true);

        ImageIcon image = new ImageIcon("BlackJack.png");
        Border border = BorderFactory.createLineBorder(Color.WHITE, 2);
        JLabel label = new JLabel();
        label.setText("二十一點遊戲");
        label.setIcon(image);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setForeground(Color.WHITE);   //change font color
        label.setFont(new Font("標楷體", Font.PLAIN,90));
        label.setIconTextGap(20);
        label.setBackground(Color.BLACK);
        label.setOpaque(true);
        label.setBorder(border);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBounds(0, 0, 600, 900);

        this.label2 = new JLabel(); //"開始遊戲"+"局數:"+this.round++ +" "+"win"+win+" "+"lose"+lose+" "+"tie"+tie
        label2.setHorizontalTextPosition(JLabel.CENTER);
        label2.setVerticalTextPosition(JLabel.TOP);
        label2.setForeground(Color.WHITE);   //change font color
        label2.setFont(new Font("標楷體", Font.PLAIN,30));
        label2.setBackground(Color.BLACK);
        label2.setOpaque(true);
        label2.setBorder(border);
        label2.setVerticalAlignment(JLabel.CENTER);
        label2.setHorizontalAlignment(JLabel.CENTER);
        label2.setBounds(603, 0, 997, 60);

        this.label3 = new JLabel(); //"電腦的牌:" + pcHandDeck.showCard(1) + "電腦還有一張蓋牌"
        label3.setHorizontalTextPosition(JLabel.LEFT);
        label3.setVerticalTextPosition(JLabel.TOP);
        label3.setForeground(Color.WHITE);   //change font color
        label3.setFont(new Font("標楷體", Font.PLAIN,30));
        label3.setBackground(Color.BLACK);
        label3.setOpaque(true);
        // label3.setBorder(border);
        label3.setVerticalAlignment(JLabel.CENTER);
        label3.setHorizontalAlignment(JLabel.LEFT);
        label3.setBounds(603, 60, 997, 60);

        this.label4 = new JLabel();     //s = s + "電腦的第"+(i+1)+"張"+pcHandDeck.showCard(i);
        label4.setHorizontalTextPosition(JLabel.LEFT);
        label4.setVerticalTextPosition(JLabel.TOP);
        label4.setForeground(Color.WHITE);   //change font color
        label4.setFont(new Font("標楷體", Font.PLAIN,30));
        label4.setBackground(Color.BLACK);
        label4.setOpaque(true);
        // label4.setBorder(border);
        label4.setVerticalAlignment(JLabel.CENTER);
        label4.setHorizontalAlignment(JLabel.LEFT);
        label4.setBounds(603, 120, 997, 60);

        this.label5 = new JLabel();
        label5.setHorizontalTextPosition(JLabel.LEFT);
        label5.setVerticalTextPosition(JLabel.TOP);
        label5.setForeground(Color.WHITE);   //change font color
        label5.setFont(new Font("標楷體", Font.PLAIN,25));
        label5.setBackground(Color.BLACK);
        label5.setOpaque(true);
        // label5.setBorder(border);
        label5.setVerticalAlignment(JLabel.CENTER);
        label5.setHorizontalAlignment(JLabel.LEFT);
        label5.setBounds(603, 180, 997, 60);

        this.label6 = new JLabel();
        label6.setHorizontalTextPosition(JLabel.LEFT);
        label6.setVerticalTextPosition(JLabel.TOP);
        label6.setForeground(Color.WHITE);   //change font color
        label6.setFont(new Font("標楷體", Font.PLAIN, 40));
        label6.setBackground(Color.BLACK);
        label6.setOpaque(true);
        // label6.setBorder(border);
        label6.setVerticalAlignment(JLabel.CENTER);
        label6.setHorizontalAlignment(JLabel.LEFT);
        label6.setBounds(603, 240, 997, 60);

        this.label10 = new JLabel();    //"我的牌:" + myHandDeck +" 我的牌合計:" + myHandDeck.sumOfHandCard()
        label10.setHorizontalTextPosition(JLabel.CENTER);
        label10.setVerticalTextPosition(JLabel.TOP);
        label10.setForeground(Color.WHITE);   //change font color
        label10.setFont(new Font("標楷體", Font.PLAIN,25));
        label10.setIconTextGap(20);
        label10.setBackground(Color.BLACK);
        label10.setOpaque(true);
        label10.setBorder(border);
        label10.setVerticalAlignment(JLabel.CENTER);
        label10.setHorizontalAlignment(JLabel.CENTER);
        label10.setBounds(603, 540, 997, 60);

        JPanel mainPanel = new JPanel();
        Border border2 = BorderFactory.createLoweredBevelBorder();
        mainPanel.setBackground(Color.DARK_GRAY);
        mainPanel.setBounds(603, 0, 997, 600);
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setOpaque(true);
        mainPanel.setBorder(border2);
        
        JPanel downPanel = new JPanel();
        Border border3 = BorderFactory.createEtchedBorder();
        downPanel.setBackground(Color.GRAY);
        downPanel.setBounds(603, 600, 997, 300);
        downPanel.setLayout(new BorderLayout());
        downPanel.setOpaque(true);
        downPanel.setBorder(border3);

        this.button = new JButton("YES");
        Border border4 = BorderFactory.createLineBorder(Color.WHITE, 1);
        button.setBounds(650, 675, 200, 100);
        // button.addActionListener(this);
        button.setFont(new Font("標楷體", Font.BOLD, 35));
        button.setFocusable(false);
        button.setOpaque(true);
        button.setForeground(Color.red);
        button.setBackground(Color.BLACK);
        button.setBorder(border4);
        button.setVisible(true);

        this.button2 = new JButton("NO");
        button2.setBounds(900, 675, 200, 100);
        // button2.addActionListener(this);
        button2.setFont(new Font("標楷體", Font.BOLD, 35));
        button2.setFocusable(false);
        button2.setOpaque(true);
        button2.setForeground(Color.red);
        button2.setBackground(Color.BLACK);
        button2.setBorder(border4);
        button2.setVisible(true);

        this.label11 = new JLabel();    //"卡片剩餘: "+ gameDeck.cardRemains()
        label11.setHorizontalTextPosition(JLabel.CENTER);
        label11.setVerticalTextPosition(JLabel.TOP);
        label11.setForeground(Color.WHITE);   //change font color
        label11.setFont(new Font("標楷體", Font.PLAIN,30));
        label11.setIconTextGap(20);
        label11.setBackground(Color.BLACK);
        label11.setOpaque(true);
        label11.setBorder(border);
        label11.setVerticalAlignment(JLabel.CENTER);
        label11.setHorizontalAlignment(JLabel.CENTER);
        label11.setBounds(1200, 675, 350, 100);

        this.jOptionPane = new JOptionPane();
        jOptionPane.setFont(new Font("標楷體", Font.BOLD, 35));
        

        // this.textField = new JTextField();
        // textField.setBounds(850, 675, 300, 100);
        // textField.setFont(new Font("Default", Font.PLAIN, 35));

        JFrame frame = new JFrame();
        frame.setTitle("BlackJack GAME");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(1600, 900);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.getContentPane().setBackground(new Color(75, 73, 73));    //Grey Color background.
        frame.add(label);
        frame.add(button);
        frame.add(button2);
        frame.add(label2);
        frame.add(label3);
        frame.add(label4);
        frame.add(label5);
        frame.add(label6);
        frame.add(label10);
        frame.add(label11);
        frame.add(mainPanel);
        frame.add(downPanel);
        // frame.add(jOptionPane);
        // frame.pack();
    }





}