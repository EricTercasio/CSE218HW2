package p2;

/**
 * Created by Eric on 2/17/2017.
 */
public class Demo {
    public static void main(String[] args) {
        StringBag stringBag = new StringBag();
        System.out.println("Original Array");
        stringBag.add("Ben");
        stringBag.add("Ashley");
        stringBag.add("John");
        stringBag.add("Bill");
        stringBag.add("Truman");
        stringBag.display();
        System.out.println("Doubled");
        stringBag.add("Hello");
        stringBag.add("Lenny");
        stringBag.add("Pablo");
        stringBag.add("Jose");
        stringBag.add("Zen");
        stringBag.display();
        System.out.println("Sorted: ");
        stringBag.bubbleSort();
        stringBag.display();
    }

}
