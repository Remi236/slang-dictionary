package model;

import entities.SlangEntity;

import java.util.ArrayList;

public class SlangModel {
    ArrayList<SlangEntity> slangs = new ArrayList<SlangEntity>();

    public ArrayList<SlangEntity> getSlangs() { return slangs; }

    public void setSlangs(ArrayList<SlangEntity> slangs) { this.slangs = slangs; }

    public void addSlang(SlangEntity s) {
        slangs.add(s);
    }

    public void updateSlang(SlangEntity oldSlang, SlangEntity newSlang) {
        int indexSlang = slangs.indexOf(oldSlang);
        if(indexSlang != -1) {
            oldSlang = slangs.get(indexSlang);
           
        }
    }

    public void delSlang(SlangEntity s) {

        slangs.remove(s);
    }

    public SlangEntity findSlang(String id) {
        SlangEntity slangFound = null;
        for (SlangEntity s: slangs) {

        }
        return slangFound;
    }

    public void listSlangs() {
        for(SlangEntity s: slangs) {
            s.showSlang();
        }
    }
}
