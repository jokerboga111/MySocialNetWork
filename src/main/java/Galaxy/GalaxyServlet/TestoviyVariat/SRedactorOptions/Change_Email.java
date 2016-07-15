package Galaxy.GalaxyServlet.TestoviyVariat.SRedactorOptions;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Change_Email.Dao_Change_Email;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Change_Email.JDBC_Change_Email;

import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_USER.UserDao;
import Galaxy.GalaxyServlet.TestoviyVariat.Dispatcher;
import Galaxy.GalaxyServlet.TestoviyVariat.Spring.Spring;
import Galaxy.Logger.LoggingGalaxy;
import Galaxy.UserAccount.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Admin on 17.02.2016.
 */
public class Change_Email  extends Dispatcher {



    LoggingGalaxy rece= new LoggingGalaxy();
    public String getServletInfo(){
        return "Registration servlet";
    }
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        String id= request.getParameter("id");
        Dao_Change_Email dao_change_email=new JDBC_Change_Email();
        Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Change_Email.Change_Email change_email=null;
        try {
            change_email=dao_change_email.SelectUserChange_Email(id);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        UserDao userDao= (UserDao) Spring.springContext().getBean("userDao");
        User user = null;
        try {
            user = userDao.selectByID(id);

        } catch (DBSystemException e) {
            e.printStackTrace();
        }

        String new_email = request.getParameter("new_email");

                try {
                    userDao.changeEmail(new_email, id);
                } catch (DBSystemException e) {
                    e.printStackTrace();
                }



        response.sendRedirect("socc2s/erd/Options.jsp");


    }}