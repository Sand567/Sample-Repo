import java.util.List;

/**
 * Created by Sharath Nagendra on 9/19/2017.
 */
public class Temperature implements  TempInterface {
    private float temperature;
    private Location location;



public Temperature(){

}


public Temperature(float temperature){
        this.temperature=temperature;
    }

    public Temperature(float temperature, Location location) {
        this.temperature = temperature;
        this.location = location;
    }

    @Override
    public float getTemperature() {
        return temperature;
    }

    @Override
    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    @Override
    public Location getLocation() {
        return location;
    }

    @Override
    public void setLocation(Location location) {
        this.temperature = 0;
        this.location = location;
    }

    @Override
    public float getTemperatureInFarenheit() {
        return (temperature *9/5)+32;
    }
    @Override
    public float setDefaultTemp(){
        return this.temperature=38;
    }

    @Override
    public List<Allergy> getAllergyList() {
        return null;
    }




}
