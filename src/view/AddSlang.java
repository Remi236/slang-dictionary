package view;

import entities.SlangEntity;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddSlang extends JFrame{
    public JPanel addPanel;
    private JTextField txt_word;
    private JTextField txt_def;
    private JButton btn_save;
    private JButton btn_cancel;

    public SlangEntity addSlang;


    public AddSlang() {
        this.setContentPane(addPanel);
        this.pack();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        JFrame thisFrame = this;
        btn_save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addSlang = new SlangEntity(txt_word.getText(), txt_def.getText());
                thisFrame.dispose();
            }
        });
        btn_cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addSlang = null;
                thisFrame.dispose();
            }
        });
    }
}
