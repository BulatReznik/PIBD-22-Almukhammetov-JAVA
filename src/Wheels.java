import java.awt.*;

public class Wheels
{
    private WheelsQuantity quantity;
    public void setQuantity(int quantity)
    {
        this.quantity = WheelsQuantity.values()[quantity - (quantity - 1) / 3 * 3];
    }
    public void drawWheels(Color dopColor, Graphics2D g2d, int startPosX, int startPosY)
    {
        g2d.setColor(dopColor);
        g2d.fillOval(startPosX + 200, startPosY + 100, 40,40);
        g2d.setColor(Color.black);
        g2d.drawOval(startPosX + 200, startPosY + 100, 40,40);
        for (int i = 0; i < quantity.ordinal(); ++i)
        {
            g2d.setColor(dopColor);
            g2d.fillOval(startPosX + 20 + (40 * i), startPosY + 100, 40,40);
            g2d.setColor(Color.black);
            g2d.drawOval(startPosX + 20 + (40 * i), startPosY + 100, 40,40);
        }
    }
}
