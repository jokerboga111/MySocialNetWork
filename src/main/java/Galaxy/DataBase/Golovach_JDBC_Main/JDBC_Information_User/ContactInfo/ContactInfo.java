package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.ContactInfo;

/**
 * Created by Admin on 11.02.2016.
 */
public class ContactInfo {
    private String Country;
    private String Town;
    private  String House;
    private  String MyPhone;
    private  String Skype;
    private String YourSite;

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getHouse() {
        return House;
    }

    public void setHouse(String house) {
        House = house;
    }

    public String getTown() {
        return Town;
    }

    public void setTown(String town) {
        Town = town;
    }

    public String getMyPhone() {
        return MyPhone;
    }

    public void setMyPhone(String myPhone) {
        MyPhone = myPhone;
    }

    public String getSkype() {
        return Skype;
    }

    public void setSkype(String skype) {
        Skype = skype;
    }

    public String getYourSite() {
        return YourSite;
    }

    public void setYourSite(String yourSite) {
        YourSite = yourSite;
    }

    @Override
    public String toString() {
        return "ContactInfo{" +
                "Country='" + Country + '\'' +
                ", Town='" + Town + '\'' +
                ", House='" + House + '\'' +
                ", MyPhone='" + MyPhone + '\'' +
                ", Skype='" + Skype + '\'' +
                ", YourSite='" + YourSite + '\'' +
                '}';
    }
}
