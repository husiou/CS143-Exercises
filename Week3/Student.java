/*


    Modified by TODO: Hugo Siou

    TODO: write a description of the Student.java class and your modifications here
    - Constructor: threw IllegalArgumentException when values passed in weren't valid under our constraints (age < 13, non null name, valid major)
    - increaseAge: threw IllegalArgumentException when increase wasn't positive
    - changeMajor: looped through majors to check if major was valid, then threw IllegalArgumentException when major wasn't valid
    - averageAge: tracked total age and total students, inside loop used try block to ensure students were non null, if they were
    null then threw NullPointerException. 0 students = 0.0 return and other cases return total age / numStudents casted to double
 */
public class Student {
    private String name;
    private int age;
    private String major;

    public static final String[] MAJORS = {
            "Computer Science", "Mechanical Engineering", "Electrical Engineering", "Biomedical Engineering",
            "Chemical Engineering", "Aerospace Engineering", "Civil Engineering", "Physics", "Mathematics",
            "Biology", "Chemistry", "Environmental Science", "Robotics Engineering", "Materials Science",
            "Nuclear Engineering", "Biochemistry", "Geology", "Astronomy", "Statistics", "Computer Engineering"
    };

    /*
        TODO: when constructing a student, the name and majors must be non-null. The age must be at least 13 (inclusive).
                Additionally, the major must be within the above array of valid majors.
    */
    public Student(String name, int age, String major){
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        if (age < 13) {
            throw new IllegalArgumentException("age must be at least 13");
        }
        boolean validMajor = false;
        for(int i = 0; i < MAJORS.length; i++) {
            if(major.equals(MAJORS[i])) {
                validMajor = true;
            }
        }
        if(validMajor == false) {
            throw new IllegalArgumentException("Major must be a valid major");
        }
        this.name = name;
        this.age = age;
        this.major = major;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getMajor() {
        return major;
    }

    /*
        Increases the age of a student by the specified amount.
        TODO: it should not be possible to increase a student's age by a non-positive amount.
     */
    public void increaseAge(int amount){
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be a positive number");
        }
    }
    /*
        Changes the major of a student to the specified String.
        TODO: if the new major is not one of the options in the MAJORS array, an exception should be thrown.
     */
    public void changeMajor(String major){
        boolean validMajor = false;
        for (String m: MAJORS) {
            if (major.equals(m)) {
                validMajor = true;
            }
        }
        if (validMajor == false) {
            throw new IllegalArgumentException("Major must be a valid major");
        }
    }

    /*
        Given an array of students, returns the average age.
     */
    public static double averageAge(Student[] students){
        // TODO: write the code to calculate average age here. Note that a student in the array may be null.
        // TODO: use a try-catch to handle this exception. Null students should not contribute to the average age.
        int totalAge = 0;
        int validStudents = 0;
        for(Student stu : students) {
            try {
                    totalAge += stu.getAge();
                    validStudents++;
            } catch (NullPointerException e){
                System.out.println("student must not be null");
            }
        }
        if(validStudents == 0) {
            return 0.0;
        }
        return (double)totalAge / validStudents;
    }
}
