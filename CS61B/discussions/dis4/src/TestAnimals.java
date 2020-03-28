public class TestAnimals {
    public static void main(String[] args){
        Animal a= new Animal("Pluto",10);
        Cat c = new Cat("Garfield",6);
        Dog d = new Dog("Fido",4);

        a.greet();
        c.greet();
        d.greet();
        a=c;
        ((Cat)a).greet();
        a.greet();


//        a = new Dog("Spot",10);
        /*error because a'sstatic type is Animal and runtime type is Dog, could not assign Animal to Dog*/
//        d = a;
    }
}
