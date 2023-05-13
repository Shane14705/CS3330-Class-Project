package LibrarySystem.Gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class newemployee_page extends JFrame {
    private JPanel window;
    private JTextField NameInput;
    private JTextField IDinput;
    private JTextField AddressInput;
    private JTextField Emailinput;
    private JTextField SSNinput;
    private JComboBox month;
    private JComboBox day;
    private JComboBox year;
    private JRadioButton librarianRadioButton;
    private JRadioButton technicianRadioButton;
    private JButton ConfirmEmployee;
    private JLabel nameHeader;
    private JLabel IDheader;
    private JLabel AddressHeader;
    private JLabel EmailHeader;
    private JLabel SSNheader;
    private JLabel DoBheader;
    private JLabel PositionHeader;

    public newemployee_page(){
        this.setContentPane(window);
        this.setTitle("Exit screen");
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        ConfirmEmployee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
