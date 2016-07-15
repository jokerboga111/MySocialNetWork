package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Stena;

/**
 * Created by Admin on 08.03.2016.
 */
public class Wall {
    String opisanie;
    String zapisi;
    String picture;
    String video;

    public String getZapisi() {
        return zapisi;
    }

    public void setZapisi(String zapisi) {
        this.zapisi = zapisi;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getOpisanie() {
        return opisanie;
    }

    public void setOpisanie(String opisanie) {
        this.opisanie = opisanie;
    }

    @Override
    public String toString() {
        return "Wall{" +
                "opisanie='" + opisanie + '\'' +
                ", zapisi='" + zapisi + '\'' +
                ", picture='" + picture + '\'' +
                ", video='" + video + '\'' +
                '}';
    }
}
