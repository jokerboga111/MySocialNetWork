package Galaxy.GalaxyServlet.TestoviyVariat.SRedactorOptions;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Opoveshenie_Email.Dao_Opoveshenie_Email;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Opoveshenie_Email.JDBC_Opoveshenie_Email;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Opoveshenie_Email.Opoveshenie_Email;
import Galaxy.GalaxyServlet.TestoviyVariat.Dispatcher;
import Galaxy.Logger.LoggingGalaxy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Admin on 17.02.2016.
 */
public class OpoveshenieEmail  extends Dispatcher {



    LoggingGalaxy rece= new LoggingGalaxy();
    public String getServletInfo(){
        return "Registration servlet";
    }
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        String id= request.getParameter("id");
        Dao_Opoveshenie_Email dao_opoveshenie_email=new JDBC_Opoveshenie_Email();
        Opoveshenie_Email opoveshenie_email=null;
        try {
            opoveshenie_email=dao_opoveshenie_email.SelectUserOpoveshenie_Email(id);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }

        String zaiavki_fiends = request.getParameter("zaiavki_fiends");
        String vosmoshnie_friends = request.getParameter("vosmoshnie_friends");
        String lich_massege= request.getParameter("lich_massege");
        String achepted_photo = request.getParameter("achepted_photo");
        String masage_wall = request.getParameter("masage_wall");
        String koment_wall= request.getParameter("koment_wall");
        String koment_photo = request.getParameter("koment_photo");
        String coment_video = request.getParameter("coment_video");
        String ansewer_coment= request.getParameter("ansewer_coment");
        String Upominaniya = request.getParameter("Upominaniya");
        String acept_group = request.getParameter("acept_group");
        String meropriyatiya= request.getParameter("meropriyatiya");
        String birthday = request.getParameter("birthday");
        String surprise= request.getParameter("surprise");


        try {
            dao_opoveshenie_email.UpdateMy_zaiavki_fiends(id, zaiavki_fiends);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        try {
            dao_opoveshenie_email.UpdateMy_vosmoshnie_friends(id, vosmoshnie_friends);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        try {
            dao_opoveshenie_email.UpdateMy_lich_massege(id, lich_massege);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        try {
            dao_opoveshenie_email.UpdateMy_achepted_photo(id, achepted_photo);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        try {
            dao_opoveshenie_email.UpdateMy_masage_wall(id, masage_wall);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        try {
            dao_opoveshenie_email.UpdateMy_koment_wall(id, koment_wall);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        try {
            dao_opoveshenie_email.UpdateMy_koment_photo(id, koment_photo);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        try {
            dao_opoveshenie_email.UpdateMy_coment_video(id,coment_video);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        try {
            dao_opoveshenie_email.UpdateMy_ansewer_coment(id, ansewer_coment);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        try {
            dao_opoveshenie_email.UpdateMy_Upominaniya(id, Upominaniya);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        try {
            dao_opoveshenie_email.UpdateMy_acept_group(id, acept_group);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        try {
            dao_opoveshenie_email.UpdateMy_meropriyatiya(id, meropriyatiya);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        try {
            dao_opoveshenie_email.UpdateMy_birthday(id, birthday);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        try {
            dao_opoveshenie_email.UpdateMy_surprise(id,surprise);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }

        response.sendRedirect("socc2s/erd/Options.jsp");


    }}