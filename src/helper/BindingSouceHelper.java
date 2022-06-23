package helper;

import entities.SlangEntity;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class BindingSouceHelper {
    public static DefaultTableModel mapModel(DefaultTableModel model, ArrayList<SlangEntity> data) {
        model.setRowCount(data.size());
        int row =0;
        for(SlangEntity item: data)
        {
            model.setValueAt(item.getWord(), row, 0);
            model.setValueAt(item.getDefinition(), row, 1);
            row++;
        }
        return model;
    }
}
