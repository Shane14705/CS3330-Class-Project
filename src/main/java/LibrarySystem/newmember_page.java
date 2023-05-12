package LibrarySystem;

import LibrarySystem.util.MemberType;
import LibrarySystem.util.SSN;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class newmember_page extends JFrame {
    private JPanel mainPanel;
    private JTextField nameTextField;
    private JTextField IDTextField;
    private JTextField physicalAddressTextField;
    private JTextField emailTextField;
    private JComboBox monthBox;
    private JComboBox dayBox;
    private JComboBox yearBox;
    private JRadioButton professorRadioButton;
    private JRadioButton studentRadioButton;
    private JRadioButton externalRadioButton;
    private JTextField SSNTextField;
    private JButton saveButton;
    private JButton clearButton;
    private JButton exitButton;
    public newmember_page() {
        this.setContentPane(mainPanel);
        this.setTitle("New Member");
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        for(int i=1950;i<=2023;i++){
            yearBox.addItem(i);
        }

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(nameTextField.getText().isEmpty() || IDTextField.getText().isEmpty() || physicalAddressTextField.getText().isEmpty() || emailTextField.getText().isEmpty() || SSNTextField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Fill out all categories", "Error", JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    String name = nameTextField.getText();
                    String email = emailTextField.getText();
                    String adr = physicalAddressTextField.getText();
                    Integer memID = Integer.valueOf(IDTextField.getText());
                    SSN ssn = new SSN(SSNTextField.getText());
                    MemberType member;
                    if (professorRadioButton.isSelected()) {
                        member = MemberType.Professor;
                    }
                    else if (studentRadioButton.isSelected()) {
                        member = MemberType.Student;
                    }
                    else {
                        member = MemberType.External;
                    }
                    //String datestr = monthBox.toString() + "/" + dayBox.toString() + "/" + yearBox.toString();
                    String datestr = "05/25/2005";
                    SimpleDateFormat DateFor = new SimpleDateFormat("MM/dd/yyyy");
                    try {
                        Date date = DateFor.parse(datestr);
                        MainProgram.CreateMember(name,adr,date,email,ssn,memID,member);
                    } catch (ParseException ex) {
                        throw new RuntimeException(ex);
                    }
                    close();
                }
            }
        });
    }

    public void close() {
        this.dispose();
    }
}
