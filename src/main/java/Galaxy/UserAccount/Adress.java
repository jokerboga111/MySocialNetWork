package Galaxy.UserAccount;

/**
 * Created by Admin on 03.12.2015.
 */
public class Adress {
    private String Street;
    private String Town;
    private String Country;

    public Adress(String Street, String Town, String Country){
        this.Country=Country;
        this.Street=Street;
        this.Town=Town;
    }

    public void setStreet(String Street){
        this.Street=Street;
    }
    public void setTown(String Town){
        this.Town=Town;
    }
    public void setCountry(String Country){
        this.Country=Country;
    }
}
