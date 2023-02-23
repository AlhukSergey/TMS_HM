package by.teachmeskills.homeworks.hm_03032023;
public class Main {
    public static void main(String[] args) {
        Animal hippo = new Hippo("Hippo.png", "Grass", 6,
                new Animal.Boundaries(100, 100), new Animal.Location(15, 15));
        Animal cat = new Cat("Cat.png", "Mice", 1,
                new Animal.Boundaries(1000, 1000), new Animal.Location(1, 1));
        Animal dog = new Dog("Dog.png", "Chappy", 9,
                new Animal.Boundaries(1000, 1000), new Animal.Location(2, 2));
        Animal lion = new Lion("Lion.png", "Antelope", 10,
                new Animal.Boundaries(10000, 10000), new Animal.Location(3, 1));
        Animal tiger = new Tiger("Tiger.png", "Antelope", 10,
                new Animal.Boundaries(10000, 10000), new Animal.Location(3, 1));
        Animal wolf = new Wolf("Wolf.png", "Rabbit", 110000,
                new Animal.Boundaries(2000, 2000), new Animal.Location(2, 2));

        Animal[] animals = {hippo, cat, dog, lion, tiger, wolf};
        for (Animal animal : animals) {
            animal.roam();
            animal.makeNoise();
            animal.eat();
            animal.sleep();
            System.out.println("!-----------------------------------------!-----------------------------------!");
        }
        System.out.println("!-----------------------------------------!-----------------------------------!");

        Feline cat2 = new Cat("Cat.png", "Chappy", 1,
                new Animal.Boundaries(1000, 1000), new Animal.Location(1, 1));
        Feline lion2 = new Lion("Lion.png", "Zebra", 10,
                new Animal.Boundaries(10000, 10000), new Animal.Location(3, 1));
        Feline tiger2 = new Tiger("Tiger.png", "Giraffe", 10,
                new Animal.Boundaries(10000, 10000), new Animal.Location(3, 1));

        Feline[] felines = {cat2, lion2, tiger2};
        for (Feline feline : felines) {
            feline.roam();
            feline.makeNoise();
            feline.eat();
            feline.sleep();
            System.out.println("!-----------------------------------------!-----------------------------------!");
        }
        System.out.println("!-----------------------------------------!-----------------------------------!");

        Canine dog2 = new Dog("Dog.png", "Soup", 9,
                new Animal.Boundaries(1000, 1000), new Animal.Location(2, 2));
        Canine wolf2 = new Wolf("Wolf.png", "Badger", 110000,
                new Animal.Boundaries(2000, 2000), new Animal.Location(2, 2));

        Canine[] canines = {dog2, wolf2};

        for (Canine canine : canines) {
            canine.roam();
            canine.makeNoise();
            canine.eat();
            canine.sleep();
            System.out.println("!-----------------------------------------!-----------------------------------!");
        }
    }
}
