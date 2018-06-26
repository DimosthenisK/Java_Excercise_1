import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;

public class Main {
    private ArrayList<Employee> employees;

    private static ArrayList<Employee> readEmployees(String fileName) {
        ArrayList<Employee> employees = new ArrayList<Employee>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                String[] tokens = line.split("#");
                employees.add(
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

        }
        catch (java.io.IOException exc) {

        }
        return employees;
    }

    public static void main(String[] args) {

        GUI gui = new GUI(readEmployees("C:/Users/demos/Desktop/java.txt"));


    }
}
