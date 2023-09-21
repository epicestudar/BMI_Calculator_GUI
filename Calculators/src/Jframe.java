import javax.swing.*;

public class Jframe extends JFrame{
    public Jframe() {
        super("SA3 GUI Layout");
        this.add(new JtabbedPane());
        

        // set frame
        this.setBounds(500, 250, 500, 500);
        this.setDefaultCloseOperation(2);
        this.setVisible(true);
        this.pack();
    }
}