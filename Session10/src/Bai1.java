public class Bai1 {
    interface Shape {
        double getArea();

        double getPerimeter();
    }

    static class Circle implements Shape {
        private final double radius;

        Circle(double radius) {
            this.radius = radius;
        }

        @Override
        public double getArea() {
            return Math.PI * radius * radius;
        }

        @Override
        public double getPerimeter() {
            return 2 * Math.PI * radius;
        }
    }

    static class Rectangle implements Shape {
        private final double width;
        private final double height;

        Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        @Override
        public double getArea() {
            return width * height;
        }

        @Override
        public double getPerimeter() {
            return 2 * (width + height);
        }
    }

    public static void main(String[] args) {
        Shape circle = new Circle(3);
        Shape rectangle = new Rectangle(4, 5);

        System.out.printf("Circle: area=%.2f, perimeter=%.2f%n", circle.getArea(), circle.getPerimeter());
        System.out.printf("Rectangle: area=%.2f, perimeter=%.2f%n", rectangle.getArea(), rectangle.getPerimeter());
    }
}
