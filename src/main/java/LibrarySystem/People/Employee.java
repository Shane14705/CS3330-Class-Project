package LibrarySystem.People;

import LibrarySystem.util.SSN;

import java.util.Date;

public class Employee extends Person {

    private int emp_id;


    public Employee(String name, String address, Date date_of_birth, String email_address, SSN ssn, int EmployeeID) {
        super(name, address, date_of_birth, email_address, ssn);
        this.emp_id = EmployeeID;
    }

    public int getEmp_id() {
        return emp_id;
    }
}
