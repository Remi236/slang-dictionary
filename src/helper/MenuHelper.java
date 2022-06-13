package helper;

public class MenuHelper {
    String[] availableSelection = {
            "Chức năng tìm kiếm theo slang word",
            "Chức năng tìm kiếm theo definition, hiển thị ra tất cả các slang words mà trong defintion có chứa keyword gõ vào.",
            "Chức năng hiển thị history, danh sách các slang word đã tìm kiếm.",
            "Chức năng add 1 slang words mới.",
            "Chức năng edit 1 slang word.",
            "Chức năng delete 1 slang word. Confirm trước khi xoá.",
            "Chức năng reset danh sách slang words gốc.",
            "Chức năng random 1 slang word (On this day slang word).",
            "Chức năng đố vui, chương trình hiển thị 1 random slang word, với 4 đáp án cho người dùng chọn.",
            "Chức năng đố vui, chương trình hiển thị 1 definition, với 4 slang words đáp án cho người dùng chọn",
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
