package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Info;

/**
 * Created by Admin on 10.02.2016.
 */
public class Iformation_User {

    private String name;
    private String SerName;
    private String Pol;
    private String FamaliOrder;
    private String Town;
    private String languege;
    private String privatBirsday;
    private String month;
    private int year;
    private int Birthday;

    public int getBirthday() {
        return Birthday;
    }

    public void setBirthday(int birthday) {
        Birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSerName() {
        return SerName;
    }

    public void setSerName(String serName) {
        SerName = serName;
    }

    public String getPol() {
        return Pol;
    }

    public void setPol(String pol) {
        Pol = pol;
    }

    public String getFamaliOrder() {
        return FamaliOrder;
    }

    public void setFamaliOrder(String famaliOrder) {
        FamaliOrder = famaliOrder;
    }

    public String getTown() {
        return Town;
    }

    public void setTown(String town) {
        Town = town;
    }

    public String getLanguege() {
        return languege;
    }

    public void setLanguege(String languege) {
        this.languege = languege;
    }

    public String getPrivatBirsday() {
        return privatBirsday;
    }

    public void setPrivatBirsday(String privatBirsday) {
        this.privatBirsday = privatBirsday;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Iformation_User{" +
                "name='" + name + '\'' +
                ", SerName='" + SerName + '\'' +
                ", Pol='" + Pol + '\'' +
                ", FamaliOrder='" + FamaliOrder + '\'' +
                ", Town='" + Town + '\'' +
                ", languege='" + languege + '\'' +
                ", privatBirsday='" + privatBirsday + '\'' +
                ", month='" + month + '\'' +
                ", year='" + year + '\'' +
                ", Birthday='" + Birthday + '\'' +
                '}';
    }
}
