import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class FormDumpCar extends JPanel
{
    private ITransport dumpcar;
    JButton buttonCreateDumpcar = new JButton("Создать Самосвал");
    JButton buttonCreateTruckcar = new JButton("Создать Грузовик");
    JButton buttonUp = new JButton(new ImageIcon("Resources/Up.png"));
    JButton buttonDown = new JButton(new ImageIcon("Resources/Down.png"));
    JButton buttonLeft = new JButton(new ImageIcon("Resources/Left.png"));
    JButton buttonRight = new JButton(new ImageIcon("Resources/Right.png"));

    public class clickListener implements  ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            String actionCommand = event.getActionCommand();
            switch (actionCommand)
            {
                case "up":
                    dumpcar.MoveTransport(Direction.Up);
                    break;
                case "down":
                    dumpcar.MoveTransport(Direction.Down);
                    break;
                case "left":
                    dumpcar.MoveTransport(Direction.Left);
                    break;
                case "right":
                    dumpcar.MoveTransport(Direction.Right);
                    break;
            }
            draw();
        }
    }

    public class createListener implements  ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
            String actionCommand = event.getActionCommand();
            Random rnd = new Random();
            switch (actionCommand)
            {
                case "truck":
                    dumpcar = new TruckCar(rnd.nextInt(3000) + 1000, rnd.nextInt(2000) + 10000, Color.blue);
                    break;
                case "dumpcar":
                    dumpcar = new DumpCar(rnd.nextInt(3000) + 1000, rnd.nextInt(2000) + 10000, Color.red, Color.yellow, true, true, true);
                    break;
            }
            dumpcar.SetPosition(rnd.nextInt(100), rnd.nextInt(100), getWidth(), getHeight());
            draw();
        }
    }

    public void buttonAdd(JButton butt, int x, int y, int width, int height)
    {
        butt.setBounds(x, y, width, height);
        add(butt);
    }
    private void draw()
    {
        dumpcar.DrawTransport(getGraphics());
        paintComponents(getGraphics());
    }
    public FormDumpCar()
    {
        setBackground(Color.white);
        setLayout(null);
        buttonRight.setActionCommand("right");
        buttonDown.setActionCommand("down");
        buttonUp.setActionCommand("up");
        buttonLeft.setActionCommand("left");
        buttonCreateTruckcar.setActionCommand("truck");
        buttonCreateDumpcar.setActionCommand("dumpcar");
        buttonAdd(buttonCreateTruckcar, 5, 5, 205, 20);
        buttonAdd(buttonCreateDumpcar, 210, 5, 205, 20);
        buttonAdd(buttonRight, 1228, 758, 30, 30);
        buttonAdd(buttonDown, 1192, 758, 30, 30);
        buttonAdd(buttonUp, 1192, 722, 30, 30);
        buttonAdd(buttonLeft, 1156, 758, 30, 30);
        buttonCreateTruckcar.addActionListener(new createListener());
        buttonCreateDumpcar.addActionListener(new createListener());
        buttonUp.addActionListener(new clickListener());
        buttonDown.addActionListener(new clickListener());
        buttonLeft.addActionListener(new clickListener());
        buttonRight.addActionListener(new clickListener());
    }
}

