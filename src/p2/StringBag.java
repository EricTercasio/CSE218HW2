package p2;

/**
 * Created by Eric on 2/17/2017.
 */
public class StringBag {
    private String[] strings;
    private int nElems;

    public StringBag(){
        strings = new String[5];
        nElems = 0;
    }
    public void add(String s){
        if (nElems == strings.length){ //If the length of the array equals the number of elements
            System.out.println("strings exceeded, doubling array size");
            doubleArray(); // jump to double the array size method
        }
        strings[nElems++] = s;

    }

    private void doubleArray() {
        String[] temp = strings; // make temp array from strings
        strings = new String[strings.length * 2]; // set strings to a new blank array double the size
        for (int i = 0; i < nElems; i++){
            strings[i] = temp[i]; //set strings back to values from temp array
        }
    }
    public void bubbleSort() {
        int out;
        int in;
        for(out = nElems - 1; out >= 1; out--) {
            for(in = 0; in < out; in++) {
                if(strings[in].compareTo(strings[in + 1]) > 0) { // make comparisons, swap if true
                    swap(in, in+1);
                }
            }
        }
    }

    private void swap(int one, int two) {
        String temp = strings[one];
        strings[one] = strings[two];
        strings[two] = temp;
    }

    public void display(){
        for(int i = 0; i < nElems; i++){
            System.out.print(strings[i] + " ");
        }
        System.out.println();
    }
}
