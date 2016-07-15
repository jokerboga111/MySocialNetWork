package Galaxy.GalaxyServlet.TestoviyVariat.Spring;



import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Admin on 07.02.2016.
 */
public class Spring {
    public static AbstractApplicationContext ctx;

    public static AbstractApplicationContext springContext(){
        ctx=new ClassPathXmlApplicationContext("config.xml");
        return ctx;
    }
}
