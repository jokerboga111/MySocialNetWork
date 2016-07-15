package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Svayzi_so_mnoy;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Options_Page.Options_Page;

/**
 * Created by Admin on 15.02.2016.
 */
public interface Dao_Svyazi_so_mnoy {
    public void Updatewho_write_masage_to_me(String id,String Newwho_write_masage_to_me) throws DBSystemException;
    public void Updatewho_can_duel_me_video(String id,String Newwho_can_duel_me_video) throws DBSystemException;
    public void Updatewho_can_duel_me_aplication(String id,String Newwho_can_duel_me_aplication) throws DBSystemException;
    public void Updatewho_can_acept_me_video(String id,String Newwho_can_acept_me_video) throws DBSystemException;
    public void Updatewho_can_acept_me_aplication(String id,String Newwho_can_acept_me_aplication) throws DBSystemException;
    public Svyazy_so_mnoy SelectUserSvyazy_so_mnoy(String id) throws DBSystemException;
    public void insertSo_mnoyRegister(String userId) throws DBSystemException;
}
