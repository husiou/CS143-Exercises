import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CheckedExceptions {
    public static void main(String[] args) {
        try {
            Scanner s = new Scanner(new File("a.txt"));
            while(s.hasNextLine()) {
                System.out.println(s.nextLine());
            }
        } catch(FileNotFoundException e) {
            System.out.println(" file does not exist");
        }

    }
}