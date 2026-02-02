public class Bai2 {
    static class Account {
        String username;
        String password;
        String email;

        Account(String username, String password, String email) {
            this.username = username;
            this.password = password;
            this.email = email;
        }

        void doiMatKhau(String matKhauMoi) {
            if (matKhauMoi == null || matKhauMoi.isEmpty()) {
                System.out.println("Mat khau moi khong hop le");
                return;
            }
            this.password = matKhauMoi;
        }

        void hienThiThongTin() {
            System.out.println("Username: " + username);
            System.out.println("Password: " + "********");
            System.out.println("Email: " + email);
        }
    }

    public static void main(String[] args) {
        Account acc = new Account("user01", "123456", "user01@gmail.com");
        System.out.println("Truoc khi doi mat khau");
        acc.hienThiThongTin();

        acc.doiMatKhau("newPass2026");
        System.out.println();
        System.out.println("Sau khi doi mat khau");
        acc.hienThiThongTin();
    }
}
