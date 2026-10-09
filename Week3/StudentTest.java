import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Random;

/**
 * Test program for CS 143 Assignment 2 (Version of 10/9/2023 9:00 AM)
 *
 * DO NOT MODIFY THE CODE IN THIS FILE. PLEASE ONLY MODIFY STUDENT.JAVA
 *
 * Author: David Anderson, with small help from ChatGPT
 *
 * You may only use this program as a student of David Anderson, CS 143 Fall 2023.
 *
 * Directions: Run this program from the same project source folder as the Student.java and StudentSurvey.java
 * files.
 */
public class StudentTest {

    private static final Random r = new Random();
    private static final int NUMBER_OF_NAMES = 100;
    // muchas gracias to ChatGPT for the first names
    private static final String[] FIRST_NAMES = {
            "Emma", "Liam", "Olivia", "Noah", "Sofia", "Elijah", "Ava", "Mateo", "Zara", "Amir",
            "Chloe", "Arjun", "Aisha", "Lucas", "Zoe", "Milo", "Layla", "Kai", "Mia", "Omar",
            "Luna", "Alexander", "Nyla", "Caleb", "Aaliyah", "Finn", "Sana", "Leo", "Leila",
            "Henry", "Amara", "Sebastian", "Amina", "Dylan", "Eva", "Mason", "Zain", "Avery",
            "Aryan", "Nina", "Ethan", "Lila", "Isaac", "Maya", "Liam", "Sari", "Eliana",
            "Cameron", "Sasha", "Lucas", "Priya", "Isaiah", "Nia", "Nathan", "Aisha", "Jaxon",
            "Sofia", "Omar", "Amara", "Eli", "Lila", "Owen", "Aria", "Carter", "Zahra",
            "Ezra", "Amina", "Nolan", "Zoya", "Samuel", "Ayesha", "Wyatt", "Anaya", "Aiden",
            "Zainab", "Jackson", "Leila", "Sebastian", "Laila", "Caleb", "Aisha", "Elijah", "Zara",
            "Grayson", "Samiya", "Landon", "Imani", "Oliver", "Aaliyah", "Miles", "Soraya", "Liam",
            "Ayana", "Lincoln", "Zahra", "James", "Amira", "Julian", "Nyla", "Isaiah"
    };
    // danke schoen to ChatGPT for the last names
    private static final String[] LAST_NAMES = {
            "Smith", "Johnson", "Martinez", "Wang", "Garcia", "Ali", "Nguyen", "Cohen", "Brown", "Lopez",
            "Robinson", "Choi", "Williams", "Taylor", "Kumar", "Jones", "Olsen", "Hernandez", "Kimura",
            "Gomez", "Gupta", "Andersen", "Lee", "Gonzalez", "Walker", "Ramirez", "Sorensen", "García",
            "Thompson", "Adeyemi", "Cruz", "Müller", "Singh", "Ahmed", "Perez", "Jacobsen", "King", "Yamamoto",
            "Carter", "Christensen", "O'Connor", "Nkosi", "Cooper", "Frederiksen", "Madsen", "Schmidt", "Fisher",
            "Johansen", "Khan", "Li", "Mandela", "Ramos", "Jensen", "Abraham", "Hassan", "Nygaard", "Rodriguez",
            "Freeman", "Castro", "Kim", "Knudsen", "Santiago", "Martinsen", "Petersen", "Sanchez", "Huang",
            "Håkansson", "Schneider", "Barnes", "Andreasen", "Mendoza", "Gupta", "Eriksen", "Jacobs", "Saito",
            "Nelson", "Larsen", "Bouarfa", "O'Brien", "Munoz", "Djokovic", "Fuentes", "Adebayo", "O'Reilly",
            "Hansen", "Reyes", "Nunes", "Ortega", "Hakim", "Kováč", "Petrov", "Leblanc", "Zhang", "Fernandez",
            "Mukherjee", "Torres", "López", "Ahn", "Ito", "Garcês"
    };


    private static String generateName(){
        return FIRST_NAMES[r.nextInt(NUMBER_OF_NAMES)] + " " + LAST_NAMES[r.nextInt(NUMBER_OF_NAMES)];
    }

    private static String[] generateNames(int count){
        String[] res = new String[count];
        for(int i = 0; i < count; i++){
            res[i] = generateName();
        }
        return res;
    }

    private static void printNames(String[] names){
        for(int i = 0; i < names.length; i++){
            System.out.print(names[i]);
            if(i < names.length - 1){
                System.out.print(", ");
            }
            if(i > 0 && (i+1) % 4 == 0){
                System.out.println();
            }
        }
    }

    private static Student[] makeStudents(String[] names, int[] ages, String[] majors, int count){
        // sanity check
        assert names.length == ages.length && names.length == majors.length && names.length == count;

        Student[] res = new Student[count];
        for(int i = 0; i < count; i++){
            res[i] = new Student(names[i], ages[i], majors[i]);
        }
        return res;
    }

    private static int[] ages(int count, int min, int max){
        int[] res = new int[count];
        for(int i = 0; i < count; i++){
            res[i] = r.nextInt(max - min) + min;
            if(r.nextBoolean()){
                res[i] = -res[i];
            }
        }
        res[count - 1] = 12;
        res[count - 2] = 13;
        return res;
    }

    public static void main(String[] args) {
        assert FIRST_NAMES.length == LAST_NAMES.length; // sanity check, ChatGPT sometimes gets confused

        System.out.println(
                "=======================================================================================\n" +
                        "Tester for CS 143 Assignment 2: Student Exceptions\n" +
                        "=======================================================================================\n" +
                        "* This tester checks your code for accuracy and provides feedback on inaccurate results.\n" +
                        "* Errors indicated by the tester should be fixed in your code. Re-run the tester after \n\t" +
                        "fixing them to check your code again.\n" +
                        "* If the tester finds no errors in your code, you should see a message at the bottom \n\t" +
                        "indicating that all tests passed.\n" +
                        "=======================================================================================\n"
        );

        boolean problems = false;
        int count = 20;

        String[] names = generateNames(count);
        System.out.println("Pseudorandomly generating names of " + count + " hypothetical CS 143 students:\n");
        printNames(names);
        System.out.println();

        System.out.println("Pseudorandomly generating ages for those " + count + " students.");
        System.out.println("Adding some invalid ages to check for exceptions:");
        int[] ages = ages(count, 13, 100);
        System.out.println(Arrays.toString(ages));
        System.out.println();

        System.out.println("Trying to construct Student objects with valid and invalid ages: ");
        for(int i = 0; i < names.length; i++) {

            if (ages[i] < 13) {
                try {
                    Student s = new Student(names[i], ages[i], "Computer Science");
                    problems = true;
                    System.out.println("Student " + names[i] + " was given an age of " + ages[i] + ". This should not be possible, but no exception was thrown!");
                } catch (Exception e) {
                    System.out.println("Student " + names[i] + " was given an age of " + ages[i] + ". An exception was correctly thrown.");
                }
            } else {
                try {
                    Student s = new Student(names[i], ages[i], "Computer Science");
                } catch (Exception e) {
                    System.out.println("Student " + names[i] + " was given an age of " + ages[i] + ". An exception should not have been thrown but was!");
                    problems = true;
                }
            }
        }

        System.out.println();
        System.out.println("Now, trying to create a Student with a null name:");
        try{
            Student s = new Student(null, 18, "Computer Science");
            problems = true;
            System.out.println("Creating a Student with a null name should not be possible, but no exception was thrown!");
        }
        catch(Exception e){
            System.out.println("Creating a Student with a null name correctly caused an exception to be thrown.");
        }

        System.out.println();
        System.out.println("Now, trying to create a Student with a null major:");
        try{
            Student s = new Student("Luke Skywalker", 18, null);
            problems = true;
            System.out.println("Creating a Student with a null major should not be possible, but no exception was thrown!");
        }
        catch (Exception e){
            System.out.println("Creating a Student with a null major correctly caused an exception to be thrown.");
        }

        System.out.println();
        System.out.println("Assigning " + count + " valid majors to the students.");

        String[] majors = Student.MAJORS;
        for(int i = 0; i < count; i++){
            try{
                System.out.println("Assigning " + names[i] + " the major " + majors[i]);
                Student s = new Student(names[i], 18, majors[i]);
                System.out.println("Valid major successfully assigned.");
            }
            catch(Exception e){
                problems = true;
                System.out.println(majors[i] + " was a valid major, but an exception was incorrectly thrown!");
            }
        }

        System.out.println();
        System.out.println("Assigning the invalid major Pseudoscience to student David Anderson.");
        try{
            Student s = new Student("David Anderson", 100, "Pseudoscience");
            problems = true;
            System.out.println("Pseudoscience is not a valid major! An exception should have been thrown.");
        }
        catch (Exception e){
            System.out.println("An exception was correctly thrown for the invalid major Pseudoscience.");
        }

        // TODO: increase age test
        System.out.println();
        System.out.println("Creating student Alan Turing with a valid age of 18.");
        try{
            Student s = new Student("Alan Turing", 18, "Computer Science");
            System.out.println("Student successfully created. Now calling increaseAge(5)");
            try{
                s.increaseAge(5);
                System.out.println("That worked! Alan Turing's age is now " + s.getAge());
                System.out.println("Now calling increaseAge(0) and increaseAge(-5)");
                try{
                    s.increaseAge(0);
                    problems = true;
                    System.out.println("0 is an invalid parameter to the increaseAge method, but no exception was thrown!");
                }
                catch(Exception e){
                    System.out.println("An exception was correctly thrown for invalid increaseAge parameter 0.");
                }
                try{
                    s.increaseAge(-5);
                    problems = true;
                    System.out.println("-5 is an invalid parameter to the increaseAge method, but no exception was thrown!");
                }
                catch(Exception e){
                    System.out.println("An exception was correctly thrown for invalid increaseAge parameter -5.");
                }
            }
            catch(Exception e){
                problems = true;
                System.out.println("5 is a valid parameter to the increaseAge method, but an exception was incorrectly thrown!");
            }
        }
        catch(Exception e){
            problems = true;
            System.out.println("Creating student Alan Turing with age 18 and major Computer Science should not have caused an exception!");
        }

        System.out.println();
        try {
            System.out.println("Re-creating student Alan Turing with age 18 and major Computer Science.");
            Student s = new Student("Alan Turing", 18, "Computer Science");
            System.out.println("Student successfully created. Now calling changeMajor(\"Physics\")");
            try{
                s.changeMajor("Physics");
                System.out.println("Physics is a valid major. Major successfully changed.");
            }
            catch(Exception e){
                problems = true;
                System.out.println("Physics is a valid major, but an exception was incorrectly thrown!");
            }
            System.out.println("Now calling changeMajor(\"Pseudoscience\")");
            try{
                s.changeMajor("Pseudoscience");
                problems = true;
                System.out.println("Pseudoscience is an invalid major, but no exception was thrown!");
            }
            catch (Exception e){
                System.out.println("Pseudoscience is an invalid major. An exception was correctly thrown.");
            }
        }
        catch (Exception e){
            problems = true;
            System.out.println("Creating student Alan Turing with age 18 and major Computer Science should not have caused an exception!");
        }

        System.out.println();
        System.out.println("Creating students A, B, C, D with ages 13, 15, 18, and 30. All students have Major Computer Science.");

        try {
            Student[] ageTest = {
                    new Student("A", 13, "Computer Science"),
                    new Student("B", 15, "Computer Science"),
                    new Student("C", 18, "Computer Science"),
                    new Student("D", 30, "Computer Science")
            };
            System.out.println("Now calling averageAge on this array of students. The average age should be 19.0.");
            try{
                double avg = Student.averageAge(ageTest);
                if(avg == 19.0){
                    System.out.println("The averageAge method correctly returned 19.0.");
                }
                else{
                    problems = true;
                    System.out.println("The averageAge method incorrectly returned " + avg);
                }
            }
            catch (Exception e){
                problems = true;
                System.out.println("The averageAge method threw an unhandled Exception. Use a try/catch to handle this!");
            }
        }
        catch(Exception e){
            problems = true;
            System.out.println("An exception should not have been thrown when creating these students!");
        }

        System.out.println();
        System.out.println("Adding a null student to the array then testing the averageAge method again.");
        Student[] nullAgeTest = {
                new Student("A", 13, "Computer Science"),
                new Student("B", 15, "Computer Science"),
                new Student("C", 18, "Computer Science"),
                new Student("D", 30, "Computer Science"),
                null
        };
        try{
            System.out.println("Now calling averageAge on this array of students. The average age should still be 19.0.");
            try{
                double avg = Student.averageAge(nullAgeTest);
                if(avg == 19.0){
                    System.out.println("The averageAge method correctly returned 19.0.");
                }
                else{
                    problems = true;
                    System.out.println("The averageAge method incorrectly returned " + avg);
                }
            }
            catch (Exception e){
                problems = true;
                System.out.println("The averageAge method threw an unhandled Exception. Use a try/catch to handle this!");
            }
        }
        catch (Exception e){
            problems = true;
            System.out.println("The averageAge method threw an unhandled Exception. Use a try/catch to handle this!");
        }



        if(!problems){
            System.out.println("\n=======================================================================================\n" +
                    "\t\t\t\t\t\t\tAll tests passed. Fantastic!\n" +
                    "=======================================================================================\n"
            );
        }
        else{
            System.out.println("=======================================================================================\n" +
                    "\t\t\t\t\t\t\tProblems were found in your code! See above for details.\n" +
                    "=======================================================================================\n"
            );
        }

        System.out.println(
                "=======================================================================================\n" +
                        "* Please see the rubric on Canvas for a breakdown of how your grade will be calculated.\n" +
                        "* Make sure your code has proper indentation and formatting. Doing CTRL+A and then \n\t " +
                            "CTRL+SHIFT+F in Eclipse will auto indent your code!\n" +
                        "* Be sure each method has a comment above it describing the purpose of that method.\n" +
                        "* Also do not forget to put a block comment at the top with your name and a description \n\t" +
                            "of the Student class.\n"+
                        "======================================================================================="
        );

    }


}
