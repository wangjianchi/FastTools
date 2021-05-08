package com.wang.translate;

import javax.swing.*;
import java.awt.event.*;

public class TranslateGenerateDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JCheckBox classCheckBox;
    private JTextField classTextField;
    private JCheckBox checkBox2;
    private JTextField textField1;
    private JCheckBox checkBox3;
    private JTextField textField2;
    private JCheckBox checkBox4;
    private JTextField textField3;

    public TranslateGenerateDialog() {
        init("");
    }
    public TranslateGenerateDialog(String translateString){
        init(translateString);
    }


    private void  init(String translateString){
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        setTitle("Generate");
        setLocation(400, 200);//距离屏幕左上角的其实位置
        setSize(800, 600);


        classTextField.setText(translateString);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        TranslateGenerateDialog dialog = new TranslateGenerateDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
