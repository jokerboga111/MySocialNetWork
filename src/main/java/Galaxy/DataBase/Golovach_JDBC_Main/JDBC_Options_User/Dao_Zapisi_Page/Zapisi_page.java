package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Zapisi_Page;

/**
 * Created by Admin on 15.02.2016.
 */
public class Zapisi_page {
    private String who_saw_bad_zapisi;
    private String who_can_cryare_zapisi;
    private String who_saw_coments_to_zapisi;
    private String who_can_coment_my_zapisi;

    public String getWho_saw_bad_zapisi() {
        return who_saw_bad_zapisi;
    }

    public void setWho_saw_bad_zapisi(String who_saw_bad_zapisi) {
        this.who_saw_bad_zapisi = who_saw_bad_zapisi;
    }

    public String getWho_can_cryare_zapisi() {
        return who_can_cryare_zapisi;
    }

    public void setWho_can_cryare_zapisi(String who_can_cryare_zapisi) {
        this.who_can_cryare_zapisi = who_can_cryare_zapisi;
    }

    public String getWho_saw_coments_to_zapisi() {
        return who_saw_coments_to_zapisi;
    }

    public void setWho_saw_coments_to_zapisi(String who_saw_coments_to_zapisi) {
        this.who_saw_coments_to_zapisi = who_saw_coments_to_zapisi;
    }

    public String getWho_can_coment_my_zapisi() {
        return who_can_coment_my_zapisi;
    }

    public void setWho_can_coment_my_zapisi(String who_can_coment_my_zapisi) {
        this.who_can_coment_my_zapisi = who_can_coment_my_zapisi;
    }

    @Override
    public String toString() {
        return "Zapisi_page{" +
                "who_saw_bad_zapisi='" + who_saw_bad_zapisi + '\'' +
                ", who_can_cryare_zapisi='" + who_can_cryare_zapisi + '\'' +
                ", who_saw_coments_to_zapisi='" + who_saw_coments_to_zapisi + '\'' +
                ", who_can_coment_my_zapisi='" + who_can_coment_my_zapisi + '\'' +
                '}';
    }
}
