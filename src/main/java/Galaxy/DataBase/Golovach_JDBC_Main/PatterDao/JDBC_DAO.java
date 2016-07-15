package Galaxy.DataBase.Golovach_JDBC_Main.PatterDao;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.Golovach_JDBC_Main.Connections.ConnectionFactory;
import Galaxy.DataBase.Golovach_JDBC_Main.Connections.ConnectionFactoryFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Admin on 12.02.2016.
 */
public class JDBC_DAO implements PatterDao {

    private ConnectionFactory factory= ConnectionFactoryFactory.newConnectionFactory();

    private Connection getConnection() throws SQLException {

        return factory.newConnection();

    }

    @Override
    public Connection Conection() throws DBSystemException {
        Connection conn;
        PreparedStatement ps=null;
        try {
            conn = getConnection();
        } catch (SQLException e) {
            throw new DBSystemException("Can't get connection "+e);
        }
        return conn;
    }
}
