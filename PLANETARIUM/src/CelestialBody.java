
public class CelestialBody {
    private int massa;
    private String name;
    private Point positionAbs;
    private Point positionRel;
    Type type = Type.NULL;

    public Type getType() {
        return type;
    }
    public void setType(Type type) {
        this.type = type;
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
