package p4;

/**
 * Created by Eric on 2/18/2017.
 */
public class StudentBag {
    private Student[] students;
    private int nElems;

    public StudentBag() {
        students = new Student[10];
        nElems = 0;
    }
    public void add(Student s){
        students[nElems++] = s;
    }
    public void display(){
        for(int i = 0; i < nElems; i++){
            students.toString();
        }
    }
    public Student findByName(String name){
        for (int i = 0; i < nElems; i++){
            if (students[i].getName().equals(name)){
                return students[i];
            }

        }
        return null;
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
    public void selectionSort() {
        int out;
        int in;
        int min;

        for (out = 0; out < nElems - 1; out++) { // outer loop
            min = out;							// index of minumum value at that point
            for(in = out + 1; in < nElems; in++) { //inner loop
                if(students[in].getName().compareTo(students[min].getName()) < 0) { 			// if first students name is before seconds name
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
    public int getnElems(){
        return nElems;
    }
    public Student[] getStudents(){
        return students;
    }

}
