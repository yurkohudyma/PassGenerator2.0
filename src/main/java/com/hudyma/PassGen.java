package com.hudyma;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.swing.*;

public class PassGen extends JFrame {
    //JButton generate;
    static JTextField display;
    static Integer[] comboOptions = {8, 16, 32, 64, 128, 256};
    static JComboBox<Integer> combo = new JComboBox<>(comboOptions);
    static boolean checked = true;

    static JCheckBox checkBox = new JCheckBox("$", true);
    transient HandlerCombo handlerCombo = new HandlerCombo();
    transient HandlerCheck handlerCheck = new HandlerCheck();

    public PassGen(String s) {
        super(s);
        setLayout(new FlowLayout());
        display = new JTextField(20);
        add(combo);
        add(display);
        add(checkBox);
        combo.addActionListener(handlerCombo);
        checkBox.addActionListener(handlerCheck);
        combo.setSelectedIndex(1);
    }

    private static String generator(boolean generateSymbols, int size) {
        StringBuilder result = new StringBuilder();
        if (!generateSymbols) {
            for (int i = 0; i < size / 3; i++) {
                result.append(PassGen.randomize(26, 65));
                result.append(PassGen.randomize(9, 48));
                result.append(PassGen.randomize(25, 97));
            }
            result.append(PassGen.randomize(9, 48));
            shuffle(result);
        } else {
            for (int i = 0; i < size; i++) {
                result.append(PassGen.randomize(93, +33));
            }
        }
        return result.toString();
    }

    private static StringBuilder shuffle(StringBuilder str) {
        List<String> list = Arrays.asList(str.toString().split(""));
        Collections.shuffle(list);
        StringBuilder res = new StringBuilder();
        for (String s: list){
            res.append(s);
        }
        return res;
    }


    private static char randomize(int range, int startingPos) {
        return (char) (new Random().nextInt((range)) + startingPos);
    }

    static class HandlerCombo implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == combo) {
                JComboBox<Integer> cb = (JComboBox<Integer>) e.getSource();
                int msg = (int) cb.getSelectedItem();
                display.setText(generator(checked, msg));
            }
        }
    }

    public static class HandlerCheck implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == checkBox) {
                JCheckBox check = (JCheckBox) e.getSource();
                checked = check.isSelected();
            }
        }
    }
}