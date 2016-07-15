package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Change_Id;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.Golovach_JDBC_Main.Connections.ConnectionFactory;
import Galaxy.DataBase.Golovach_JDBC_Main.Connections.ConnectionFactoryFactory;
import Galaxy.DataBase.Golovach_JDBC_Main.Connections.JdbcUtil;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Change_Email.Change_Email;
import Galaxy.Logger.LoggingGalaxy;

import java.sql.*;

/**
 * Created by Admin on 15.02.2016.
 */
public class JDBC_Change_Id implements Dao_Change_Id {


    private static final String UPDATE_USER_Id="UPDATE galaxyuser.change_id set new_id=";
    private static final String UPDATE_USER_ID_WHERE="WHERE id=";
    public static final String SELECT_ALLINFORMAATION="SELECT * FROM galaxyuser.user,galaxyuser.change_id WHERE change_id.id=user.id AND change_id.id=";


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
    public void UpdateId(String id, String NewId) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_Id,id,UPDATE_USER_ID_WHERE,NewId);
    }

    @Override
    public Change_Id SelectUserChange_Id(String id) throws DBSystemException {
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
            Change_Id change_id=null;

            if(rs.next()){

                String new_id=rs.getString("new_id");
                change_id= new Change_Id();

                change_id.setNewId(new_id);


            }
            conn.commit();
            return change_id;
        }catch(SQLException e){
            JdbcUtil.rollbackQuietly(conn);
            throw new DBSystemException("Can't execute SQL = '"+SELECT_ALLINFORMAATION +e);
        }finally{
            JdbcUtil.closeQuietly(ps);
            JdbcUtil.closeQuietly(conn);
        }
    }

    @Override
    public void inserIdREgister(String Id) throws DBSystemException {
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
            ps = conn.prepareStatement("insert into galaxyuser.change_id (old_id,new_id,id) value(?,?,?)");
            ps.setString(1,Id);
            ps.setString(2,Id);
            ps.setString(3,Id);
            ps.executeUpdate();
            conn.commit();
        }catch(SQLException e){
            JdbcUtil.rollbackQuietly(conn);
            throw new DBSystemException("");

        }finally{
            JdbcUtil.closeQuietly(ps);
            JdbcUtil.closeQuietly(conn);
        }
    }
}
