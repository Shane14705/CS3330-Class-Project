package LibrarySystem.util;

import LibrarySystem.LibraryCollection.LibraryItem;
import LibrarySystem.People.Member;

import java.util.Calendar;
import java.time.*;

public class ItemLoan {

    private Member borrower;

    private LocalDate dueDate;

    private LibraryItem borrowedItem;

    //create a loan
    public ItemLoan(Member borrower, LibraryItem item) {
        this.borrower = borrower;


        //Check if member has already hit the 5 item-at-a-time limit, throw an error if so:
        if (borrower.getNumItemsOnLoan() >= 5) {
            System.out.println("We are sorry, but you can only have up to 5 items on loan at a time. Please try again once you have returned some items.");
            //TODO: throw exception here
        }

        //Check if we have enough of the requested item to loan:
        if (item.getNumberAvailable() < 1) {
            System.out.println("We are sorry, but there are currently no available copies of this item to loan out. Please try again later.");
            //TODO: throw exception here
        }



        //Calculate due date (two weeks from now)
        dueDate = LocalDate.now().plus(Period.ofWeeks(2));

        //If we pass both checks, add this new ItemLoan to the item's list of borrowers and record it on the member's account
        this.borrowedItem = item;
        borrowedItem.registerLoan(this);
        borrower.registerLoan(this);
    }

    /**
     * Function to get the number of days left before the given itemLoan is due to be returned.
     * @return Number of days left before due date
     */
    public int getDaysLeft() {
        return Period.between(LocalDate.now(), dueDate).getDays();
    }

    public void returnLoan() {
        borrowedItem.endLoan(this);
        borrower.endLoan(this);
    }

}