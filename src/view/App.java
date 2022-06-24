package view;

import config.Config;
import controller.SlangController;
import helper.BindingSouceHelper;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Vector;

public class App extends JFrame{
    private JPanel appPanel;
    private JComboBox cb_search;
    private JTextField txt_search;
    private JButton btn_search;
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
    private JLabel lb_random_slang;

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
        btn_search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int type = cb_search.getSelectedIndex();
                String search = txt_search.getText();
                model = BindingSouceHelper.mapModel(model, sc.search(type, search));
            }
        });
        btn_random.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btn_reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btn_show_history.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                History frame = new History(sc.showHistory(), Config.APP_HISTORY_TITLE);
                frame.setVisible(true);
            }
        });
        btn_add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btn_update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btn_del.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btn_quiz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btn_pick_A.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btn_pick_B.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btn_pick_C.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        btn_pick_D.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        txt_search.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                changed();
            }
            public void removeUpdate(DocumentEvent e) {
                changed();
            }
            public void insertUpdate(DocumentEvent e) {
                changed();
            }

            public void changed() {
                if (txt_search.getText().equals("")){
                    System.out.println(true);
                    model = BindingSouceHelper.mapModel(model, sc.getSlangs());
                }
                else {
                    System.out.println(false);
                }

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new App(Config.APP_TITLE);
        frame.setVisible(true);
    }
}
