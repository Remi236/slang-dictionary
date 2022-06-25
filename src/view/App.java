package view;

import config.Config;
import controller.SlangController;
import entities.SlangEntity;
import helper.BindingSouceHelper;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;

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
    SlangEntity quiz = null;
    SlangEntity answer = null;
    ArrayList<SlangEntity> dataQuiz = null;

    public void initTableBingdingSource() {
        model.setColumnIdentifiers(Config.SLANG_HEADER_COLUMNS);
        model = BindingSouceHelper.mapModel(model, sc.getSlangs());
        tbl_slangs.setModel(model);
    }

    public void quizUIHandle(boolean state) {
        btn_pick_A.setEnabled(state);
        btn_pick_B.setEnabled(state);
        btn_pick_C.setEnabled(state);
        btn_pick_D.setEnabled(state);
    }

    public App(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(appPanel);
        this.pack();
        this.setLocationRelativeTo(null);
        JFrame thisFrame = this;
        initTableBingdingSource();
        quizUIHandle(false);
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
                SlangEntity ranSlang = sc.random();
                lb_random_slang.setText(ranSlang.getWord() +": "+ ranSlang.getDefinition());
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
                int type = cb_quiz.getSelectedIndex();
                dataQuiz = sc.quiz();
                quiz = dataQuiz.get(Config.QUIZ_INDEX); // index == 0 => quiz
                Collections.shuffle(dataQuiz);
                lb_noti.setText(Config.APP_EMPTY_STRING);
                if(type == Config.QUIZ_TYPE_WORD) {
                    lb_quiz.setText(String.format(Config.MESSAGE_QUIZ_TYPE_WORD, quiz.getWord()));
                    btn_pick_A.setText(Config.ANSWER_PREFIX_A + dataQuiz.get(Config.PICK_A).getDefinition());
                    btn_pick_B.setText(Config.ANSWER_PREFIX_B + dataQuiz.get(Config.PICK_B).getDefinition());
                    btn_pick_C.setText(Config.ANSWER_PREFIX_C + dataQuiz.get(Config.PICK_C).getDefinition());
                    btn_pick_D.setText(Config.ANSWER_PREFIX_D + dataQuiz.get(Config.PICK_D).getDefinition());
                }
                else if(type == Config.QUIZ_TYPE_DEFINITION) {
                    lb_quiz.setText(String.format(Config.MESSAGE_QUIZ_TYPE_DEFINITION, quiz.getDefinition()));
                    btn_pick_A.setText(Config.ANSWER_PREFIX_A + dataQuiz.get(Config.PICK_A).getWord());
                    btn_pick_B.setText(Config.ANSWER_PREFIX_B + dataQuiz.get(Config.PICK_B).getWord());
                    btn_pick_C.setText(Config.ANSWER_PREFIX_C + dataQuiz.get(Config.PICK_C).getWord());
                    btn_pick_D.setText(Config.ANSWER_PREFIX_D + dataQuiz.get(Config.PICK_D).getWord());
                }
                quizUIHandle(true);
            }
        });
        btn_pick_A.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String answerText = btn_pick_A.getText().replace(Config.ANSWER_PREFIX_A, Config.APP_EMPTY_STRING);
                System.out.println(answerText);
                quizUIHandle(false);
                answer = dataQuiz.get(Config.PICK_A);
                String result = cb_quiz.getSelectedIndex() == Config.QUIZ_TYPE_WORD ? quiz.getDefinition() : quiz.getWord();
                if(sc.verifyAnswer(quiz,answer, cb_quiz.getSelectedIndex())){
                    System.out.println(true);
                    lb_noti.setText(Config.MESSAGE_QUIZ_CORRECT);
                }
                else {
                    System.out.println(false);
                    lb_noti.setText(String.format(Config.MESSAGE_QUIZ_INCORRECT, result));
                }
            }
        });
        btn_pick_B.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String answerText = btn_pick_B.getText().replace(Config.ANSWER_PREFIX_B, Config.APP_EMPTY_STRING);
                System.out.println(answerText);
                quizUIHandle(false);
                answer = dataQuiz.get(Config.PICK_B);
                String result = cb_quiz.getSelectedIndex() == Config.QUIZ_TYPE_WORD ? quiz.getDefinition() : quiz.getWord();
                if(sc.verifyAnswer(quiz,answer, cb_quiz.getSelectedIndex())){
                    System.out.println(true);
                    lb_noti.setText(Config.MESSAGE_QUIZ_CORRECT);
                }
                else {
                    System.out.println(false);
                    lb_noti.setText(String.format(Config.MESSAGE_QUIZ_INCORRECT, result));
                }
            }
        });
        btn_pick_C.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String answerText = btn_pick_C.getText().replace(Config.ANSWER_PREFIX_C, Config.APP_EMPTY_STRING);
                System.out.println(answerText);
                quizUIHandle(false);
                answer = dataQuiz.get(Config.PICK_C);
                String result = cb_quiz.getSelectedIndex() == Config.QUIZ_TYPE_WORD ? quiz.getDefinition() : quiz.getWord();
                if(sc.verifyAnswer(quiz,answer, cb_quiz.getSelectedIndex())){
                    System.out.println(true);
                    lb_noti.setText(Config.MESSAGE_QUIZ_CORRECT);
                }
                else {
                    System.out.println(false);
                    lb_noti.setText(String.format(Config.MESSAGE_QUIZ_INCORRECT, result));
                }
            }
        });
        btn_pick_D.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String answerText = btn_pick_D.getText().replace(Config.ANSWER_PREFIX_D,Config.APP_EMPTY_STRING);
                System.out.println(answerText);
                quizUIHandle(false);
                answer = dataQuiz.get(Config.PICK_D);
                String result = cb_quiz.getSelectedIndex() == Config.QUIZ_TYPE_WORD ? quiz.getDefinition() : quiz.getWord();
                if(sc.verifyAnswer(quiz,answer, cb_quiz.getSelectedIndex())){
                    System.out.println(true);
                    lb_noti.setText(Config.MESSAGE_QUIZ_CORRECT);
                }
                else {
                    System.out.println(false);
                    lb_noti.setText(String.format(Config.MESSAGE_QUIZ_INCORRECT, result));
                }
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
                if (txt_search.getText().equals(Config.APP_EMPTY_STRING)){
//                    System.out.println(true);
                    model = BindingSouceHelper.mapModel(model, sc.getSlangs());
                }
                else {
//                    System.out.println(false);
                }

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new App(Config.APP_TITLE);
        frame.setVisible(true);
    }
}
