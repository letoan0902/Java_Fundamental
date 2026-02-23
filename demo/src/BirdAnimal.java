import java.util.Scanner;

public class BirdAnimal extends Animal {
    private boolean isFly;
    private String birdSound;

    public BirdAnimal() {
    }

    public BirdAnimal(String animalName, int numberOfLegs, String furColor, double averageLifeExpectancy,
                      boolean isFly, String birdSound) {
        super(animalName, numberOfLegs, furColor, averageLifeExpectancy);
        this.isFly = isFly;
        this.birdSound = birdSound;
    }

    public boolean isFly() {
        return isFly;
    }

    public void setFly(boolean fly) {
        isFly = fly;
    }

    public String getBirdSound() {
        return birdSound;
    }

    public void setBirdSound(String birdSound) {
        this.birdSound = birdSound;
    }

    @Override
    public void input() {
        super.input();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Can fly (true/false): ");
        isFly = Boolean.parseBoolean(scanner.nextLine());
        System.out.print("Bird sound: ");
        birdSound = scanner.nextLine();
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Can fly: " + isFly);
        System.out.println("Bird sound: " + birdSound);
    }
}
