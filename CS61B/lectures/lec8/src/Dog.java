public class Dog implements Animal {
    public void sniff(Animal a) {
        System.out.println("dog sniff animal");
    }

    public void flatter(Dog a) {
        System.out.println("u r cool dog");
    }

//    public void flatter(Animal a) {
//        System.out.println("u r cool dog");
//    }

    public static void main(String[] args) {
        Animal a = new Dog();
        Dog d = new Dog();
        // 调用Animal里的
        // flatter(Dog a)是overload,
        // flatter(Animal a)是override
        a.flatter(d);
    }
}
