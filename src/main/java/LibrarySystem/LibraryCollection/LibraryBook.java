package LibrarySystem.LibraryCollection;


public class LibraryBook {
    private int ISBN[], Page_Count;
    private String Book_Title, Book_Author, Publisher;
    private char[] ID_num = new char[6];

    //Get and set for ISBN
    //The set method references the ISBN calculation method. It requires 10 digits and must be divisible by 11 after a specific operation.
    public int[] getISBN() {
        return ISBN;
    }
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

    //Get and set for the title
    public String getBook_Title() {
        return Book_Title;
    }
    public void setBook_Title(String book_Title) {
        this.Book_Title = book_Title;
    }

    //Get and set for the page count
    public int getPage_Count() {
        return Page_Count;
    }
    public void setPage_Count(int Page_Count) {
        if(Page_Count < 1)
        {
            throw new IllegalArgumentException("This book is not a valid length");
        }
        this.Page_Count = Page_Count;
    }

    //Get and set for the author.
    public String getBook_Author() {
        return Book_Author;
    }
    public void setBook_Author(String book_Author) {
        this.Book_Author = book_Author;
    }


    //Get and set for the publisher.
    public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String Publisher) {
        this.Publisher = Publisher;
    }


    //Get and set for the ID number.
    public char[] getID_num() {
        return ID_num;
    }
    public void setID_num(char[] ID_num) {
        this.ID_num = ID_num;
    }

    //Primary constructor for all instance variables.
    public LibraryBook(int[] ISBN, int Page_count, String Book_Title, String Book_Author, String Publisher, char[] ID_num ){
        setISBN(ISBN);
        setPage_Count(Page_count);
        setBook_Title(Book_Title);
        setBook_Author(Book_Author);
        setPublisher(Publisher);
        setID_num(ID_num);
    }
}
