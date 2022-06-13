package route;

import java.util.Scanner;
import helper.*;
import controller.StudentController;

public class Route {

    int action = -1;
    boolean isContinue = true;
    StudentController sc = new StudentController();

    public void handleExit() {
        sc.saveData();
    }

    public void route() {
        switch (action) {
            case 0:
//                System.out.println("Thêm học sinh");
                    sc.addStudent();
                break;
            case 1:
//                System.out.println("Cập nhật thông tin");
                    sc.editStudent();
                break;
            case 2:
//                System.out.println("Xóa học sinh");
                    sc.delStudent();
                break;
            case 3:
//                System.out.println("Xem danh sách học sinh");
                    sc.listStudents();
                break;
            case 4:
//                System.out.println("Import danh sách học sinh");
                    sc.importStudents();
                break;
            case 5:
//                System.out.println("Export danh sách học sinh");
                    sc.exportStudents();
                break;
            default:
                    handleExit();
//                System.out.println("thoát chương trình !");
                break;
        }
    }

    public void main() {
        Menu menu = new Menu();
        menu.showMenu();
        do {
            Scanner in = new Scanner(System.in);
            System.out.println("Mời chọn hành động ( chọn theo số đã nêu ở trên menu nhé !!!): ");
            action = in.nextInt();
            menu.confirmSelection(action);
            this.route();
            if(action != -1) {
                System.out.println("Bạn có muốn tiếp tục? (chọn y để tiếp tục và n để ngược lại): ");
                String confirm = in.next();
                if(confirm.equalsIgnoreCase("y")) {
                    isContinue = true;
                }
                else if(confirm.equalsIgnoreCase("n")) {
                    isContinue = false;
                    handleExit();
                    System.out.println("Thoát chương trình !");
                }
                else {
                    System.out.println("Không hiểu là bạn muốn tiếp tục hay không ? nên mặc định là tiếp tục ");
                }
            }
            else {
                isContinue = false;
            }
        }while (isContinue);
    }
}
