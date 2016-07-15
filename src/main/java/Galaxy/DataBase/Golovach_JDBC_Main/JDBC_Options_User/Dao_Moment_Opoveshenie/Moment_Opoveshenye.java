package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Moment_Opoveshenie;

/**
 * Created by Admin on 15.02.2016.
 */
public class Moment_Opoveshenye {
    private String opovechenie_of_all;
    private String saw_the_massege;
    private String listen_audio_masage;

    public String getOpovechenie_of_all() {
        return opovechenie_of_all;
    }

    public void setOpovechenie_of_all(String opovechenie_of_all) {
        this.opovechenie_of_all = opovechenie_of_all;
    }

    public String getSaw_the_massege() {
        return saw_the_massege;
    }

    public void setSaw_the_massege(String saw_the_massege) {
        this.saw_the_massege = saw_the_massege;
    }

    public String getListen_audio_masage() {
        return listen_audio_masage;
    }


    public void setListen_audio_masage(String listen_audio_masage) {
        this.listen_audio_masage = listen_audio_masage;
    }

    @Override
    public String toString() {
        return "Moment_Opoveshenye{" +
                "opovechenie_of_all='" + opovechenie_of_all + '\'' +
                ", saw_the_massege='" + saw_the_massege + '\'' +
                ", listen_audio_masage='" + listen_audio_masage + '\'' +
                '}';
    }
}

