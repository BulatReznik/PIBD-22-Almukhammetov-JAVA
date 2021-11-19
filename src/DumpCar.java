import java.awt.*;
import java.util.Random;

public class DumpCar
{
    private Wheels wheels;
    private int startPosX;
    private int startPosY;
    private int pictureWidth;
    private int pictureHeight;
    private static final int truckWidth = 240;
    private static final int truckHeight = 140;
    public int MaxSpeed;
    public float Weight;
    public Color MainColor;
    public Color DopColor;
    public boolean Wheels;
    public boolean TipperBody;
    public boolean Glasses;
    public void Init(int maxSpeed, float weight, Color mainColor, Color dopColor, boolean wheels, boolean glasses, boolean tipperBody)
    {
        this.MaxSpeed = maxSpeed;
        this.Weight = weight;
        this.MainColor = mainColor;
        this.DopColor = dopColor;
        this.Wheels = wheels;
        this.Glasses = glasses;
        this.TipperBody = tipperBody;
        this.wheels = new Wheels();
        if (wheels)
        {
            Random rnd = new Random();
            this.wheels.setQuantity(rnd.nextInt(5) + 1);
        }
        else
        {
            this.wheels.setQuantity(0);
        }
    }
    public void SetPosition(int x, int y, int width, int height)
    {
        startPosX = x;
        startPosY = y;
        pictureWidth = width;
        pictureHeight = height;
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
                if (startPosX - step >= 0)
                {
                    startPosX -= step;
                }
                break;
            case Up:
                if (startPosY - step >= 0)
                {
                    startPosY -= step;
                }
                break;
            case Down:
                if (startPosY + step <= pictureHeight - truckHeight)
                {
                    startPosY += step;
                }
                break;
        }
    }
    public void DrawTransport(Graphics gr)
    {
        gr.clearRect(0, 0, 1366, 875);
        Graphics2D g2d = (Graphics2D)gr;
        //корпус
        g2d.setColor(MainColor);
        g2d.fillRect(startPosX + 20, startPosY + 80, 220, 20 );
        g2d.fillRect(startPosX + 160, startPosY + 20,80,60);
        g2d.setPaint(Color.black);
        g2d.drawRect(startPosX + 20, startPosY + 80, 220, 20);
        g2d.drawRect(startPosX + 160, startPosY + 20,80,60);
        //стекла
        if (Glasses)
        {
            g2d.setColor(Color.blue);
            g2d.fillRect(startPosX + 190, startPosY+ 30, 50, 40 );
        }
        //кузов
        if(TipperBody)
        {
            g2d.setColor(DopColor);
            int xPointsBody[] = new int[]
                    {
                            startPosX,
                            startPosX + 20,
                            startPosX + 110,
                            startPosX + 130,
                            startPosX + 150,
                            startPosX + 150,
                            startPosX + 130,
                            startPosX + 110,
                            startPosX
                    };
            int yPointsBody[] = new int[]
                    {
                            startPosY + 80,
                            startPosY + 20,
                            startPosY + 20,
                            startPosY,
                            startPosY,
                            startPosY + 20,
                            startPosY + 20,
                            startPosY + 80,
                            startPosY + 80
                    };
            g2d.fillPolygon(xPointsBody,yPointsBody, xPointsBody.length);
            g2d.setColor(Color.black);
            g2d.drawPolygon(xPointsBody,yPointsBody, xPointsBody.length);
        }
        //колеса
        if (Wheels)
        {
            wheels.drawWheels(DopColor, g2d, startPosX, startPosY);
        }
    }
}