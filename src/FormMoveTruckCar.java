import javax.swing.*;

public class FormMoveTruckCar extends JDialog
{
    PanelMoveTruckCar panelMoveTruckCar = new PanelMoveTruckCar();
    public void SetTruckCar(ITransport dumpcar)
    {
        panelMoveTruckCar.SetCarTruck(dumpcar);
    }
    public FormMoveTruckCar()
    {
        setTitle("Грузовик");
        setSize(1366, 875);
        setLocation(1350, 836);
        add(panelMoveTruckCar);
    }
}
