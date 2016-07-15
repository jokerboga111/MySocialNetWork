package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_USER;

import Galaxy.Chat.DialogExm;
import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.DataBaseException.NotUniqueUserEmailException;
import Galaxy.DataBase.DataBaseException.NotUniqueUserLoginException;
import Galaxy.GalaxyServlet.TestoviyVariat.SGroups.Groups;
import Galaxy.UserAccount.User;

import java.io.FileInputStream;
import java.util.List;
import java.util.Map;


public interface UserDao {

		public User selectByLogin(String login) throws DBSystemException;

	    public List<User> selectAll()throws DBSystemException;

	    public User selectByID(String id) throws DBSystemException;

	    public List<User> selectByIDAndLogin(String id) throws DBSystemException;

	    public int selectId(String login) throws DBSystemException;
		
		public int deleteByLogin(String login) throws DBSystemException;


		public boolean insertNewUser(User user) throws DBSystemException,NotUniqueUserEmailException ,NotUniqueUserLoginException;

	    public void changePassword(String NewPass,String id) throws DBSystemException;

	    public void changeEmail(String NewEmail,String id) throws DBSystemException;

	public String selectMaxId()throws DBSystemException;



}

