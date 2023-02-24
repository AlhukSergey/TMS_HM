package by.teachmeskills.homeworks.hm_03032023.Animals;

public abstract class Animal {
    protected String picture;
    protected String food;
    protected int hungerLevel;
    protected Boundaries boundaries;
    protected Location location;

    public Animal(String picture, String food, int hungerLevel, Boundaries boundaries, Location location) {
        this.picture = picture;
        this.food = food;
        this.hungerLevel = hungerLevel;
        this.boundaries = boundaries;
        this.location = location;
    }

    protected abstract void makeNoise();

    protected abstract void eat();

    protected void sleep() {
        System.out.println("I'm sleeping. hrrrrrffff");
    }

    protected void roam() {
        System.out.println("I walk slowly.");
    }

    protected static class Location {
        private int x;
        private int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        @Override
        public String toString() {
            return "Location{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    protected static class Boundaries {
        private int width;
        private int height;

        public Boundaries(int width, int height) {
            this.width = width;
            this.height = height;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        @Override
        public String toString() {
            return "Boundaries{" +
                    "width=" + width +
                    ", height=" + height +
                    '}';
        }
    }
}
