package controller;

import config.Config;
import entities.SlangEntity;
import helper.FileHelper;
import model.SlangModel;

import java.util.Scanner;

public class SlangController {
    SlangModel model = new SlangModel();
    FileHelper f = new FileHelper();

    public SlangController() {
        try {
            model.setSlangs(f.readDataFromFile(Config.dataFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addSlang() {

    }

    public void editSlang() {

    }

    public void delSlang() {

    }

    public void resetData() {
        try {
            model.setSlangs(f.readDataFromFile(Config.RESET_DATA_FILE));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveData() {
        try {
            f.writeDataToFile(Config.dataFile, model.getSlangs());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void search(int type, String search) {

    }
}
