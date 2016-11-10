package com.starfighterix.progress;

import com.starfighterix.code.MainFrame;

import javax.swing.*;

/**
 * Created by sameen on 10/11/2016.
 */
public class App {


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new com.starfighterix.progress.MainFrame("ProgressBar Demo");
            }
        });
    }
}
