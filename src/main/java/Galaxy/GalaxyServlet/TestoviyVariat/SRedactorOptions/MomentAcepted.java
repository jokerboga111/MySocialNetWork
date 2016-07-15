package Galaxy.GalaxyServlet.TestoviyVariat.SRedactorOptions;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Change_password.Change_Pasword;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Change_password.Dao_Change_Password;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Change_password.JDBC_Change_Password;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Moment_Opoveshenie.Dao_Moment_opoveshenye;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Moment_Opoveshenie.JDBC_Moment_Opovechenye;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Moment_Opoveshenie.Moment_Opoveshenye;
import Galaxy.GalaxyServlet.TestoviyVariat.Dispatcher;
import Galaxy.Logger.LoggingGalaxy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Admin on 17.02.2016.
 */
public class MomentAcepted  extends Dispatcher {



    LoggingGalaxy rece= new LoggingGalaxy();
    public String getServletInfo(){
        return "Registration servlet";
    }
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        String id= request.getParameter("id");
        Dao_Moment_opoveshenye moment_opovechenye=new JDBC_Moment_Opovechenye();
        Moment_Opoveshenye moment_opoveshenye1=null;
        try {
            moment_opoveshenye1=moment_opovechenye.SelectUserMoment_Opoveshenye(id);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }

        String saw_the_massege = request.getParameter("saw_the_massege");
        String listen_audio_masage = request.getParameter("listen_audio_masage");

        try {
            moment_opovechenye.Update_saw_the_massege(id,saw_the_massege);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        try {
            moment_opovechenye.Update_listen_audio_masage(id,listen_audio_masage);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }


        response.sendRedirect("socc2s/erd/Options.jsp");


    }}
