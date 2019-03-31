public class Point {
    private float x;
    private float y;

    public float getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public float getX() {
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


