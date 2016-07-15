package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Change_password;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.Golovach_JDBC_Main.Connections.ConnectionFactory;
import Galaxy.DataBase.Golovach_JDBC_Main.Connections.ConnectionFactoryFactory;
import Galaxy.DataBase.Golovach_JDBC_Main.Connections.JdbcUtil;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Change_Id.Change_Id;
import Galaxy.Logger.LoggingGalaxy;

import java.sql.*;

/**
 * Created by Admin on 15.02.2016.
 */
public class JDBC_Change_Password implements Dao_Change_Password {
    private static final String UPDATE_USER_PASSWORD="UPDATE galaxyuser.change_password  set new_password=";
    private static final String UPDATE_USER_ID_WHERE="WHERE id=";
    public static final String SELECT_ALLINFORMAATION="SELECT * FROM galaxyuser.user,galaxyuser.change_password WHERE change_password.id=user.id AND change_password.id=";

    private void UpdateDaoShablon(String Update,String id,String where ,String newInfo) throws DBSystemException {

        Connection conn;
        PreparedStatement ps=null;
        try {
            conn = getConnection();
        } catch (SQLException e) {
            throw new DBSystemException("Can't get connection "+e);
        }
        try{
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            conn.setAutoCommit(false);
            System.out.printf("Re re");
            ps = conn.prepareStatement(Update + " '" + newInfo + "' " + where + " '" + id + "'");
            ps.executeUpdate();
            conn.commit();
        }catch(SQLException e){
            JdbcUtil.rollbackQuietly(conn);
            throw new DBSystemException("Can't execute SQL = '"+Update+" '"+newInfo+" '"+where+" '"+id+"'");

        }finally{
            JdbcUtil.closeQuietly(ps);
            JdbcUtil.closeQuietly(conn);
        }
    }

    private ConnectionFactory factory= ConnectionFactoryFactory.newConnectionFactory();

    LoggingGalaxy rece= new LoggingGalaxy();

    private Connection getConnection() throws SQLException {

        return factory.newConnection();

    }


    @Override
    public void UpdatePassWord(String id, String NewPassword) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_PASSWORD,id,UPDATE_USER_ID_WHERE,NewPassword);
    }

    @Override
    public Change_Pasword SelectUserChange_Id(String id) throws DBSystemException {
        Connection conn;
        try {
            conn = getConnection();
        } catch (SQLException e) {
            throw new DBSystemException("Can't get connection "+e);
        }
        Statement ps=null;
        ResultSet rs=null;
        try{
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            conn.setAutoCommit(false);
            ps = conn.createStatement();
            rs= ps.executeQuery(SELECT_ALLINFORMAATION+"'"+id+"'");
            Change_Pasword change_password=null;

            if(rs.next()){

                String new_password=rs.getString("new_password");
                change_password= new Change_Pasword();

                change_password.setNew_password(new_password);


            }
            conn.commit();
            return change_password;
        }catch(SQLException e){
            JdbcUtil.rollbackQuietly(conn);
            throw new DBSystemException("Can't execute SQL = '"+SELECT_ALLINFORMAATION +e);
        }finally{
            JdbcUtil.closeQuietly(ps);
            JdbcUtil.closeQuietly(conn);
        }
    }
}
