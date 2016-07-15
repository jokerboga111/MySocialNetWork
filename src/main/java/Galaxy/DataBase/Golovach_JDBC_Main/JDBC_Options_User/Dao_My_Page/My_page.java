package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_My_Page;

/**
 * Created by Admin on 15.02.2016.
 */
public class My_page {
    private String who_saw_my_info;
    private String who_saw_photo_in_what_you_acept;
    private String who_saw_video_in_what_you_acept;
    private String who_saw_spisok_group;
    private  String who_saw_spisok_audio;
    private  String who_saw_spisok_surprise;
    private String who_saw_map_photos;
    private  String who_saw_friends_and_pidpish;
    private String who_saw_my_skritish_friends;

    public String getWho_saw_my_info() {
        return who_saw_my_info;
    }

    public void setWho_saw_my_info(String who_saw_my_info) {
        this.who_saw_my_info = who_saw_my_info;
    }

    public String getWho_saw_photo_in_what_you_acept() {
        return who_saw_photo_in_what_you_acept;
    }

    public void setWho_saw_photo_in_what_you_acept(String who_saw_photo_in_what_you_acept) {
        this.who_saw_photo_in_what_you_acept = who_saw_photo_in_what_you_acept;
    }

    public String getWho_saw_video_in_what_you_acept() {
        return who_saw_video_in_what_you_acept;
    }

    public void setWho_saw_video_in_what_you_acept(String who_saw_video_in_what_you_acept) {
        this.who_saw_video_in_what_you_acept = who_saw_video_in_what_you_acept;
    }

    public String getWho_saw_spisok_group() {
        return who_saw_spisok_group;
    }

    public void setWho_saw_spisok_group(String who_saw_spisok_group) {
        this.who_saw_spisok_group = who_saw_spisok_group;
    }

    public String getWho_saw_spisok_audio() {
        return who_saw_spisok_audio;
    }

    public void setWho_saw_spisok_audio(String who_saw_spisok_audio) {
        this.who_saw_spisok_audio = who_saw_spisok_audio;
    }

    public String getWho_saw_spisok_surprise() {
        return who_saw_spisok_surprise;
    }

    public void setWho_saw_spisok_surprise(String who_saw_spisok_surprise) {
        this.who_saw_spisok_surprise = who_saw_spisok_surprise;
    }

    public String getWho_saw_map_photos() {
        return who_saw_map_photos;
    }

    public void setWho_saw_map_photos(String who_saw_map_photos) {
        this.who_saw_map_photos = who_saw_map_photos;
    }

    public String getWho_saw_friends_and_pidpish() {
        return who_saw_friends_and_pidpish;
    }

    public void setWho_saw_friends_and_pidpish(String who_saw_friends_and_pidpish) {
        this.who_saw_friends_and_pidpish = who_saw_friends_and_pidpish;
    }

    public String getWho_saw_my_skritish_friends() {
        return who_saw_my_skritish_friends;
    }

    public void setWho_saw_my_skritish_friends(String who_saw_my_skritish_friends) {
        this.who_saw_my_skritish_friends = who_saw_my_skritish_friends;
    }

    @Override
    public String toString() {
        return "My_page{" +
                "who_saw_my_info='" + who_saw_my_info + '\'' +
                ", who_saw_photo_in_what_you_acept='" + who_saw_photo_in_what_you_acept + '\'' +
                ", who_saw_video_in_what_you_acept='" + who_saw_video_in_what_you_acept + '\'' +
                ", who_saw_spisok_group='" + who_saw_spisok_group + '\'' +
                ", who_saw_spisok_audio='" + who_saw_spisok_audio + '\'' +
                ", who_saw_spisok_surprise='" + who_saw_spisok_surprise + '\'' +
                ", who_saw_map_photos='" + who_saw_map_photos + '\'' +
                ", who_saw_friends_and_pidpish='" + who_saw_friends_and_pidpish + '\'' +
                ", who_saw_my_skritish_friends='" + who_saw_my_skritish_friends + '\'' +
                '}';
    }
}
