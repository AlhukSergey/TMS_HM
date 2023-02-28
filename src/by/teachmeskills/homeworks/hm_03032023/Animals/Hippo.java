package by.teachmeskills.homeworks.hm_03032023.Animals;

public class Hippo extends Animal {
    public Hippo(String picture, String food, int hungerLevel, Boundaries boundaries, Location location) {
        super(picture, food, hungerLevel, boundaries, location);
    }

    @Override
    protected void makeNoise() {
        System.out.println("GGGGGGGGGUUUUUUUUuu");
    }

    @Override
    protected void eat() {
        System.out.println("I eat fresh grass!");
    }
}
