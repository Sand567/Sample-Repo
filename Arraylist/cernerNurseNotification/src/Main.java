import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sharath Nagendra on 9/22/2017.
 */
public class Main {

    public static void main(String[] args) {


        List<Frequency> freque1 = new ArrayList<Frequency>();

        Nurse alice = new Nurse("Alice");
        alice.addTime(Frequency.PartoftheDay.Morning);
        alice.addTime(Frequency.PartoftheDay.Afternoon);

        Nurse bob = new Nurse("Bob");
        bob.addTime(Frequency.PartoftheDay.Afternoon);
        bob.addTime(Frequency.PartoftheDay.Evening);


        Medicine med1 = new Medicine("Paracetemol", "38g", "For fever");
        med1.setFrequencyList(freque1);


        List<Frequency> freque2 = new ArrayList<Frequency>();

        Medicine med2 = new Medicine("Ibuprofen", "38g", "For body pains");
        med2.setFrequencyList(freque2);

        List<Medicine> medicineList = new ArrayList<Medicine>();
        medicineList.add(med1);
        medicineList.add(med2);

        Scheduler scheduler = new Scheduler();
        scheduler.addListener(alice);
        scheduler.addListener(bob);

        Patient patient1 = new Patient("Deepthi", "For body pains");
        patient1.setMedicineList(medicineList);

        List<Patient> patientList = new ArrayList<Patient>();
        patientList.add(patient1);

        for (Patient patientt : patientList) {
            System.out.println(patientt.getDisease());
            System.out.println(patientt.getName());

            for (Medicine medi : patientt.getMedicineList()) {

                System.out.println(medi.getDetails() + medi.getComposition()
                        + medi.getName());

                for (Frequency freq : medi.getFrequencyList()) {
                    System.out.println(freq.part);
                }

            }


            // Show who is scheduled to respond to alarms and when
            scheduler.rollCall();

            // Do this if "Morning" has arrived
            System.out.println("Morning now! ----------------");
            scheduler.notifyListeners(Frequency.PartoftheDay.Morning);
            System.out.println("");

            // Do this if "Afternoon" has arrived
            System.out.println("Afternoon now! --------------");
            scheduler.notifyListeners(Frequency.PartoftheDay.Afternoon);
            System.out.println("");

            // Do this if "Evening" has arrived
            System.out.println("Evening now! --------------");
            scheduler.notifyListeners(Frequency.PartoftheDay.Evening);
        }
    }
}