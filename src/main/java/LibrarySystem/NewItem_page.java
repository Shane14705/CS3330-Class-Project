package LibrarySystem;



import LibrarySystem.LibraryCollection.LibrarySection;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NewItem_page extends JFrame{


    public JPanel panel1;
    private JTextArea BookFieldTitle;
    private JTextArea DVDfieldLabel;
    private JTextArea NewsPaperFieldLabel;
    private JTextField BookTitleText;
    private JTextField BookAuthorText;
    private JTextField BookPublisherText;
    private JTextField BookISBNText;
    private JTextField BookPageCount;
    private JTextField BookPrice;
    private JTextField BookNumAvailableTextField;
    private JButton EnterBookButton;
    private JComboBox BookSectionDrop;
    private JTextField BookID;
    private JTextField JournalTitle;
    private JTextField JournalVolume;
    private JTextField JournalIssueTextField;
    private JTextField JournalPublisherTextField;
    private JComboBox JournalSection;
    private JTextField JournalISSNTextField;
    private JTextField JournalIDTextField;
    private JTextField JournalPriceTextField;
    private JTextField JournalNumAvailableTextField;
    private JButton EnterJournal;
    private JTextField NewsPublisher;
    private JTextField NewsPubDateTextField;
    private JTextField NewsISSNTextField;
    private JTextField NewsIDTextField;
    private JTextField NewsPriceTextField;
    private JTextField NewsNumAvailableTextField;
    private JButton EnterNewsEntriesButton;
    private JTextField DVDdirectorTextField;
    private JTextField DVDcastTextField;
    private JTextField DVDruntimeTextField;
    private JTextField DVDisbnTextField;
    private JTextField DVDidTextField;
    private JTextField DVDpriceTextField;
    private JTextField DVDnumAvailableTextField;
    private JTextField DVDtitle;
    private JComboBox DVDsection;
    private JButton EnterDVD;
    private JTextArea JournalField;
    private JTextArea BookInfoOrder;
    private JTextArea JournalInfoOrder;
    private JTextArea NewsInfoOrder;
    private JTextArea DVDinfoOrder;


    public NewItem_page(){
        this.setContentPane(panel1);
        this.setTitle("Enter new items into the Library Database");
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //Controls all book entries
        EnterBookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            /*The following code is simply taking all the inputted values and converting them into
             the proper form for the ADD function. All the four actions will be like this*/
            String Title = BookTitleText.getText();
            String Author = BookAuthorText.getText();
            String Publisher = BookPublisherText.getText();
            int PageCount = Integer.parseInt(BookPageCount.getText());
            int [] ISBN = new int[BookISBNText.getText().length()];
            for(int i=0; i<BookISBNText.getText().length(); i++){
                ISBN[i] = BookISBNText.getText().charAt(i) - '0';
            }
            char[] ID = new char[BookID.getText().length()];
            for(int i=0; i<BookID.getText().length(); i++){
                ID[i] = BookID.getText().charAt(i);
            }
            float Price = Float.parseFloat(BookPrice.getText());
            int NumAvial = Integer.parseInt(BookNumAvailableTextField.getText());


            //The following uses the Section input to complete the entry.
            String temp = BookSectionDrop.getSelectedItem().toString();
            if(temp.equals("ARTS")) {
                LibrarySection Section = LibrarySection.ARTS;
                MainProgram.AddBook(ISBN, Section, PageCount, Title, Author, Publisher, ID, Price, NumAvial);
            };
            if(temp.equals("SCIENCES")){
                LibrarySection Section=LibrarySection.SCIENCES;
                MainProgram.AddBook(ISBN, Section, PageCount, Title, Author, Publisher, ID, Price, NumAvial);
            };
            if(temp.equals("LAW")){
                LibrarySection Section=LibrarySection.LAW;
                MainProgram.AddBook(ISBN, Section, PageCount, Title, Author, Publisher, ID, Price, NumAvial);
            };


            }
        });

        //This will control the journal entries.
        EnterJournal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String Title = JournalTitle.getText();
                String Publisher = JournalPublisherTextField.getText();
                int Volume = Integer.parseInt(JournalVolume.getText());
                int Issue = Integer.parseInt(JournalIssueTextField.getText());
                int NumAvail = Integer.parseInt(JournalNumAvailableTextField.getText());
                float Price = Float.parseFloat(JournalPriceTextField.getText());
                char[] ID = new char[JournalIDTextField.getText().length()];
                for(int i=0; i<JournalIDTextField.getText().length(); i++){ID[i] = JournalIDTextField.getText().charAt(i);};
                int[] ISSN = new int[JournalISSNTextField.getText().length()];
                for(int i=0; i<JournalISSNTextField.getText().length(); i++){
                    ISSN[i] = JournalISSNTextField.getText().charAt(i) - '0';
                }


                String temp = JournalSection.getSelectedItem().toString();
                if(temp.equals("ARTS")) {
                    LibrarySection Section = LibrarySection.ARTS;
                    MainProgram.AddJournal(ISSN, Section, Volume, Issue, Publisher, Title, ID, Price, NumAvail);
                };
                if(temp.equals("SCIENCES")){
                    LibrarySection Section=LibrarySection.SCIENCES;
                    MainProgram.AddJournal(ISSN, Section, Volume, Issue, Publisher, Title, ID, Price, NumAvail);
                };
                if(temp.equals("LAW")){
                    LibrarySection Section=LibrarySection.LAW;
                    MainProgram.AddJournal(ISSN, Section, Volume, Issue, Publisher, Title, ID, Price, NumAvail);
                };
            }
        });

        //This will control the newspaper entry.
        EnterNewsEntriesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Publisher = NewsPublisher.getText();
                Date PubDate = null;
                try {
                    PubDate = new SimpleDateFormat("dd/MM/yyyy").parse(NewsPubDateTextField.getText());
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }
                float Price = Float.parseFloat(NewsPriceTextField.getText());
                int NumAvail = Integer.parseInt(NewsNumAvailableTextField.getText());
                char []ID = new char[NewsIDTextField.getText().length()];
                for(int i=0; i<NewsIDTextField.getText().length(); i++){ID[i] = NewsIDTextField.getText().charAt(i);};
                int[] ISSN = new int[NewsISSNTextField.getText().length()];
                for(int i=0; i<NewsISSNTextField.getText().length(); i++){
                    ISSN[i] = NewsISSNTextField.getText().charAt(i) - '0';
                }

                MainProgram.AddNewspaper(ISSN, PubDate, Publisher, ID, Price, NumAvail);
            }
        });

        //Controls DVD entries.
        EnterDVD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Title = DVDtitle.getText();
                String Director = DVDdirectorTextField.getText();
                String[] Cast = DVDcastTextField.getText().split(",");
                int runtime = Integer.parseInt(DVDruntimeTextField.getText());
                float Price = Float.parseFloat(DVDpriceTextField.getText());
                int NumAvail = Integer.parseInt(DVDnumAvailableTextField.getText());
                int [] ISBN = new int[DVDisbnTextField.getText().length()];
                for(int i=0; i<DVDisbnTextField.getText().length(); i++){
                    ISBN[i] = DVDisbnTextField.getText().charAt(i) - '0';
                }
                char []ID = new char[DVDidTextField.getText().length()];
                for(int i=0; i<DVDidTextField.getText().length(); i++){ID[i] = DVDidTextField.getText().charAt(i);};


                String temp = BookSectionDrop.getSelectedItem().toString();
                if(temp.equals("ARTS")) {
                    LibrarySection Section = LibrarySection.ARTS;
                    MainProgram.AddDVD(ISBN, Section, runtime, Title, Cast, Director, ID, Price, NumAvail);
                };
                if(temp.equals("SCIENCES")){
                    LibrarySection Section=LibrarySection.SCIENCES;
                    MainProgram.AddDVD(ISBN, Section, runtime, Title, Cast, Director, ID, Price, NumAvail);
                };
                if(temp.equals("LAW")){
                    LibrarySection Section=LibrarySection.LAW;
                    MainProgram.AddDVD(ISBN, Section, runtime, Title, Cast, Director, ID, Price, NumAvail);
                };
            }
        });
    }
}
