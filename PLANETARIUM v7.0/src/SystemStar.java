import it.unibs.fp.mylib.InputDati;
import java.util.ArrayList;

public class SystemStar {

    ArrayList arrayListCelestianBody = new ArrayList<CelestialBody>();
    CelestialBody celestialBody = new CelestialBody();
    Point pointMiddle = new Point();
    int numPlanet = 0;

    public CelestialBody getCelestialBody(int index) {
        return (CelestialBody) arrayListCelestianBody.get(index);
    }

    public void addCelestialBody(int index, String strType, TypeOfCelestianBody typeOfCelestianBody){

        if (typeOfCelestianBody == TypeOfCelestianBody.PLANET && numPlanet <26000){
            System.out.println("! ! ! ERROR reached maximum number of planets ! ! ! " );
            return;
        }

        Point pointPass = new Point();
        Point pointRight = new Point();
        boolean pos = false;

        System.out.println("");
        switch (InputDati.leggiStringa("insert the position \n [R] if relative \n [A] if absolute"+"\nInsert ...\n").toUpperCase()){
            case "A":
                pos = true;
                break;
            case "R":
                pos = false;
                break;
             default:
                 System.out.println("NUll");
        }
        pointPass.setY(InputDati.leggiIntero("Insert the x of "+ strType +":"));
        pointPass.setX(InputDati.leggiIntero("Insert the y of "+ strType +":"));

        switch (typeOfCelestianBody){
            case STAR:

                break;
            case PLANET:

                numPlanet++;
                break;
            case MOON:
                String strNamePlanet=InputDati.leggiStringa("Insert the planet: ");
                int indexPlanet = findIndexCelestianBody(strNamePlanet);
                if(getCelestialBody(indexPlanet).getNumMoon()>5000){
                    return;
                }
                int num = getCelestialBody(indexPlanet).getNumMoon()+1;
                getCelestialBody(indexPlanet).setNumMoon(num);

                break;
        }
    }

    public boolean deleteCelestianBody(String strType,TypeOfCelestianBody typeOfCelestianBody){
        switch (typeOfCelestianBody){
            case STAR:
                break;
            case PLANET:
                --numPlanet;
                break;
            case MOON:
                String strNamePlanet=InputDati.leggiStringa("Insert the planet: ");
                int indexPlanet = findIndexCelestianBody(strNamePlanet);
                int num = getCelestialBody(indexPlanet).getNumMoon()-1;
                getCelestialBody(indexPlanet).setNumMoon(num);
                break;
        }

        String str2= it.unibs.fp.mylib.InputDati.leggiStringa("Insert the" + strType +" name you want to delete: ");
        arrayListCelestianBody.remove(findIndexCelestianBody(str2));

        return findIndexCelestianBody(str2) != -1;
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
                        if (getCelestialBody(i).getIdCEl().getTypeOfCelestianBody() != TypeOfCelestianBody.PLANET){

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
                        if (getCelestialBody(i).getIdCEl().getTypeOfCelestianBody() == TypeOfCelestianBody.PLANET) {
                            System.out.println(getCelestialBody(0).getName() + "->" + getCelestialBody(i).getName() + str3 + "->" + str3);
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
                        if(getCelestialBody(i).getIdCEl().getTypeOfCelestianBody() == TypeOfCelestianBody.PLANET){
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