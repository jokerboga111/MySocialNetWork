package Galaxy.Chat.massage;

/**
 * Created by Admin on 28.03.2016.
 */
public class Masege {
    private String IdDiaPol;
 private int idDialog;
private     String masage;
 private    String yourId;
  private   String time;
   private String firstAndLastName;

    public int getIdDialog() {
        return idDialog;
    }

    public void setIdDialog(int idDialog) {
        this.idDialog = idDialog;
    }

    public String getMasage() {
        return masage;
    }

    public void setMasage(String masage) {
        this.masage = masage;
    }

    public String getYourId() {
        return yourId;
    }

    public void setYourId(String yourId) {
        this.yourId = yourId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getFirstAndLastName() {
        return firstAndLastName;
    }

    public void setFirstAndLastName(String firstAndLastName) {
        this.firstAndLastName = firstAndLastName;
    }

    @Override
    public String toString() {
        return "Masege{" +
                "idDialog='" + idDialog + '\'' +
                ", masage='" + masage + '\'' +
                ", yourId='" + yourId + '\'' +
                ", time='" + time + '\'' +
                ", firstAndLastName='" + firstAndLastName + '\'' +
                '}';
    }

    public String getIdDiaPol() {
        return IdDiaPol;
    }

    public void setIdDiaPol(String idDiaPol) {
        IdDiaPol = idDiaPol;
    }
}
