package p3;

/**
 * Created by Eric on 2/17/2017.
 */
public class StudentBag {
    private Student[] students;
    private int nElems;

    public StudentBag(int maxSize){
        students = new Student[maxSize];
        nElems = 0;
    }

    public void add(Student s){
        students[nElems++] = s;
    }
    public boolean removeById(String id) {
        int j;
        for (j = 0; j < nElems; j++) {
            if (students[j].getIdNumber().equals(id)) {
                break;
            }
        }

        if (j == nElems) {
            return false;
        } else {
            for (int k = j; k < nElems - 1; k++) {
                students[k] = students[k + 1];

            }
            nElems--;
            return true;
        }
    }
    public Student findById(String id) {
        for (int i = 0; i < nElems; i++) {
            if (students[i].getIdNumber().equals(id)) {
                return students[i];
            }
        }
        return null;
    }


    public void display() {
        System.out.println("Displaying Student Bag: ");
        for (int i = 0; i < nElems; i++){
            System.out.println(students[i].toString());
        }
    }

    public void selectionSort() {
        int out;
        int in;
        int min;

        for (out = 0; out < nElems - 1; out++) { // outer loop
            min = out;							// index of minumum value at that point
            for(in = out + 1; in < nElems; in++) { //inner loop
                if(students[in].getName().compareTo(students[min].getName()) < 0) { 			// if value at index of min is greater
                    min = in;				// we have a new min index
                }
            }
            swap(out, min);
        }
    }
    private void swap(int one, int two){
        Student temp = students[one];
        students[one] = students[two];
        students[two] = temp;
    }

    public int getnElems() {
        return nElems;
    }
    public Student[] getStudents(){
        return students;
    }
}
