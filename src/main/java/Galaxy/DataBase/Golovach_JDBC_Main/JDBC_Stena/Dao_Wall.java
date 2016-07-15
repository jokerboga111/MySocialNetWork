package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Stena;

import Galaxy.Chat.DialogExm;
import Galaxy.DataBase.DataBaseException.DBSystemException;

import java.util.List;

/**
 * Created by Admin on 08.03.2016.
 */
public interface Dao_Wall {
    public void insertNewOpisanie(String id,String Opisanie)throws DBSystemException;

    public void updateNewPicture(String id,String Picture)throws DBSystemException;

    public void updateNewVideo(String id,String Video) throws DBSystemException;

    public void updateNewZapisi(String id,String Zapisi) throws DBSystemException;

    public List<Wall> selectListWall(String id) throws DBSystemException;

    public Wall selectWall(String id) throws DBSystemException;

}
