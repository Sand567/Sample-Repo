import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Sharath Nagendra on 9/22/2017.
 */
//extends thread and records temperature every 10 seconds and stores in list..variation..can also store in hashmap
public class Main extends Thread {

    public static void main(String[] args) {

        Temperature temp = new Temperature();
        Patient pt = new Patient();
        Allergy allergy = new Allergy();
        Thread t = new Thread();
        List<Double> list = new ArrayList<>();


        // al.setAllergyList(allergyList);

        while (true) {
            System.out.println("Default temperatures: " + temp.setDefaultTemp() + "C OR " + temp.getTemperatureInFarenheit() + "F");
            System.out.println("1.Convert Celcius to Fareiheit");
            System.out.println("2.Convert Fareiheit to Celcius");
            System.out.println("3.Update default temperature");
            System.out.println("4.Get list of allergies");
            System.out.println("5.Record temperature every 10 seconds");
            Scanner sc = new Scanner(System.in);
            int input = sc.nextInt();
            switch (input) {
                case 1:
                    System.out.println("Enter temperature in Celcius to convert into Farenheit");
                    double celsius = sc.nextDouble();
                    temp.setTemperature((float) celsius);
                    System.out.println(celsius + "C = " + temp.getTemperatureInFarenheit() + "F");
                    break;
                case 2:
                    System.out.println("Enter temperature in Farenheit to convert into Celcius");
                    double fahrenheit = sc.nextDouble();
                    System.out.println(fahrenheit + "F = " + temp.getTemperature() + "C");
                    break;
                case 3:
                    System.out.println("Enter temperature in celcius");
                    temp.setTemperature(temp.getTemperature());
                    break;
                case 4:
                    System.out.println(allergy.getAllergyList());
                    break;
                case 5:
                    System.out.println("enter the number of seconds interval");
//                    int n=sc.nextInt();
//                    System.out.println("Enter temp to record every"+n+" seconds:");
                    for(int i=1;i<=5;i++) {
                        try {

                            list.add(sc.nextDouble());
                            Thread.sleep(5000);
                            System.out.println("Please enter your input again");


                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                        for (int i = 0; i < list.size(); i++)
                            System.out.println(list.get(i));

                        break;

                default:
                    System.out.println("Invalid input.");
            }
        }
    }
}



