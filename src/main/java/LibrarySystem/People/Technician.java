package LibrarySystem.People;

import LibrarySystem.util.SSN;

import java.util.Date;

//This class should have access to the collection to assign/create new items in the collection and check what is and isnt available
public class Technician extends Employee {
    public Technician(String name, String address, Date date_of_birth, String email_address, SSN ssn, int EmployeeID) {
        super(name, address, date_of_birth, email_address, ssn, EmployeeID);
    }
}
