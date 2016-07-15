package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Info;

import Galaxy.DataBase.DataBaseException.DBSystemException;

/**
 * Created by Admin on 10.02.2016.
 */
public interface Dao_Informaion_User {
    public void UpdateNameUser(String id,String NewName) throws DBSystemException;
    public void UpdateSerName(String id,String NewSerName) throws DBSystemException;
    public void UpdateBirthDay(String id,String NewBirthDay) throws DBSystemException;
    public void UpdateBirthMonth(String id,String NewBirthMonth) throws DBSystemException;
    public void UpdateBirthYear(String id,String NewBirthMonth) throws DBSystemException;
    public void UpdatePol(String id,String NewPol) throws DBSystemException;
    public void UpdateFamaliOrder(String id,String NewFamaliOrder) throws DBSystemException;
    public void UpdatePrivateBirthDay(String id,String NewPrivateBirthDay) throws DBSystemException;
    public void UpdateLanguege(String id,String NewLanguege) throws DBSystemException;
    public void UpdateTown(String id,String NewTown) throws DBSystemException;
    public Iformation_User SelectUserInformation(String id) throws DBSystemException;
    public void insertRegisterInfo(String Name,String twoName,String UserId)throws DBSystemException;

}
