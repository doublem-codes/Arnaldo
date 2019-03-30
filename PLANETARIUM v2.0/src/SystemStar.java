import it.unibs.fp.mylib.InputDati;

import java.util.ArrayList;

public class SystemStar {

    ArrayList arrayListCelestianBody = new ArrayList<CelestialBody>();
    CelestialBody celestialBody = new CelestialBody();

    public ArrayList getArrayListCelestianBody() {
        return arrayListCelestianBody;
    }

    public CelestialBody getCelestialBody(int index) {
        return (CelestialBody) arrayListCelestianBody.get(index);
    }

    public void setArrayListPlanet(ArrayList arrayListPlanet) {
        this.arrayListCelestianBody = arrayListPlanet;
    }

    public void addCelestialBody(int index, String strType){
        CelestialBody celestialBody =  new CelestialBody();


        String strName=it.unibs.fp.mylib.InputDati.leggiStringa("Insert name "+ strType +":");
        celestialBody.setName(strName);
        int nMass= InputDati.leggiIntero("Insert mass of"+ strName + ":");
        celestialBody.setMassa(nMass);
        celestialBody.setId(strName,0);
        System.out.println("ID creato: " + celestialBody.getId());

        arrayListCelestianBody.add(celestialBody);
    }

    public boolean deleteCelestianBody(String strCelestianBody){

        String str2= it.unibs.fp.mylib.InputDati.leggiStringa("Insert the planet name you want to delete: ");
        int i;
        for(i=0; i<=arrayListCelestianBody.size(); i++) {
            if (str2.equals(getCelestialBody(i).getName())) {
                arrayListCelestianBody.remove(i);
            }
        }
        return false;
    }



    public void calculateMiddle(){

    }

    public void printInfoBody(){

    }

    public boolean findCelestialBody (){

        return false;
    }



}
