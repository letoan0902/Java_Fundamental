import java.util.Scanner;

public class MamalAnimal extends Animal {
    private String foodType;
    private boolean isLiveWithHuman;
    private String mamalSound;

    public MamalAnimal() {
    }

    public MamalAnimal(String animalName, int numberOfLegs, String furColor, double averageLifeExpectancy,
                       String foodType, boolean isLiveWithHuman, String mamalSound) {
        super(animalName, numberOfLegs, furColor, averageLifeExpectancy);
        this.foodType = foodType;
        this.isLiveWithHuman = isLiveWithHuman;
        this.mamalSound = mamalSound;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public boolean isLiveWithHuman() {
        return isLiveWithHuman;
    }

    public void setLiveWithHuman(boolean liveWithHuman) {
        isLiveWithHuman = liveWithHuman;
    }

    public String getMamalSound() {
        return mamalSound;
    }

    public void setMamalSound(String mamalSound) {
        this.mamalSound = mamalSound;
    }

    @Override
    public void input() {
        super.input();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Food type: ");
        foodType = scanner.nextLine();
        System.out.print("Live with human (true/false): ");
        isLiveWithHuman = Boolean.parseBoolean(scanner.nextLine());
        System.out.print("Mamal sound: ");
        mamalSound = scanner.nextLine();
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Food type: " + foodType);
        System.out.println("Live with human: " + isLiveWithHuman);
        System.out.println("Mamal sound: " + mamalSound);
    }
}
