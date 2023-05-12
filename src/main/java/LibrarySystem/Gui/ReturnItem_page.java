package LibrarySystem.Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class ReturnItem_page extends JFrame{
    public JPanel window;
    private JLabel ReturnHeader;
    private JTextField LoanInput;
    private JButton LoanButton;

    public ReturnItem_page(){
        this.setContentPane(window);
        this.setTitle("Return Library Items");
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        LoanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String LoanID = LoanInput.getText();
            }
        });
    }
}
