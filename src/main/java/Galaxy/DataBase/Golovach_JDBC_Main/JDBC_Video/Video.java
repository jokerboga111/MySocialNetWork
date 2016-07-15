package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Video;

/**
 * Created by Admin on 21.02.2016.
 */
public class Video {
    private String id;
    private  String NameVideo;
    private  String AdresVideo;

    public String getAdresVideo() {
        return AdresVideo;
    }

    public void setAdresVideo(String adresVideo) {
        AdresVideo = adresVideo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameVideo() {
        return NameVideo;
    }

    public void setNameVideo(String nameVideo) {
        NameVideo = nameVideo;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id='" + id + '\'' +
                ", NameVideo='" + NameVideo + '\'' +
                '}';
    }
}
