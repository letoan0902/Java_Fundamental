public class Bai3 {
    static abstract class Animal {
        protected String name;

        protected Animal(String name) {
            this.name = name;
        }
    }

    interface Swimmable {
        void swim();
    }

    interface Flyable {
        void fly();
    }

    static class Duck extends Animal implements Swimmable, Flyable {
        Duck(String name) {
            super(name);
        }

        @Override
        public void swim() {
            System.out.println(name + " đang bơi");
        }

        @Override
        public void fly() {
            System.out.println(name + " đang bay");
        }
    }

    static class Fish extends Animal implements Swimmable {
        Fish(String name) {
            super(name);
        }

        @Override
        public void swim() {
            System.out.println(name + " đang bơi");
        }
    }

    public static void main(String[] args) {
        Duck duck = new Duck("Vịt");
        Fish fish = new Fish("Cá");

        duck.swim();
        duck.fly();
        fish.swim();
    }
}
