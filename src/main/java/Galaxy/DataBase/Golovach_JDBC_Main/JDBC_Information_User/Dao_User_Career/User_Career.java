package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.Dao_User_Career;

/**
 * Created by Admin on 12.02.2016.
 */
public class User_Career {
    private String Country;
    private String Town;
    private String Place_To_work;
    private String Position;
    private String Year_Start_Study;

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getTown() {
        return Town;
    }

    public void setTown(String town) {
        Town = town;
    }

    public String getPlace_To_work() {
        return Place_To_work;
    }

    public void setPlace_To_work(String place_To_work) {
        Place_To_work = place_To_work;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public String getYear_Start_Study() {
        return Year_Start_Study;
    }

    public void setYear_Start_Study(String year_Start_Study) {
        Year_Start_Study = year_Start_Study;
    }

    public String getYear_End_Study() {
        return Year_End_Study;
    }

    public void setYear_End_Study(String year_End_Study) {
        Year_End_Study = year_End_Study;
    }

    String Year_End_Study;

    @Override
    public String toString() {
        return "User_Career{" +
                "Country='" + Country + '\'' +
                ", Town='" + Town + '\'' +
                ", Place_To_work='" + Place_To_work + '\'' +
                ", Position='" + Position + '\'' +
                ", Year_Start_Study='" + Year_Start_Study + '\'' +
                ", Year_End_Study='" + Year_End_Study + '\'' +
                '}';
    }
}
