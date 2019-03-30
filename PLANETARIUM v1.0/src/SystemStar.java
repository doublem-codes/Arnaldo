import it.unibs.fp.mylib.InputDati;

import java.util.ArrayList;

public class SystemStar {

    ArrayList arrayListPlanet = new ArrayList<CelestialBody>();
    CelestialBody planet = new CelestialBody();

    public ArrayList getArrayListPlanet() {
        return arrayListPlanet;
    }

    public void setArrayListPlanet(ArrayList arrayListPlanet) {
        this.arrayListPlanet = arrayListPlanet;
    }

    public void addCelestialBody(int index, String strType){
        CelestialBody celestialBody =  new CelestialBody();


        String strName=it.unibs.fp.mylib.InputDati.leggiStringa("Insert name "+ strType +":");
        celestialBody.setName(strName);
        int nMass= InputDati.leggiIntero("Insert mass of"+ strName + ":");
        celestialBody.setMassa(nMass);
        System.out.println("ID creato: ");

        arrayListPlanet.add(celestialBody);


    }

    public void calculateMiddle(){

    }

    public void printInfoBody(){

    }

    public boolean findCelestialBody (){

        return false;
    }



}
