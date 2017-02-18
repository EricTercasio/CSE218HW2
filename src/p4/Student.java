package p4;

/**
 * Created by Eric on 2/18/2017.
 */
public class Student {
    private String name;
    private String idNumber;
    private static int id;

    public Student(String name){
        idNumber = String.valueOf(id++);
        this.name = name;

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
                "name='" + name + '\'' +
                ", id='" + idNumber + '\'' +
                '}';
    }
}
