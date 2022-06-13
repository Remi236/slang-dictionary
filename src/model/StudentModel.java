package model;
import entities.StudentEntitiy;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class StudentModel {
//    ArrayList<StudentEntitiy> students = new ArrayList<StudentEntitiy>(Arrays.asList(
//            new StudentEntitiy("21424002", "Huỳnh Ninh Bình", 9.0f, "TP HCM", ""),
//            new StudentEntitiy("21424062", "Quách Hải Trung", 7.2f, "TP HCM", ""),
//            new StudentEntitiy("21424064", "Đào Anh Tú", 7.5f, "TP NT", "TP HCM")
//    ));

    ArrayList<StudentEntitiy> students = new ArrayList<StudentEntitiy>();

    public ArrayList<StudentEntitiy> getStudents() { return students; }

    public void setStudents(ArrayList<StudentEntitiy> students) { this.students = students; }

    public void addStudent(StudentEntitiy s) {
        students.add(s);
    }

    public void updateStudent(StudentEntitiy oldStudent, StudentEntitiy newStudent) {
        int indexStudent = students.indexOf(oldStudent);
        if(indexStudent != -1) {
            oldStudent = students.get(indexStudent);
            oldStudent.setId(newStudent.getId());
            oldStudent.setName(newStudent.getName());
            oldStudent.setPoint(newStudent.getPoint());
            oldStudent.setAddress(newStudent.getAddress());
            oldStudent.setNote(newStudent.getNote());
            students.set(indexStudent, oldStudent);
        }
    }

    public void delStudent(StudentEntitiy s) {

        students.remove(s);
    }

    public StudentEntitiy findStudent(String id) {
        StudentEntitiy studentFound = null;
        for (StudentEntitiy s: students) {
            if(s.getId().equals(id)) {
                studentFound = s;
            }
        }
        return studentFound;
    }

    public void listStudents() {
        for(StudentEntitiy s: students) {
            s.showInfo();
        }
    }

    public void sortStudentsByID(boolean asc) {
        if(asc)
            Collections.sort(students, Comparator.comparing(StudentEntitiy::getId));
        else
            Collections.sort(students, Comparator.comparing(StudentEntitiy::getId).reversed());
    }

    public void sortStudentsByPoint(boolean asc) {
        if(asc)
            Collections.sort(students, Comparator.comparing(StudentEntitiy::getPoint));
        else
            Collections.sort(students, Comparator.comparing(StudentEntitiy::getPoint).reversed());
    }

}
