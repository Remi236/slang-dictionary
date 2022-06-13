package controller;

import java.util.Scanner;

import entities.StudentEntitiy;
import model.*;
import helper.*;
import config.*;

public class StudentController {

    StudentModel model = new StudentModel();
    FileHandle f = new FileHandle();


    public StudentController() {
        try {
            model.setStudents(f.readObjFromFile(Config.dataFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void addStudent() {
        StudentEntitiy addStudent = new StudentEntitiy();
        System.out.println("===================");
        System.out.println("Nhập thông tin sinh viên mà bạn muốn thêm: ");
        addStudent.scanStudent();
        System.out.println("===================");
        model.addStudent(addStudent);
        System.out.println("Đã thêm sinh viên !");
    }
    public void editStudent() {
        System.out.println("===================");
        String updateID;
        Scanner in = new Scanner(System.in);
        StudentEntitiy newStudent = new StudentEntitiy();
        System.out.println("Nhập mssv của sinh viên mà bạn muốn sửa: ");
        updateID = in.nextLine();
        System.out.println("Nhập thông tin sinh viên mà bạn muốn sửa: ");
        newStudent.scanStudent();
        StudentEntitiy oldStudent = model.findStudent(updateID);
        if(oldStudent == null) {
            System.out.println("Không tìm thấy sinh viên bạn muốn cập nhật !");
        }
        else {
            model.updateStudent(oldStudent, newStudent);
            System.out.println("Đã cập nhật sinh viên !");
        }
        System.out.println("===================");
    }
    public void delStudent() {
        System.out.println("===================");
        String delID;
        Scanner in = new Scanner(System.in);
        System.out.println("Nhập MSSV mà bạn muốn xoá khỏi chương trình: ");
        delID = in.nextLine();
        StudentEntitiy delStudent = model.findStudent(delID);
        if(delStudent == null) {
            System.out.println("Không tìm thấy sinh viên bạn muốn xoá !");
        }
        else {
            model.delStudent(delStudent);
            System.out.println("Đã xoá sinh viên !");
        }
        System.out.println("===================");
    }
    public void listStudents() {
       if(model.getStudents().isEmpty()) {
           System.out.println("Danh sách sinh viên rỗng !!!");
       }
       else {
           int type, sortDirection;
           Scanner in = new Scanner(System.in);
           System.out.println("===================");
           System.out.println("Bạn muốn liệt kê danh sách sinh viên được sắp xếp theo MSSV hay Điểm ? (Chọn 0 để theo MSSV / chọn 1 để theo Điểm): ");
           type = in.nextInt();
           System.out.println("Bạn muốn liệt kê tăng dần hay giảm dần ? (Chọn 0 để theo tăng / chọn 1 để theo giảm): ");
           sortDirection = in.nextInt();
           switch (type){
               case 0:
                   model.sortStudentsByID(sortDirection == 0);
                   System.out.println("Danh sách sinh viên:");
                   model.listStudents();
                   break;
               case 1:
                   model.sortStudentsByPoint(sortDirection == 0);
                   System.out.println("Danh sách sinh viên:");
                   model.listStudents();
                   break;
               default:
                   System.out.println("Không xác định được kiểu sắp xếp bạn cần !!!");
                   break;
           }
           System.out.println("===================");
       }
    }

    public void importStudents() {
        String importPath;
        Scanner in = new Scanner(System.in);
        System.out.println("Nhập đường dẫn file để import data: ");
        importPath = in.nextLine();
        try {
//            f.writeObjToFile(exportPath, model.getStudents());
            if(importPath.contains(".csv"))
                model.setStudents(f.importCSVFile(importPath));
            else
                System.out.println("Định dạng file không hợp lệ !!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void exportStudents() {
        String exportPath;
        Scanner in = new Scanner(System.in);
        System.out.println("Nhập đường dẫn file csv để export data: ");
        exportPath = in.nextLine();
        try {
//            f.writeObjToFile(exportPath, model.getStudents());
            if(exportPath.contains(".csv"))
                f.exportCSVFile(exportPath, model.getStudents());
            else
                System.out.println("Định dạng file không hợp lệ !!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveData() {
        try {
            f.writeObjToFile(Config.dataFile, model.getStudents());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
