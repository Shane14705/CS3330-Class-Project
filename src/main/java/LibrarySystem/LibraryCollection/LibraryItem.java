package LibrarySystem.LibraryCollection;

import LibrarySystem.People.Member;
import LibrarySystem.util.ItemLoan;

import java.util.ArrayList;
import java.util.Arrays;

//The idea is every item in the library will have ONE instance of its respective class for it. ie: book A will have one Book instance regardless of how many copies of BookA are going around
public class LibraryItem {



    //Only LibraryItem is able to update number available, meaning it can only be interacted with through loans which are well defined.
    //Eventually we may need a way for technicians to update this amount (ie: if they buy an extra copy of a book) but dont worry about that for now since it is not in the PDF anywhere
    private int numberAvailable;

    private float price;

    //TODO: Create a "BorrowInstance" utility class/record that is just a combination of a Member and information about a specific instance of borrowing an object (ie when they checked it out, etc). Then the below array will hold those borrow records instead.
    private ArrayList<ItemLoan> currentLoans;

    private LibrarySection section;

    //Library ID, NOT the same as the ISBN/ISSN. PDF specifies its alphanumeric with 6 characters. No setter either as this id should not change after creation
    private char[] item_num = new char[6];

    /**
     * Returns the price of this item (in case it is needing to be replaced/purchased again).
     * @return Float representing the price of one copy of this item
     */
    public float getPrice() {
        return price;
    }

    /**
     * Updates the price of this item (in case it has changed since the item was originally added to the collection).
     * @param price Float representing the updated price of one copy of this item
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * Returns the section of the library in which this item resides.
     * @return LibrarySection enum representing the section of the library in which this item can be found
     */
    public LibrarySection getSection() {
        return section;
    }

    /**
     * Updates the section in which this item can be found in.
     * @param section A LibrarySection enum representing the section in which this item will now be located
     */
    public void setSection(LibrarySection section) {
        this.section = section;
    }

    /**
     * Returns a copy of the ArrayList representing all of the currently outstanding loans on this item.
     * @return ArrayList of ItemLoan objects, each of which represents an outstanding loan on this item
     */
    public ArrayList<ItemLoan> getCurrentLoans() {
        return (ArrayList<ItemLoan>) currentLoans.clone();
    }

    /**
     * Gets the array containing the 6 character alphanumeric ID of this item.
     * @return 6 Character array of alpha-numeric characters representing the alphanumeric ID of this item
     */
    public char[] getItem_num() {
        return item_num;
    }

    /**
     * Allows employees to account for new copies of an item being added to the collection. There is no ability to remove items as items are permanently added to the collection (unless they are borrowed and not returned).
     * @param numAdded Positive integer representing the number of copies to be added
     */
    public void AddNumberAvailable(int numAdded) {
        if (numAdded < 0) {
            throw new IllegalArgumentException("Unable to manually remove items from the collection after they are added.");
        }
        else {
            numberAvailable += numAdded;
        }
    }

    /**
     * Gets the number of copies of this item that are currently available to be borrowed.
     * @return Int representing the number of copies of this item that are currently available to borrow
     */
    public int getNumberAvailable() {
        return numberAvailable;
    }


    /**
     * Constructs a generic LibraryItem for the collection. Each title in the library should be represented by one instance of this object
     * @param item_num Character array containing 6 chars to represent the 6-digit alphanumeric unique ID for this item in the collection
     * @param section LibrarySection enum representing the section of the library in which this item can be found.
     * @param price Float representing the price of one copy of this title (in case it needs to be replaced or new copies need to be bought)
     * @param numberAvailable Int representing the number of copies of this item that will currently be available to borrow
     */
    public LibraryItem(char[] item_num, LibrarySection section, float price, int numberAvailable) {
        if (item_num.length != 6) {
            throw new IllegalArgumentException("Item_ID is not the correct length of 6.");
        }

        this.item_num = Arrays.copyOf(item_num, 6);
        setSection(section);
        setPrice(price);
        this.numberAvailable = numberAvailable;
        this.currentLoans = new ArrayList<ItemLoan>();

    }


    //TODO: Clean up these register/end loan routines and make sure they catch errors correctly

    /**
     * Registers one of a user's "loan instances" with this collection item and updates the available number of items to match this.
     * @param loanInstance ItemLoan object representing the loan to be registered with this item.
     */
    public void registerLoan(ItemLoan loanInstance) {
        currentLoans.add(loanInstance);
        numberAvailable--;
    }

    /**
     * Completes and removes one of a user's "loan instances" that is currently outstanding on this collection item and updates the available number of items to match this.
     * @param loanInstance ItemLoan object representing the outstanding loan to be closed
     */
    public void endLoan(ItemLoan loanInstance) {
        currentLoans.remove(loanInstance);
        numberAvailable++;
    }
}
