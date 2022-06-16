package model;

import entities.SlangEntity;

import java.util.ArrayList;

public class SlangModel {
    ArrayList<SlangEntity> slangs = new ArrayList<SlangEntity>();
    ArrayList<SlangEntity> historySlangs = new ArrayList<SlangEntity>();


    public ArrayList<SlangEntity> getSlangs() { return slangs; }

    public void setSlangs(ArrayList<SlangEntity> slangs) { this.slangs = slangs; }

    public void addSlang(SlangEntity s) {
        slangs.add(s);
    }

    public void updateSlang(SlangEntity oldSlang, SlangEntity newSlang) {
        int indexSlang = slangs.indexOf(oldSlang);
        if(indexSlang != -1) {
            oldSlang = slangs.get(indexSlang);
            oldSlang.setWord(newSlang.getWord());
            oldSlang.setDefinition(newSlang.getDefinition());
        }
    }

    public void delSlang(SlangEntity s) {
        slangs.remove(s);
    }

    public ArrayList<SlangEntity> findSlangs(int type,String search) {
        ArrayList<SlangEntity> searchSlangs = new ArrayList<SlangEntity>();
        for (SlangEntity s: slangs) {
            if(type == 0) { // word

                if (s.getWord().contains(search)){
                    searchSlangs.add(s);
                }
            }
            else { // defination
                if (s.getDefinition().contains(search)){
                    searchSlangs.add(s);
                }
            }
            historySlangs.add(s);

        }
        return searchSlangs;
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
}
