package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Sound;

import Galaxy.DataBase.DataBaseException.DBSystemException;
import Galaxy.GalaxyServlet.TestoviyVariat.SSound.Sound;

import java.util.List;

/**
 * Created by Admin on 21.01.2016.
 */
public class TestSound {
    public static void main(String[] args) throws DBSystemException {
        SoundDao der = new SoundDaoJDBC();
        List<Sound> rec=der.selectSoundByUserId("1");
        for(Sound s:rec){
            System.out.println(s.getNameSound());
        }
    }



}
