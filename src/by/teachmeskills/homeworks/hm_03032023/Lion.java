package by.teachmeskills.homeworks.hm_03032023;

public class Lion extends Feline {
    public Lion(String picture, String food, int hungerLevel, Boundaries boundaries, Location location) {
        super(picture, food, hungerLevel, boundaries, location);
    }

    @Override
    protected void makeNoise() {
        System.out.println("RRRRRAAAAAAAAAUUUU!!");
    }

    @Override
    protected void eat() {
        System.out.println("I eat everyone I catch!");
    }

    @Override
    protected void roam() {
        System.out.println("I'm walking alone.");
    }
}
