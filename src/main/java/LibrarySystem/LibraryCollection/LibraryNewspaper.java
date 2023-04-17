package LibrarySystem.LibraryCollection;

import java.util.Date;

public class LibraryNewspaper {
    private int ISSN[];
    private Date Pub_Date;
    private String Publisher;
    private char[] ID_num = new char[6];

    //Get and set for ISSN
    //Set for ISSN references its actual method, so don't worry about the strange calculations.
    public int[] getISSN() {
        return ISSN;
    }
    public void setISSN(int[] ISSN) {
        if(ISSN.length != 8)
        {
            throw new IllegalArgumentException("ISSN must be 8 digits.");
        }
        else
        {
            //This goes through the actual ISSN calculation method to ensure it's an accurate ISSN
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

    //Get and set for the publication date.
    public Date getPub_Date() {
        return Pub_Date;
    }
    public void setPub_Date(Date pub_Date) {
        Pub_Date = pub_Date;
    }

    //Get and set for the publisher.
    public String getPublisher() {
        return Publisher;
    }
    public void setPublisher(String publisher) {
        Publisher = publisher;
    }

    //Get and set for the ID number.
    public char[] getID_num() {
        return ID_num;
    }
    public void setID_num(char[] ID_num){
        this.ID_num = ID_num;
    }

    //Primary constructor for all instance variables.
    public LibraryNewspaper(int[] ISSN, Date Pub_Date, String Publisher, char[] ID_num){
        setISSN(ISSN);
        setPub_Date(Pub_Date);
        setPublisher(Publisher);
        setID_num(ID_num);
    }
}
