package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Hobbys;

/**
 * Created by Admin on 12.02.2016.
 */
public class User_Hobbys {
    private String Hobbys;
    private String Interests;
    private String FavoriteMusic;
    private String FavoriteFilm;
    private String FavoriteTvShow;
    private String FavoriteBooks;
    private String FavoriteGames;
    private String FavoriteNovels;
    private String FavoriteKeyInfo;

    public String getHobbys() {
        return Hobbys;
    }

    public void setHobbys(String hobbys) {
        Hobbys = hobbys;
    }

    public String getInterests() {
        return Interests;
    }

    public void setInterests(String interests) {
        Interests = interests;
    }

    public String getFavoriteMusic() {
        return FavoriteMusic;
    }

    public void setFavoriteMusic(String favoriteMusic) {
        FavoriteMusic = favoriteMusic;
    }

    public String getFavoriteFilm() {
        return FavoriteFilm;
    }

    public void setFavoriteFilm(String favoriteFilm) {
        FavoriteFilm = favoriteFilm;
    }

    public String getFavoriteTvShow() {
        return FavoriteTvShow;
    }

    public void setFavoriteTvShow(String favoriteTvShow) {
        FavoriteTvShow = favoriteTvShow;
    }

    public String getFavoriteBooks() {
        return FavoriteBooks;
    }

    public void setFavoriteBooks(String favoriteBooks) {
        FavoriteBooks = favoriteBooks;
    }

    public String getFavoriteGames() {
        return FavoriteGames;
    }

    public void setFavoriteGames(String favoriteGames) {
        FavoriteGames = favoriteGames;
    }

    public String getFavoriteNovels() {
        return FavoriteNovels;
    }

    public void setFavoriteNovels(String favoriteNovels) {
        FavoriteNovels = favoriteNovels;
    }

    public String getFavoriteKeyInfo() {
        return FavoriteKeyInfo;
    }

    public void setFavoriteKeyInfo(String favoriteKeyInfo) {
        FavoriteKeyInfo = favoriteKeyInfo;
    }

    @Override
    public String toString() {
        return "User_Hobbys{" +
                "Hobbys='" + Hobbys + '\'' +
                ", Interests='" + Interests + '\'' +
                ", FavoriteMusic='" + FavoriteMusic + '\'' +
                ", FavoriteFilm='" + FavoriteFilm + '\'' +
                ", FavoriteTvShow='" + FavoriteTvShow + '\'' +
                ", FavoriteBooks='" + FavoriteBooks + '\'' +
                ", FavoriteGames='" + FavoriteGames + '\'' +
                ", FavoriteNovels='" + FavoriteNovels + '\'' +
                ", FavoriteKeyInfo='" + FavoriteKeyInfo + '\'' +
                '}';
    }
}
