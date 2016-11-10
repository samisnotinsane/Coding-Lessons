package com.starfighterix.progress;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by sameen on 10/11/2016.
 */
public class MainFrame extends JFrame {

    private JProgressBar jProgressBar = new JProgressBar(0, 100);
    private JLabel statusLabel = new JLabel("Task not complete.");
    private JButton btnRun = new JButton("Run");

    public MainFrame(String title) {
        super(title);

        jProgressBar.setValue(0);
        jProgressBar.setBorderPainted(true);

        setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();

        gc.fill = GridBagConstraints.NONE;

        gc.gridx = 0;
        gc.gridy = 0;
        gc.weightx = 1;
        gc.weighty = 1;
        add(jProgressBar, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        gc.weightx = 1;
        gc.weighty = 1;
        add(statusLabel, gc);

        gc.gridx = 0;
        gc.gridy = 2;
        gc.weightx = 1;
        gc.weighty = 1;
        add(btnRun, gc);

        btnRun.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                start();
            }
        });

        setSize(200, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }


    public void start() {
        WorkerClass worker = new WorkerClass(jProgressBar, statusLabel);
        worker.execute();
    }
}
