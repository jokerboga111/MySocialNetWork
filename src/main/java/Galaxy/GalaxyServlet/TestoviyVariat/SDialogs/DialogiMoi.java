package Galaxy.GalaxyServlet.TestoviyVariat.SDialogs;

import Galaxy.Chat.DialogExm;
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
import java.util.List;

/**
 * Created by Admin on 12.01.2016.
 */
public class DialogiMoi  extends Dispatcher {
    LoggingGalaxy rece= new LoggingGalaxy();
    public String getServletInfo(){
        return "Registration servlet";
    }
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String sel=request.getParameter("Selid");
        List<DialogExm> dial=null;
        DaoMassage massageDao=
                (DaoMassage) Spring.springContext().getBean("masageDao");
        try {
            dial=massageDao.selectDialog4(sel);
        } catch (DBSystemException e) {
            e.printStackTrace();
        }
        request.setAttribute("Dialogi",dial);
        System.out.println(sel);
        this.forward("/socc2s/erd/message.jsp?sel="+sel, request, response);



    }
}