package org.helloworld.task;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class MyFirstGUI extends JFrame {
    private JLabel textYear = new JLabel("Year: ");
    private JTextField year = new JTextField("", 5);
    private JButton button = new JButton("Return");

    public MyFirstGUI() {
        super("Most frequent day in the year");
        this.setBounds(0, 0, 250, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(1, 1, 2, 2));
        container.add(textYear);
        container.add(year);
        button.addActionListener(new ButtonEventListener());
        container.add(button);
    }

    class ButtonEventListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String massage = "Most frequent day(s):" + Arrays.toString(codewars.Task32.mostFrequentDays(Integer.parseInt(year.getText())));
            JOptionPane.showMessageDialog(null, massage, "Most frequent", JOptionPane.PLAIN_MESSAGE);
        }
    }
}
