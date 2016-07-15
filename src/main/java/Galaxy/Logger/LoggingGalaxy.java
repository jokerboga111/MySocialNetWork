package Galaxy.Logger;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import static Galaxy.Logger.ClassNameUtil.getCurrentClassName;

/**
 * Created by Admin on 19.12.2015.
 */
public class LoggingGalaxy {
       public static final Logger log = Logger.getLogger(getCurrentClassName());
    public static void TEST_log4j(){
        String log4jConfPath = "/log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);
    }
}
