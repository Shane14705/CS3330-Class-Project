package LibrarySystem;

import LibrarySystem.People.*;
import LibrarySystem.util.EmployeeType;
import LibrarySystem.util.MemberType;
import LibrarySystem.util.PersonType;
import LibrarySystem.util.SSN;
import jdk.jshell.spi.ExecutionControl;

import javax.xml.transform.Result;
import java.util.Date;
import java.util.Scanner;
import java.util.Random;
import java.sql.*;

import java.io.*;

public class MainProgram {
    static Person currentUser;
    static PersonType userType;
    public static void mainMenu(){
        
        System.out.println("University of Java Library System");
        System.out.println("Menu Options");
        System.out.println("1. New Membership");
        System.out.println("2. Add item to Library");
        System.out.println("5. New Employee");
        System.out.println("6. Borrow Item");
        System.out.println("7. Return Item");
        System.out.println("8. Check overdues");
        System.out.println("9. Quit");
        System.out.println("");
    }

    public static void newMemberEvent(String name, String address, Date date_of_birth, String email_address, SSN ssn, int MemberID, MemberType memberType) {
        Member member;
        switch (memberType) {
            case Student -> member = new Student(name, address, date_of_birth, email_address, ssn, MemberID);
            case External -> member = new External(name, address, date_of_birth, email_address, ssn, MemberID);
            case Professor -> member = new Professor(name, address, date_of_birth, email_address, ssn, MemberID);
            default -> throw new IllegalArgumentException("Member type not specified!");
        }
        //Connecting to database
        try {
            Random rand = new Random();
            Connection db = DriverManager.getConnection("jdbc:sqlite:library.db");
            String insertString = "INSERT INTO MEMBERS VALUES( ? , ? , ? , ? );";
            PreparedStatement insertStatement = db.prepareStatement(insertString);
            insertStatement.setInt(1, rand.nextInt());
            insertStatement.setString(2, name);
            insertStatement.setString(3, memberType.toString());

            ByteArrayOutputStream output = new ByteArrayOutputStream();
            ObjectOutputStream outStream = new ObjectOutputStream(output);
            outStream.writeObject(member);
            ByteArrayInputStream input = new ByteArrayInputStream(output.toByteArray());
            insertStatement.setBlob(4, input);
            insertStatement.execute();
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
//            System.out.println("Unable to connect to database! Closing program...");
//            System.exit(-1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    };
    public static void newCollectionEvent(){};
    public static void newRemoveMemberEvent(){};
    public static void newRemoveCollectionEvent(){};
    public static void newEmployeeEvent(){};
    public static void newBorrowsEvent(){};
    public static void newReturnEvent(){};
    public static void newCheckOverdues(){};
    public static void main(String [] args) {


        while(true) {
            System.out.println("Please login first:\n");
            System.out.println("What type of login do you have? (1 for Member, 2 for Employee: \n");
            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();
            System.out.println("Please enter your ID: \n");
            int ID_num = scanner.nextInt();
            try {
                switch (option) {
                    case 1:
                        loginMemberEvent(ID_num);
                        userType = PersonType.Member;
                        break;
                        
                    case 2:
                        loginEmployeeEvent(ID_num);
                        userType = PersonType.Employee;
                        break;
                }
            }
            catch (IllegalArgumentException e) {
                System.out.println("Unable to find account with that ID. Exiting...");
                System.exit(-1);
            }

            //If we made it here, we are successfully logged in.
            switch (userType) {
                case Member -> System.out.println("TODO: Show GUI for members...\n");
                case Employee -> System.out.println("TODO: Show GUI for employees...\n");
            }
            
            
            //TODO: Only certain options should appear based on the type of user logged in, which can be gotten from variable userType
            MainProgram.mainMenu();
//            System.out.print("Enter your option number: ");
//            option = scanner.nextInt();
//            switch (option) {
//                case 1:
//                    MainProgram.newMemberEvent();
//                    break;
//                case 2:
//                    MainProgram.newCollectionEvent();
//                    break;
//                case 3:
//                    MainProgram.newRemoveMemberEvent();
//                    break;
//                case 4:
//                    MainProgram.newRemoveCollectionEvent();
//                    break;
//                case 5:
//                    MainProgram.newEmployeeEvent();
//                    break;
//                case 6:
//                    MainProgram.newBorrowsEvent();
//                    break;
//                case 7:
//                    MainProgram.newReturnEvent();
//                    break;
//                case 8:
//                    MainProgram.newCheckOverdues();
//                    break;
//                case 9:
//                    System.exit(0);
//                    break;
//                default:
//                    System.out.println("Invalid input");
//            }
        }

    }

    private static void loginMemberEvent(int idNum) {
        //Connecting to database
        try {
            Connection db = DriverManager.getConnection("jdbc:sqlite:library.db");
            String loginString = "SELECT * FROM MEMBERS WHERE MemberID = ? ;";
            PreparedStatement loginStatement = db.prepareStatement(loginString);
            loginStatement.setInt(1, idNum);

            //execution returns true if theres at least one row returned.
            if (loginStatement.execute()) {
                ResultSet set = loginStatement.getResultSet();

                MemberType memberType = MemberType.valueOf(set.getString(3));
                ObjectInputStream inputStream = new ObjectInputStream(set.getBlob(4).getBinaryStream());
                switch (memberType) {
                    case Professor -> currentUser = (Professor) inputStream.readObject();
                    case External -> currentUser = (External) inputStream.readObject();
                    case Student -> currentUser = (Student) inputStream.readObject();
                }
            }
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
//            System.out.println("Unable to connect to database! Closing program...");
//            System.exit(-1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    private static void loginEmployeeEvent(int idNum) {
        //Connecting to database
        try {
            Connection db = DriverManager.getConnection("jdbc:sqlite:library.db");
            String loginString = "SELECT * FROM EMPLOYEES WHERE EmployeeID = ? ;";
            PreparedStatement loginStatement = db.prepareStatement(loginString);
            loginStatement.setInt(1, idNum);

            //execution returns true if theres at least one row returned.
            if (loginStatement.execute()) {
                ResultSet set = loginStatement.getResultSet();

                EmployeeType empType = EmployeeType.valueOf(set.getString(3));
                ObjectInputStream inputStream = new ObjectInputStream(set.getBlob(4).getBinaryStream());
                switch (empType) {
                    case Librarian -> currentUser = (Librarian) inputStream.readObject();
                    case Technician -> currentUser = (Technician) inputStream.readObject();
                }

            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }


}
