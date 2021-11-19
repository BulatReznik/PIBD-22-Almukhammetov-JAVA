import java.awt.*;

public class WheelThree implements IWheels
{
    private WheelsQuantity quantity;
    public void setQuantity(int quantity)
    {
        this.quantity = WheelsQuantity.values()[quantity - (quantity - 1) / 3 * 3];
    }
    public void drawWheels(Graphics2D g2d, int startPosX, int startPosY)
    {
        g2d.setColor(Color.gray);
        g2d.fillOval(startPosX + 200, startPosY + 100, 40,40);
        g2d.setColor(Color.black);
        g2d.drawOval(startPosX + 200, startPosY + 100, 40,40);
        g2d.fillOval(startPosX + 210, startPosY + 110, 20,20);
        for (int i = 0; i < quantity.ordinal(); ++i)
        {
            g2d.setColor(Color.gray);
            g2d.fillOval(startPosX + 20 + (40 * i), startPosY + 100, 40,40);
            g2d.setColor(Color.black);
            g2d.drawOval(startPosX + 20 + (40 * i), startPosY + 100, 40,40);
            g2d.fillOval(startPosX + 30 + (40 * i), startPosY + 110, 20,20);
        }
    }
}