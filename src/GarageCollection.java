import java.util.*;

public class GarageCollection
{
    final Map<String, Garage <Vehicle, WheelOne>> garageStages  = new HashMap<String, Garage<Vehicle, WheelOne>>();
    public ArrayList<String> Keys()
    {
        return new ArrayList<>(garageStages.keySet());
    }
    private final int pictureWidth;
    private final int pictureHeight;
    public GarageCollection(int pictureWidth, int pictureHeight)
    {
        this.pictureWidth = pictureWidth;
        this.pictureHeight = pictureHeight;
    }
    public void AddGarage(String name)
    {
        if (!garageStages.containsKey(name))
        {
            garageStages.put(name, new Garage<Vehicle, WheelOne>(pictureWidth, pictureHeight));
        }
    }
    public void DelGarage(String name)
    {
        if (garageStages.containsKey(name))
        {
            garageStages.remove(name);
        }
    }
    public Garage<Vehicle, WheelOne> getGarage(String index)
    {
        if (garageStages.containsKey(index))
        {
            return garageStages.get(index);
        }
        else
        {
            return null;
        }
    }
    public Vehicle getTruckCarGarage(String indexGarage, int indexTruck)
    {
        if (garageStages.containsKey(indexGarage) && garageStages.get(indexGarage) != null)
        {
            return garageStages.get(indexGarage).getTruckCar(indexTruck);
        }
        else
        {
            return null;
        }
    }
}
