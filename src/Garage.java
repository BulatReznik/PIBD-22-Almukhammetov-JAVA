import java.awt.*;
import java.util.ArrayList;

public class Garage<T extends ITransport, M extends IWheels>
{
    private ArrayList<T> places;
    private final int maxCount;
    private final int pictureWidth;
    private final int pictureHeight;
    private final int placeSizeWidth = 260;
    private final int placeSizeHeight = 160;
    private final int garageWidth;
    private final int garageHeight;

    public T getTruckCar(int index)
    {
        if (index > -1 && index < places.size())
        {
            return places.get(index);
        }
        else
        {
            return null;
        }
    }
    public Garage(int picWidth, int picHeight)
    {
        places = new ArrayList<T>();
        garageWidth = picWidth / placeSizeWidth;
        garageHeight = picHeight / placeSizeHeight;
        pictureWidth = picWidth;
        pictureHeight = picHeight;
        maxCount = garageWidth * garageHeight;
    }

    public int plus(T dumpcar)
    {
        if (places.size() < maxCount)
        {
            places.add(dumpcar);
            return places.size() - 1;
        }
        else
        {
            return -1;
        }
    }
    public T minus(int index)
    {
        if (index > -1 && index < places.size())
        {
            T bufTruck = places.get(index);
            places.remove(index);
            return bufTruck;
        }
        else
        {
            return null;
        }
    }
    public boolean more(int count)
    {
        return places.size() > count;
    }
    public boolean less(int count)
    {
        return places.size() < count;
    }
    public void Draw(Graphics gr)
    {
        gr.setColor(Color.black);
        DrawMarking(gr);
        for (int i = 0; i < places.size(); i++)
        {
            places.get(i).SetPosition(i % garageWidth * placeSizeWidth + 10, i / garageWidth * placeSizeHeight + 5, pictureWidth, pictureHeight);
            places.get(i).DrawTransport(gr);
        }
    }
    public void DrawMarking(Graphics gr)
    {
        gr.setColor(Color.black);
        for (int i = 0; i < garageWidth; i++)
        {
            for (int j = 0; j < garageHeight + 1; ++j)
            {
                gr.drawLine(i * placeSizeWidth, j * placeSizeHeight, i *
                        placeSizeWidth + placeSizeWidth / 2, j * placeSizeHeight);
            }
            gr.drawLine(i * placeSizeWidth, 0, i * placeSizeWidth,
                    (garageHeight) * placeSizeHeight);
        }
    }
}