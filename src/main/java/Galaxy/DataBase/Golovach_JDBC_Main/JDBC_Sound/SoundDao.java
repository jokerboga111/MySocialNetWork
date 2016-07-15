package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Sound;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.GalaxyServlet.TestoviyVariat.SPhoto.Photo;
import Galaxy.GalaxyServlet.TestoviyVariat.SSound.Sound;

import java.util.List;

/**
 * Created by Admin on 20.01.2016.
 */
public interface SoundDao {
    public List<Sound> selectAllSound() throws DBSystemException;
    public void insertSound(String idUser, String NameSound) throws DBSystemException;
    public List<Sound> selectSoundByUserId(String idUser) throws DBSystemException;
}
