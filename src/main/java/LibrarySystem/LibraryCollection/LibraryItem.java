package LibrarySystem.LibraryCollection;

import LibrarySystem.People.Member;
import LibrarySystem.util.ItemLoan;

import java.util.ArrayList;

//The idea is every item in the library will have ONE instance of its respective class for it. ie: book A will have one Book instance regardless of how many copies of BookA are going around
public class LibraryItem {

    //Only LibraryItem is able to update number available, meaning it can only be interacted with through loans which are well defined.
    //Eventually we may need a way for technicians to update this amount (ie: if they buy an extra copy of a book) but dont worry about that for now since it is not in the PDF anywhere
    private int numberAvailable;

    private float price;

    //TODO: Create a "BorrowInstance" utility class/record that is just a combination of a Member and information about a specific instance of borrowing an object (ie when they checked it out, etc). Then the below array will hold those borrow records instead.
    private ArrayList<ItemLoan> currentLoans;

    private LibrarySection section;

    //Library ID, NOT the same as the ISBN/ISSN. PDF specifies its alphanumeric with 6 characters
    private char[] item_num = new char[6];

    public int getNumberAvailable() {
        return numberAvailable;
    }

    public void registerLoan(ItemLoan loanInstance) {
        currentLoans.add(loanInstance);
        numberAvailable--;
    }

    public void endLoan(ItemLoan loanInstance) {
        currentLoans.remove(loanInstance);
        numberAvailable++;
    }
}
