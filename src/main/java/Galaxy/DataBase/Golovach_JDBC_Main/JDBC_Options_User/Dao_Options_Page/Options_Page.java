package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Options_Page;

/**
 * Created by Admin on 15.02.2016.
 */
public class Options_Page {
    private String skrity_blok_podarkov;
    private String Zapisi_moi;
    private String Off_coments;

    public String getSkrity_blok_podarkov() {
        return skrity_blok_podarkov;
    }

    public void setSkrity_blok_podarkov(String skrity_blok_podarkov) {
        this.skrity_blok_podarkov = skrity_blok_podarkov;
    }

    public String getZapisi_moi() {
        return Zapisi_moi;
    }

    public void setZapisi_moi(String zapisi_moi) {
        Zapisi_moi = zapisi_moi;
    }

    public String getOff_coments() {
        return Off_coments;
    }

    public void setOff_coments(String off_coments) {
        Off_coments = off_coments;
    }

    @Override
    public String toString() {
        return "Options_Page{" +
                "skrity_blok_podarkov='" + skrity_blok_podarkov + '\'' +
                ", Zapisi_moi='" + Zapisi_moi + '\'' +
                ", Off_coments='" + Off_coments + '\'' +
                '}';
    }
}
