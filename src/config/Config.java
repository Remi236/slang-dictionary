package config;

public class Config {
    // FILE
    public final static String DATA_FILE = "data.txt";
    public final static String RESET_DATA_FILE = "slang.txt";
    public final static String PROPERTY_SEPARATOR = "`";
    public final static String NEW_LINE_SEPARATOR = "\n";

    // INDEX
    public static int INDEX_READER = 0;

    //  TABLE HELPER
    public static final Object[] SLANG_HEADER_COLUMNS = {"Word", "Definition"};

    // ADD
    public static final String TITLE_ADD = "Add SLang Word";
    public static final String MESSAGE_ADD_SLANG_SUCCESS = "Your Word Added Successfully !!";
    public static final String MESSAGE_ADD_SLANG_FAIL = "Your Word Added Unsuccessfully !!";

    // DEL
    public static final String TITLE_DEL = "Confirm Delete";
    public static final String MESSAGE_DEL_CONFIRM = "Do you really wish to delete this record ??";
    public static final String MESSAGE_DEL_ERROR = "Error on Deleted Word";
    public static final String MESSAGE_DEL_SUCCESS = "Deleted word Successfully!!";
    public static final String MESSAGE_DEL_FAIL = "Deleted word Unsuccessfully!!";

    // UPDATE
    public static final String TITLE_EDIT = "Update Word !!";
    public static final String MESSAGE_EDIT_ERROR = "Error on Edit Word";
    public static final String MESSAGE_EDIT_FAIL = "Edit Word Unsuccessfully!!";
    public static final String MESSAGE_EDIT_SUCCESS = "Edit Word Successfully!!";

    // RESET
    public static final String MESSAGE_RESET = "Reset Dictionary Successfully!!";
    public static final String TITLE_RESET = "Reset Dictionary";

    // APP
    public static String APP_TITLE = "SlangWord Application";
    public static String APP_HISTORY_TITLE = "SlangWord History";
    public static String APP_EMPTY_STRING = "SlangWord History";
    public static final int MAX_CHOISES = 4;
    public static final int QUIZ_TYPE_WORD = 0;
    public static final int QUIZ_TYPE_DEFINITION = 1;
    public static final String MESSAGE_QUIZ_TYPE_WORD = "What is %s mean ?";
    public static final String MESSAGE_QUIZ_TYPE_DEFINITION = "What is slang word for %s?";
    public static final String MESSAGE_QUIZ_CORRECT = "Congratulation !! You have found the correct answer";
    public static final String MESSAGE_QUIZ_INCORRECT = "Opp !! It's look like you have found the wrong answer. The answer is : %s";
    public static final String ANSWER_PREFIX_A = "A. ";
    public static final String ANSWER_PREFIX_B = "B. ";
    public static final String ANSWER_PREFIX_C = "C. ";
    public static final String ANSWER_PREFIX_D = "D. ";
    public static final int QUIZ_INDEX = 0;
    public static final int PICK_A = 0;
    public static final int PICK_B = 1;
    public static final int PICK_C = 2;
    public static final int PICK_D = 3;
}
