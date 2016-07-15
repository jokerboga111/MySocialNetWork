package Galaxy.GalaxyServlet.TestoviyVariat.SRedactorOptions;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Change_password.Change_Pasword;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Change_password.Dao_Change_Password;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Change_password.JDBC_Change_Password;
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
public class Zapisi_so_page  extends Dispatcher {



    LoggingGalaxy rece= new LoggingGalaxy();
    public String getServletInfo(){
        return "Registration servlet";
    }
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        String id= request.getParameter("id");
        Dao_Zapisi_Page dao_zapisi_page=new JDBC_Zapisi_Page();
        Zapisi_page zapisi_page=null;
        try {
            zapisi_page=dao_zapisi_page.SelectUserZapisi_page(id);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        String who_saw_bad_zapisi = request.getParameter("who_saw_bad_zapisi");
        String who_can_cryare_zapisi = request.getParameter("who_can_cryare_zapisi");
        String who_saw_coments_to_zapisi= request.getParameter("who_saw_coments_to_zapisi");
        String who_can_coment_my_zapisi= request.getParameter("who_can_coment_my_zapisi");


                try {
                    dao_zapisi_page.Update_who_saw_bad_zapisi(id,who_saw_bad_zapisi);
                } catch (DBSystemException e) {
                    e.printStackTrace();
                }
        try {
            dao_zapisi_page.Update_who_can_cryare_zapisi(id,who_can_cryare_zapisi);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }

        try {
            dao_zapisi_page.Update_who_saw_coments_to_zapisi(id,who_saw_coments_to_zapisi);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }

        try {
            dao_zapisi_page.Update_who_can_coment_my_zapisi(id,who_can_coment_my_zapisi);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }


        response.sendRedirect("socc2s/erd/Options.jsp");


    }}