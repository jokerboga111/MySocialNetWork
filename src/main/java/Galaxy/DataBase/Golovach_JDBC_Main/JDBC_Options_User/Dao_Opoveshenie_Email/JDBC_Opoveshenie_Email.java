package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Opoveshenie_Email;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.Golovach_JDBC_Main.Connections.ConnectionFactory;
import Galaxy.DataBase.Golovach_JDBC_Main.Connections.ConnectionFactoryFactory;
import Galaxy.DataBase.Golovach_JDBC_Main.Connections.JdbcUtil;

import Galaxy.Logger.LoggingGalaxy;

import java.sql.*;

/**
 * Created by Admin on 16.02.2016.
 */
public class JDBC_Opoveshenie_Email implements Dao_Opoveshenie_Email {

    private static final String UPDATE_USER_email="UPDATE galaxyuser.opoveshenye_email set email=";
    private static final String UPDATE_USER_chastota_opoveshenie="UPDATE galaxyuser.opoveshenye_email  set chastota_opoveshenie=";
    private static final String UPDATE_USER_zaiavki_fiends="UPDATE galaxyuser.opoveshenye_email  set zaiavki_fiends=";
    private static final String UPDATE_USER_vosmoshnie_friends="UPDATE galaxyuser.opoveshenye_email  set vosmoshnie_friends=";
    private static final String UPDATE_USER_lich_massege="UPDATE galaxyuser.opoveshenye_email set lich_massege=";
    private static final String UPDATE_USER_achepted_photo="UPDATE galaxyuser.opoveshenye_email set achepted_photo=";
    private static final String UPDATE_USER_masage_wall="UPDATE galaxyuser.opoveshenye_email set masage_wall=";
    private static final String UPDATE_USER_koment_wall="UPDATE galaxyuser.opoveshenye_email set koment_wall=";
    private static final String UPDATE_USER_koment_photo="UPDATE galaxyuser.opoveshenye_email set koment_photo=";
    private static final String UPDATE_USER_coment_video="UPDATE galaxyuser.opoveshenye_email set coment_video=";
    private static final String UPDATE_USER_ansewer_coment="UPDATE galaxyuser.opoveshenye_email set ansewer_coment=";
    private static final String UPDATE_USER_Upominaniya="UPDATE galaxyuser.opoveshenye_email set Upominaniya=";
    private static final String UPDATE_USER_acept_group="UPDATE galaxyuser.opoveshenye_email set acept_group=";
    private static final String UPDATE_USER_meropriyatiya="UPDATE galaxyuser.opoveshenye_email set meropriyatiya=";
    private static final String UPDATE_USER_birthday="UPDATE galaxyuser.opoveshenye_email set  birthday=";
    private static final String UPDATE_USER_surprise="UPDATE galaxyuser.opoveshenye_email set surprise=";
    private static final String UPDATE_USER_ID_WHERE="WHERE id=";
    public static final String SELECT_ALLINFORMAATION="SELECT * FROM galaxyuser.user,galaxyuser.opoveshenye_email WHERE opoveshenye_email.id=user.id AND opoveshenye_email.id=";


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
    public void UpdateMy_email(String id, String NewMy_email) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_email,id,UPDATE_USER_ID_WHERE,NewMy_email);
    }

    @Override
    public void UpdateMy_chastota_opoveshenie(String id, String NewMy_chastota_opoveshenie) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_chastota_opoveshenie,id,UPDATE_USER_ID_WHERE,NewMy_chastota_opoveshenie);
    }

    @Override
    public void UpdateMy_zaiavki_fiends(String id, String NewMy_zaiavki_fiends) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_zaiavki_fiends,id,UPDATE_USER_ID_WHERE,NewMy_zaiavki_fiends);
    }

    @Override
    public void UpdateMy_vosmoshnie_friends(String id, String NewMy_vosmoshnie_friends) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_vosmoshnie_friends,id,UPDATE_USER_ID_WHERE,NewMy_vosmoshnie_friends);
    }

    @Override
    public void UpdateMy_lich_massege(String id, String NewMy_lich_massege) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_lich_massege,id,UPDATE_USER_ID_WHERE,NewMy_lich_massege);
    }

    @Override
    public void UpdateMy_achepted_photo(String id, String NewMy_achepted_photo) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_achepted_photo,id,UPDATE_USER_ID_WHERE,NewMy_achepted_photo);
    }

    @Override
    public void UpdateMy_masage_wall(String id, String NewMy_masage_wall) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_masage_wall,id,UPDATE_USER_ID_WHERE,NewMy_masage_wall);
    }

    @Override
    public void UpdateMy_koment_wall(String id, String NewMy_koment_wall) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_koment_wall,id,UPDATE_USER_ID_WHERE,NewMy_koment_wall);
    }

    @Override
    public void UpdateMy_koment_photo(String id, String NewMy_koment_photo) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_koment_photo,id,UPDATE_USER_ID_WHERE,NewMy_koment_photo);
    }

    @Override
    public void UpdateMy_coment_video(String id, String NewMy_coment_video) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_coment_video,id,UPDATE_USER_ID_WHERE,NewMy_coment_video);
    }

    @Override
    public void UpdateMy_ansewer_coment(String id, String NewMy_ansewer_coment) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_ansewer_coment,id,UPDATE_USER_ID_WHERE,NewMy_ansewer_coment);
    }

    @Override
    public void UpdateMy_Upominaniya(String id, String NewMy_Upominaniya) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_Upominaniya,id,UPDATE_USER_ID_WHERE,NewMy_Upominaniya);
    }

    @Override
    public void UpdateMy_acept_group(String id, String NewMy_acept_group) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_acept_group,id,UPDATE_USER_ID_WHERE,NewMy_acept_group);
    }

    @Override
    public void UpdateMy_meropriyatiya(String id, String NewMy_meropriyatiya) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_meropriyatiya,id,UPDATE_USER_ID_WHERE,NewMy_meropriyatiya);
    }

    @Override
    public void UpdateMy_birthday(String id, String NewMy_birthday) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_birthday,id,UPDATE_USER_ID_WHERE,NewMy_birthday);
    }

    @Override
    public void UpdateMy_surprise(String id, String NewMy_surprise) throws DBSystemException {
        UpdateDaoShablon(UPDATE_USER_surprise,id,UPDATE_USER_ID_WHERE,NewMy_surprise);
    }

    @Override
    public Opoveshenie_Email SelectUserOpoveshenie_Email(String id) throws DBSystemException {
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
            Opoveshenie_Email opoveshenie_email=null;

            if(rs.next()){

                String email=rs.getString("email");
                String chastota_opoveshenie=rs.getString("chastota_opoveshenie");
                String zaiavki_fiends=rs.getString("zaiavki_fiends");
                String vosmoshnie_friends=rs.getString("vosmoshnie_friends");
                String lich_massege=rs.getString("lich_massege");
                String achepted_photo=rs.getString("achepted_photo");
                String masage_wall=rs.getString("masage_wall");
                String koment_wall=rs.getString("koment_wall");
                String koment_photo=rs.getString("koment_photo");
                String coment_video=rs.getString("coment_video");
                String ansewer_coment=rs.getString("ansewer_coment");
                String Upominaniya=rs.getString("Upominaniya");
                String acept_group=rs.getString("acept_group");
                String meropriyatiya=rs.getString("meropriyatiya");
                String birthday=rs.getString("birthday");
                String surprise=rs.getString("surprise");
                opoveshenie_email= new Opoveshenie_Email();
                opoveshenie_email.setEmail(email);
                opoveshenie_email.setChastota_opoveshenie(chastota_opoveshenie);
                opoveshenie_email.setZaiavki_fiends(zaiavki_fiends);
                opoveshenie_email.setVosmoshnie_friends(vosmoshnie_friends);
                opoveshenie_email.setLich_massege(lich_massege);
                opoveshenie_email.setAchepted_photo(achepted_photo);
                opoveshenie_email.setMasage_wall(masage_wall);
                opoveshenie_email.setKoment_wall(koment_wall);
                opoveshenie_email.setKoment_photo(koment_photo);
                opoveshenie_email.setComent_video(coment_video);
                opoveshenie_email.setAnsewer_coment(ansewer_coment);
                opoveshenie_email.setUpominaniya(Upominaniya);
                opoveshenie_email.setAcept_group(acept_group);
                opoveshenie_email.setMeropriyatiya(meropriyatiya);
                opoveshenie_email.setBirthday(birthday);
                opoveshenie_email.setSurprise(surprise);


            }
            conn.commit();
            return opoveshenie_email;
        }catch(SQLException e){
            JdbcUtil.rollbackQuietly(conn);
            throw new DBSystemException("Can't execute SQL = '"+SELECT_ALLINFORMAATION +e);
        }finally{
            JdbcUtil.closeQuietly(ps);
            JdbcUtil.closeQuietly(conn);
        }
    }

    @Override
    public void insertOpoveshenieRegistetion(String idUser) throws DBSystemException {
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
            ps = conn.prepareStatement("insert into galaxyuser.opoveshenye_email (email,chastota_opoveshenie,zaiavki_fiends,vosmoshnie_friends,lich_massege,achepted_photo,masage_wall,koment_wall,koment_photo,coment_video,ansewer_coment,Upominaniya,acept_group,meropriyatiya,birthday,surprise,id) value(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1,"true");
            ps.setString(2,"true");
            ps.setString(3,"true");
            ps.setString(4,"true");
            ps.setString(5,"true");
            ps.setString(6,"true");
            ps.setString(7,"true");
            ps.setString(8,"true");
            ps.setString(9,"true");
            ps.setString(10,"true");
            ps.setString(11,"true");
            ps.setString(12,"true");
            ps.setString(13,"true");
            ps.setString(14,"true");
            ps.setString(15,"true");
            ps.setString(16,"true");
            ps.setString(17,idUser);
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
