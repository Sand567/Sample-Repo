import java.util.List;

/**
 * Created by Sharath Nagendra on 9/19/2017.
 */
public interface TempInterface {
    public float getTemperature();
    public void setTemperature(float temperature);
    public Location getLocation();
    public void setLocation(Location location);
    public float getTemperatureInFarenheit();
    public float setDefaultTemp();
    public List<Allergy> getAllergyList();
}
