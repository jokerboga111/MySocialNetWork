package Galaxy.GalaxyServlet.TestoviyVariat.SRedactorUserInformation;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Hobbys.JDBC_User_Hobbys;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_Hobbys.User_Hobbys;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_life_Position.JDBC_User_Life_Position;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Information_User.User_life_Position.User_Life_Position;
import Galaxy.GalaxyServlet.TestoviyVariat.Dispatcher;
import Galaxy.GalaxyServlet.TestoviyVariat.Spring.Spring;
import Galaxy.Logger.LoggingGalaxy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Admin on 14.02.2016.
 */
public class RedactorUserPosition extends Dispatcher {



    LoggingGalaxy rece= new LoggingGalaxy();
    public String getServletInfo(){
        return "Registration servlet";
    }
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        JDBC_User_Life_Position jdbc_user_life_position = (JDBC_User_Life_Position) Spring.springContext().getBean("LifePosition");
        String id = request.getParameter("id");
        User_Life_Position user_life_position= null;
        try {
            user_life_position = jdbc_user_life_position.SelectUser_Life_Position(id);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        String Political_answ = request.getParameter("Political_answ");
        String Worldview = request.getParameter("Worldview");
        String maininlife = request.getParameter("maininlife");
        String maininpeople = request.getParameter("maininpeople");
        String about_smoking = request.getParameter("about_smoking");
        String about_alcohole= request.getParameter("about_alcohole");
        String Pierian_spring= request.getParameter("Pierian_spring");


        try {
            jdbc_user_life_position.UpdatePierian_spring(id, Pierian_spring);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }


        try {
            jdbc_user_life_position.Updateworldview(id, Worldview);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }


        try {
            jdbc_user_life_position.UpdatePolitical_answ(id, Political_answ);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }



        try {
            jdbc_user_life_position.Updatemain_in_life(id, maininlife);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }


        try {
            jdbc_user_life_position.Updatemain_in_people(id, maininpeople);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }


        try {
            jdbc_user_life_position.Updateattitude_about_smoking(id, about_smoking);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }

        try {
            jdbc_user_life_position.Updateattitude_about_alcohole(id, about_alcohole);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }



        response.sendRedirect("socc2s/erd/Redactor.jsp");


    }


}
