
public class CelestialBody {
    private int massa;
    private String name;
    private String id;
    private Point positionAbs;
    private Point positionRel;

    public Point getPositionAbs() {
        return positionAbs;
    }
    public void setPositionAbs(Point positionAbs) {
        this.positionAbs = positionAbs;
    }
    public Point getPositionRel() {
        return positionRel;
    }
    public void setPositionRel(Point positionRel) {
        this.positionRel = positionRel;
    }
    public int getMassa() {
        return massa;
    }
    public void setMassa(int massa) {
        this.massa = massa;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getId(){
        return id;
    }
    public void setId(String strings){
        String stringTrim = strings.trim();
        String app = deleteVocal(stringTrim.toLowerCase());
        this.id = app.substring(0,4);
    }

    private static String deleteVocal(String dataInput) {
        if (dataInput.equals("")) return "";
        else if (dataInput.charAt(0)=='a'||
                dataInput.charAt(0)=='e'||
                dataInput.charAt(0)=='i'||
                dataInput.charAt(0)=='o'||
                dataInput.charAt(0)=='u') return deleteVocal(dataInput.substring(1));
        else return dataInput.substring(0,1) + deleteVocal(dataInput.substring(1));
    }
}
