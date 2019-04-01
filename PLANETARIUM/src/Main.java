
import java.lang.System;
import java.util.ArrayList;

public class Main {
int j;
    public static void main(String[] args) {
        ArrayList celestialBodyArrayList = new ArrayList<CelestialBody>();
        int index = 0;
        Utilty utility = new Utilty();

        while( !utility.menu()) {

            utility.process();
            utility.reset();
        }
    }
}
