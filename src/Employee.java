public class Employee {
    public String firstName;
    public String lastName;
    public float salary;
    public String specialty;
    public String year;
    public int minimumMonthHours;
    public int extraHours;

    public Employee(String firstName, String lastName, float salary, String specialty, String year, int minimumMonthHours) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.specialty = specialty;
        this.year = year;
        this.minimumMonthHours = minimumMonthHours;
        this.extraHours = 0;
    }

    public double getSalary() {
        return this.salary + (this.extraHours / this.minimumMonthHours) * this.salary * 1.5;
    }
}
