package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_life_Position;

/**
 * Created by Admin on 12.02.2016.
 */
public class User_Life_Position {
    private String Political_answ;
    private String worldview;
    private String main_in_life;
    private  String main_in_people;
    private  String attitude_about_smoking;
    private String attitude_about_alcohole;
    private String Pierian_spring;

    public String getPolitical_answ() {
        return Political_answ;
    }

    public void setPolitical_answ(String political_answ) {
        Political_answ = political_answ;
    }

    public String getWorldview() {
        return worldview;
    }

    public void setWorldview(String worldview) {
        this.worldview = worldview;
    }

    public String getMain_in_life() {
        return main_in_life;
    }

    public void setMain_in_life(String main_in_life) {
        this.main_in_life = main_in_life;
    }

    public String getMain_in_people() {
        return main_in_people;
    }

    public void setMain_in_people(String main_in_people) {
        this.main_in_people = main_in_people;
    }

    public String getAttitude_about_alcohole() {
        return attitude_about_alcohole;
    }

    public void setAttitude_about_alcohole(String attitude_about_alcohole) {
        this.attitude_about_alcohole = attitude_about_alcohole;
    }

    public String getAttitude_about_smoking() {
        return attitude_about_smoking;
    }

    public void setAttitude_about_smoking(String attitude_about_smoking) {
        this.attitude_about_smoking = attitude_about_smoking;
    }

    public String getPierian_spring() {
        return Pierian_spring;
    }

    public void setPierian_spring(String pierian_spring) {
        Pierian_spring = pierian_spring;
    }

    @Override
    public String toString() {
        return "User_Life_Position{" +
                "Political_answ='" + Political_answ + '\'' +
                ", worldview='" + worldview + '\'' +
                ", main_in_life='" + main_in_life + '\'' +
                ", main_in_people='" + main_in_people + '\'' +
                ", attitude_about_smoking='" + attitude_about_smoking + '\'' +
                ", attitude_about_alcohole='" + attitude_about_alcohole + '\'' +
                ", Pierian_spring='" + Pierian_spring + '\'' +
                '}';
    }
}
