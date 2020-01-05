import java.util.Date;
import java.util.List;

/**
 * Created by Sharath Nagendra on 9/19/2017.
 */
public class Patient extends Person {


    private List<Allergy> allergy;
    private List<Disease> diseases;
    private List<Medication> medications;
    private Temperature temperature;
    private Date lastSeen;

    public Patient(){

    }
    public Patient(String name, int age, Address address,List<Allergy> allergy,List<Disease> diseases) {
        super(name, age, address);
        this.allergy=allergy;
        this.diseases=diseases;

    }

    public Patient(String name, int age, Address address,List<Allergy> allergy,List<Disease> diseases,List<Medication> medications) {
        super(name, age, address);
        this.allergy=allergy;
        this.diseases=diseases;
        this.medications=medications;
    }

    public Patient(String name, int age, Address address,List<Allergy> allergy,List<Disease> diseases,List<Medication> medications,Temperature temperature) {
        super(name, age, address);
        this.allergy=allergy;
        this.diseases=diseases;
        this.medications=medications;
        this.temperature=temperature;
    }

    public Patient(String name, int age, Address address,List<Allergy> allergy,List<Disease> diseases,List<Medication> medications,Temperature temperature,Date lastSeen) {
        super(name, age, address);
        this.allergy=allergy;
        this.diseases=diseases;
        this.medications=medications;
        this.temperature=temperature;
        this.lastSeen=lastSeen;
    }

    public List<Allergy> getAllergy(){
        return allergy;
    }

    public void setAllergy(List<Allergy> allergy){
        this.allergy=allergy;
    }
    public List<Medication> getMedications(){
        return medications;
    }

    public void setMedications(List<Medication> medications){
        this.medications=medications;
    }

    public List<Disease> getDiseases(){
        return diseases;
    }

    public void setDiseases(List<Disease> diseases){
        this.diseases=diseases;
    }

    public Date getLastSeen(){
        return lastSeen;
    }
    public void setLastSeen(Date lastSeen){
        this.lastSeen=lastSeen;
    }

    public boolean checkFever(){
        return temperature.getTemperatureInFarenheit()>100 ? true : false;
    }

    public String getFullAllergy(){
        String fullAllergy=String.format("%s has the following allergies:\n",this.getName());

        for (int i = 0; i < this.getAllergy().size(); i++) {
            fullAllergy += String.format("%s with a %s severity.",
                    this.getAllergy().get(i).getAllergyName(),
                    this.getAllergy().get(i).getSeverity()
            );
            fullAllergy += "\n";
        }

        return fullAllergy;

    }

    public String getFullDiseases(){
        String fullDiseases = String.format("%s has the next diseases: \n", this.getName());

        for (int i = 0; i < this.getDiseases().size(); i++) {
            fullDiseases += String.format("%s disease.",
                    this.getDiseases().get(i).getName()
            );
            fullDiseases += "\n";
        }

        return fullDiseases;
    }

    public String getFullMedicines(){
        String medicines = String.format("%s has the next medicines: ", this.getName());

        for (int i = 0; i < this.getMedications().size(); i++) {
            final String medicine;
            if (this.getMedications().get(i).getEndDate() != null) {
                medicine = String.format("%s from %s to %s.",
                        this.getMedications().get(i).getName(),
                        this.getMedications().get(i).getStartDate(),
                        this.getMedications().get(i).getEndDate()
                );
            } else {
                medicine = String.format("%s since %s.",
                        this.getMedications().get(i).getName(),
                        this.getMedications().get(i).getStartDate()
                );
            }
            medicines += medicine + "\n";
        }

        return medicines;
    }


    public boolean hasMedicines(){
        return ( this.getMedications().size() > 0 ) ? true : false ;
    }





}
