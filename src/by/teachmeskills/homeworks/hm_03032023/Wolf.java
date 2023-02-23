package by.teachmeskills.homeworks.hm_03032023;

public class Wolf extends Canine {
    public Wolf(String picture, String food, int hungerLevel, Boundaries boundaries, Location location) {
        super(picture, food, hungerLevel, boundaries, location);
    }

    @Override
    protected void makeNoise() {
        System.out.println("AuuuuuuuuuUUUU!");
    }

    @Override
    protected void eat() {
        System.out.println("I like to eat fresh meat, especially rabbits!");
    }

    @Override
    protected void roam() {
        System.out.println("I live and walk in a flock.");
    }
}
