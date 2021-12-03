import java.awt.*;

public class TruckCar extends Vehicle
{
    protected int truckWidth = 240;
    protected int truckHeight = 140;
    public TruckCar(int maxSpeed, float weight, Color mainColor)
    {
        super.MaxSpeed = maxSpeed;
        super.Weight = weight;
        super.MainColor = mainColor;
    }
    protected TruckCar(int maxSpeed, float weight, Color mainColor, int truckWidth, int truckHeight)
    {
        super.MaxSpeed = maxSpeed;
        super.Weight = weight;
        super.MainColor = mainColor;
        this.truckWidth = truckWidth;
        this.truckHeight = truckHeight;
    }
    public void MoveTransport(Direction direction)
    {
        float step = MaxSpeed * 100 / Weight;
        switch (direction)
        {
            case Right:
                if (startPosX + step <= pictureWidth - truckWidth)
                {
                    startPosX += step;
                }
                break;
            case Left:
                if (startPosX - step >= 0) {
                    startPosX -= step;
                }
                break;
            case Up:
                if (startPosY - step >= 0) {
                    startPosY -= step;
                }
                break;
            case Down:
                if (startPosY + step <= pictureHeight - truckHeight) {
                    startPosY += step;
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + direction);
        }
    }
    public void DrawTransport(Graphics gr)
    {
        Graphics2D g2d = (Graphics2D)gr;
        //корпус
        g2d.setColor(MainColor);
        g2d.fillRect(startPosX + 20, startPosY + 80, 220, 20 );
        g2d.fillRect(startPosX + 160, startPosY + 20,80,60);
        g2d.setPaint(Color.black);
        g2d.drawRect(startPosX + 20, startPosY + 80, 220, 20);
        g2d.drawRect(startPosX + 160, startPosY + 20,80,60);
        //колесо спереди
        g2d.setColor(Color.GRAY);
        g2d.fillOval(startPosX + 200, startPosY + 100, 40,40);
        g2d.setColor(Color.black);
        g2d.drawOval(startPosX + 200, startPosY + 100, 40,40);
        //колесо сзади
        g2d.setColor(Color.gray);
        g2d.fillOval(startPosX + 20, startPosY + 100, 40,40);
        g2d.setColor(Color.black);
        g2d.drawOval(startPosX + 20, startPosY + 100, 40,40);
    }
}
