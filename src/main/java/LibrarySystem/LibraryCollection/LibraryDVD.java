package LibrarySystem.LibraryCollection;

public class LibraryDVD{

    private int ISBN[], runTime; //Run time is in minutes.
    private String DVD_Title, Cast_List[], Director;
    private char[] ID_num = new char[6];

    //Get and set for the ISBN
    //The set method references the actual ISBN method.
    public int[] getISBN(){
        return ISBN;
    }
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

    //Get and set for the title.
    public String getDVD_Title() {
        return DVD_Title;
    }
    public void setDVD_Title(String DVD_Title) {
        this.DVD_Title = DVD_Title;
    }

    //Get and set for the run time of the DVD.
    public int getRunTime() {
        return runTime;
    }
    public void setRunTime(int runTime) {
        if(runTime<0)
        {
            throw new IllegalArgumentException("This is not a valid run time.");
        }
        this.runTime = runTime;
    }

    //Get and set for the cast list.
    public String[] getCast_List(){
        return Cast_List;
    }
    public void setCast_List(String[] Cast_List) {
        this.Cast_List = Cast_List;
    }

    //Get and set for the director.
    public String getDirector(){
        return Director;
    }
    public void setDirector(String Director){
        this.Director = Director;
    }

    //Get and set for the ID number.
    public char[] getID_num() {
        return ID_num;
    }
    public void setID_num(char[] ID_num) {
        this.ID_num = ID_num;
    }

    //Primary constructor including all instance variables
    public LibraryDVD(int[] ISBN, int runTime, String DVD_Title, String[] Cast_List, String Director, char[] ID_num){
        setISBN(ISBN);
        setRunTime(runTime);
        setDVD_Title(DVD_Title);
        setCast_List(Cast_List);
        setDirector(Director);
        setID_num(ID_num);
    }
}

