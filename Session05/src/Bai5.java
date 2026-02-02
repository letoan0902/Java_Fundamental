public class Bai5 {
    static class Book {
        String maSach;
        String tenSach;
        String tacGia;
        int namXuatBan;

        Book(String maSach, String tenSach, String tacGia, int namXuatBan) {
            this.maSach = maSach;
            this.tenSach = tenSach;
            this.tacGia = tacGia;
            this.namXuatBan = namXuatBan;
        }

        void hienThiThongTin() {
            System.out.println("Ma sach: " + maSach);
            System.out.println("Ten sach: " + tenSach);
            System.out.println("Tac gia: " + tacGia);
            System.out.println("Nam xuat ban: " + namXuatBan);
        }
    }

    public static void main(String[] args) {
        Book b = new Book("B01", "Lap trinh Java", "Author A", 2025);
        b.hienThiThongTin();
    }
}
