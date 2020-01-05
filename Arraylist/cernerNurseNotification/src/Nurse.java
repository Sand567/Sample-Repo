import java.util.HashSet;
import java.util.Set;

/**
 * Created by Sharath Nagendra on 9/22/2017.
 */
public class Nurse implements AlarmListener {
    private String name;
    private Set<Frequency.PartoftheDay> times = new HashSet<>();
    Patient a = new Patient("patient1", "fever");
    Patient b = new Patient("patient2", "post operative care");


    Set<Patient> patientSet = new HashSet<>();


    Nurse(String name) {
        this.name = name;
    }

    // Add times of day that this nurse will be notified
    public void addTime(Frequency.PartoftheDay time) {
        this.times.add(time);
    }

    @Override
    public void notify(Frequency.PartoftheDay time, String msg) {
        if (times.contains(time)) {
            patientSet.add(a);
            patientSet.add(b);
            for (Patient a : patientSet)
                System.out.println("Nurse " + name + ", you are being notified to give medicines for:  " + a.getName() + " for the disease :" + a.getDisease());
        }
    }

    @Override
    public String toString() {
        StringBuffer b = new StringBuffer();
        b.append(name).append(":  scheduled for\n");
        for (Frequency.PartoftheDay time : times) {
            b.append("  ").append(time).append("\n");
        }

        return b.toString();
    }
}



