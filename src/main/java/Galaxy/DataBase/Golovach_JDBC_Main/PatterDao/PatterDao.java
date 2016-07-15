package Galaxy.DataBase.Golovach_JDBC_Main.PatterDao;


import Galaxy.DataBase.DataBaseException.DBSystemException;

import java.sql.Connection;

/**
 * Created by Admin on 03.02.2016.
 */
public interface PatterDao {
   public Connection Conection() throws DBSystemException;
}
