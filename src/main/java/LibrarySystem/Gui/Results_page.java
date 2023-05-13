package LibrarySystem.Gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Results_page extends JFrame{

    public JTable ResultsTable;
    private JButton checkOutButton;
    private JTextField IDinput;
    private JLabel IDheader;
    private JPanel window;
    private JLabel ResultsHeader;

    public Results_page(){
        this.setContentPane(window);
        this.setTitle("Search Results");
        this.setLocationRelativeTo(null);
        this.setSize(500,500);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        checkOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ID = IDinput.getText();
            }
        });
    }
}
