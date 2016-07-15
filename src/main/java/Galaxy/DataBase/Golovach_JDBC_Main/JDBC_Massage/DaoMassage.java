package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Massage;

import Galaxy.Chat.DialogExm;
import Galaxy.Chat.massage.Masege;
import Galaxy.DataBase.DataBaseException.DBSystemException;

import java.util.List;

/**
 * Created by Admin on 03.02.2016.
 */
public interface DaoMassage {
    public void insertNewMassage(String id,String massage,String login)throws DBSystemException;

    public void insertNewDialog(int idDialog,String massage,String id,String idfriend)throws DBSystemException;

    public boolean selectDialog(String login) throws DBSystemException;

    public List<DialogExm> selectDialog4(String id) throws DBSystemException;

    public List<String> selectMassage(String id,String idDialog) throws DBSystemException;

    public void insertNewMassage1(Masege masege) throws DBSystemException;
    public List<Masege> selectMasege(String id,String idDialog) throws DBSystemException;

    public boolean checkDialog(String idFirst,String idSecond) throws DBSystemException;

    public int selectMaxId(String id)throws DBSystemException;

    public int selectIdDialog(String idFirst,String idSecond) throws DBSystemException;

}
