public class Point {

    private float x;
    private float y;

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public Point convertionPos(Point punti ,Point puntos){
        Point pointReturn = new Point();
        pointReturn.x = punti.x + puntos.x;
        pointReturn.y = punti.y + puntos.y;
        return punti;
    }

}


