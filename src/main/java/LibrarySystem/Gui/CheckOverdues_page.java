package LibrarySystem.Gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckOverdues_page extends JFrame{
    private JButton CheckButton;
    private JPanel window;

    public CheckOverdues_page(){
        this.setContentPane(window);
        this.setTitle("Check Overdues");
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        CheckButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new OverdueResults_page();
            }
        });

    }
}
