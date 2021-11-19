import javax.swing.*;

public class MainWindow extends JFrame
{
    public MainWindow()
    {
        setTitle("Самосвал");
        setSize(1366, 875);
        setLocation(1350, 836);
        add(new FormDumpCar());
        setVisible(true);
    }

    public static void main(String[] args)
    {
        MainWindow MainWindow = new MainWindow();
    }
}
