package LibrarySystem.People;

import LibrarySystem.util.SSN;

import java.util.Date;

public class Student extends Member {

    //PDF states student can have one professor as advisor
    private Professor advisor;

    public Student(String name, String address, Date date_of_birth, String email_address, SSN ssn, int MemberID) {
        super(name, address, date_of_birth, email_address, ssn, MemberID);
    }
}
