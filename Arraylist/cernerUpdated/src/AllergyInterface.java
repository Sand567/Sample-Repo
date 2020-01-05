import java.util.List;

/**
 * Created by Sharath Nagendra on 10/9/2017.
 */
public interface AllergyInterface {

    public List<String> getAllergyList();
    public String getAllergyName();
    public void setAllergyName(String allergyName);
    public Severity getSeverity();
    public void setSeverity(Severity severity);

}
