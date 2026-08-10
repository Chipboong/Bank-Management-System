package me.chip.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {

    Login() {
        setTitle("Login");
        setLayout(null);
        setSize(800, 480);
        setLocation(350, 200);
        ImageIcon bank = new ImageIcon(
            ClassLoader.getSystemResource("me.chip/images/bank.png")
        );
        Image bank2 = bank
            .getImage()
            .getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon bank3 = new ImageIcon(bank2);
        JLabel bankLabel = new JLabel(bank3);
        bankLabel.setBounds(70, 10, 100, 100);
        add(bankLabel);
        JLabel welcome = new JLabel("Bank Management System");
        welcome.setFont(new Font("Times New Roman", Font.PLAIN, 32));
        welcome.setBounds(200, 40, 400, 40);
        add(welcome);

        JLabel userName = new JLabel("Card Number");
        userName.setFont(new Font("Times New Roman", Font.PLAIN, 32));
        userName.setBounds(70, 170, 400, 40);
        add(userName);

        JTextField userNameField = new JTextField();
        userNameField.setBounds(275, 170, 400, 40);
        add(userNameField);

        JLabel PIN = new JLabel("PIN");
        PIN.setFont(new Font("Times New Roman", Font.PLAIN, 32));
        PIN.setBounds(190, 220, 400, 40);
        add(PIN);

        JPasswordField PINField = new JPasswordField();
        PINField.setBounds(275, 220, 400, 40);
        add(PINField);

        JButton login = new JButton("Login");
        login.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        login.setBounds(275, 280, 100, 40);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        add(login);

        JButton signUp = new JButton("SIGN UP");
        signUp.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        signUp.setBounds(275, 350, 225, 40);
        signUp.setBackground(Color.BLACK);
        signUp.setForeground(Color.WHITE);
        add(signUp);

        JButton clear = new JButton("CLEAR");
        clear.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        clear.setBounds(400, 280, 100, 40);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        add(clear);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {}
}
