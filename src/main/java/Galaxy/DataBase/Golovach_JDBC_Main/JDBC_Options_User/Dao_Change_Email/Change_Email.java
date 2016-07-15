package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Change_Email;

/**
 * Created by Admin on 15.02.2016.
 */
public class Change_Email {
    private String old_email;
    private String newEmail;

    public String getOld_email() {
        return old_email;
    }

    public void setOld_email(String old_email) {
        this.old_email = old_email;
    }

    public String getNewEmail() {
        return newEmail;
    }

    public void setNewEmail(String newEmail) {
        this.newEmail = newEmail;
    }

    @Override
    public String toString() {
        return "Change_Email{" +
                "old_email='" + old_email + '\'' +
                ", newEmail='" + newEmail + '\'' +
                '}';
    }
}
