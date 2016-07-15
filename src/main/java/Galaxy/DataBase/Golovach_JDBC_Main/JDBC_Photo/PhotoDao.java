package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Photo;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.GalaxyServlet.TestoviyVariat.SPhoto.Photo;
import Galaxy.UserAccount.User;

/**
 * Created by Admin on 20.01.2016.
 */
public interface PhotoDao {
    public Photo selectAvatarByIdUser(String idUser) throws DBSystemException;
    public void insertAvatar(String idUser,String NameAvatar) throws DBSystemException;
}
