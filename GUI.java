/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telikh;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;

/**
 *
 * @author sun
 */
public class GUI extends Frame implements ActionListener, WindowListener{
    private Label fNameLb;
    private Label lNameLb;
    private Label salaryLb;
    private Label spLb;
    private Label yrLb;
    private Label minHLb;
    private Button pBtn;
    private Button nBtn;
    private TextField overtimeTF;
    private ArrayList<Employee> employees;
    private String fileName;
    private int empIndex;
    
    public void firstEmployee () {
        Employee employee = employees.get(empIndex);
        fNameLb = new Label("Όνομα: " + employee.fName);
        lNameLb = new Label("Επίθετο: " + employee.lName);
        salaryLb = new Label("Βασικός μισθός: " + employee.salary);
        spLb = new Label("Ειδικότητα: " + employee.specialty);
        yrLb = new Label("Χρόνος πρόσληψης: " + employee.year);
        minHLb = new Label("Μηνιαίο ωράριο: " + employee.minMonthH);
        
        nBtn = new Button("Επόμενος");
        pBtn = new Button("Προηγούμενος");
        overtimeTF = new TextField("Υπερωρίες");
        
        add(fNameLb);
        add(lNameLb);
        add(salaryLb);
        add(spLb);
        add(yrLb);
        add(minHLb);
        add(nBtn);
        add(pBtn);
        add(overtimeTF);
    }
    
    public void showEmployee(){
        Employee employee = employees.get(empIndex);
        this.fNameLb.setText("Όνομα: " + employee.fName);
        this.lNameLb.setText("Επίθετο: " + employee.lName);
        this.salaryLb.setText("Βασικός μισθός: " + employee.salary);
        this.spLb.setText("Ειδικότητα: " + employee.specialty);
        this.yrLb.setText("Έτος πρόσληψης: " + employee.year);
        this.minHLb.setText("Μηνιαίο ωράριο: " + employee.minMonthH);
        if (employee.exHours == 0)
            this.overtimeTF.setText("Υπερωρίες");
        else 
            this.overtimeTF.setText("" + employee.exHours);
    }
    
    public GUI(ArrayList<Employee> employees, String fileName) {
        this.fileName = fileName;
        this.employees = employees;
        setLayout(new FlowLayout());
        setTitle("Εξέταση Java");
        setSize(350,160);
        addWindowListener(this);
        
        firstEmployee();
        
        nBtn.addActionListener(this);
        pBtn.addActionListener(this);
        
        setVisible(true);
    }
    
    public void windowClosing(WindowEvent e) {
        try {
            FileOutputStream fos = new FileOutputStream("C:\\Users\\sun\\Desktop\\exetashJavaOut.txt");
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos, StandardCharsets.UTF_8));
            
            for (int i = 0; i < employees.size(); i++) {
                bw.write(employees.get(i).toString());
                bw.newLine();
            }
            
            bw.close();
        }
        catch (java.io.FileNotFoundException exc) {
            System.out.println("Δεν βρέθηκε το αρχείο που ζητήθηκε.");
        }
        catch (java.io.IOException exc) {
            System.out.println("Δεν μπόρεσε να διαβαστεί το αρχείο.");
        }
        
        System.exit(0);
    }
    
    public void windowOpened(WindowEvent e){}
    public void windowClosed(WindowEvent e){}
    public void windowDeactivated(WindowEvent e){}
    public void windowActivated(WindowEvent e){}
    public void windowIconified(WindowEvent e){}
    public void windowDeiconified(WindowEvent e){}
    
    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getActionCommand().equals("Επόμενος")) {
            Employee employee = employees.get(empIndex);
            try {
                employee.exHours = Integer.parseInt(overtimeTF.getText());
                employee.getSalary();
            }
            catch (Exception ex) {
                System.out.println("Λάθος!");
            }
            this.empIndex++;
            if (this.empIndex == employees.size()) this.empIndex = 0;
            showEmployee();
        }
        else {
            Employee employee = employees.get(empIndex);
            try {
                employee.getSalary();
                employee.exHours = Integer.parseInt(overtimeTF.getText());
            }
            catch (Exception ex) {
                System.out.println("Λάθος!");
            }
            this.empIndex--;
            if (this.empIndex == -1) this.empIndex = this.employees.size() -1;
            showEmployee();
        }
    }
}
