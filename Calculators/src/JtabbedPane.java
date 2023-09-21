import javax.swing.*;

public class JtabbedPane extends JTabbedPane{
    public JtabbedPane() {
        super();
        this.add("Calculadora IMC", new Calculadora_IMC());
        
    }
}