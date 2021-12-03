import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Objects;
import java.util.Stack;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class PanelGarage extends JPanel
{
    private Stack<Vehicle> stackGarageDelTruckCar = new Stack<Vehicle>();
    private final GarageCollection garageCollection;
    private DefaultListModel<String> defListBoxGarages = new DefaultListModel<String>();
    JList<String> jListBoxGarages;
    JButton buttonAddGarage = new JButton("<html>Добавить<br>гараж");
    JButton buttonDelGarage = new JButton("<html>Удалить<br>гараж");
    JTextField textFieldAddGarage = new JTextField();
    JLabel labelGarages = new JLabel("<html>Введите название <br>нового гаража:");
    JButton buttonShowDelTruckCar = new JButton("Показать");
    JButton buttonSetTruckCar = new JButton("<html>Припарковать<br>грузовик");
    JButton buttonSetDumpCar = new JButton("<html>Припарковать<br>самосвал");
    JLabel labelGetTruck = new JLabel("Забрать грузовик: ");
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
                    if ((garageCollection.getGarage(jListBoxGarages.getSelectedValue()).plus(truckCar)) > -1)
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
                    if ((garageCollection.getGarage(jListBoxGarages.getSelectedValue()).plus(dumpCar)) > -1)
                    {
                        repaint();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Гараж переполнен");
                    }
                    break;
                case "Get truckCar":
                    if (!Objects.equals(textFieldGetTruckCar.getText(), ""))
                    {
                        var takenTruckCar = garageCollection.getGarage(jListBoxGarages.getSelectedValue()).minus(Integer.parseInt(textFieldGetTruckCar.getText()));
                        if (takenTruckCar != null)
                        {
                            stackGarageDelTruckCar.add(takenTruckCar);
                        }
                        repaint();
                    }
                    break;
            }
        }
    }
    public class showDelTruckCarListener implements  ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            if (stackGarageDelTruckCar.size() > 0)
            {
                formMoveTruckCar.SetTruckCar(stackGarageDelTruckCar.pop());
                formMoveTruckCar.setVisible(true);
            }
        }
    }
    public class addDelGarageListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            String actionCommand = event.getActionCommand();
            switch (actionCommand)
            {
                case "Add Garage":
                    if (textFieldAddGarage.getText().equals(""))
                    {
                        JOptionPane.showMessageDialog(null, "Введите название гаража", "Ошибка", JOptionPane.ERROR_MESSAGE);
                    }
                    else
                    {
                        garageCollection.AddGarage(textFieldAddGarage.getText());
                        ReloadGarages();
                    }
                    break;
                case "Del Garage":
                    if (jListBoxGarages.getSelectedValue() != null)
                    {
                        if (JOptionPane.showConfirmDialog(null, "Удалить гараж " + jListBoxGarages.getSelectedValue() + "?") == 0)
                        {
                            garageCollection.DelGarage(jListBoxGarages.getSelectedValue());
                            ReloadGarages();
                        }
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
        garageCollection = new GarageCollection(1200, 875);
        formMoveTruckCar.setModal(true);
        //panel
        setBackground(Color.white);
        setLayout(null);
        smthAdd(labelGarages, 1225, 10, 110, 27);
        smthAdd(textFieldAddGarage, 1225, 40, 110, 25);
        buttonAddGarage.setActionCommand("Add Garage");
        buttonAddGarage.addActionListener(new addDelGarageListener());
        smthAdd(buttonAddGarage, 1225, 70, 110, 40);
        jListBoxGarages = new JList<String>(defListBoxGarages);
        jListBoxGarages.setPrototypeCellValue("Установленный размер");
        jListBoxGarages.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jListBoxGarages.addListSelectionListener(new listBoxChangeListener());
        smthAdd(new JScrollPane(jListBoxGarages), 1225, 120, 110, 90);
        buttonDelGarage.setActionCommand("Del Garage");
        buttonDelGarage.addActionListener(new addDelGarageListener());
        smthAdd(buttonDelGarage, 1225, 220, 110, 40);
        buttonSetTruckCar.setActionCommand("Set TruckCar");
        buttonSetDumpCar.setActionCommand("Set DumpCar");
        buttonGetTruckCar.setActionCommand("Get truckCar");
        smthAdd(buttonSetTruckCar, 1225, 405, 110, 35);
        smthAdd(buttonSetDumpCar, 1225, 450, 110, 45);
        smthAdd(labelGetTruck, 1225, 580, 110, 20);
        smthAdd(labelPlace, 1225, 540, 100, 20);
        NumberFormat format = NumberFormat.getInstance();
        NumberFormatter formatter = new NumberFormatter(format);
        formatter.setAllowsInvalid(false);
        textFieldGetTruckCar = new JFormattedTextField(formatter);
        smthAdd(textFieldGetTruckCar, 1270, 540, 40, 20);
        smthAdd(buttonGetTruckCar, 1225, 620, 110, 40);
        buttonSetTruckCar.addActionListener(new setGetTruckCarListener());
        buttonSetDumpCar.addActionListener(new setGetTruckCarListener());
        buttonGetTruckCar.addActionListener(new setGetTruckCarListener());
        buttonShowDelTruckCar.addActionListener(new showDelTruckCarListener());
        smthAdd(buttonShowDelTruckCar, 1225, 720, 110, 20);
    }
    public void ReloadGarages()
    {
        int index = jListBoxGarages.getSelectedIndex();
        defListBoxGarages.clear();
        for (int i = 0; i < garageCollection.Keys().size(); i++)
        {
            defListBoxGarages.addElement(garageCollection.Keys().get(i));
        }
        if (defListBoxGarages.size() > 0 && (index == -1 || index >= defListBoxGarages.size()))
        {
            jListBoxGarages.setSelectedIndex(0);
        }
        else
        {
            if (defListBoxGarages.size() > 0 && index > -1 && index < defListBoxGarages.size())
            {
                jListBoxGarages.setSelectedIndex(index);
            }
        }
    }
    public class listBoxChangeListener implements ListSelectionListener
    {
        @Override
        public void valueChanged(ListSelectionEvent e)
        {
            repaint();
        }
    }
    private void Draw(Graphics gr)
    {
        if (jListBoxGarages.getSelectedValue() != null)
        {
            garageCollection.getGarage(jListBoxGarages.getSelectedValue()).Draw(gr);
        }
    }

    public void paintComponent(Graphics gr)
    {
        super.paintComponent(gr);
        Draw(gr);
    }
}
