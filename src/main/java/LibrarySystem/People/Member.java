package LibrarySystem.People;

import jdk.jshell.spi.ExecutionControl;

public class Member extends  Person {
    private int id_num;

    private float amountOwed = 0.0f;

    //TODO: Add List of LibraryCollection Objects representing everything the member currently has checked out


    //This function will be used to send the return/overdue reminders, returns boolean saying whether notification went through or not
    public boolean NotifyMember(String message) {
        return false;
    }
}
