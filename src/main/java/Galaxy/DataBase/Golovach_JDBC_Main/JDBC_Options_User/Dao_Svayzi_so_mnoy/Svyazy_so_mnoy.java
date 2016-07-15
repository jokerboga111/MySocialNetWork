package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Svayzi_so_mnoy;

/**
 * Created by Admin on 15.02.2016.
 */
public class Svyazy_so_mnoy {
    private String who_write_masage_to_me;
    private String who_can_duel_me_video;
    private String who_can_duel_me_aplication;
    private String who_can_acept_me_video;
    private  String who_can_acept_me_aplication;

    public String getWho_write_masage_to_me() {
        return who_write_masage_to_me;
    }

    public void setWho_write_masage_to_me(String who_write_masage_to_me) {
        this.who_write_masage_to_me = who_write_masage_to_me;
    }

    public String getWho_can_duel_me_video() {
        return who_can_duel_me_video;
    }

    public void setWho_can_duel_me_video(String who_can_duel_me_video) {
        this.who_can_duel_me_video = who_can_duel_me_video;
    }

    public String getWho_can_duel_me_aplication() {
        return who_can_duel_me_aplication;
    }

    public void setWho_can_duel_me_aplication(String who_can_duel_me_aplication) {
        this.who_can_duel_me_aplication = who_can_duel_me_aplication;
    }

    public String getWho_can_acept_me_video() {
        return who_can_acept_me_video;
    }

    public void setWho_can_acept_me_video(String who_can_acept_me_video) {
        this.who_can_acept_me_video = who_can_acept_me_video;
    }

    public String getWho_can_acept_me_aplication() {
        return who_can_acept_me_aplication;
    }

    public void setWho_can_acept_me_aplication(String who_can_acept_me_aplication) {
        this.who_can_acept_me_aplication = who_can_acept_me_aplication;
    }

    @Override
    public String toString() {
        return "Svyazy_so_mnoy{" +
                "who_write_masage_to_me='" + who_write_masage_to_me + '\'' +
                ", who_can_duel_me_video='" + who_can_duel_me_video + '\'' +
                ", who_can_duel_me_aplication='" + who_can_duel_me_aplication + '\'' +
                ", who_can_acept_me_video='" + who_can_acept_me_video + '\'' +
                ", who_can_acept_me_aplication='" + who_can_acept_me_aplication + '\'' +
                '}';
    }
}
