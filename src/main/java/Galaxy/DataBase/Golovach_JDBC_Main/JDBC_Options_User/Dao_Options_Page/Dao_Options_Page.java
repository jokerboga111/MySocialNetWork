package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Options_Page;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Ather_Service.Ather_Service;

/**
 * Created by Admin on 15.02.2016.
 */
public interface Dao_Options_Page {
    public void UpdateSkrity_blok_podarkov(String id,String NeweSkrity_blok_podarkov) throws DBSystemException;
    public void UpdateZapisi_moi(String id,String NewZapisi_moi) throws DBSystemException;
    public void UpdateOff_coments(String id,String NewOff_coments) throws DBSystemException;
    public Options_Page SelectUserOptions_Page(String id) throws DBSystemException;
    public void insertPageRegist(String UserId) throws DBSystemException;
}
