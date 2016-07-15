package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Hith_Education;

/**
 * Created by Admin on 12.02.2016.
 */
public class User_Hith_Education {
    private String Country;
    private String Town;
    private String university;
    private  String department;
    private  String chair;
    private   String Mode_of_study;
    private   String Status;
    private   String Release_date;

    public String getTown() {
        return Town;
    }

    public void setTown(String town) {
        Town = town;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getChair() {
        return chair;
    }

    public void setChair(String chair) {
        this.chair = chair;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getMode_of_study() {
        return Mode_of_study;
    }

    public void setMode_of_study(String mode_of_study) {
        Mode_of_study = mode_of_study;
    }

    public String getRelease_date() {
        return Release_date;
    }

    public void setRelease_date(String release_date) {
        Release_date = release_date;
    }

    @Override
    public String toString() {
        return "User_Hith_Education{" +
                "Country='" + Country + '\'' +
                ", Town='" + Town + '\'' +
                ", university='" + university + '\'' +
                ", department='" + department + '\'' +
                ", chair='" + chair + '\'' +
                ", Mode_of_study='" + Mode_of_study + '\'' +
                ", Status='" + Status + '\'' +
                ", Release_date='" + Release_date + '\'' +
                '}';
    }
}
