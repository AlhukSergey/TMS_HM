package by.teachmeskills.homeworks.hm_03032023.Animals;

public abstract class Canine extends Animal {

    public Canine(String picture, String food, int hungerLevel, Boundaries boundaries, Location location) {
        super(picture, food, hungerLevel, boundaries, location);
    }

    protected abstract void roam();
}
