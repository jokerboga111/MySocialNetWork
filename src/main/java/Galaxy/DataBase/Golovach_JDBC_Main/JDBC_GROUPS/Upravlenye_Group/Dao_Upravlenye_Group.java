package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_GROUPS.Upravlenye_Group;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.ContactInfo.ContactInfo;

/**
 * Created by Admin on 20.02.2016.
 */
public interface Dao_Upravlenye_Group {
    public void UpdatenameGroup(String id,String NewnameGroup) throws DBSystemException;
    public void UpdatecodeGroup(String id,String NewcodeGroup) throws DBSystemException;
    public void UpdateInfoGroup(String id,String NewInfoGroup) throws DBSystemException;
    public void UpdateTemaGroup(String id,String NewTemaGroup) throws DBSystemException;
    public void UpdateWebSite(String id,String NewWebSite) throws DBSystemException;
    public void UpdateMassageGroup(String id,String NewMassageGroup) throws DBSystemException;
    public void UpdateOldfilter(String id,String NewOldfilter) throws DBSystemException;
    public void UpdateComentFilter(String id,String NewComentFilter) throws DBSystemException;
    public void UpdateAddersGroup(String id,String NewAddersGroup) throws DBSystemException;
    public void UpdateWall(String id,String NewWall) throws DBSystemException;
    public void UpdatePhoto(String id,String NewPhoto) throws DBSystemException;
    public void UpdateVideo(String id,String NewVideo) throws DBSystemException;
    public void Updateaudio(String id,String Newaudio) throws DBSystemException;
    public void Updatedocument(String id,String Newdocument) throws DBSystemException;
    public void UpdateBeseda(String id,String NewBeseda) throws DBSystemException;
    public void UpdateMatirial(String id,String NewMatirial) throws DBSystemException;
    public void UpdateType_of_group(String id,String NewType_of_group) throws DBSystemException;
    public UpravlenyeGroup SelectUpravlenyeGroup(String id) throws DBSystemException;
    public void InsertUpravlenye(String idGroup,String nameGroup) throws DBSystemException;
}
