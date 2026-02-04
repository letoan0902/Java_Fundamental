public class Bai2 {
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
    }

    static class Cat extends Animal {
        @Override
        void sound() {
            System.out.println("Meo meo");
        }
    }

    public static void main(String[] args) {
        Animal dog = new Dog();
        Animal cat = new Cat();
        dog.sound();
        cat.sound();
    }
}
