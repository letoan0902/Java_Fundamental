public class Main {
    public static void main(String[] args) {
        BirdAnimal bird = new BirdAnimal();
        MamalAnimal mamal = new MamalAnimal();

        bird.input();
        bird.display();

        mamal.input();
        mamal.display();
    }
}