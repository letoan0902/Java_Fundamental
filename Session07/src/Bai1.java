public class Bai1 {
    static class Student {
        String studentId;
        String studentName;
        static int totalStudent = 0;

        Student(String studentId, String studentName) {
            this.studentId = studentId;
            this.studentName = studentName;
            totalStudent++;
        }

        void printInfo() {
            System.out.println("Ma: " + studentId + ", Ten: " + studentName);
        }

        static void printTotal() {
            System.out.println("Tong so sinh vien: " + totalStudent);
        }
    }

    public static void main(String[] args) {
        // Tao nhieu sinh vien, totalStudent tang dung
        Student s1 = new Student("SV01", "An");
        Student s2 = new Student("SV02", "Binh");
        Student s3 = new Student("SV03", "Chi");

        s1.printInfo();
        s2.printInfo();
        s3.printInfo();
        Student.printTotal();
    }
}
