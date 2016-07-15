package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Photo.JDBC_Picture;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.GalaxyServlet.TestoviyVariat.SPhoto.Photo;

import java.util.List;

/**
 * Created by Admin on 21.02.2016.
 */
public interface Dao_Picture {
    public List<Photo> selectPictureByIdUser(String idUser) throws DBSystemException;
}
