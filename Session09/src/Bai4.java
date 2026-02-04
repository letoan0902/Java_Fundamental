public class Bai4 {
    static class Animal {
        void sound() {
            System.out.println("Am thanh dong vat");
        }
    }

    static class Dog extends Animal {
        @Override
        void sound() {
            System.out.println("Gau gau");
        }

        void wagTail() {
            System.out.println("Vay duoi");
        }
    }

    public static void main(String[] args) {
        Animal animal = new Dog();
        animal.sound();
        // animal.wagTail(); // khong goi duoc tu kieu cha

        if (animal instanceof Dog) {
            Dog dog = (Dog) animal; // ep kieu an toan
            dog.wagTail();
        }
    }
}
