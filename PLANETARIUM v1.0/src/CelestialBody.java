
public class CelestialBody {
    int j;
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

    public void setId(String strings , int index){
        String output = Integer.toString(index);//conversion int to string
        String stringTrim = strings.trim();//delete space from string
        String app = deleteVocal(stringTrim.toUpperCase());//deletevocal from string
        String app1 = app.substring(0, 4);
        this.id =output + app1;// return index + substring of 4 element
    }

    private static String deleteVocal(String s) {

        if (s.equals("")) return "";
        else if (s.charAt(0)=='A'||
                s.charAt(0)=='E'||
                s.charAt(0)=='I'||
                s.charAt(0)=='O'||
                s.charAt(0)=='U'
        ) return deleteVocal(s.substring(1));
        else return s.substring(0,1) + deleteVocal(s.substring(1));
    }
}
