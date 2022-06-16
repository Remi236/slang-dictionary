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
        SlangEntity addSlang = new SlangEntity();
        System.out.println("===================");
        System.out.println("Nhập thông tin vào từ điển mà bạn muốn thêm: ");
        addSlang.scanSlang();
        System.out.println("===================");
        model.addSlang(addSlang);
        System.out.println("Đã thêm từ mới !");
    }

    public void editSlang() {
        System.out.println("===================");
        String updateSlang;
        Scanner in = new Scanner(System.in);
        SlangEntity newSlang = new SlangEntity();
        System.out.println("Nhập từ  mà bạn muốn sửa: ");
        updateSlang = in.nextLine();
        System.out.println("Nhập thông tin từ mà bạn muốn sửa: ");
        newSlang.scanSlang();
        SlangEntity oldSlang = model.findSlang(updateSlang);
        if(oldSlang == null) {
            System.out.println("Không tìm thấy từ bạn muốn cập nhật !");
        }
        else {
            model.updateSlang(oldSlang, newSlang);
            System.out.println("Đã cập nhật từ !");
        }
        System.out.println("===================");
    }

    public void delSlang() {
        System.out.println("===================");
        String delSlang;
        Scanner in = new Scanner(System.in);
        System.out.println("Nhập từ mà bạn muốn xoá khỏi chương trình: ");
        delSlang = in.nextLine();
        SlangEntity delStudent = model.findSlang(delSlang);
        if(delStudent == null) {
            System.out.println("Không tìm thấy từ bạn muốn xoá !");
        }
        else {
            System.out.println("Bạn có chắc chắn thật sự muốn xoá? (chọn y để đồng ý / chọn n để huỷ): ");
            String confirmDel = in.nextLine();
            if(confirmDel.equalsIgnoreCase("y")) {
                model.delSlang(delStudent);
                System.out.println("Đã xoá sinh viên !");
            }
        }
        System.out.println("===================");
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
}
