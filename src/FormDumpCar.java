import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class FormDumpCar extends JPanel
{
    private DumpCar dumpcar;
    JButton buttonCreateDumpCar = new JButton("Создать самосвал");
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
        buttonAdd(buttonCreateDumpCar, 5, 5, 150, 20);
        buttonAdd(buttonRight, 1228, 758, 30, 30);
        buttonAdd(buttonDown, 1192, 758, 30, 30);
        buttonAdd(buttonUp, 1192, 722, 30, 30);
        buttonAdd(buttonLeft, 1156, 758, 30, 30);
        buttonCreateDumpCar.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                Random rnd = new Random();
                dumpcar = new DumpCar();
                dumpcar.Init(rnd.nextInt(3000) + 1000, rnd.nextInt(2000) + 10000, Color.red, Color.yellow, true, true, true);
                dumpcar.SetPosition(rnd.nextInt(100), rnd.nextInt(100), getWidth(), getHeight());
                draw();
            }
        });
        buttonUp.addActionListener(new clickListener());
        buttonDown.addActionListener(new clickListener());
        buttonLeft.addActionListener(new clickListener());
        buttonRight.addActionListener(new clickListener());
    }
}
