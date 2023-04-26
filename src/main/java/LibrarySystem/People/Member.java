package LibrarySystem.People;

import LibrarySystem.util.SSN;
import jdk.jshell.spi.ExecutionControl;

import java.util.ArrayList;
import java.util.Date;

import LibrarySystem.util.ItemLoan;

public class Member extends Person implements java.io.Serializable {
    private int id_num;

    private float amountOwed = 0.0f;

    private ArrayList<ItemLoan> currentLoans;

    public Member(String name, String address, Date date_of_birth, String email_address, SSN ssn, int MemberID) {
        super(name, address, date_of_birth, email_address, ssn);
        this.id_num = MemberID;
    }

    //TODO: Add List of LibraryCollection Objects representing everything the member currently has checked out


    //This function will be used to send the return/overdue reminders, returns boolean saying whether notification went through or not
    public boolean NotifyMember(String message) {
        return false;
    }

    public int getNumItemsOnLoan() {
        return currentLoans.size();
    }

    public void registerLoan(ItemLoan loanInstance) {
        currentLoans.add(loanInstance);
    }

    public void endLoan(ItemLoan loanInstance) {
        currentLoans.remove(loanInstance);
    }
}
