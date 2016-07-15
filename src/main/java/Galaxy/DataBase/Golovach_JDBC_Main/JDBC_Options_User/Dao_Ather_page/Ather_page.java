package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Ather_page;

/**
 * Created by Admin on 15.02.2016.
 */
public class Ather_page {
    private String who_can_see_my_page;
    private String what_about_can_see;

    public String getWho_can_see_my_page() {
        return who_can_see_my_page;
    }

    public void setWho_can_see_my_page(String who_can_see_my_page) {
        this.who_can_see_my_page = who_can_see_my_page;
    }

    public String getWhat_about_can_see() {
        return what_about_can_see;
    }

    public void setWhat_about_can_see(String what_about_can_see) {
        this.what_about_can_see = what_about_can_see;
    }

    @Override
    public String toString() {
        return "Ather_page{" +
                "who_can_see_my_page='" + who_can_see_my_page + '\'' +
                ", what_about_can_see='" + what_about_can_see + '\'' +
                '}';
    }
}
