import java.util.Scanner;

public class Animal {
    private String animalName;
    private int numberOfLegs;
    private String furColor;
    private double averageLifeExpectancy;

    public Animal() {
    }

    public Animal(String animalName, int numberOfLegs, String furColor, double averageLifeExpectancy) {
        this.animalName = animalName;
        this.numberOfLegs = numberOfLegs;
        this.furColor = furColor;
        this.averageLifeExpectancy = averageLifeExpectancy;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public int getNumberOfLegs() {
        return numberOfLegs;
    }

    public void setNumberOfLegs(int numberOfLegs) {
        this.numberOfLegs = numberOfLegs;
    }

    public String getFurColor() {
        return furColor;
    }

    public void setFurColor(String furColor) {
        this.furColor = furColor;
    }

    public double getAverageLifeExpectancy() {
        return averageLifeExpectancy;
    }

    public void setAverageLifeExpectancy(double averageLifeExpectancy) {
        this.averageLifeExpectancy = averageLifeExpectancy;
    }

    public void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Animal name: ");
        animalName = scanner.nextLine();
        System.out.print("Number of legs: ");
        numberOfLegs = Integer.parseInt(scanner.nextLine());
        System.out.print("Fur color: ");
        furColor = scanner.nextLine();
        System.out.print("Average life expectancy: ");
        averageLifeExpectancy = Double.parseDouble(scanner.nextLine());
    }

    public void display() {
        System.out.println("Animal name: " + animalName);
        System.out.println("Number of legs: " + numberOfLegs);
        System.out.println("Fur color: " + furColor);
        System.out.println("Average life expectancy: " + averageLifeExpectancy);
    }
}
