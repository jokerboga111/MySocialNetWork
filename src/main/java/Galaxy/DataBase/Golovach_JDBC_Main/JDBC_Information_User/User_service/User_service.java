package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_service;

/**
 * Created by Admin on 12.02.2016.
 */
public class User_service {
    private String Country;
    private String service_war;

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getService_war() {
        return service_war;
    }

    public void setService_war(String service_war) {
        this.service_war = service_war;
    }

    @Override
    public String toString() {
        return "User_service{" +
                "Country='" + Country + '\'' +
                ", service_war='" + service_war + '\'' +
                '}';
    }
}
