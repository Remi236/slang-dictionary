package view;

import config.Config;
import controller.SlangController;
import entities.SlangEntity;
import helper.BindingSouceHelper;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class History extends JFrame{
    private JPanel historyPanel;
    private JTable tbl_his;
    DefaultTableModel model = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column)
        {
            // add your code here
            return false;
        }
    };
    public void initTableBingdingSource(ArrayList<SlangEntity> data) {
        model.setColumnIdentifiers(Config.SLANG_HEADER_COLUMNS);
        model = BindingSouceHelper.mapModel(model, data);
        tbl_his.setModel(model);
    }

    public History(ArrayList<SlangEntity> data, String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(historyPanel);
        this.pack();
        this.setLocationRelativeTo(null);
        initTableBingdingSource(data);
    }

}
