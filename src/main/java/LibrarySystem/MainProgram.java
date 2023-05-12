package LibrarySystem;

import LibrarySystem.LibraryCollection.*;
import LibrarySystem.People.*;
import LibrarySystem.util.*;
import jdk.jshell.spi.ExecutionControl;

import javax.naming.NoPermissionException;
import javax.xml.transform.Result;
import java.nio.file.AccessDeniedException;
import java.util.*;
import java.sql.*;

import java.io.*;
import java.util.Date;

public class MainProgram {
    static Person currentUser;
    static PersonType userType;

//    public static void mainMenu() {
//
//        System.out.println("University of Java Library System");
//        System.out.println("Menu Options");
//        System.out.println("1. New Membership");
//        System.out.println("2. Add item to Library");
//        System.out.println("5. New Employee");
//        System.out.println("6. Borrow Item");
//        System.out.println("7. Return Item");
//        System.out.println("8. Check overdues");
//        System.out.println("9. Quit");
//        System.out.println("");
//    }

    /**
     * Takes an object representing a member already in the database that has been modified by the program, and updates its database counterpart to match its updated version in the program. Must be used anytime you manually edit the fields/properties of the object.
     * @param member The member to be updated.
     */
    private static void UpdateMember(Member member) {
        //Connecting to database
        try {
            Connection db = DriverManager.getConnection("jdbc:sqlite:library.db");
            String updateString = "UPDATE MEMBERS SET Name = ? , MemberData = ? WHERE MemberID = ? ;";
            PreparedStatement updateStatement = db.prepareStatement(updateString);
            updateStatement.setString(1, member.getName());
            updateStatement.setInt(3, member.getId_num());

            ByteArrayOutputStream output = new ByteArrayOutputStream();
            ObjectOutputStream outStream = new ObjectOutputStream(output);
            outStream.writeObject(member);
            ByteArrayInputStream input = new ByteArrayInputStream(output.toByteArray());
            updateStatement.setBytes(2, input.readAllBytes());
            updateStatement.execute();
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Takes an object representing an employee already in the database that has been modified by the program, and updates its database counterpart to match its updated version in the program. Must be used anytime you manually edit the fields/properties of the object.
     * @param employee The employee to be updated.
     */
    private static void UpdateEmployee(Employee employee) {
        //Connecting to database
        try {
            Connection db = DriverManager.getConnection("jdbc:sqlite:library.db");
            String updateString = "UPDATE EMPLOYEES SET Name = ? , EmployeeData = ? WHERE EmployeeID = ? ;";
            PreparedStatement updateStatement = db.prepareStatement(updateString);
            updateStatement.setString(1, employee.getName());
            updateStatement.setInt(3, employee.getEmp_id());

            ByteArrayOutputStream output = new ByteArrayOutputStream();
            ObjectOutputStream outStream = new ObjectOutputStream(output);
            outStream.writeObject(employee);
            ByteArrayInputStream input = new ByteArrayInputStream(output.toByteArray());
            updateStatement.setBytes(2, input.readAllBytes());
            updateStatement.execute();
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void UpdateItem(LibraryItem item) {
        //Connecting to database
        try {
            Connection db = DriverManager.getConnection("jdbc:sqlite:library.db");
            String updateString = "UPDATE ITEMS SET ItemData = ? WHERE ItemID = ? ;";
            PreparedStatement updateStatement = db.prepareStatement(updateString);
            updateStatement.setString(2, String.valueOf(item.getItem_num()));

            ByteArrayOutputStream output = new ByteArrayOutputStream();
            ObjectOutputStream outStream = new ObjectOutputStream(output);
            outStream.writeObject(item);
            ByteArrayInputStream input = new ByteArrayInputStream(output.toByteArray());
            updateStatement.setBytes(1, input.readAllBytes());
            updateStatement.execute();
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Creates a new member and adds them to the database.
     * @param name The name of the new member.
     * @param address The address of the new member.
     * @param date_of_birth The date of birth of the new member.
     * @param email_address The email address of the new member.
     * @param ssn The SSN of the new member.
     * @param MemberID The numeric id to be given to the new member (they will use this to log in!).
     * @param memberType The type of the new member (Student, Professor, or External)
     */
    public static void CreateMember(String name, String address, Date date_of_birth, String email_address, SSN ssn, int MemberID, MemberType memberType) {
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
            insertStatement.setBytes(4, input.readAllBytes());
            insertStatement.execute();
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
//            System.out.println("Unable to connect to database! Closing program...");
//            System.exit(-1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    };

    /**
     * Creates a new employee and adds them to the database.
     * @param name The name of the new employee.
     * @param address The address of the new employee.
     * @param date_of_birth The date of birth of the new employee.
     * @param email_address The email address of the new employee.
     * @param ssn The SSN of the new employee.
     * @param EmployeeID The numeric id to be given to the employee (they will use this to log in!).
     * @param empType The type of the new employee (Technician or Librarian)
     */
    public static void CreateEmployee(String name, String address, Date date_of_birth, String email_address, SSN ssn, int EmployeeID, EmployeeType empType){
        Employee emp;
        switch (empType) {
            case Librarian -> emp = new Librarian(name, address, date_of_birth, email_address, ssn, EmployeeID);
            case Technician -> emp = new Technician(name, address, date_of_birth, email_address, ssn, EmployeeID);
            default -> throw new IllegalArgumentException("Member type not specified!");
        }
        //Connecting to database
        try {
            Random rand = new Random();
            Connection db = DriverManager.getConnection("jdbc:sqlite:library.db");
            String insertString = "INSERT INTO EMPLOYEES VALUES( ? , ? , ? , ? );";
            PreparedStatement insertStatement = db.prepareStatement(insertString);
            insertStatement.setInt(1, rand.nextInt());
            insertStatement.setString(2, name);
            insertStatement.setString(3, empType.toString());

            ByteArrayOutputStream output = new ByteArrayOutputStream();
            ObjectOutputStream outStream = new ObjectOutputStream(output);
            outStream.writeObject(emp);
            ByteArrayInputStream input = new ByteArrayInputStream(output.toByteArray());
            insertStatement.setBytes(4, input.readAllBytes());
            insertStatement.execute();
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
//            System.out.println("Unable to connect to database! Closing program...");
//            System.exit(-1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    };


    /**
     * Constructs a Book item and adds it to the database. Each Book title in the library should be represented by one instance of this object
     * @param ISBN Integer array containing 10 digits to ensure a unique identifier for this Book title
     * @param section LibrarySection enum representing the section of the library in which this Book can be found
     * @param Page_count Integer representing the total number of pages in this Book
     * @param Book_Title String representing the title of this Book
     * @param Book_Author String representing the author of this Book
     * @param Publisher String representing the publisher of this Book
     * @param ID_num Character array containing 6 chars to represent the 6-digit alphanumeric unique ID for this Book in the library collection
     * @param price Float representing the price of one copy of this Book (in case it needs to be replaced or new copies need to be bought)
     * @param numberAvailable Int representing the number of copies of this Book that will currently be available to borrow
     */
    public static void AddBook(int[] ISBN, LibrarySection section, int Page_count, String Book_Title, String Book_Author, String Publisher, char[] ID_num, float price, int numberAvailable){
        if (userType != PersonType.Employee) {
            throw new RuntimeException("Members cannot add items.");
        }

        LibraryBook book = new LibraryBook(ISBN, section, Page_count, Book_Title, Book_Author, Publisher, ID_num, price, numberAvailable);
        try {
            Connection db = DriverManager.getConnection("jdbc:sqlite:library.db");
            String insertString = "INSERT INTO ITEMS VALUES( ? , ? , ? , ? , ? );";
            PreparedStatement insertStatement = db.prepareStatement(insertString);
            insertStatement.setString(1, String.valueOf(ID_num));
            insertStatement.setString(2, Book_Title);
            insertStatement.setString(3, section.toString());
            insertStatement.setString(4, ItemType.Book.toString());

            ByteArrayOutputStream output = new ByteArrayOutputStream();
            ObjectOutputStream outStream = new ObjectOutputStream(output);
            outStream.writeObject(book);
            ByteArrayInputStream input = new ByteArrayInputStream(output.toByteArray());
            insertStatement.setBytes(5, input.readAllBytes());
            insertStatement.execute();
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
//            System.out.println("Unable to connect to database! Closing program...");
//            System.exit(-1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    };

    /**
     * Constructs a DVD item and adds it to the database. Each DVD title in the library should be represented by one instance of this object
     * @param ISBN Integer array containing 10 digits that ensures a uniqueness identifier for this DVD title
     * @param section LibrarySection enum representing the section of the library in which this DVD can be found
     * @param runTime Integer representing the total run time for this DVD (in minutes)
     * @param DVD_Title String representing the title of this DVD
     * @param Cast_List String array holding the cast of this DVD
     * @param Director String representing the director of this DVD
     * @param ID_num Character array containing 6 chars to represent the 6-digit alphanumeric unique ID for this DVD in the library collection
     * @param price Float representing the price of one copy of this DVD (in case it needs to be replaced or new copies need to be bought)
     * @param numberAvailable Int representing the number of copies of this DVD that will be available to borrow
     */
    public static void AddDVD(int[] ISBN, LibrarySection section, int runTime, String DVD_Title, String[] Cast_List, String Director, char[] ID_num, float price, int numberAvailable){
        if (userType != PersonType.Employee) {
            throw new RuntimeException("Members cannot add items.");
        }
        LibraryDVD dvd = new LibraryDVD(ISBN, section, runTime, DVD_Title, Cast_List, Director, ID_num, price, numberAvailable);
        try {
            Connection db = DriverManager.getConnection("jdbc:sqlite:library.db");
            String insertString = "INSERT INTO ITEMS VALUES( ? , ? , ? , ? , ? );";
            PreparedStatement insertStatement = db.prepareStatement(insertString);
            insertStatement.setString(1, String.valueOf(ID_num));
            insertStatement.setString(2, DVD_Title);
            insertStatement.setString(3, section.toString());
            insertStatement.setString(4, ItemType.DVD.toString());

            ByteArrayOutputStream output = new ByteArrayOutputStream();
            ObjectOutputStream outStream = new ObjectOutputStream(output);
            outStream.writeObject(dvd);
            ByteArrayInputStream input = new ByteArrayInputStream(output.toByteArray());
            insertStatement.setBytes(5, input.readAllBytes());
            insertStatement.execute();
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
//            System.out.println("Unable to connect to database! Closing program...");
//            System.exit(-1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    };


    /**
     * Constructs a Journal item and adds it to the database. Each edition of a journal in the library should be represented by one instance of this object
     * @param ISSN Integer array containing 8 digits that ensures a unique identifier for this journal publication.
     * @param section LibrarySection enum representing the section of the library in which this journal can be found
     * @param volume Integer containing the volume of this journal publication
     * @param issue Integer containing the issue of this journal publication
     * @param Publisher String containing the name of the publisher of this journal
     * @param Title String containing the title of this journal
     * @param ID_num Character array containing 6 chars to represent the 6-digit alphanumeric unique ID for this journal in the library collection
     * @param price Float representing the price of one copy of this journal (in case it needs to be replaced or new copies need to be bought)
     * @param numberAvailable Int representing the number of copies of this journal that will be available to borrow
     */
    public static void AddJournal(int[] ISSN, LibrarySection section, int volume, int issue, String Publisher, String Title, char[] ID_num, float price, int numberAvailable){
        if (userType != PersonType.Employee) {
            throw new RuntimeException("Members cannot add items.");
        }
        LibraryJournal journal = new LibraryJournal(ISSN, section, volume, issue, Publisher, Title, ID_num, price, numberAvailable);
        try {
            Connection db = DriverManager.getConnection("jdbc:sqlite:library.db");
            String insertString = "INSERT INTO ITEMS VALUES( ? , ? , ? , ? , ? );";
            PreparedStatement insertStatement = db.prepareStatement(insertString);
            insertStatement.setString(1, String.valueOf(ID_num));
            insertStatement.setString(2, Title);
            insertStatement.setString(3, section.toString());
            insertStatement.setString(4, ItemType.Journal.toString());

            ByteArrayOutputStream output = new ByteArrayOutputStream();
            ObjectOutputStream outStream = new ObjectOutputStream(output);
            outStream.writeObject(journal);
            ByteArrayInputStream input = new ByteArrayInputStream(output.toByteArray());
            insertStatement.setBytes(5, input.readAllBytes());
            insertStatement.execute();
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
//            System.out.println("Unable to connect to database! Closing program...");
//            System.exit(-1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    };


    /**
     * Constructs a Newspaper item and adds it to the database. Each edition of a Newspaper in the library should be represented by one instance of this object
     * @param ISSN Integer array containing 8 digits that ensures uniqueness of this Newspaper publication
     * @param Pub_Date Date variable containing the date in which this newspaper was published
     * @param Publisher String containing the name of the publisher of this newspaper
     * @param ID_num Character array containing 6 chars to represent the 6-digit alphanumeric unique ID for this newspaper edition in the collection
     * @param price Float representing the price of one copy of this newspaper edition (in case it needs to be replaced or new copies need to be bought)
     * @param numberAvailable Int representing the number of copies of this newspaper edition that will be available to borrow
     */
    public static void AddNewspaper(int[] ISSN, Date Pub_Date, String Publisher, char[] ID_num, float price, int numberAvailable){
        if (userType != PersonType.Employee) {
            throw new RuntimeException("Members cannot add items.");
        }
        LibraryNewspaper newspaper = new LibraryNewspaper(ISSN, Pub_Date, Publisher, ID_num, price, numberAvailable);
        try {
            Connection db = DriverManager.getConnection("jdbc:sqlite:library.db");
            String insertString = "INSERT INTO ITEMS VALUES( ? , ? , ? , ? , ? );";
            PreparedStatement insertStatement = db.prepareStatement(insertString);
            insertStatement.setString(1, String.valueOf(ID_num));
            //Publisher is title for newspapers, ie: "New York Times"
            insertStatement.setString(2, Publisher);
            insertStatement.setString(3, LibrarySection.NEWSPAPERS.toString());
            insertStatement.setString(4, ItemType.Newspaper.toString());

            ByteArrayOutputStream output = new ByteArrayOutputStream();
            ObjectOutputStream outStream = new ObjectOutputStream(output);
            outStream.writeObject(newspaper);
            ByteArrayInputStream input = new ByteArrayInputStream(output.toByteArray());
            insertStatement.setBytes(5, input.readAllBytes());
            insertStatement.execute();
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
//            System.out.println("Unable to connect to database! Closing program...");
//            System.exit(-1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    };


    /**
     * Completes the loan that is passed in. This function will remove the loan from both the member and the item, and then update both in the database.
     * @param loan The loan to be returned
     */
    public static void ReturnItem(ItemLoan loan){
        //Don't forget to remove the loan from both the USER in the database and the ITEM in the database
        loan.returnLoan();
        UpdateMember(loan.getBorrower());
        UpdateItem(loan.getBorrowedItem());
    };

    /**
     * Attempts to check out the given item for the current user. If successful, it will update the item and member in the database accordingly. Throws an error if the user is unable to borrow the item.
     * @param item The item to attempt to borrow
     */
    public static void CheckoutItem(LibraryItem item) {
        if (userType != PersonType.Member) {
            throw new RuntimeException("Employees cannot checkout items!");
        }
        try {
            ItemLoan newLoan = new ItemLoan(((Member) currentUser), item);
            UpdateItem(newLoan.getBorrowedItem());
            UpdateMember(newLoan.getBorrower());
        } catch (AccessDeniedException e) {
            System.out.println("There are no copies available to borrow right now.");
            throw new RuntimeException(e);
        } catch (NoPermissionException e) {
            System.out.println("You have already reached your 5 concurrent item limit.");
            throw new RuntimeException(e);
        }
    }

    /**
     * takes a search query and returns a list of items from the collection. The Item objects returned can then be passed to the CheckoutItem function to borrow them.
     * @param title The keyword you want to search for.
     * @return A list of LibraryItems representing the search results
     */
    public static ArrayList<LibraryItem> SearchCollections(String title){
        try {
            ArrayList<LibraryItem> results = new ArrayList<LibraryItem>();
            Connection db = DriverManager.getConnection("jdbc:sqlite:library.db");
            String searchString = "SELECT * FROM ITEMS WHERE TITLE LIKE '%?%';";
            PreparedStatement searchStatement = db.prepareStatement(searchString);
            searchStatement.setString(1, title);

            //execution returns true if theres at least one row returned.
            if (searchStatement.execute()) {
                ResultSet set = searchStatement.getResultSet();

                do {
                    ItemType itemType = ItemType.valueOf(set.getString(4));
                    ObjectInputStream inputStream = new ObjectInputStream(new ByteArrayInputStream(set.getBytes(5)));
                    switch(itemType) {
                        case DVD -> results.add((LibraryDVD) inputStream.readObject());
                        case Book -> results.add((LibraryBook) inputStream.readObject());
                        case Journal -> results.add((LibraryJournal) inputStream.readObject());
                        case Newspaper -> results.add((LibraryNewspaper) inputStream.readObject());
                    };
                } while (set.next());
            }

            return results;

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }

    };


    //Call this function with onlyOverdue=true to filter the list so that only overdue loans are shown (you could always call the original function and filter them yourself as well if you want
    //ItemLoan gives you access to things like due date as well as the item itself

    /**
     * Returns a list of loans that the currently logged in user has outstanding. These ItemLoan objects contain info about the LibraryItems being loaned as well as the current user who has loaned them and their due dates. These loans can be returned by passing the loan to the ReturnLoan function.
     * @param onlyOverdue If true, this function will only return loans which are currently overdue.
     * @return List of ItemLoan objects representing the currently logged in user's outstanding loans
     */
    public static ArrayList<ItemLoan> GetBorrowedItems(boolean onlyOverdue) {
        //Note: The references from this function will not be updated in the database, so DO NOT try to directly modify them (your changes wont be saved). Instead use a function like ReturnItem

        if (userType != PersonType.Member) {
            throw new RuntimeException("Employees do not have borrowed items!");
        }
        ArrayList<ItemLoan> loans = new ArrayList<ItemLoan>();
        for (ItemLoan loan: ((Member) currentUser).getCurrentLoans()) {
            if (onlyOverdue && (loan.getDaysLeft() >= 0)) continue;
            loans.add(loan);
        }

        return loans;
    };

    //TODO: Get the list of borrowed items of the currently logged in user. The ID's of these items can then be used in a function like "ReturnItem" by passing the ID of the item

    /**
     * Returns a list of loans that the currently logged in user has outstanding. These ItemLoan objects contain info about the LibraryItems being loaned as well as the current user who has loaned them and their due dates. These loans can be returned by passing the loan to the ReturnLoan function.
     * @return List of ItemLoan objects representing the currently logged in user's outstanding loans
     */
    public static ArrayList<ItemLoan> GetBorrowedItems() {
        return GetBorrowedItems(false);
    };


    public static void main(String [] args) {
        MainMenu menu = new MainMenu();
        SSN ssn = new SSN("123456785");

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
            if (userType == PersonType.Employee) {
                System.out.print("Enter your option number: ");
                option = scanner.nextInt();
                switch(option) {
                    case 1:
                        System.out.println("Show GUI for adding new item info to collection");

                }

            }
//            MainProgram.mainMenu();
//
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
//        }

//    }
    }
    /**
     * Attempts to login as a member using the given ID number. Must be performed before any other function in main program.
     * @param idNum The ID to attempt to login as.
     */
    protected static void loginMemberEvent(int idNum) {
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
                ObjectInputStream inputStream = new ObjectInputStream(new ByteArrayInputStream(set.getBytes(4)));
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

    /**
     * Attempts to login as a employee using the given ID number. Must be performed before any other function in main program.
     * @param idNum The ID to attempt to login as.
     */
    protected static void loginEmployeeEvent(int idNum) {
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
                ObjectInputStream inputStream = new ObjectInputStream(new ByteArrayInputStream(set.getBytes(4)));
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
