import java.util.Date;

/**
 * Created by Sharath Nagendra on 9/19/2017.
 */
public class Medication {
    private String name;
    private Date start;
    private Date endDate;


    public Medication(String name,Date start,Date endDate){
        this.name=name;
        this.start=start;
        this.endDate=endDate;
    }


    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;

    }

    public Date getStartDate(){
        return start;
    }
    public void setStartDate(Date start){
        this.start=start;
    }

    public Date getEndDate(){
        return endDate;
    }
    public void setEndDate(Date endDate){
        this.endDate=endDate;
    }

}
