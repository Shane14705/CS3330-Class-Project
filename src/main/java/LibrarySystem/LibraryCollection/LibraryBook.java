package LibrarySystem.LibraryCollection;


public class LibraryBook extends LibraryItem {
    private int ISBN[], Page_Count;
    private String Book_Title, Book_Author, Publisher;


    /**
     * Gets the 10 digit ISBN number for this Book
     * @return Int array of 10 digits representing the valid ISBN of this Book
     */
    public int[] getISBN() {
        return ISBN;
    }

    /**
     * Function to validate and update the ISBN number for this Book.
     * @param ISBN Int array of 10 digits representing the valid ISBN of this Book
     */
    public void setISBN(int[] ISBN) {
        if(ISBN.length != 10)
        {
            throw new IllegalArgumentException("ISBN must be 10 digits.");
        }
        else
        {
            //This goes through the actual ISBN calculation method to ensure it's an accurate ISBN
            int total=0;
            for(int i=0; i<10; i++)
            {
                total+=(ISBN[i]*(10-i));
            }
            if(total%11 != 0)
            {
                throw new IllegalArgumentException("This ISBN is not legal.");
            }
        }
        this.ISBN = ISBN;
    }

    /**
     * Gets the title of this Book.
     * @return String representing the title of this Book
     */
    public String getBook_Title() {
        return Book_Title;
    }

    /**
     * Updates the title of this Book.
     * @param book_Title String representing the updated title of this Book
     */
    public void setBook_Title(String book_Title) {
        this.Book_Title = book_Title;
    }

    /**
     * Get the page count of this book.
     * @return Int representing the page count of this book
     */
    public int getPage_Count() {
        return Page_Count;
    }

    /**
     * Updates the page count of this book.
     * @param Page_Count Int representing the updated page count of this book
     */
    public void setPage_Count(int Page_Count) {
        if(Page_Count < 1)
        {
            throw new IllegalArgumentException("This book is not a valid length");
        }
        this.Page_Count = Page_Count;
    }

    /**
     * Get the author of this book.
     * @return String representing the name of this book's author
     */
    public String getBook_Author() {
        return Book_Author;
    }

    /**
     * Update the author of this book.
     * @param book_Author String representing the updated name of this book's author
     */
    public void setBook_Author(String book_Author) {
        this.Book_Author = book_Author;
    }


    /**
     * Gets the publisher of this book.
     * @return String representing the name of the publisher of this book
     */
    public String getPublisher() {
        return Publisher;
    }

    /**
     * Updates the publisher of this book.
     * @param Publisher String representing the updated name of this book's publisher
     */
    public void setPublisher(String Publisher) {
        this.Publisher = Publisher;
    }


    //TODO: Finish filling out the documentation for the parameters here
    /**
     * Constructs a Book item for the collection. Each Book title in the library should be represented by one instance of this object
     * @param ISBN
     * @param section LibrarySection enum representing the section of the library in which this Book can be found
     * @param Page_count
     * @param Book_Title
     * @param Book_Author
     * @param Publisher
     * @param ID_num Character array containing 6 chars to represent the 6-digit alphanumeric unique ID for this Book in the library collection
     * @param price Float representing the price of one copy of this Book (in case it needs to be replaced or new copies need to be bought)
     * @param numberAvailable Int representing the number of copies of this Book that will currently be available to borrow
     */
    public LibraryBook(int[] ISBN, LibrarySection section, int Page_count, String Book_Title, String Book_Author, String Publisher, char[] ID_num, float price, int numberAvailable){

        super(ID_num, section, price, numberAvailable);
        setISBN(ISBN);
        setPage_Count(Page_count);
        setBook_Title(Book_Title);
        setBook_Author(Book_Author);
        setPublisher(Publisher);
    }
}
