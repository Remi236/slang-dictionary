package view;

import entities.SlangEntity;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateSlang extends JFrame{
    private JTextField txt_word;
    private JTextField txt_def;
    private JButton btn_save;
    private JButton btn_cancel;
    public JPanel updatePanel;

    public SlangEntity updateSlang;

    public UpdateSlang(SlangEntity dto) {
        this.setContentPane(updatePanel);
        this.pack();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        JFrame thisFrame = this;

        updateSlang = new SlangEntity(dto.getWord(), dto.getDefinition());

        txt_word.setText(dto.getWord());
        txt_def.setText(dto.getDefinition());

        btn_save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateSlang = new SlangEntity(txt_word.getText(), txt_def.getText());
                thisFrame.dispose();
            }
        });
        btn_cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                thisFrame.dispose();
            }
        });
    }



}
