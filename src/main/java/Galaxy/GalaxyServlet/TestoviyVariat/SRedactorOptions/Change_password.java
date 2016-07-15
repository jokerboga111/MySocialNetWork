package Galaxy.GalaxyServlet.TestoviyVariat.SRedactorOptions;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Change_password.Change_Pasword;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Change_password.Dao_Change_Password;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Change_password.JDBC_Change_Password;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Options_Page.Dao_Options_Page;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Options_Page.JDBC_Option_Page;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Options_Page.Options_Page;
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
public class Change_password extends Dispatcher {



    LoggingGalaxy rece= new LoggingGalaxy();
    public String getServletInfo(){
        return "Registration servlet";
    }
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        String id= request.getParameter("id");
        Dao_Change_Password dao_change_password=new JDBC_Change_Password();
        Change_Pasword change_password=null;
        try {
            change_password=dao_change_password.SelectUserChange_Id(id);
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
        user.getPassword();
        String old_password = request.getParameter("old_password");
        String new_password = request.getParameter("new_password");
        String repite_password= request.getParameter("repite_password");

        if(old_password.equals(user.getPassword())){
            if(new_password.equals(repite_password)){
                try {
                    userDao.changePassword(new_password,id);
                } catch (DBSystemException e) {
                    e.printStackTrace();
                }
            }
        }

        response.sendRedirect("socc2s/erd/Options.jsp");


    }}