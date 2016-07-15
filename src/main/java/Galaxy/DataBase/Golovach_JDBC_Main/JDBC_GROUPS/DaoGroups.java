package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_GROUPS;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.DataBaseException.NotUniqueUserEmailException;
import Galaxy.DataBase.DataBaseException.NotUniqueUserLoginException;
import Galaxy.GalaxyServlet.TestoviyVariat.SGroups.Groups;
import Galaxy.UserAccount.User;

import java.util.List;

/**
 * Created by Admin on 03.02.2016.
 */
public interface DaoGroups {

    public List<Groups> selectAdminGroupById(String idUser) throws DBSystemException;
    public Groups selectAdminGrouppById(String idUser,String idgroup) throws DBSystemException;

    public List<User> selectAdminZayavkiByIdGroup(String idGroup) throws DBSystemException;

    public void deleteGroupAdminZayavka(String id,String idGroup) throws DBSystemException;

    public void insertNewFriendInGroup(String id,String NameGroup,String idGroup) throws DBSystemException;

    public void insertNewGroupInUser(String idGroup,String NameGroup,String id) throws DBSystemException;

    public void insertAdminGroup(String idGroup,String NameGroup,String idUser) throws DBSystemException;

    public List<Groups> selectMyGroupById(String id) throws DBSystemException;

    public List<User> selectUserInGroupById(String idGroup) throws DBSystemException;

    public void insertGroup(String idgroup,String NameGroup)throws DBSystemException;

    public List<Groups> selectAllGroups()throws DBSystemException;

    public boolean insertNewOrderGroups(String idGroup,String NameGroup,String idUser) throws DBSystemException,NotUniqueUserEmailException,NotUniqueUserLoginException;

}
