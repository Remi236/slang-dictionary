package view;

import config.Config;
import controller.SlangController;
import helper.BindingSouceHelper;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;

public class App extends JFrame{
    private JPanel appPanel;
    private JComboBox cb_search;
    private JTextField txt_search;
    private JButton btn_search;
    private JTextField txt_random_word;
    private JTextField txt_random_def;
    private JButton btn_random;
    private JButton btn_add;
    private JButton btn_update;
    private JButton btn_del;
    private JButton btn_reset;
    private JButton btn_show_history;
    private JComboBox cb_quiz;
    private JButton btn_quiz;
    private JLabel lb_quiz;
    private JLabel lb_noti;
    private JButton btn_pick_A;
    private JButton btn_pick_B;
    private JButton btn_pick_C;
    private JButton btn_pick_D;
    private JTable tbl_slangs;
    private JScrollPane slangScrollPanel;

    SlangController sc = new SlangController();
    DefaultTableModel model = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int row, int column)
        {
            // add your code here
            return false;
        }
    };
    public void initTableBingdingSource() {
        model.setColumnIdentifiers(Config.SLANG_HEADER_COLUMNS);
        model = BindingSouceHelper.mapModel(model, sc.getSlangs());
        tbl_slangs.setModel(model);
    }

    public App(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(appPanel);
        this.pack();
        this.setLocationRelativeTo(null);
        JFrame thisFrame = this;
        initTableBingdingSource();
    }

    public static void main(String[] args) {
        JFrame frame = new App(Config.APP_TITLE);
        frame.setVisible(true);
    }
}
