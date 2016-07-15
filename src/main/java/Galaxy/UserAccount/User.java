package Galaxy.UserAccount;

/**
 * Created by Admin on 02.12.2015.
 */
public class User {
   private String login;
   private String uname;
   private String serName;
   private String password;
   private String E_mail;
    private String Age;
   private String ID;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setSerName(String SerName){
        this.serName=SerName;
    }
    public String getSerName(){
        return serName;
    }
    public void setlogin(String login){
        this.login=login;
    }
    public String getlogin(){
       return login;
    }

    public void setPassword(String password){
        this.password=password;
    }

    public void setEmail(String Email){

        this.E_mail=Email;
    }
    public String getEmail(){

        return E_mail;
    }
    public void setAge(String Age){

        this.Age=Age;
    }
    public String getAge(){

        return Age;
    }

    public void setName(String name){
        this.uname=name;
    }

    public String getName(){
        return uname;
    }


    public String getPassword(){
        return password;
    }



    public String toString(){
        return "[ Uname="+uname+" ; Password="+password+" ; SerName="+serName+" ; Login="+login+" ; Email="+E_mail+" ; Age="+Age+" ; "+"ID="+ID+" ]";
    }



}

