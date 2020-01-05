/**
 * Created by Sharath Nagendra on 10/15/2017.
 */
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class cernerMedicationFrequency {

    private static Scanner input;
    public static void main(String args[]) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");

        System.out.println("when to begin taking the medication (Year,month,day of month,hour, minute");
        input = new Scanner(System.in);

        String begin = input.nextLine();
        String[] parts = begin.split(",");
        Calendar calendar = new GregorianCalendar(Integer.parseInt(parts[0]),Integer.parseInt(parts[1])-1,Integer.parseInt(parts[2]),Integer.parseInt(parts[3]),Integer.parseInt(parts[4]),00);
        System.out.println(sdf.format(calendar.getTime()));
        System.out.println("when to end");

        String end = input.nextLine();
        String[] parts2 = end.split(",");
        Calendar calendar2 = new GregorianCalendar(Integer.parseInt(parts2[0]),Integer.parseInt(parts2[1])-1,Integer.parseInt(parts2[2]),Integer.parseInt(parts2[3]),Integer.parseInt(parts2[4]),00);
        System.out.println(sdf.format(calendar2.getTime()));

        System.out.println("proper dosage");
        String dosage = input.nextLine();

        System.out.println("frequency (hours between medication)");
        int frequence = input.nextInt();

        calendar.add(Calendar.HOUR_OF_DAY,frequence);
        System.out.println("The second scheduled medication is: " + sdf.format(calendar.getTime()));

    }
}
