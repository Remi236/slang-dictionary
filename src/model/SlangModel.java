package model;

import config.Config;
import entities.SlangEntity;
import helper.FileHelper;
import helper.RandomHelper;

import java.util.ArrayList;
import java.util.Random;

public class SlangModel {
    ArrayList<SlangEntity> slangs = new ArrayList<SlangEntity>();
    ArrayList<SlangEntity> historySlangs = new ArrayList<SlangEntity>();
    FileHelper f = new FileHelper();

    public ArrayList<SlangEntity> getSlangs() { return slangs; }

    public void setSlangs(ArrayList<SlangEntity> slangs) { this.slangs = slangs; }

    public ArrayList<SlangEntity> getHistorySlangs() { return historySlangs; }


    public void addSlang(SlangEntity s) { slangs.add(s); }

    public void updateSlang(SlangEntity oldSlang, SlangEntity newSlang) {
        oldSlang.setWord(newSlang.getWord());
        oldSlang.setDefinition(newSlang.getDefinition());
    }

    public void delSlang(SlangEntity s) {
        slangs.remove(s);
    }

    public boolean findSlangs(int type,String search) {
        boolean isHave = false;
        for (SlangEntity s: slangs) {
            if(type == 0) { // word
                if (s.getWord().contains(search)){
                    isHave = !isHave;
                }
            }
            else { // defination
                if (s.getDefinition().contains(search)){
                    isHave = !isHave;
                }
            }
            historySlangs.add(s);
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
                slangFound = new SlangEntity(slangFound);
            }
        }
        return slangFound;
    }

    public void resetSlangs() {
        try {
            slangs = f.readDataFromFile(Config.RESET_DATA_FILE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadSlangs() {
        try {
            slangs = f.readDataFromFile(Config.DATA_FILE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
