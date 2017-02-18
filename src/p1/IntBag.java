package p1;

/**
 * Created by Eric on 2/17/2017.
 */
public class IntBag {
    private int[] numbers;
    private int nElems;

    public IntBag(){
        numbers = new int[5];
        nElems = 0;
    }
    public void add(int n){
        if (nElems == numbers.length){ //If the length of the array equals the number of elements
            System.out.println("Numbers exceeded, doubling array size");
            doubleArray(); // jump to double the array size method
        }
        numbers[nElems++] = n;

    }

    private void doubleArray() {
        int[] temp = numbers; // make temp array from numbers
        numbers = new int[numbers.length * 2]; // set numbers to a new blank array double the size
        for (int i = 0; i < nElems; i++){
            numbers[i] = temp[i]; //set numbers back to values from temp array
        }
    }

    public void display(){
        for(int i = 0; i < nElems; i++){
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
    }
}
