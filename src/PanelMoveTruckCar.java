import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelMoveTruckCar extends JPanel
{
    private ITransport dumpcar;
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
            repaint();
        }
    }

    public void buttonAdd(JButton butt, int x, int y, int width, int height)
    {
        butt.setBounds(x, y, width, height);
        add(butt);
    }
    public void SetCarTruck(ITransport dumpcar) {
        this.dumpcar = dumpcar;
        this.dumpcar.SetPosition(50, 50, 1366, 875);
    }
    public void Draw(Graphics g2d)
    {
        dumpcar.DrawTransport(g2d);
    }
    @Override
    public void paintComponent(Graphics g2d)
    {
        super.paintComponent(g2d);
        Draw(g2d);
    }
    public PanelMoveTruckCar()
    {
        setBackground(Color.white);
        setLayout(null);
        buttonRight.setActionCommand("right");
        buttonDown.setActionCommand("down");
        buttonUp.setActionCommand("up");
        buttonLeft.setActionCommand("left");
        buttonAdd(buttonRight, 1228, 758, 30, 30);
        buttonAdd(buttonDown, 1192, 758, 30, 30);
        buttonAdd(buttonUp, 1192, 722, 30, 30);
        buttonAdd(buttonLeft, 1156, 758, 30, 30);
        buttonUp.addActionListener(new clickListener());
        buttonDown.addActionListener(new clickListener());
        buttonLeft.addActionListener(new clickListener());
        buttonRight.addActionListener(new clickListener());
    }
}
