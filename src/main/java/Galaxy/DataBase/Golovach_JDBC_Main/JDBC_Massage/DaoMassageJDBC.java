package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Massage;

import Galaxy.Chat.DialogExm;
import Galaxy.Chat.massage.Masege;
import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.Golovach_JDBC_Main.Connections.ConnectionFactory;
import Galaxy.DataBase.Golovach_JDBC_Main.Connections.ConnectionFactoryFactory;
import Galaxy.DataBase.Golovach_JDBC_Main.Connections.JdbcUtil;
import Galaxy.Logger.LoggingGalaxy;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 03.02.2016.
 */
public class DaoMassageJDBC implements DaoMassage {
    public static final String SELECT_LDialog_SQL="SELECT * FROM galaxyuser.dialog WHERE Name=";
    public static final String INSERT_SQL_DIALOG="INSERT INTO galaxyuser.dialog  (idDiaPol,Name,idyour,idfriend) value(?,?,?,?)";
    public static final String INSERT_SQL_MASSAGE="INSERT INTO galaxyuser.masage  (idDiaPol,masage,idyour) value(?,?,?)";
    public static final String INSERT_SQL_MASSAGE1="INSERT INTO galaxyuser.masage  (idDiaPol,masage,idyour,idDialog,time1,firstAndlastName) value(?,?,?,?,?,?)";
    public static final String SELECT_BY_ID_DIALOG_SQL="SELECT * FROM galaxyuser.dialog,galaxyuser.masage WHERE masage.idDiaPol=dialog.Name AND masage.idyour=dialog.idyour AND masage.idDiaPol=";
    public static final String SELECT_L1Dialog_SQL="SELECT * FROM galaxyuser.dialog WHERE idyour=";
    public static final String SELECT_BY_ID_DIALOG_SQL1="SELECT * FROM galaxyuser.masage WHERE masage.idDialog=";

    private ConnectionFactory factory= ConnectionFactoryFactory.newConnectionFactory();
    LoggingGalaxy rece= new LoggingGalaxy();
    private Connection getConnection() throws SQLException {

        return factory.newConnection();

    }
    @Override
    public void insertNewMassage(String id, String massage, String login) throws DBSystemException {
        Connection conn;
        boolean result=true;
        try {
            conn = getConnection();
            rece.log.debug("Подключились к базе данных");
        } catch (SQLException e) {
            throw new DBSystemException("Can't get connection "+e);
        }
        PreparedStatement ps=null;
        try{
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            rece.log.debug("Зоздли иерархию транзакции!");
            conn.setAutoCommit(false);
            rece.log.debug("Отключили авто закрытие!");

            ps= conn.prepareStatement(INSERT_SQL_MASSAGE);
            rece.log.debug("Содали запрос!");
            ps.setString(1,login);
            ps.setString(2,massage);
            ps.setString(3,id);
            ps.executeUpdate();
            rece.log.debug("Запрос отработал!");
            conn.commit();
        }catch(SQLException e){
            JdbcUtil.rollbackQuietly(conn);
            throw new DBSystemException("Can't execute SQL = '"+INSERT_SQL_MASSAGE);
        }finally{
            JdbcUtil.closeQuietly(ps);
            JdbcUtil.closeQuietly(conn);
        }
    }

    @Override
    public void insertNewDialog(int idDialog, String massage, String id,String idfriend) throws DBSystemException {
        Connection conn;
        boolean result=true;
        try {
            conn = getConnection();
            rece.log.debug("Подключились к базе данных");
        } catch (SQLException e) {
            throw new DBSystemException("Can't get connection "+e);
        }
        PreparedStatement ps=null;
        try{
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            rece.log.debug("Зоздли иерархию транзакции!");
            conn.setAutoCommit(false);
            rece.log.debug("Отключили авто закрытие!");

            ps= conn.prepareStatement(INSERT_SQL_DIALOG);
            rece.log.debug("Содали запрос!");
            ps.setInt(1, idDialog);
            ps.setString(2,massage);
            ps.setString(3,id);
            ps.setString(4,idfriend);
            ps.executeUpdate();
            rece.log.debug("Запрос отработал!");
            conn.commit();
        }catch(SQLException e){
            JdbcUtil.rollbackQuietly(conn);
            throw new DBSystemException("Can't execute SQL = '"+INSERT_SQL_DIALOG);
        }finally{
            JdbcUtil.closeQuietly(ps);
            JdbcUtil.closeQuietly(conn);
        }
    }

    @Override
    public boolean selectDialog(String login) throws DBSystemException {
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
            System.out.println("2");
            ps = conn.createStatement();
            System.out.println("2");
            rs= ps.executeQuery(SELECT_LDialog_SQL+"'"+login+"'");
            System.out.println("2");
            boolean result = false;
            if(rs.next()){
                result=true;
            }
            conn.commit();
            return result;
        }catch(SQLException e){
            JdbcUtil.rollbackQuietly(conn);
            throw new DBSystemException("Can't execute SQL = '"+SELECT_LDialog_SQL +e);
        }finally{
            JdbcUtil.closeQuietly(ps);
            JdbcUtil.closeQuietly(conn);
        }
    }

    @Override
    public List<DialogExm> selectDialog4(String id) throws DBSystemException {
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
            rs= ps.executeQuery(SELECT_L1Dialog_SQL+"'"+id+"'");
            List<DialogExm> Ldia=new ArrayList<DialogExm>();
            DialogExm dia;
            while(rs.next()){
                String idDiaPol=rs.getString("idDiaPol");
                String Name=rs.getString("Name");
                String idyour=rs.getString("idyour");
                String idfriend=rs.getString("idfriend");
                dia=new DialogExm();
                dia.setIdDiaPol(idDiaPol);
                dia.setYourid(idyour);
                dia.setName(Name);
                dia.setIdfriend(idfriend);
                Ldia.add(dia);
            }
            conn.commit();
            return Ldia;
        }catch(SQLException e){
            JdbcUtil.rollbackQuietly(conn);
            throw new DBSystemException("Can't execute SQL = '"+SELECT_L1Dialog_SQL +e);
        }finally{
            JdbcUtil.closeQuietly(ps);
            JdbcUtil.closeQuietly(conn);
        }
    }

    @Override
    public List<String> selectMassage(String id, String idDialog) throws DBSystemException {
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
            System.out.println("2");
            ps = conn.createStatement();
            System.out.println("2");
            rs= ps.executeQuery(SELECT_BY_ID_DIALOG_SQL+"'"+idDialog+"'"+"AND masage.idyour="+"'"+id+"'");
            System.out.println("2");
            List<String> Ldia=new ArrayList<String>();
            while(rs.next()){
                String masage=rs.getString("masage");
                Ldia.add(masage);
            }
            conn.commit();
            return Ldia;
        }catch(SQLException e){
            JdbcUtil.rollbackQuietly(conn);
            throw new DBSystemException("Can't execute SQL = '"+SELECT_BY_ID_DIALOG_SQL+"'"+idDialog+"'"+"AND masage.idyour="+"'"+id+"'" +e);
        }finally{
            JdbcUtil.closeQuietly(ps);
            JdbcUtil.closeQuietly(conn);
        }
    }

    @Override
    public void insertNewMassage1(Masege masege) throws DBSystemException {
        Connection conn;
        boolean result=true;
        try {
            conn = getConnection();
        } catch (SQLException e) {
            throw new DBSystemException("Can't get connection "+e);
        }
        PreparedStatement ps=null;
        try{
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            conn.setAutoCommit(false);

            ps= conn.prepareStatement(INSERT_SQL_MASSAGE1);
            ps.setString(1,masege.getFirstAndLastName());
            ps.setString(2,masege.getMasage());
            ps.setString(3,masege.getYourId());
            ps.setInt(4, masege.getIdDialog());
            ps.setString(5,masege.getTime());
            ps.setString(6,masege.getFirstAndLastName());
            ps.executeUpdate();
            conn.commit();
        }catch(SQLException e){
            JdbcUtil.rollbackQuietly(conn);
            throw new DBSystemException("Can't execute SQL = '"+INSERT_SQL_MASSAGE);
        }finally{
            JdbcUtil.closeQuietly(ps);
            JdbcUtil.closeQuietly(conn);
        }
    }

    @Override
    public List<Masege> selectMasege(String id, String idDialog) throws DBSystemException {
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
            rs= ps.executeQuery(SELECT_BY_ID_DIALOG_SQL1+"'"+idDialog+"'"+"AND masage.idyour="+"'"+id+"'");
            List<Masege> maseges=new ArrayList<Masege>();
            while(rs.next()){
                String idDiaPol=rs.getString("idDiaPol");
                String masage=rs.getString("masage");
                String idyour=rs.getString("idyour");
                int idDialog1=rs.getInt("idDialog");
                String time1=rs.getString("time1");
                String firstAndlastName=rs.getString("firstAndlastName");
                Masege masege=new Masege();
                masege.setTime(time1);
                masege.setFirstAndLastName(firstAndlastName);
                masege.setMasage(masage);
                masege.setIdDialog(idDialog1);
                masege.setYourId(idyour);
                masege.setIdDiaPol(idDiaPol);

                maseges.add(masege);
            }
            conn.commit();
            return maseges;
        }catch(SQLException e){
            JdbcUtil.rollbackQuietly(conn);
            throw new DBSystemException("Can't execute SQL = '"+SELECT_BY_ID_DIALOG_SQL+"'"+idDialog+"'"+"AND masage.idyour="+"'"+id+"'" +e);
        }finally{
            JdbcUtil.closeQuietly(ps);
            JdbcUtil.closeQuietly(conn);
        }
    }

    @Override
    public boolean checkDialog(String idFirst, String idSecond) throws DBSystemException {
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
            rs= ps.executeQuery("SELECT idDiaPol FROM galaxyuser.dialog  where idyour in("+idFirst+","+idSecond+")");
            int idDiaPol=0;
            while(rs.next()){
                idDiaPol = rs.getInt("idDiaPol");
            }
            conn.commit();
            return idDiaPol==0;

        }catch(SQLException e){
            JdbcUtil.rollbackQuietly(conn);
            throw new DBSystemException("SELECT max(idDiaPol) FROM galaxyuser.dialog" +e);
        }finally{
            JdbcUtil.closeQuietly(ps);
            JdbcUtil.closeQuietly(conn);
        }
    }

    @Override
    public int selectMaxId(String id) throws DBSystemException {
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
            rs= ps.executeQuery("SELECT MAX(idDiaPol) FROM galaxyuser.dialog");
            int idDiaPol=0;
            while(rs.next()){
                idDiaPol = rs.getInt(1);
            }
            conn.commit();
            return idDiaPol;

        }catch(SQLException e){
            JdbcUtil.rollbackQuietly(conn);
            throw new DBSystemException("SELECT max(idDiaPol) FROM galaxyuser.dialog" +e);
        }finally{
            JdbcUtil.closeQuietly(ps);
            JdbcUtil.closeQuietly(conn);
        }
    }

    @Override
    public int selectIdDialog(String idFirst, String idSecond) throws DBSystemException {
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
            rs= ps.executeQuery("SELECT DISTINCT idDiaPol FROM galaxyuser.dialog  where idyour in("+idFirst+","+idSecond+")");
            int idDiaPol=0;
            while(rs.next()){
                idDiaPol = rs.getInt("idDiaPol");
            }
            conn.commit();
            return idDiaPol;

        }catch(SQLException e){
            JdbcUtil.rollbackQuietly(conn);
            throw new DBSystemException("SELECT max(idDiaPol) FROM galaxyuser.dialog" +e);
        }finally{
            JdbcUtil.closeQuietly(ps);
            JdbcUtil.closeQuietly(conn);
        }
    }


}
