package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Opoveshenie_Email;

/**
 * Created by Admin on 16.02.2016.
 */
public class Opoveshenie_Email {
    private String email;
    private String chastota_opoveshenie;
    private String zaiavki_fiends;
    private String vosmoshnie_friends;
    private String lich_massege;
    private String achepted_photo;
    private String masage_wall;
    private String koment_wall;
    private String koment_photo;
    private String coment_video;
    private  String ansewer_coment;
    private String Upominaniya;
    private String acept_group;
    private String meropriyatiya;
    private  String birthday;
    private String surprise;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getChastota_opoveshenie() {
        return chastota_opoveshenie;
    }

    public void setChastota_opoveshenie(String chastota_opoveshenie) {
        this.chastota_opoveshenie = chastota_opoveshenie;
    }

    public String getZaiavki_fiends() {
        return zaiavki_fiends;
    }

    public void setZaiavki_fiends(String zaiavki_fiends) {
        this.zaiavki_fiends = zaiavki_fiends;
    }

    public String getVosmoshnie_friends() {
        return vosmoshnie_friends;
    }

    public void setVosmoshnie_friends(String vosmoshnie_friends) {
        this.vosmoshnie_friends = vosmoshnie_friends;
    }

    public String getLich_massege() {
        return lich_massege;
    }

    public void setLich_massege(String lich_massege) {
        this.lich_massege = lich_massege;
    }

    public String getAchepted_photo() {
        return achepted_photo;
    }

    public void setAchepted_photo(String achepted_photo) {
        this.achepted_photo = achepted_photo;
    }

    public String getMasage_wall() {
        return masage_wall;
    }

    public void setMasage_wall(String masage_wall) {
        this.masage_wall = masage_wall;
    }

    public String getKoment_photo() {
        return koment_photo;
    }

    public void setKoment_photo(String koment_photo) {
        this.koment_photo = koment_photo;
    }

    public String getKoment_wall() {
        return koment_wall;
    }

    public void setKoment_wall(String koment_wall) {
        this.koment_wall = koment_wall;
    }

    public String getComent_video() {
        return coment_video;
    }

    public void setComent_video(String coment_video) {
        this.coment_video = coment_video;
    }

    public String getAnsewer_coment() {
        return ansewer_coment;
    }

    public void setAnsewer_coment(String ansewer_coment) {
        this.ansewer_coment = ansewer_coment;
    }

    public String getUpominaniya() {
        return Upominaniya;
    }

    public void setUpominaniya(String upominaniya) {
        Upominaniya = upominaniya;
    }

    public String getAcept_group() {
        return acept_group;
    }

    public void setAcept_group(String acept_group) {
        this.acept_group = acept_group;
    }

    public String getMeropriyatiya() {
        return meropriyatiya;
    }

    public void setMeropriyatiya(String meropriyatiya) {
        this.meropriyatiya = meropriyatiya;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSurprise() {
        return surprise;
    }

    public void setSurprise(String surprise) {
        this.surprise = surprise;
    }

    @Override
    public String toString() {
        return "Opoveshenie_Email{" +
                "email='" + email + '\'' +
                ", chastota_opoveshenie='" + chastota_opoveshenie + '\'' +
                ", zaiavki_fiends='" + zaiavki_fiends + '\'' +
                ", vosmoshnie_friends='" + vosmoshnie_friends + '\'' +
                ", lich_massege='" + lich_massege + '\'' +
                ", achepted_photo='" + achepted_photo + '\'' +
                ", masage_wall='" + masage_wall + '\'' +
                ", koment_wall='" + koment_wall + '\'' +
                ", koment_photo='" + koment_photo + '\'' +
                ", coment_video='" + coment_video + '\'' +
                ", ansewer_coment='" + ansewer_coment + '\'' +
                ", Upominaniya='" + Upominaniya + '\'' +
                ", acept_group='" + acept_group + '\'' +
                ", meropriyatiya='" + meropriyatiya + '\'' +
                ", birthday='" + birthday + '\'' +
                ", surprise='" + surprise + '\'' +
                '}';
    }
}
