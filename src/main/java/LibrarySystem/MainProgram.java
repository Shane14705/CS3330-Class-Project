package LibrarySystem;

import java.util.Scanner;
import java.sql.*;

public class MainProgram {
    public static void mainMenu(){
        System.out.println("University of Java Library System");
        System.out.println("Menu Options");
        System.out.println("1. New Membership");
        System.out.println("2. New Collection");
        System.out.println("3. Remove Membership");
        System.out.println("4. Remove Item from Collection");
        System.out.println("5. New Employee");
        System.out.println("6. Borrow Item");
        System.out.println("7. Return Item");
        System.out.println("8. Check overdues");
        System.out.println("9. Quit");
        System.out.println("");
    }

    public static void newMemberEvent() {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter Membership info: \n");
        System.out.println("Enter Member Name: ");
    };
    public static void newCollectionEvent(){};
    public static void newRemoveMemberEvent(){};
    public static void newRemoveCollectionEvent(){};
    public static void newEmployeeEvent(){};
    public static void newBorrowsEvent(){};
    public static void newReturnEvent(){};
    public static void newCheckOverdues(){};
    public static void main(String [] args) {
        //Connecting to database
        try {
            Connection db = DriverManager.getConnection("jdbc:sqlite:library.db");
        } catch (SQLException exception) {
            System.out.println("Unable to connect to database! Closing program...");
            System.exit(-1);
        }

        while(true) {
            MainProgram.mainMenu();
            System.out.print("Enter your option number: ");
            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    MainProgram.newMemberEvent();
                    break;
                case 2:
                    MainProgram.newCollectionEvent();
                    break;
                case 3:
                    MainProgram.newRemoveMemberEvent();
                    break;
                case 4:
                    MainProgram.newRemoveCollectionEvent();
                    break;
                case 5:
                    MainProgram.newEmployeeEvent();
                    break;
                case 6:
                    MainProgram.newBorrowsEvent();
                    break;
                case 7:
                    MainProgram.newReturnEvent();
                    break;
                case 8:
                    MainProgram.newCheckOverdues();
                    break;
                case 9:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }

    }


}
