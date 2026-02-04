public class Bai2 {
    static class Student {
        String name;

        Student(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        int a = 5;
        int b = a;
        b = 10;

        System.out.println("a = " + a + ", b = " + b);

        Student s1 = new Student("Nam");
        Student s2 = s1;
        s2.name = "Hoa";

        System.out.println("s1.name = " + s1.name + ", s2.name = " + s2.name);
    }
}
