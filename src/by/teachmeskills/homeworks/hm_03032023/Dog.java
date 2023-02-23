package by.teachmeskills.homeworks.hm_03032023;

public class Dog extends Canine {
    public Dog(String picture, String food, int hungerLevel, Boundaries boundaries, Location location) {
        super(picture, food, hungerLevel, boundaries, location);
    }

    @Override
    protected void makeNoise() {
        System.out.println("GAF!! GAAAAF!!!!");
    }

    @Override
    protected void eat() {
        System.out.println("I eat dray food and soup!");
    }

    @Override
    protected void roam() {
        System.out.println("I like to walk with my master! I love him!");
    }
}
