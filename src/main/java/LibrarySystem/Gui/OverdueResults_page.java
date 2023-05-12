package LibrarySystem.Gui;

import javax.swing.*;

public class OverdueResults_page extends JFrame{
    private JPanel window;
    private JTable TableOutput;
    private JLabel OverdueHeader;

    public OverdueResults_page() {
        this.setContentPane(window);
        this.setTitle("Overdue Results");
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
