package Galaxy.GalaxyServlet.TestoviyVariat.SRedactorOptions;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Svayzi_so_mnoy.Dao_Svyazi_so_mnoy;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Svayzi_so_mnoy.JDBC_Svyazi_so_mnoy;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Zapisi_Page.Dao_Zapisi_Page;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Zapisi_Page.JDBC_Zapisi_Page;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Zapisi_Page.Zapisi_page;
import Galaxy.GalaxyServlet.TestoviyVariat.Dispatcher;
import Galaxy.Logger.LoggingGalaxy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Admin on 17.02.2016.
 */
public class Svyazy_so_mnoy extends Dispatcher {



    LoggingGalaxy rece= new LoggingGalaxy();
    public String getServletInfo(){
        return "Registration servlet";
    }
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        String id= request.getParameter("id");
        Dao_Svyazi_so_mnoy dao_svyazi_so_mnoy=new JDBC_Svyazi_so_mnoy();
        Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Svayzi_so_mnoy.Svyazy_so_mnoy svyazy_so_mnoy=null;
        try {
            svyazy_so_mnoy=dao_svyazi_so_mnoy.SelectUserSvyazy_so_mnoy(id);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        String who_write_masage_to_me = request.getParameter("who_write_masage_to_me");
        String who_can_duel_me_video = request.getParameter("who_can_duel_me_video");
        String who_can_duel_me_aplication= request.getParameter("who_can_duel_me_aplication");
        String who_can_acept_me_video= request.getParameter("who_can_acept_me_video");
        String who_can_acept_me_aplication= request.getParameter("who_can_acept_me_aplication");


        try {
            dao_svyazi_so_mnoy.Updatewho_write_masage_to_me(id,who_write_masage_to_me);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        try {
            dao_svyazi_so_mnoy.Updatewho_can_duel_me_video(id,who_can_duel_me_video);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }

        try {
            dao_svyazi_so_mnoy.Updatewho_can_duel_me_aplication(id,who_can_duel_me_aplication);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }

        try {
            dao_svyazi_so_mnoy.Updatewho_can_acept_me_video(id,who_can_acept_me_video);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        try {
            dao_svyazi_so_mnoy.Updatewho_can_acept_me_aplication(id,who_can_acept_me_aplication);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }



        response.sendRedirect("socc2s/erd/Options.jsp");


    }}