package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Opoveshenie_Email;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Ather_Service.Ather_Service;

/**
 * Created by Admin on 16.02.2016.
 */
public interface Dao_Opoveshenie_Email {
    public void UpdateMy_email(String id,String NewMy_email) throws DBSystemException;
    public void UpdateMy_chastota_opoveshenie(String id,String NewMy_chastota_opoveshenie) throws DBSystemException;
    public void UpdateMy_zaiavki_fiends(String id,String NewMy_zaiavki_fiends) throws DBSystemException;
    public void UpdateMy_vosmoshnie_friends(String id,String NewMy_vosmoshnie_friends) throws DBSystemException;
    public void UpdateMy_lich_massege(String id,String NewMy_lich_massege) throws DBSystemException;
    public void UpdateMy_achepted_photo(String id,String NewMy_achepted_photo) throws DBSystemException;
    public void UpdateMy_masage_wall(String id,String NewMy_masage_wall) throws DBSystemException;
    public void UpdateMy_koment_wall(String id,String NewMy_koment_wall) throws DBSystemException;
    public void UpdateMy_koment_photo(String id,String NewMy_koment_photo) throws DBSystemException;
    public void UpdateMy_coment_video(String id,String NewMy_coment_video) throws DBSystemException;
    public void UpdateMy_ansewer_coment(String id,String NewMy_ansewer_coment) throws DBSystemException;
    public void UpdateMy_Upominaniya(String id,String NewMy_Upominaniya) throws DBSystemException;
    public void UpdateMy_acept_group(String id,String NewMy_acept_group) throws DBSystemException;
    public void UpdateMy_meropriyatiya(String id,String NewMy_meropriyatiya) throws DBSystemException;
    public void UpdateMy_birthday(String id,String NewMy_birthday) throws DBSystemException;
    public void UpdateMy_surprise(String id,String NewMy_surprise) throws DBSystemException;
    public Opoveshenie_Email SelectUserOpoveshenie_Email(String id) throws DBSystemException;
    public void insertOpoveshenieRegistetion(String idUser) throws DBSystemException;

}
