/**
 * Created by Sharath Nagendra on 9/22/2017.
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
public interface AlarmListener {

    void notify(Frequency.PartoftheDay time, String msg);
}
