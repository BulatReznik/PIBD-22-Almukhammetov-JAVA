import java.awt.*;

public abstract class Vehicle implements ITransport
{
    protected int startPosX;
    protected int startPosY;
    protected int pictureWidth;
    protected int pictureHeight;
    public int MaxSpeed;
    public float Weight;
    public Color MainColor;

    public void SetPosition(int x, int y, int width, int height)
    {
        startPosX = x;
        startPosY = y;
        pictureWidth = width;
        pictureHeight = height;
    }
    public abstract void MoveTransport(Direction direction);
    public abstract void DrawTransport(Graphics gr);
}