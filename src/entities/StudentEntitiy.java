package entities;
import java.io.Serializable;
import java.util.Scanner;

public class StudentEntitiy implements Serializable {
    private static final long serialVersionUID = -6500665823330706018L;
    String id;
    String name;
    float point;
    String address;
    String note;

    public StudentEntitiy() {
        setId("");
        setName("");
        setPoint(0.0f);
        setAddress("");
        setNote("");
    }

    public StudentEntitiy(String dtoID, String dtoName, float dtoPoint, String dtoAddress, String dtoNote) {
        setId(dtoID);
        setName(dtoName);
        setPoint(dtoPoint);
        setAddress(dtoAddress);
        setNote(dtoNote);
    }

    public StudentEntitiy(StudentEntitiy dto) {
        setId(dto.getId());
        setName(dto.getName());
        setPoint(dto.getPoint());
        setAddress(dto.getAddress());
        setNote(dto.getNote());
    }

    public String getId() { return id; }

    public String getName() { return name; }

    public float getPoint() { return point; }

    public String getAddress() { return address; }

    public String getNote() { return note; }

    public void setId(String id) { this.id = id; }

    public void setName(String name) { this.name = name; }

    public void setPoint(float point) { this.point = point; }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String toString (){ return this.id + "," + this.name + "," + this.point + "," + this.address+ "," + this.note;}

    public void scanStudent() {
        Scanner in = new Scanner(System.in);
        System.out.println("Mã số sinh viên: ");
        id = in.nextLine();
        System.out.println("Tên sinh viên: ");
        name = in.nextLine();
        System.out.println("Điểm: ");
        point = in.nextFloat();
        in.nextLine();
        System.out.println("Địa chỉ: ");
        address = in.nextLine();
        System.out.println("Ghi chú: ");
        note = in.nextLine();
        System.out.println("\n");
    }

    public void showInfo() {
        System.out.println("Thông tin sinh viên:");
        System.out.println("Mã số sinh viên: " + id);
        System.out.println("Tên sinh viên: " + name);
        System.out.println("Điểm: "+ point);
        System.out.println("Địa chỉ: "+ address);
        System.out.println("Ghi chú: "+ note);
        System.out.println("\n");
    }
}
