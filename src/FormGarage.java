import javax.swing.*;

public class FormGarage extends JFrame
{
    PanelGarage panelGarage = new PanelGarage();
    public FormGarage()
    {
        setTitle("Парковка");
        setSize(1366, 875);
        setLocation(1350, 836);
        add(panelGarage);
        setVisible(true);
    }

    public static void main(String[] args)
    {
        FormGarage mW = new FormGarage();
    }
}