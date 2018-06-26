import java.awt.*; //form controls
import java.awt.event.*; //button events
import java.util.ArrayList; // for employee list
import javax.swing.JOptionPane; // for alert

public class GUI extends Frame implements ActionListener { //Classic user inteface, extends Frame for window and ActionListener for button events
    //Initializing form controls
    private Label firstNameLabel;
    private Label lastNameLabel;
    private Label salaryLabel;
    private Label specialtyLabel;
    private Label yearLabel;
    private Label minimumHoursLabel;
    private Button getSalaryBtn;
    private Button prevBtn;
    private Button nextBtn;
    private TextField extraHoursTF;
    private ArrayList<Employee> employees;
    private int empIndex = 0;

    //Show first employee and add controls to form
    public void firstEmployee() {
        Employee employee = employees.get(empIndex);
        firstNameLabel = new Label("Όνομα: " + employee.firstName);
        lastNameLabel = new Label("Επίθετο: " + employee.lastName);
        salaryLabel = new Label("Βασικός μισθός: " + employee.salary);
        specialtyLabel = new Label("Ειδικότητα: " + employee.specialty);
        yearLabel = new Label("Έτος πρόσληψης: " + employee.year);
        minimumHoursLabel = new Label("ΥΜΩ: " + employee.minimumMonthHours);

        //add all controls to form
        add(firstNameLabel);
        add(lastNameLabel);
        add(salaryLabel);
        add(specialtyLabel);
        add(yearLabel);
        add(minimumHoursLabel);

        getSalaryBtn = new Button("Υπολογισμός Μισθού");
        nextBtn = new Button("Επόμενο");
        prevBtn = new Button("Προηγούμενο");
        extraHoursTF = new TextField("Υπερωρίες");

        add(extraHoursTF);
        add(getSalaryBtn);
        add(prevBtn);
        add(nextBtn);
    }

    //show next-previous employee
    public void outputEmployee() {
        Employee employee = employees.get(empIndex);
        this.firstNameLabel.setText("Όνομα: " + employee.firstName);
        this.lastNameLabel.setText("Επίθετο: " + employee.lastName);
        this.salaryLabel.setText("Βασικός μισθός: " + employee.salary);
        this.specialtyLabel.setText("Ειδικότητα: " + employee.specialty);
        this.yearLabel.setText("Έτος πρόσληψης: " + employee.year);
        this.minimumHoursLabel.setText("ΥΜΩ: " + employee.minimumMonthHours);

        extraHoursTF.setText("Υπερωρίες");
    }

    //constructor with window parameters
    public GUI(ArrayList<Employee> employees) {
        this.employees = employees;
        setLayout(new FlowLayout());
        setTitle("Εξέταση Java");
        setSize(400,200);

        //show first employee
        firstEmployee();

        //add button click actions
        getSalaryBtn.addActionListener(this);
        nextBtn.addActionListener(this);
        prevBtn.addActionListener(this);

        setVisible(true);
    }

    //handle button clicks based on button text
    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getActionCommand().equals("Υπολογισμός Μισθού")) {
            Employee employee = employees.get(empIndex);
            employee.extraHours = Integer.parseInt(extraHoursTF.getText());
            JOptionPane.showMessageDialog(null, "Τελικός μισθός: " + employee.getSalary(), "Τελικός μισθός", JOptionPane.PLAIN_MESSAGE); //show alert
        }
        else if (evt.getActionCommand().equals("Επόμενο")) {
            this.empIndex++;
            if (this.empIndex == employees.size()) this.empIndex = 0; //avoid index error
            outputEmployee();
        }
        else if (evt.getActionCommand().equals("Προηγούμενο")) {
            this.empIndex--;
            if (this.empIndex == -1) this.empIndex = employees.size() -1; //avoid index error
            outputEmployee();
        }
        System.out.println(evt.toString());
    }
}
