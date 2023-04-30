package LibrarySystem.People;

import LibrarySystem.util.SSN;

import java.util.Date;

public class External extends Member {
    public External(String name, String address, Date date_of_birth, String email_address, SSN ssn, int MemberID) {
        super(name, address, date_of_birth, email_address, ssn, MemberID);
    }
}
