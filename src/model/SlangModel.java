package model;

import config.Config;
import entities.SlangEntity;
import helper.FileHelper;
import helper.RandomHelper;

import java.util.ArrayList;

public class SlangModel {

    ArrayList<SlangEntity> slangs = new ArrayList<SlangEntity>();
    ArrayList<SlangEntity> historySlangs = new ArrayList<SlangEntity>();
    ArrayList<SlangEntity> searchSlangs = new ArrayList<SlangEntity>();

    FileHelper f = new FileHelper();

    public ArrayList<SlangEntity> getSlangs() { return slangs; }

    public void setSlangs(ArrayList<SlangEntity> slangs) { this.slangs = slangs; }

    public ArrayList<SlangEntity> getHistorySlangs() { return historySlangs; }

    public ArrayList<SlangEntity> getSearchSlangs() { return searchSlangs; }


    public void saveData() {
        try {
            f.writeDataToFile(Config.DATA_FILE, slangs);
            f.writeDataToFile(Config.DATA_HISTORY_FILE, slangs);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addSlang(SlangEntity s) { slangs.add(s); }

    public void updateSlang(SlangEntity oldSlang, SlangEntity newSlang) {
        int index = slangs.indexOf(oldSlang);
        oldSlang.setWord(newSlang.getWord());
        oldSlang.setDefinition(newSlang.getDefinition());
        slangs.set(index, newSlang);
    }

    public void delSlang(SlangEntity s) { slangs.remove(s); }

    public boolean findSlangs(int type,String search) {
        boolean isHave = false;
        searchSlangs = new ArrayList<SlangEntity>();
        for (SlangEntity s: slangs) {
            if(type == 0) { // word
                if (s.getWord().contains(search)){
                    isHave = true;
                    searchSlangs.add(s);
                    historySlangs.add(s);
                }
            }
            else { // defination
                if (s.getDefinition().contains(search)){
                    isHave = true;
                    searchSlangs.add(s);
                    historySlangs.add(s);
                }
            }

        }
        return isHave;
    }

    public SlangEntity randomSlang() {
        int index = RandomHelper.randomIndexArrayList(slangs.size());
        return slangs.get(index);
    }

    public ArrayList<SlangEntity> getDataQuiz() {
        ArrayList<SlangEntity> data = new ArrayList<SlangEntity>();
        for (int i = 0; i < Config.MAX_CHOISES; i++) {
            data.add(randomSlang());
        }
        return data;
    }

    public SlangEntity findSlang(String search) {
        SlangEntity slangFound = null;
        for (SlangEntity s: slangs) {
            if(s.getWord().equalsIgnoreCase(search)) {
                slangFound = new SlangEntity(s);
                break;
            }
        }
        return slangFound;
    }

    public boolean resetSlangs() {
        boolean isReseted = true;
        try {
            slangs = f.readDataFromFile(Config.RESET_DATA_FILE);
        } catch (Exception e) {
            e.printStackTrace();
            isReseted = false;
        }
        return isReseted;
    }

    public void loadSlangs() {
        try {
            slangs = f.readDataFromFile(Config.DATA_FILE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
