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

        Point point = new Point();

        String strName1=it.unibs.fp.mylib.InputDati.leggiStringa("Insert name "+ strType +":");
        celestialBody.setName(strName1);
        int nMass1= InputDati.leggiIntero("Insert mass of "+ strName1 + ":");
        celestialBody.setMassa(nMass1);
        int x =InputDati.leggiIntero("Insert the x of "+ strType +":");
        celestialBody.point.setX(x);
        int y =InputDati.leggiIntero("Insert the y of "+ strType +":");
        celestialBody.point.setX(y);

        switch (typeOfCelestianBody){
            case STAR:
                celestialBody.id.setId(strName1,TypeOfCelestianBody.STAR);
                System.out.println("ID creato: " + celestialBody.id.getId());
                arrayListCelestianBody.add(0,celestialBody);
                break;
            case PLANET:
                celestialBody.id.setId(strName1,TypeOfCelestianBody.PLANET);
                System.out.println("ID creato: " + celestialBody.id.getId());
                arrayListCelestianBody.add(celestialBody);
                break;
            case MOON:
                String strNamePlanet=InputDati.leggiStringa("Insert the planet: ");
                int indexPlanet = findIndexCelestianBody(strNamePlanet);
                celestialBody.id.setId(strName1,TypeOfCelestianBody.MOON);
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
        return -1;
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

    public boolean printInfoBody(String strType, TypeOfCelestianBody typeOfCelestianBody){


        switch (typeOfCelestianBody) {
            case PLANET:
                String str2= it.unibs.fp.mylib.InputDati.leggiStringa("Insert the" + strType +" name you want to print the info about ");
                if (findIndexCelestianBody(str2) != -1){
                    int i;
                    boolean flag =false;
                    for (i=findIndexCelestianBody(str2);flag;i++){
                        if (getCelestialBody(i).id.typeOfCelestianBody != TypeOfCelestianBody.PLANET){

                            System.out.println(getCelestialBody(i).getName());
                        }else {
                            flag=true;
                        }
                    }
                    return true;
                }
                break;

            case MOON:
                String str3= it.unibs.fp.mylib.InputDati.leggiStringa("Insert the" + strType +" name you want to print the info about: ");
                if (findIndexCelestianBody(str3) != -1){
                    int i;
                    boolean flag=false;
                    for (i=findIndexCelestianBody(str3)-1;flag;i--){
                        if (getCelestialBody(i).id.typeOfCelestianBody == TypeOfCelestianBody.PLANET) {
                            System.out.println(getCelestialBody(0).getName() + "->" +getCelestialBody(i).getName() + str3);
                            flag = true;
                        }
                    }
                    return true;
                }

                break;
        }

        return false;
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
                if (findIndexCelestianBody(str3) != -1){
                    System.out.println("moon planet found");
                    int i;
                    boolean flag=false;
                    for(i=findIndexCelestianBody(str3);flag; i--){
                        if(getCelestialBody(i).id.typeOfCelestianBody==TypeOfCelestianBody.PLANET){
                            System.out.println("The planet is:" + getCelestialBody(i).getName());
                            flag=true;
                        }
                    }
                    return true;
                }

                break;
        }

        return false;
    }


}
