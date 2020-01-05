import java.util.List;

/**
 * Created by Sharath Nagendra on 9/22/2017.
 */
public class Medicine {

    private String name;
    private String disease;
    private String composition;
    private String details;
    private List<Frequency> frequencyList;



    public List<Frequency> getFrequencyList() {
        return frequencyList;
    }

    public void setFrequencyList(List<Frequency> frequencyList) {
        this.frequencyList = frequencyList;
    }

    public String getName() {
        return name;
    }

    public Medicine(String name, String composition, String details) {
        this.name = name;
        this.setComposition(composition);
        this.setDetails(details);

    }

    public void setName(String name) {
        this.name = name;
    }
    public String getDisease() {
        return disease;
    }
    public void setDisease(String disease) {
        this.disease = disease;
    }

    /**
     * @return the composition
     */
    public String getComposition() {
        return composition;
    }

    /**
     * @param composition the composition to set
     */
    public void setComposition(String composition) {
        this.composition = composition;
    }

    /**
     * @return the details
     */
    public String getDetails() {
        return details;
    }

    /**
     * @param details the details to set
     */
    public void setDetails(String details) {
        this.details = details;
    }
}
