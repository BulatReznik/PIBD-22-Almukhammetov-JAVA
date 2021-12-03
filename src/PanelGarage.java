import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Objects;

public class PanelGarage extends JPanel
{
    private Garage<TruckCar, WheelOne> garage;
    JButton buttonSetTruckCar = new JButton("<html>Припарковать<br>грузовик");
    JButton buttonSetDumpCar = new JButton("<html>Припарковать<br>самосвал");
    JLabel labelGetTruck = new JLabel("Забрать грузовик");
    JLabel labelPlace = new JLabel("Место: ");
    JButton buttonGetTruckCar = new JButton("Забрать");
    JFormattedTextField textFieldGetTruckCar;
    FormMoveTruckCar formMoveTruckCar = new FormMoveTruckCar();

    public class setGetTruckCarListener implements ActionListener
    {   //реализация интерфейса
        @Override
        public void actionPerformed(ActionEvent event)
        {
            String actionCommand = event.getActionCommand();
            switch (actionCommand)
            {
                case "Set TruckCar":
                    Color truckColor = JColorChooser.showDialog(null, "Choose a color", Color.RED);
                    var truckCar = new TruckCar(100, 1000, truckColor);
                    if ((garage.plus(truckCar)) > -1)
                    {
                        repaint();
                    } else
                    {
                        JOptionPane.showMessageDialog(null, "Гараж переполнен");
                    }
                    break;
                case "Set DumpCar":
                    Color mainColor = JColorChooser.showDialog(null, "Choose a color", Color.RED);
                    Color dopColor = JColorChooser.showDialog(null, "Choose a color", Color.RED);
                    var dumpCar = new DumpCar(100, 1000, mainColor, dopColor, true, true, true);
                    if ((garage.plus(dumpCar)) > -1)
                    {
                        repaint();
                    } else
                    {
                        JOptionPane.showMessageDialog(null, "Гараж переполнен");
                    }
                    break;
                case "Get truckCar":
                    if (!Objects.equals(textFieldGetTruckCar.getText(), ""))
                    {
                        var takenTruckCar = garage.minus(Integer.parseInt(textFieldGetTruckCar.getText()));
                        if (takenTruckCar != null) {
                            formMoveTruckCar.SetTruckCar(takenTruckCar);
                            formMoveTruckCar.setVisible(true);
                        }
                        repaint();
                    }
                    break;
            }
        }
    }

    public void smthAdd(JComponent butt, int x, int y, int width, int height)
    {
        butt.setBounds(x, y, width, height);
        add(butt);
    }

    public PanelGarage()
    {
        garage = new Garage<TruckCar, WheelOne>(1200, 875);
        formMoveTruckCar.setModal(true);
        //panel
        setBackground(Color.white);
        setLayout(null);
        buttonSetTruckCar.setActionCommand("Set TruckCar");
        buttonSetDumpCar.setActionCommand("Set DumpCar");
        buttonGetTruckCar.setActionCommand("Get truckCar");
        smthAdd(buttonSetTruckCar, 1225, 5, 110, 35);
        smthAdd(buttonSetDumpCar, 1225, 50, 110, 45);
        smthAdd(labelGetTruck, 1225, 120, 110, 20);
        smthAdd(labelPlace, 1225, 140, 100, 20);
        NumberFormat format = NumberFormat.getInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setAllowsInvalid(false);
        textFieldGetTruckCar = new JFormattedTextField(formatter);
        smthAdd(textFieldGetTruckCar, 1270, 140, 40, 20);
        smthAdd(buttonGetTruckCar, 1225, 180, 100, 40);
        buttonSetTruckCar.addActionListener(new setGetTruckCarListener());
        buttonSetDumpCar.addActionListener(new setGetTruckCarListener());
        buttonGetTruckCar.addActionListener(new setGetTruckCarListener());
    }

    private void Draw(Graphics gr)
    {
        garage.Draw(gr);
    }

    public void paintComponent(Graphics gr)
    {
        super.paintComponent(gr);
        Draw(gr);
    }
}
