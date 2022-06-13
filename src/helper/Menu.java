package helper;


public class Menu {

    String[] availableSelection = {
            "Thêm học sinh",
            "Cập nhật thông tin ",
            "Xóa học sinh",
            "Xem danh sách học sinh",
            "Import danh sách học sinh",
            "Export danh sách học sinh",
    };

    public void showMenu() {
        System.out.println("================================= Menu =================================");
        for (int i = 0; i < availableSelection.length; i++) {
            String text = String.format("Nhập số %d để %s ", i, availableSelection[i]);
            System.out.println(text);
        }
        System.out.println("Nhập số -1 để thoát chương trình ! ");
    }

    public void confirmSelection(int action) {
        String strreturn = "";
        int maxSelection = availableSelection.length;
        if(action == -1)
            strreturn = "Thoát chương trinh !!!";
        else if (action >= maxSelection)
            strreturn = "Không xác định được chức năng bạn cần !!!";
        else
            strreturn =  String.format("Bạn đã chọn chức năng %s ", availableSelection[action]);
        System.out.println(strreturn);
    }

}
