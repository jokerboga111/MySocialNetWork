package Galaxy.GalaxyServlet.TestoviyVariat.SDialogs;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Massage.DaoMassage;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Massage.DaoMassageJDBC;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_USER.UserDao;
import Galaxy.DataBase.Golovach_JDBC_Main.JDBC_USER.UserDaoJdbc;
import Galaxy.GalaxyServlet.TestoviyVariat.Dispatcher;
import Galaxy.GalaxyServlet.TestoviyVariat.Spring.Spring;
import Galaxy.Logger.LoggingGalaxy;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 10.01.2016.
 */
public class poiscDialoga extends Dispatcher {
    LoggingGalaxy rece= new LoggingGalaxy();
    public String getServletInfo(){
        return "Registration servlet";
    }
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String sel=request.getParameter("idSel");
        String login=request.getParameter("login");
        DaoMassage massageDao= (DaoMassage) Spring.springContext().getBean("masagerDao");
        List<String> list=new ArrayList<String>();
        try {
            list=massageDao.selectMassage(sel,login);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        request.setAttribute("Masages23",list);
        this.forward("/socc2s/massage.jsp?idSel="+sel+"login="+login, request, response);



    }
}
