package by.teachmeskills.homeworks.hm_03032023.Animals;

public class Cat extends Feline {
    public Cat(String picture, String food, int hungerLevel, Boundaries boundaries, Location location) {
        super(picture, food, hungerLevel, boundaries, location);
    }

    @Override
    protected void makeNoise() {
        System.out.println("Miaaaau!");
    }

    @Override
    protected void eat() {
        System.out.println("I'm eating dry food and mice!");
    }

    @Override
    protected void roam() {
        System.out.println("I'm walking alone and anywhere!");
    }
}
