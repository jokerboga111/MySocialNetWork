package Galaxy.GalaxyServlet.TestoviyVariat;

import Galaxy.Logger.LoggingGalaxy;
import org.apache.log4j.PropertyConfigurator;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static Galaxy.Logger.LoggingGalaxy.TEST_log4j;

public class Registration extends Dispatcher {
    LoggingGalaxy rece= new LoggingGalaxy();
    public String getServletInfo(){
        return "Registration servlet";
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TEST_log4j();
        rece.log.info("Конфигурации ввели!");
        if (request.getParameter("login")!=""){
            rece.log.info("Проверили логин что он не равен пустомц месту!");
            this.forward("/CheckUser", request, response);
        }if (request.getParameter("Регистрация")!=null) {
                rece.log.info("Проверили проверили что кнопку регистрации не нажимали!");
                this.forward("/registration1.html", request, response);
            }
        }
    }
