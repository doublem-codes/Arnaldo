import it.unibs.fp.mylib.InputDati;

import java.util.ArrayList;

public class SystemStar {

    ArrayList arrayListCelestianBody = new ArrayList<CelestialBody>();
    CelestialBody celestialBody = new CelestialBody();
    Point pointMiddle = new Point();

    public ArrayList getArrayListCelestianBody() {
        return arrayListCelestianBody;
    }

    public CelestialBody getCelestialBody(int index) {
        return (CelestialBody) arrayListCelestianBody.get(index);
    }

    public void setArrayListPlanet(ArrayList arrayListPlanet) {
        this.arrayListCelestianBody = arrayListPlanet;
    }

    public void addCelestialBody(int index, String strType, TypeOfCelestianBody typeOfCelestianBody){

        switch (typeOfCelestianBody){
            case STAR:
                String strName1=it.unibs.fp.mylib.InputDati.leggiStringa("Insert name "+ strType +":");
                celestialBody.setName(strName1);
                int nMass1= InputDati.leggiIntero("Insert mass of "+ strName1 + ":");
                celestialBody.setMassa(nMass1);
                celestialBody.id.setId(strName1,TypeOfCelestianBody.STAR);
                System.out.println("ID creato: " + celestialBody.id.getId());
                arrayListCelestianBody.add(0,celestialBody);
                break;
            case PLANET:
                String strName2=it.unibs.fp.mylib.InputDati.leggiStringa("Insert name "+ strType +":");
                celestialBody.setName(strName2);
                int nMass2= InputDati.leggiIntero("Insert mass of "+ strName2 + ":");
                celestialBody.setMassa(nMass2);
                celestialBody.id.setId(strName2,TypeOfCelestianBody.PLANET);
                System.out.println("ID creato: " + celestialBody.id.getId());
                arrayListCelestianBody.add(celestialBody);
                break;
            case MOON:
                String strName3=it.unibs.fp.mylib.InputDati.leggiStringa("Insert name "+ strType +":");
                celestialBody.setName(strName3);
                int nMass3= InputDati.leggiIntero("Insert mass of "+ strName3 + ":");
                celestialBody.setMassa(nMass3);
                String strNamePlanet=InputDati.leggiStringa("Insert the planet: ");
                int indexPlanet = findIndexCelestianBody(strNamePlanet);
                celestialBody.id.setId(strName3,TypeOfCelestianBody.MOON);
                System.out.println("\nID creato: " + celestialBody.id.getId()+ "\n");
                arrayListCelestianBody.add(indexPlanet+1,celestialBody);
                break;
        }





    }

    public boolean deleteCelestianBody(String strType){

        String str2= it.unibs.fp.mylib.InputDati.leggiStringa("Insert the" + strType +" name you want to delete: ");
        arrayListCelestianBody.remove(findIndexCelestianBody(str2));
        if (findIndexCelestianBody(str2) != -1){
            return true;
        }
        return false;
    }

    public int findIndexCelestianBody(String strCelestianbody){
        int i;
        for(i=0; i<arrayListCelestianBody.size(); i++) {
            if (strCelestianbody.equals(getCelestialBody(i).getName())) {
                return i;
            }
        }
        return i=-1;
    }

    public Point calculateMiddle(){
        Point point = new Point();
        float x = 0,y = 0;
        float sommaMasse = 0 ;
        for (int i = 0; i < arrayListCelestianBody.size(); i++){
            sommaMasse += getCelestialBody(i).getMassa();
            x += getCelestialBody(i).getMassa() * getCelestialBody(i).getPositionAbs().getX();
            y += getCelestialBody(i).getMassa() * getCelestialBody(i).getPositionAbs().getY();
        }
        point.setX(x/sommaMasse);
        point.setY(y/sommaMasse);
        return point;
    }

    public void printInfoBody(){

    }

    public boolean findCelestialBody (String strType, TypeOfCelestianBody typeOfCelestianBody) {
        switch (typeOfCelestianBody) {
            case PLANET:
                String str2= it.unibs.fp.mylib.InputDati.leggiStringa("Insert the" + strType +" name you want to find: ");
                if (findIndexCelestianBody(str2) != -1){
                    System.out.println("planet found");
                    return true;
                }
                break;

            case MOON:
                String str3= it.unibs.fp.mylib.InputDati.leggiStringa("Insert the" + strType +" name you want to find: ");


                break;
        }

        return false;
    }


}
