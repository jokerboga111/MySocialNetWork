package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Friends;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.DataBaseException.NotUniqueUserEmailException;
import Galaxy.DataBase.DataBaseException.NotUniqueUserLoginException;
import Galaxy.UserAccount.User;

import java.util.List;

/**
 * Created by Admin on 03.02.2016.
 */
public interface DaoFriend {
    public List<User> selectFriends(String id) throws DBSystemException;

    public void deleteFriend(String id,String idf) throws DBSystemException;

    public boolean insertNewFriend(String idf,String name,String id) throws DBSystemException, NotUniqueUserEmailException, NotUniqueUserLoginException;

    public boolean insertNewOrder(String id,String name,String idS) throws DBSystemException,NotUniqueUserEmailException ,NotUniqueUserLoginException;

    public void deleteByIDF(String id,String idf) throws DBSystemException;
}
