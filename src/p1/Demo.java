package p1;

/**
 * Created by Eric on 2/17/2017.
 */
public class Demo {
    public static void main(String[] args){
        IntBag intBag = new IntBag();
        System.out.println("Original array");
        intBag.add(5);
        intBag.add(9);
        intBag.add(1);
        intBag.add(3);
        intBag.add(2);
        System.out.println("Doubled");
        intBag.display();
        intBag.add(4);
        intBag.add(67);
        intBag.add(67);
        intBag.add(67);
        intBag.add(67);
        System.out.println("Doubled");
        intBag.display();
        intBag.add(67);
        intBag.add(67);
        intBag.add(67);
        intBag.add(67);
        intBag.add(67);
        intBag.add(67);
        intBag.add(67);
        intBag.add(67);
        intBag.add(67);
        intBag.add(67);
        System.out.println("Doubled");
        intBag.display();
        intBag.add(67);
        intBag.display();

    }
}
