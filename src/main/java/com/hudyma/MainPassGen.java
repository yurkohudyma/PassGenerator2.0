package com.hudyma;

import javax.swing.*;

public class MainPassGen {

    public static void main(String[] args) {
        PassGen r = new PassGen("Hudyma PassGen 2.0");
        r.setVisible(true);
        r.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        r.setSize(350,75);
        r.setResizable(false);
        r.setLocationRelativeTo(null);
    }
}
