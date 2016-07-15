package Galaxy.GalaxyServlet.TestoviyVariat;

import Galaxy.Chat.ChatListener;
import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_USER.UserDao;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_USER.UserDaoJdbc;

import Galaxy.GalaxyServlet.TestoviyVariat.Spring.Spring;
import Galaxy.Logger.LoggingGalaxy;
import Galaxy.UserAccount.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class CheckUser extends Dispatcher {;
    LoggingGalaxy rece= new LoggingGalaxy();
    public String getServletInfo(){
        return "Registration servlet";
    }

    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext ctx=request.getServletContext();
        HttpSession ser=request.getSession();
        UserDao userDao= (UserDao) Spring.springContext().getBean("userDao");
        User user = null;
        try {
            String login =request.getParameter("login");
            user = userDao.selectByLogin(login);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }

        if (user == null){
            this.forward("/ErrorOpen.jsp", request, response);
        } else {
            if(!user.getPassword().equals(request.getParameter("password"))){
                this.forward("/ErrorOpen.jsp", request, response);
            } else {
                System.out.println(request.getSession().getId());
                ser.setAttribute("user",user);
                ser.setAttribute("img","197870.jpg");
                response.sendRedirect("/socc2s/erd/index.jsp");
            }
        }
    }

}