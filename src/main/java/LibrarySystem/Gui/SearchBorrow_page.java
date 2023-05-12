package LibrarySystem.Gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchBorrow_page extends JFrame{
    public JPanel window;
    private JButton ConfirmButton;
    private JLabel Header;
    private JTextField SearchInput;

    public SearchBorrow_page(){
        this.setContentPane(window);
        this.setTitle("Search and Borrow");
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        ConfirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Results_page();
            }
        });
    }
}
