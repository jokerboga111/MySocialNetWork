package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_Options_User.Dao_Change_Id;

/**
 * Created by Admin on 15.02.2016.
 */
public class Change_Id {
    private String newId;
    private String oldId;

    public String getNewId() {
        return newId;
    }

    public void setNewId(String newId) {
        this.newId = newId;
    }

    public String getOldId() {
        return oldId;
    }

    public void setOldId(String oldId) {
        this.oldId = oldId;
    }

    @Override
    public String toString() {
        return "Change_Id{" +
                "newId='" + newId + '\'' +
                ", oldId='" + oldId + '\'' +
                '}';
    }
}
