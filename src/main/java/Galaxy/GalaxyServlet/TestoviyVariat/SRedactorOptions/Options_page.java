package Galaxy.GalaxyServlet.TestoviyVariat.SRedactorOptions;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Ather_Service.Ather_Service;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Ather_Service.Dao_Ather_Service;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Ather_Service.JDBC_Ather_Service;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Options_Page.Dao_Options_Page;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Options_Page.JDBC_Option_Page;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Options_Page.Options_Page;
import Galaxy.GalaxyServlet.TestoviyVariat.Dispatcher;
import Galaxy.Logger.LoggingGalaxy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Admin on 17.02.2016.
 */
public class Options_page extends Dispatcher {



    LoggingGalaxy rece= new LoggingGalaxy();
    public String getServletInfo(){
        return "Registration servlet";
    }
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        String id= request.getParameter("id");
        Dao_Options_Page dao_options_page=new JDBC_Option_Page();
        try {
            Options_Page options_page=dao_options_page.SelectUserOptions_Page(id);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }

        String skrity_blok_podarkov = request.getParameter("skrity_blok_podarkov");
        String Zapisi_moi = request.getParameter("Zapisi_moi");
        String Off_coments = request.getParameter("Off_coments");

        try {
            dao_options_page.UpdateSkrity_blok_podarkov(id,skrity_blok_podarkov);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        try {
            dao_options_page.UpdateZapisi_moi(id,Zapisi_moi);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        try {
            dao_options_page.UpdateOff_coments(id,Off_coments);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }


        response.sendRedirect("socc2s/erd/Options.jsp");


    }}