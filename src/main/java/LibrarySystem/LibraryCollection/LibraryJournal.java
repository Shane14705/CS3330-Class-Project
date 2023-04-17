package LibrarySystem.LibraryCollection;

public class LibraryJournal{
    private int ISSN[], Volume, Issue;
    private String Title, Publisher;
    private char[] ID_num = new char[6];

    //Get and set for ISSN.
    //ISSN references the actual method of calculation to ensure its accuracy.
    public int[] getISSN(){
        return ISSN;
    }
    public void setISSN(int[] ISSN){
        if(ISSN.length != 8)
        {
            throw new IllegalArgumentException("ISSN must be 8 digits.");
        }
        else
        {
            //This goes through the actual ISSN calculation method to ensure it's an accurate ISSN.
            int total=0;
            for(int i=0; i<8; i++)
            {
                total+=(ISSN[i]*(8-i));
            }
            if(total%11 != 0)
            {
                throw new IllegalArgumentException("This ISSN is not legal.");
            }
        }
        this.ISSN = ISSN;
    }

    //Get and Set for the title.
    public String getTitle() {
        return Title;
    }
    public void setTitle(String Title) {
        this.Title = Title;
    }

    //Get and set for the volume number.
    public int getVolume() {
        return Volume;
    }
    public void setVolume(int Volume) {
        if(Volume<0)
        {
            throw new IllegalArgumentException("This is not a valid volume.");
        }
        this.Volume = Volume;
    }

    //Get and set for the issue number.
    public int getIssue() {
        return Issue;
    }
    public void setIssue(int Issue) {
        if(Issue<0)
        {
            throw new IllegalArgumentException("This is not a valid issue.");
        }
        this.Issue = Issue;
    }

    //Get and set for the publisher.
    public String getPublisher(){
        return Publisher;
    }
    public void setPublisher(String Publisher){
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
    public LibraryJournal(int[] ISSN, int volume, int issue, String Publisher, String Title, char[] ID_num){
        setISSN(ISSN);
        setVolume(volume);
        setIssue(issue);
        setPublisher(Publisher);
        setTitle(Title);
        setID_num(ID_num);
    }
}
