package helper;

import entities.SlangEntity;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DataRowHelper {
    public static SlangEntity convertDataRowToEntity(DefaultTableModel model, JTable table) {
        String word = model.getValueAt(table.getSelectedRow(), 0).toString();
        String def = model.getValueAt(table.getSelectedRow(), 1).toString();
        SlangEntity dto = new SlangEntity(word, def);
        return dto;
    }
}
