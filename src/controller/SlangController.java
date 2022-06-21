package controller;

import config.Config;
import entities.SlangEntity;
import model.SlangModel;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SlangController {
    SlangModel model = new SlangModel();

    public SlangController() {
        model.loadSlangs();
    }

    public boolean addSlang(SlangEntity addSlang) {
        boolean isAdded = true;
        SlangEntity foundSlang = model.findSlang(addSlang.getWord());
        if(foundSlang == null) {
            model.addSlang(addSlang);
        }
        else {
            isAdded = false;
        }
        return isAdded;
    }

    public boolean editSlang(String word, SlangEntity newSlang) {
        boolean isUpdated = true;
        SlangEntity oldSlang = model.findSlang(word);
        if(oldSlang == null) {
            System.out.println("Không tìm thấy de cập nhật !");
            isUpdated = false;
        }
        else {
            model.updateSlang(oldSlang, newSlang);
            System.out.println("Đã cập nhật sinh viên !");
        }
        return isUpdated;
    }

    public boolean delSlang(String delWord) {
        boolean isDelete = true;
        SlangEntity delSlang = model.findSlang(delWord);
        if(delSlang == null) {
            isDelete = false;
        }
        else {
            model.delSlang(delSlang);
        }
        return isDelete;
    }

    public void resetData() {
        model.resetSlangs();
    }

    public ArrayList<SlangEntity> search(int type, String query) {
        ArrayList<SlangEntity> searchSlang = new ArrayList<SlangEntity>();
        if(model.findSlangs(type, query)) {
                searchSlang = model.getSearchSlangs();
        }
        return searchSlang;
    }

    public SlangEntity random(){
        SlangEntity ranSlang = new SlangEntity();
        if(model.getSlangs().size() == 0) {
            System.out.println("Emty to random!!!");
        }
        else {
            ranSlang = model.randomSlang();
        }
        return ranSlang;
    }

    public ArrayList<SlangEntity> showHistory() {
        ArrayList<SlangEntity> historySlang = new ArrayList<SlangEntity>();
        if(model.getHistorySlangs().size() == 0) {
            System.out.println("Emty history!!!");
        }
        else {
            historySlang = model.getHistorySlangs();
        }
        return historySlang;
    }

    public ArrayList<SlangEntity> quiz() {
        ArrayList<SlangEntity> data = model.getDataQuiz();
        if(data.size() == 0) {
            System.out.println("Emty data!!!");
        }
        return data;
    }
}
