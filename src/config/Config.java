package config;

public class Config {
    // FILE
    public final static String DATA_FILE = "data.data";
    public final static String RESET_DATA_FILE = "slang.txt";
    public final static String PROPERTY_SEPARATOR = "`";
    public final static String NEW_LINE_SEPARATOR = "\n";

    // INDEX
    public static int INDEX_READER = 0;

    //  TABLE HELPER
    public static final Object[] STUDENTS_HEADER_COLUMNS = {"Word", "Definication"};

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
    public static final String MESSAGE_EDIT_ERROR = "Fail On Edit Word";
    public static final String MESSAGE_EDIT_FAIL = "Deleted word Unsuccessfully!!";
    public static final String MESSAGE_EDIT_SUCCESS = "Deleted word Successfully!!";

    // APP
    public static final int MAX_CHOISES = 4;
}
