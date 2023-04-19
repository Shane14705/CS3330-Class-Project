package LibrarySystem.LibraryCollection;

public class LibraryDVD extends LibraryItem {

    private int ISBN[], runTime; //Run time is in minutes.
    private String DVD_Title, Cast_List[], Director;

    /**
     * Gets the 10 digit ISBN number for this DVD
     * @return Int array of 10 digits representing the valid ISBN of this DVD
     */
    public int[] getISBN(){
        return ISBN;
    }

    /**
     * Function to validate and update the ISBN number for this DVD.
     * @param ISBN Int array of 10 digits representing the valid ISBN of this DVD
     */
    public void setISBN(int[] ISBN){
        if(ISBN.length != 10)
        {
            throw new IllegalArgumentException("ISBN must be 10 digits.");
        }
        else
        {
            //This goes through the actual ISBN calculation method to ensure it's an accurate ISBN.
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
     * Gets the title of this DVD.
     * @return String representing the title of this DVD
     */
    public String getDVD_Title() {
        return DVD_Title;
    }

    /**
     * Updates the title of this DVD.
     * @param DVD_Title String representing the updated title of this DVD
     */
    public void setDVD_Title(String DVD_Title) {
        this.DVD_Title = DVD_Title;
    }

    /**
     * Get the runtime (in minutes) of this DVD.
     * @return Int representing the runtime of this DVD in minutes
     */
    public int getRunTime() {
        return runTime;
    }

    /**
     * Updates the runtime (in minutes) of this DVD.
     * @param runTime Positive int representing the updated runtime (in minutes) of this DVD
     */
    public void setRunTime(int runTime) {
        if(runTime<0)
        {
            throw new IllegalArgumentException("This is not a valid run time.");
        }
        this.runTime = runTime;
    }

    /**
     * Gets the cast list of this DVD.
     * @return Array of Strings representing the list of cast members
     */
    public String[] getCast_List(){
        return Cast_List;
    }

    /**
     * Updates the cast list of this DVD.
     * @param Cast_List Array of strings representing the updated list of cast members
     */
    public void setCast_List(String[] Cast_List) {
        this.Cast_List = Cast_List;
    }

    /**
     * Gets the name of the Director of this DVD.
     * @return String representing the name of the Director
     */
    public String getDirector(){
        return Director;
    }

    /**
     * Update the Director of this DVD.
     * @param Director String representing the updated Director's name
     */
    public void setDirector(String Director){
        this.Director = Director;
    }


    //TODO: Finish filling out the documentation for the parameters here
    /**
     * Constructs a DVD item for the collection. Each DVD title in the library should be represented by one instance of this object
     * @param ISBN Integer array containing 10 digits that ensures a uniqueness identifier for this DVD title
     * @param section LibrarySection enum representing the section of the library in which this DVD can be found
     * @param runTime Integer representing the total run time for this DVD (in minutes)
     * @param DVD_Title String representing the title of this DVD
     * @param Cast_List String array holding the cast of this DVD
     * @param Director String representing the director of this DVD
     * @param ID_num Character array containing 6 chars to represent the 6-digit alphanumeric unique ID for this DVD in the library collection
     * @param price Float representing the price of one copy of this DVD (in case it needs to be replaced or new copies need to be bought)
     * @param numberAvailable Int representing the number of copies of this DVD that will currently be available to borrow
     */
    public LibraryDVD(int[] ISBN, LibrarySection section, int runTime, String DVD_Title, String[] Cast_List, String Director, char[] ID_num, float price, int numberAvailable){
        super(ID_num, section, price, numberAvailable);
        setISBN(ISBN);
        setRunTime(runTime);
        setDVD_Title(DVD_Title);
        setCast_List(Cast_List);
        setDirector(Director);
    }
}

