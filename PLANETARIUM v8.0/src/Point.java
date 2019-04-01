public class Point {

    private float x;
    private float y;

    public Point(float x,float y){
        this.x = x;
        this.y = y;
    }


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
        Point pointReturn = new Point((punti.x + puntos.x),(punti.y + puntos.y));
        return pointReturn;
    }

}


