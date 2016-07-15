package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Hobbys;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Info.Iformation_User;

/**
 * Created by Admin on 12.02.2016.
 */
public interface Dao_User_Hobbys {
    public void UpdateHobbyUser(String id,String NewHobbyUser) throws DBSystemException;
    public void UpdateInterests(String id,String NewInterests) throws DBSystemException;
    public void UpdateFavoriteMusic(String id,String NewFavoriteMusic) throws DBSystemException;
    public void UpdateFavoriteFilm(String id,String NewFavoriteFilm) throws DBSystemException;
    public void UpdateFavoriteTvShow(String id,String NewFavoriteTvShow) throws DBSystemException;
    public void UpdateFavoriteBooks(String id,String NewFavoriteBooks) throws DBSystemException;
    public void UpdateFavoriteGames(String id,String NewFavoriteGames) throws DBSystemException;
    public void UpdateFavoriteNovels(String id,String NewFavoriteNovels) throws DBSystemException;
    public void UpdateKeyInfo(String id,String NewKeyInfo) throws DBSystemException;
    public User_Hobbys SelectUserHobbys(String id) throws DBSystemException;
    public void insertHobbyRegister(String userId) throws DBSystemException;
}
