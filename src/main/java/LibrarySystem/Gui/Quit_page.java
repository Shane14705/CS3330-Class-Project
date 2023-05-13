package LibrarySystem.Gui;

import javax.swing.*;

public class Quit_page extends JFrame {
    public JPanel panel1;
    private JLabel QuitMessage;

    public Quit_page(){
        this.setContentPane(panel1);
        this.setTitle("Exit screen");
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
