package LibrarySystem.People;

import LibrarySystem.util.SSN;

import java.util.Date;

//This class should be able to add/remove Members and search through the collection for different kinds of items for members to checkout
public class Librarian extends Employee {
    public Librarian(String name, String address, Date date_of_birth, String email_address, SSN ssn, int EmployeeID) {
        super(name, address, date_of_birth, email_address, ssn, EmployeeID);
    }
}
