package assesment;

public class StudentData{

    private int id;
    private String name;
    private int age;
    private String course;

    public StudentData(int id, String name, int age, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + age + "," + course;
    }
}