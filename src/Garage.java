import java.awt.*;

public class Garage<T extends ITransport, M extends IWheels>
{
    private final Object[] places;
    private final int pictureWidth;
    private final int pictureHeight;
    private final int placeSizeWidth = 260;
    private final int placeSizeHeight = 160;
    private final int garageWidth;
    private final int garageHeight;

    public Garage(int picWidth, int picHeight)
    {
        garageWidth = picWidth / placeSizeWidth;
        garageHeight = picHeight / placeSizeHeight;
        places = new Object[garageWidth * garageHeight];
        pictureWidth = picWidth;
        pictureHeight = picHeight;
    }

    public int plus(T dumpcar)
    {
        int i = 0;
        while (i < places.length && places[i] != null)
        {
            i++;
        }
        if (i < places.length && places[i] == null)
        {
            dumpcar.SetPosition(i % garageWidth * placeSizeWidth + 10, i / garageWidth * placeSizeHeight + 5, pictureWidth, pictureHeight);
            places[i] = dumpcar;
            return i;
        } else
        {
            return -1;
        }
    }
    public T minus(int index)
    {
        if (index > -1 && index < places.length && places[index] != null)
        {
            T bufTruck = (T) places[index];
            places[index] = null;
            return bufTruck;
        }
        else
        {
            return null;
        }
    }
    public boolean more(Garage<ITransport,IWheels> L,int count)
    {
        int length = L.places.length;
        int fullness = 0;
        for (int i = 0; i < length; ++i)
        {
            if (places[i] != null)
            {
                fullness += 1;
            }
        }
        return fullness > count;
    }
    public boolean less(Garage<ITransport,IWheels> L, int count)
    {
        int length = L.places.length;
        int fullness = 0;
        for (int i = 0; i < length; ++i)
        {
            if (places[i] != null)
            {
                fullness += 1;
            }
        }
        return fullness < count;
    }
    public void Draw(Graphics gr)
    {
        gr.setColor(Color.black);
        DrawMarking(gr);
        for (int i = 0; i < places.length; i++)
        {
            if (places[i] != null)
            {
                ((T) places[i]).DrawTransport(gr);
            }
        }
    }
    public void DrawMarking(Graphics gr)
    {
        gr.setColor(Color.black);
        for (int i = 0; i < garageWidth; i++) {
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