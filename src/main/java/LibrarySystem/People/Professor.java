package LibrarySystem.People;

import LibrarySystem.util.SSN;

import java.util.ArrayList;
import java.util.Date;

public class Professor extends Member {

    //PDF states that a professor can supervise multiple students
    private ArrayList<Student> students;

    public Professor(String name, String address, Date date_of_birth, String email_address, SSN ssn, int MemberID) {
        super(name, address, date_of_birth, email_address, ssn, MemberID);
    }
}
