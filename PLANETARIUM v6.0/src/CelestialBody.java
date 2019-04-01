
public class CelestialBody {
    int j;
    private int massa;
    private String name;
    Id id = new Id();
    private Point positionAbs;
    private Point positionRel;
    Point point = new Point();

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public CelestialBody(String str, int massa, int x, int y){
        this.name = str;
        this.massa = massa;
    }

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
}
