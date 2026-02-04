public class Bai6 {
    abstract static class Shape {
        abstract double area();
    }

    static class Circle extends Shape {
        private double radius;

        Circle(double radius) {
            this.radius = radius;
        }

        Circle(double value, boolean isDiameter) {
            this.radius = isDiameter ? value / 2 : value;
        }

        @Override
        double area() {
            return Math.PI * radius * radius;
        }

        double area(double r) {
            return Math.PI * r * r;
        }
    }

    static class Rectangle extends Shape {
        private double width;
        private double height;

        Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        @Override
        double area() {
            return width * height;
        }
    }

    public static void main(String[] args) {
        Shape[] shapes = {
            new Circle(3),
            new Rectangle(4, 5),
            new Circle(10, true)
        };

        double tong = 0;
        for (Shape s : shapes) {
            tong += s.area();
        }

        Circle c = new Circle(2);
        double areaOverload = c.area(4); // goi overload

        System.out.println("Tong dien tich: " + tong);
        System.out.println("Dien tich overload: " + areaOverload);
    }
}
