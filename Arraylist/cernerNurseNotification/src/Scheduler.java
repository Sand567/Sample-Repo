import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sharath Nagendra on 9/22/2017.
 */
public class Scheduler {
    List<AlarmListener> alarmListenerList = new ArrayList<>();

    public void addListener(AlarmListener alarmListener) {
        alarmListenerList.add(alarmListener);
    }

    public void rollCall() {
        System.out.println("Roll call:");
        for (AlarmListener a : alarmListenerList) {
            System.out.println(a.toString());
        }
    }

    public void notifyListeners(Frequency.PartoftheDay time) {
        for (AlarmListener a : alarmListenerList) {
            a.notify(time, time.name());
        }
    }

}
