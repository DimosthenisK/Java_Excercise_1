import java.util.ArrayList; //employee list
import java.io.BufferedReader; //open file
import java.io.InputStreamReader; //open file
import java.io.FileInputStream; //open file
import java.nio.charset.StandardCharsets; //encoding

public class Main {
    private ArrayList<Employee> employees;

    private static ArrayList<Employee> readEmployees(String fileName) {
        ArrayList<Employee> employees = new ArrayList<Employee>(); //enpty Employee list
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8))) { //open file with UTF8 encoding
            String line;
            while ((line = br.readLine()) != null) { //while we have lines
                System.out.println(line); //show line in console for debugging
                String[] tokens = line.split("#"); //split file to tokens
                employees.add( //add new employee to employee list
                        new Employee(
                                tokens[0],
                                tokens[1],
                                Float.parseFloat(tokens[2]),
                                tokens[3],
                                tokens[4],
                                Integer.parseInt(tokens[5])
                        )
                );
            }
        }
        catch (java.io.FileNotFoundException exc) {
            System.out.println("Δεν βρέθηκε το αρχείο που ζητήθηκε");
        }
        catch (java.io.IOException exc) {
            System.out.println("Υπήρξε κάποιο πρόβλημα στο διάβασμα του αρχείου");
        }
        return employees;
    }

    public static void main(String[] args) {
        //initialize GUI with employees list
        String fileName = "C:/Users/demos/Desktop/java.txt";
        GUI gui = new GUI(readEmployees(fileName), fileName);
    }
}
