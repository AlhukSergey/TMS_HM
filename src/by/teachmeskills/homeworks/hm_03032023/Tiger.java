package by.teachmeskills.homeworks.hm_03032023;

public class Tiger extends Feline {
    public Tiger(String picture, String food, int hungerLevel, Boundaries boundaries, Location location) {
        super(picture, food, hungerLevel, boundaries, location);
    }

    @Override
    protected void makeNoise() {
        System.out.println("SHHHHHRRRRAAAAU");
    }

    @Override
    protected void eat() {
        System.out.println("I like the same as the lion!");
    }

    @Override
    protected void roam() {
        System.out.println("I'm walking alone and very fast!");
    }
}
