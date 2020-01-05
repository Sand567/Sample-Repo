import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sharath Nagendra on 9/19/2017.
 */
public class Allergy implements AllergyInterface{
    private String allergyName;
    private Severity severity;


    public Allergy(){

    }
    public Allergy(String allergyName, Severity severity) {
        this.allergyName = allergyName;
        this.severity = severity;
    }


    @Override
    public List<String> getAllergyList() {



            Allergy al = new Allergy("rashes",Severity.High);

            Allergy al1 = new Allergy("swelling",Severity.Medium);
            List<String> allergyList = new ArrayList<String>();
            allergyList.add(al.allergyName);
            allergyList.add(al1.allergyName);
            return  allergyList;
        }


    public String getAllergyName() {
        return allergyName;
    }

    public void setAllergyName(String allergyName) {
        this.allergyName = allergyName;
    }


    public Severity getSeverity() {
        return severity;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }


}
