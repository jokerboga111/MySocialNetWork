package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Education;

/**
 * Created by Admin on 12.02.2016.
 */
public class User_Education {
    private String Country;
    private  String Town;
    private  String School;
    private  String Y_S_Study;
    private  String Y_E_Study;
    private   String Data_End;
    private   String Class1;
    private   String Spechializeshion;

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

    public String getSchool() {
        return School;
    }

    public void setSchool(String school) {
        School = school;
    }

    public String getY_S_Study() {
        return Y_S_Study;
    }

    public void setY_S_Study(String y_S_Study) {
        Y_S_Study = y_S_Study;
    }

    public String getY_E_Study() {
        return Y_E_Study;
    }

    public void setY_E_Study(String y_E_Study) {
        Y_E_Study = y_E_Study;
    }

    public String getData_End() {
        return Data_End;
    }

    public void setData_End(String data_End) {
        Data_End = data_End;
    }

    public String getClass1() {
        return Class1;
    }

    public void setClass1(String class1) {
        Class1 = class1;
    }

    public String getSpechializeshion() {
        return Spechializeshion;
    }

    public void setSpechializeshion(String spechializeshion) {
        Spechializeshion = spechializeshion;
    }

    @Override
    public String toString() {
        return "User_Education{" +
                "Country='" + Country + '\'' +
                ", Town='" + Town + '\'' +
                ", School='" + School + '\'' +
                ", Y_S_Study='" + Y_S_Study + '\'' +
                ", Y_E_Study='" + Y_E_Study + '\'' +
                ", Data_End='" + Data_End + '\'' +
                ", Class1='" + Class1 + '\'' +
                ", Spechializeshion='" + Spechializeshion + '\'' +
                '}';
    }
}
