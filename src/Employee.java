//employee base class

public class Employee {
    public String firstName;
    public String lastName;
    public float salary;
    public String specialty;
    public String year;
    public int minimumMonthHours;
    public int extraHours;
    public double finalSalary;

    public Employee(String firstName, String lastName, float salary, String specialty, String year, int minimumMonthHours) {
        //initialize employee data
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.finalSalary = salary;
        this.specialty = specialty;
        this.year = year;
        this.minimumMonthHours = minimumMonthHours;
        this.extraHours = 0;
    }

    //Calculate salary based on given form
    public double getSalary() {
        this.finalSalary = this.salary + (this.extraHours / this.minimumMonthHours) * this.salary * 1.5;
        return this.finalSalary;
    }

    //override toString method so that it returns the serialized data we need to save
    @Override
    public String toString() {
        return this.firstName         + "#" +
               this.lastName          + "#" +
               this.salary            + "#" +
               this.specialty         + "#" +
               this.year              + "#" +
               this.minimumMonthHours + "#" +
               this.extraHours        + "#" +
               this.finalSalary       ;
    }
}
