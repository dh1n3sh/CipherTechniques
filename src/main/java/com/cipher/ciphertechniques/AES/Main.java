package com.cipher.ciphertechniques.AES;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Main {
    public static boolean isempty(JTextField t1, JTextField t2) {
        String s1 = t1.getText();
        String s2 = t2.getText();
        if (s1.equals("") || s1.equals("Enter a number") ||
            s2.equals("") || s2.equals("Enter a number"))
            return true;
        return false;
    }
    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }
    public Main() {
        JFrame jf = new JFrame("AES-128");
        jf.setLocation(500, 500);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(600, 160);
        JPanel p = new JPanel();
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
        jf.add(p);
        final JTextField text = new JTextField("Text");
        final JTextField key = new JTextField("Key");
        final JTextField ans = new
        JTextField("Encrypted/Decrypted Text");
        ans.setEditable(false);
        p.add(text);
        p.add(key);
        p.add(ans);
        JPanel jp = new JPanel();
        jp.setLayout(new FlowLayout());
        JButton enc = new JButton("Encrypt");
        JButton dec = new JButton("Decrypt");
        JButton clear = new JButton("Clear");
        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                ans.setText("");
                text.setText("");
                key.setText("");
            }
        });
        enc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (isempty(text, key))
                    ans.setText("Both key and text required");
                else {
                    ans.setText(AES.encrypt(text.getText(),
                        key.getText()));
                }
            }
        });
        dec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (isempty(text, key))
                    ans.setText("Both key and text required");
                else {
                    ans.setText(AES.decrypt(text.getText(),
                        key.getText()));
                }
            }
        });
        jp.add(enc);
        jp.add(dec);
        jp.add(clear);
        p.add(jp);
        jf.setVisible(true);
    }
}