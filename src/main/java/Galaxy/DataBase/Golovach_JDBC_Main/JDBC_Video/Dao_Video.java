package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Video;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.GalaxyServlet.TestoviyVariat.SPhoto.Photo;

import java.util.List;

/**
 * Created by Admin on 21.02.2016.
 */
public interface Dao_Video {
    public List<Video> selectVideoByIdUser(String idUser) throws DBSystemException;
}
