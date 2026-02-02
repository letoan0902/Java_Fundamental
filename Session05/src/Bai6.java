public class Bai6 {
    static class User {
        private int id;
        private String username;
        private String password;
        private String email;

        User(int id, String username, String password, String email) {
            this.id = id;
            this.username = username;
            setPassword(password);
            setEmail(email);
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            if (password == null || password.trim().isEmpty()) {
                System.out.println("Password khong duoc rong");
                return;
            }
            this.password = password;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            if (!isValidEmail(email)) {
                System.out.println("Email khong hop le: " + email);
                return;
            }
            this.email = email;
        }

        private boolean isValidEmail(String email) {
            if (email == null) {
                return false;
            }
            int at = email.indexOf('@');
            if (at <= 0 || at != email.lastIndexOf('@')) {
                return false;
            }
            int dot = email.indexOf('.', at + 2);
            return dot > at + 1 && dot < email.length() - 1;
        }

        void hienThiThongTin() {
            System.out.println("Id: " + id);
            System.out.println("Username: " + username);
            System.out.println("Password: " + "********");
            System.out.println("Email: " + email);
        }
    }

    public static void main(String[] args) {
        User u1 = new User(1, "alice", "123456", "alice@gmail.com");
        User u2 = new User(2, "bob", "", "bob@gmail.com");
        User u3 = new User(3, "charlie", "pass", "charliegmail.com");

        System.out.println("User 1");
        u1.hienThiThongTin();
        System.out.println();

        System.out.println("User 2");
        u2.hienThiThongTin();
        System.out.println();

        System.out.println("User 3");
        u3.hienThiThongTin();
        System.out.println();

        u1.setPassword("   ");
        u1.setEmail("a@b");
        u1.setEmail("a@b.com");
        System.out.println("User 1 sau khi test set sai/dung");
        u1.hienThiThongTin();
    }
}
