/**
 * Created by Sharath Nagendra on 9/19/2017.
 */
public class Address {
    private String country;
    private String state;
    private String city;
    private int phoneNumber;

    public Address(String country,String state,String city,int phoneNumber){
        this.country=country;
        this.state=state;
        this.city=city;
        this.phoneNumber=phoneNumber;
    }

    public String getCountry(){
        return country;
    }

    public void setCountry(String country){
        this.country=country;
    }

    public String getState(){
        return state;
    }

    public void setState(String state){
        this.state=state;
    }

    public String getCity(){
        return city;
    }

    public void setCity(String city){
        this.city=city;
    }
    public int getPhoneNumber(){
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber){
        this.phoneNumber=phoneNumber;
    }

}
