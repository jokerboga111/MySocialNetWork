package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Moment_Opoveshenie;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Ather_Service.Ather_Service;

/**
 * Created by Admin on 15.02.2016.
 */
public interface Dao_Moment_opoveshenye {

    public void Update_opovechenie_of_all(String id,String New_opovechenie_of_all) throws DBSystemException;
    public void Update_saw_the_massege(String id,String New_saw_the_massege) throws DBSystemException;
    public void Update_listen_audio_masage(String id,String New_listen_audio_masage) throws DBSystemException;
    public Moment_Opoveshenye SelectUserMoment_Opoveshenye(String id) throws DBSystemException;
    public void insertMomentRegister(String idUser) throws DBSystemException;

}
