package Galaxy.DataBase.Golovach_JDBC_Main.JDBC_GROUPS.Upravlenye_Group;

/**
 * Created by Admin on 20.02.2016.
 */
public class UpravlenyeGroup {
   private String nameGroup;
    private String codeGroup;
    private String InfoGroup;
    private String TemaGroup;
    private String WebSite;
    private String Oldfilter;
    private String ComentFilter;
    private String AddersGroup;
    private String MassageGroup;
    private String Wall;
    private String Photo;
    private String Video;
    private String audio;
    private String document;
    private String Beseda;
    private String Matirial;
    private String Type_of_group;

    public String getNameGroup() {
        return nameGroup;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }

    public String getCodeGroup() {
        return codeGroup;
    }

    public void setCodeGroup(String codeGroup) {
        this.codeGroup = codeGroup;
    }

    public String getInfoGroup() {
        return InfoGroup;
    }

    public void setInfoGroup(String infoGroup) {
        InfoGroup = infoGroup;
    }

    public String getTemaGroup() {
        return TemaGroup;
    }

    public void setTemaGroup(String temaGroup) {
        TemaGroup = temaGroup;
    }

    public String getWebSite() {
        return WebSite;
    }

    public void setWebSite(String webSite) {
        WebSite = webSite;
    }

    public String getComentFilter() {
        return ComentFilter;
    }

    public void setComentFilter(String comentFilter) {
        ComentFilter = comentFilter;
    }

    public String getOldfilter() {
        return Oldfilter;
    }

    public void setOldfilter(String oldfilter) {
        Oldfilter = oldfilter;
    }

    public String getAddersGroup() {
        return AddersGroup;
    }

    public void setAddersGroup(String addersGroup) {
        AddersGroup = addersGroup;
    }

    public String getMassageGroup() {
        return MassageGroup;
    }

    public void setMassageGroup(String massageGroup) {
        MassageGroup = massageGroup;
    }

    public String getWall() {
        return Wall;
    }

    public void setWall(String wall) {
        Wall = wall;
    }

    public String getPhoto() {
        return Photo;
    }

    public void setPhoto(String photo) {
        Photo = photo;
    }

    public String getVideo() {
        return Video;
    }

    public void setVideo(String video) {
        Video = video;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getBeseda() {
        return Beseda;
    }

    public void setBeseda(String beseda) {
        Beseda = beseda;
    }

    public String getMatirial() {
        return Matirial;
    }

    public void setMatirial(String matirial) {
        Matirial = matirial;
    }

    public String getType_of_group() {
        return Type_of_group;
    }

    public void setType_of_group(String type_of_group) {
        Type_of_group = type_of_group;
    }

    @Override
    public String toString() {
        return "UpravlenyeGroup{" +
                "nameGroup='" + nameGroup + '\'' +
                ", codeGroup='" + codeGroup + '\'' +
                ", InfoGroup='" + InfoGroup + '\'' +
                ", TemaGroup='" + TemaGroup + '\'' +
                ", WebSite='" + WebSite + '\'' +
                ", Oldfilter='" + Oldfilter + '\'' +
                ", ComentFilter='" + ComentFilter + '\'' +
                ", AddersGroup='" + AddersGroup + '\'' +
                ", MassageGroup='" + MassageGroup + '\'' +
                ", Wall='" + Wall + '\'' +
                ", Photo='" + Photo + '\'' +
                ", Video='" + Video + '\'' +
                ", audio='" + audio + '\'' +
                ", document='" + document + '\'' +
                ", Beseda='" + Beseda + '\'' +
                ", Matirial='" + Matirial + '\'' +
                ", Type_of_group='" + Type_of_group + '\'' +
                '}';
    }
}