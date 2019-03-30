public class Point {
    int j;
    private int x;
    private int y;

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
    public Point convertionPos(Point punti ,Point puntos){
        Point pointReturn = new Point();
        pointReturn.x = punti.x + puntos.x;
        pointReturn.y = punti.y + puntos.y;
        return punti;
    }


}


