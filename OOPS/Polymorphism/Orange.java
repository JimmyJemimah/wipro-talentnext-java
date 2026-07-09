class Orange extends Fruit {

    Orange() {
        super("Orange", "Citrusy", "Medium");
    }

    @Override
    void eat() {
        System.out.println(name + " tastes " + taste + ".");
    }

    public static void main(String[] args) {

        Apple apple = new Apple();
        Orange orange = new Orange();

        apple.eat();
        orange.eat();
    }
}