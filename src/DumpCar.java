import java.awt.*;
import java.util.Random;

public class DumpCar extends TruckCar
{
    private IWheels wheels;
    public Color DopColor;
    public boolean Wheels;
    public boolean TipperBody;
    public boolean Glasses;
    protected DumpCar(int maxSpeed, float weight, Color mainColor, Color dopColor, boolean wheels, boolean glasses, boolean tipperBody)
    {
        super(maxSpeed,weight,mainColor);
        this.DopColor = dopColor;
        this.Wheels = wheels;
        this.Glasses = glasses;
        this.TipperBody = tipperBody;
        Random rnd = new Random();
        switch(rnd.nextInt(3))
        {
            case 0:
                this.wheels = new WheelOne();
                break;
            case 1:
                this.wheels = new WheelTwo();
                break;
            case 2:
                this.wheels = new WheelThree();
                break;
        }
        if (wheels)
        {
            this.wheels.setQuantity(rnd.nextInt(5)+1);
        }
        else
        {
            this.wheels.setQuantity(0);
        }
    }
    @Override
    public void DrawTransport(Graphics gr)
    {
        gr.clearRect(0, 0, 1366, 875);
        Graphics2D g2d = (Graphics2D)gr;
        super.DrawTransport(gr);
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
            wheels.drawWheels(g2d, startPosX, startPosY);
        }
    }
}