public class Bai5 {
    static abstract class Employee {
        protected String name;
        protected double baseSalary;

        protected Employee(String name, double baseSalary) {
            this.name = name;
            this.baseSalary = baseSalary;
        }

        abstract double calculateSalary();
    }

    interface BonusCalculator {
        double getBonus();
    }

    static class OfficeStaff extends Employee {
        OfficeStaff(String name, double baseSalary) {
            super(name, baseSalary);
        }

        @Override
        double calculateSalary() {
            return baseSalary;
        }
    }

    static class Manager extends Employee implements BonusCalculator {
        private final double bonus;

        Manager(String name, double baseSalary, double bonus) {
            super(name, baseSalary);
            this.bonus = bonus;
        }

        @Override
        public double getBonus() {
            return bonus;
        }

        @Override
        double calculateSalary() {
            return baseSalary + getBonus();
        }
    }

    private static void printPayslip(Employee e) {
        double bonus = 0;
        if (e instanceof BonusCalculator) {
            bonus = ((BonusCalculator) e).getBonus();
        }
        double total = e.baseSalary + bonus;

        System.out.printf("%-12s | Base: %10.2f | Bonus: %10.2f | Total: %10.2f%n",
                e.getClass().getSimpleName(), e.baseSalary, bonus, total);
    }

    public static void main(String[] args) {
        Employee staff = new OfficeStaff("An", 8000);
        Employee manager = new Manager("Binh", 12000, 3000);

        System.out.println("BẢNG LƯƠNG");
        printPayslip(staff);
        printPayslip(manager);
    }
}
