/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telikh;

/**
 *
 * @author sun
 */
public class Employee {
    public String fName;
    public String lName;
    public double salary;
    public String specialty;
    public String year;
    public int minMonthH;
    public int exHours;
    public double finalSalary;
    
    public Employee(String fName, String lName, double salary, String specialty, String year, int minMonthH) {
        
        this.fName = fName;
        this.lName = lName;
        this.salary = salary;
        this.specialty = specialty;
        this.year = year;
        this.minMonthH = minMonthH;
        this.exHours = 0;
        this.finalSalary = this.salary;
    }
    
    public double getSalary() {
        double multipl = 1.6;
        if (
                this.specialty.equals("Αναπληρωτής") ||
                this.specialty.equals("Επίκουρος") ||
                this.specialty.equals("Λέκτορας") ||
                this.specialty.equals("ΕΔΙΠ")
                )
            multipl = 1.5;
        this.finalSalary = this.salary + (1.0*this.exHours/this.minMonthH) * this.salary * multipl;
        return this.finalSalary;
        
    }
    
    @Override
    public String toString() {
        return this.fName + "#" + this.lName + "#" + this.salary + "#" + this.specialty + "#" + this.year + "#" + this.minMonthH
                + "#" + this.exHours + "#" + this.finalSalary;
    }
    
}
