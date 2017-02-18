package p3;

/**
 * Created by Eric on 2/17/2017.
 */
public class Student {
    private String name;
    private String idNumber;
    private static int id = 0;

    public Student(String name){
        this.name = name;
        idNumber = String.valueOf(id++);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdNumber() {
        return idNumber;
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' + "id: " + idNumber +
                '}';
    }
}
