package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Change_password;

/**
 * Created by Admin on 15.02.2016.
 */
public class Change_Pasword {
    private String old_password;
    private String new_password;
    private String repite_password;

    public String getOld_password() {
        return old_password;
    }

    public void setOld_password(String old_password) {
        this.old_password = old_password;
    }

    public String getNew_password() {
        return new_password;
    }

    public void setNew_password(String new_password) {
        this.new_password = new_password;
    }

    public String getRepite_password() {
        return repite_password;
    }

    public void setRepite_password(String repite_password) {
        this.repite_password = repite_password;
    }

    @Override
    public String toString() {
        return "Change_Pasword{" +
                "old_password='" + old_password + '\'' +
                ", new_password='" + new_password + '\'' +
                ", repite_password='" + repite_password + '\'' +
                '}';
    }
}
