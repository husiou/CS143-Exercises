// class code
/*
student class for cc cs 143
*/
public class Student {
    
    private String name;
    private int id;
    private int age;
    private String major;
    public Student(String name, int iD, int age, String major) {
        this.name = name;
        this.id = iD;
        this.age = age;
        this.major = major;
    }

    public String toString() {
        return "name, iD, age, major";
    }

    public void changeMajor(String newMajor) {
        major = newMajor;
    }
}
    public static void main(String[] args) {
        // Student s1 = new Student("David Anderosn", 12345, 33, "Computer Science");

        // Student s2 = new Student("Diego Smith", 39424, 40, "Math");

        // Student s3 = new Student("Lydia", 30402, 18, "History");
        //System.out.println(s1);
    }
