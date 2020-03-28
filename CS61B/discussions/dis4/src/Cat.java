/*Given the Animal class, fill in the definition of the Cat class so that when greet() is
called, “Cat says: Meow!” is printed (instead of “Animal says: Huh?”). Cats less
than the ages of 5 can say “MEOW!” instead of “Meow!”*/

public class Cat extends Animal {

    public Cat(String name, int age) {
        super(name, age);
        noise = "Meow!";

    }

    public String makeNoise() {
        if (age < 5) {
            return noise.toUpperCase();
        } else {
            return noise;
        }
    }

    @Override
    public void greet() {
        System.out.println("Cat " + name + " says: " + makeNoise());
    }
}
