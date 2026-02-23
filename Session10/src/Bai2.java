public class Bai2 {
    static abstract class Vehicle {
        protected String brand;

        protected Vehicle(String brand) {
            this.brand = brand;
        }

        abstract void move();

        protected void printMove(String description) {
            System.out.println(brand + " - Cách di chuyển: " + description);
        }
    }

    static class Car extends Vehicle {
        Car(String brand) {
            super(brand);
        }

        @Override
        void move() {
            printMove("Di chuyển bằng động cơ");
        }
    }

    static class Bicycle extends Vehicle {
        Bicycle(String brand) {
            super(brand);
        }

        @Override
        void move() {
            printMove("Di chuyển bằng sức người");
        }
    }

    public static void main(String[] args) {
        Vehicle car = new Car("Toyota");
        Vehicle bicycle = new Bicycle("Giant");

        car.move();
        bicycle.move();
    }
}
