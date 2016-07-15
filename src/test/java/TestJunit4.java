import Galaxy.UserAccount.User;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by Admin on 10.02.2016.
 */
public class TestJunit4 {
    User u=null;
    @Test
    public void testUser(){
        u.setAge("24");
      String t=u.getAge();

        assertEquals("Hello",t=="24");
    }
    @Before
    public void beforeTests(){
        u=new User();

    }
}
