
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telikh;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author sun
 */
public class Main {
    private ArrayList<Employee> employees;
    
    private static ArrayList<Employee> getEmployees(String fileName) {
        
        ArrayList<Employee> employees = new ArrayList<Employee>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8))) {
            String lines;
            while ((lines = br.readLine()) != null) {
                String[] eData = lines.split("#");
                employees.add(new Employee(eData[0], eData[1], Double.parseDouble(eData[2]), eData[3], eData[4],Integer.parseInt(eData[5])));
            }
        }
        catch (java.io.FileNotFoundException exc) {
            System.out.println("Δεν βρέθηκε το αρχείο που ζητήθηκε.");
        }
        catch (java.io.IOException exc) {
            System.out.println("Δεν μπόρεσε να διαβαστεί το αρχείο.");
        }
        return employees;
    }
    
    public static void main(String[] args) {
        String fileName = "C:/Users/sun/Desktop/exetashJava.txt";
        GUI gui = new GUI(getEmployees(fileName), fileName);
    }
    
}
