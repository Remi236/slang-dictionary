package controller;

import config.Config;
import entities.SlangEntity;
import model.SlangModel;

import java.util.ArrayList;

public class SlangController {
    SlangModel model = new SlangModel();

    public SlangController() {
        model.loadSlangs();
    }

    public ArrayList<SlangEntity> getSlangs() { return model.getSlangs(); }

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
            System.out.println("Đã cập nhật!");
        }
        return isUpdated;
    }

    public boolean delSlang(String delWord) {
        boolean isDelete = true;
        SlangEntity delSlangE = model.findSlang(delWord);
        if(delSlangE == null) {
            isDelete = false;
        }
        else {
            model.delSlang(delSlangE);
        }
        return isDelete;
    }

    public void resetData() {
        model.resetSlangs();
    }

    public ArrayList<SlangEntity> search(int type, String query) {
        ArrayList<SlangEntity> searchSlang = null;
        if(model.findSlangs(type, query)) {
            searchSlang = model.getSearchSlangs();
        }
        else {
            searchSlang = new ArrayList<SlangEntity>();
        }
        System.out.println(searchSlang.size());
        return searchSlang;
    }

    public SlangEntity random(){
        SlangEntity ranSlang = new SlangEntity();
        if(model.getSlangs().size() == 0) {
            System.out.println("Empty to random!!!");
        }
        else {
            ranSlang = model.randomSlang();
        }
        return ranSlang;
    }

    public ArrayList<SlangEntity> showHistory() {
        ArrayList<SlangEntity> historySlang = new ArrayList<SlangEntity>();
        if(model.getHistorySlangs().size() == 0) {
            System.out.println("Empty history!!!");
        }
        else {
            historySlang = model.getHistorySlangs();
        }
        return historySlang;
    }

    public ArrayList<SlangEntity> quiz() {
        ArrayList<SlangEntity> data = model.getDataQuiz();
        if(data.size() == 0) {
            System.out.println("Empty data!!!");
        }
        return data;
    }

    public boolean verifyAnswer(SlangEntity quiz, SlangEntity answer, int type) {
        return type == Config.QUIZ_TYPE_WORD ? quiz.getDefinition().equalsIgnoreCase(answer.getDefinition()) : quiz.getWord().equalsIgnoreCase(answer.getWord());
    }
}
