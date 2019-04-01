import it.unibs.fp.mylib.InputDati;
import java.util.ArrayList;

public class SystemStar {

    ArrayList<CelestialBody> arrayListCelestianBody = new ArrayList<>();
    Integer numPlanet = 0;

    public CelestialBody getCelestialBody(int index) {
        return arrayListCelestianBody.get(index);
    }

    public void addCelestialBody(int index, String strType, TypeOfCelestianBody typeOfCelestianBody){

        if (typeOfCelestianBody == TypeOfCelestianBody.PLANET && numPlanet >26000){
            System.out.println("! ! ! ERROR reached maximum number of planets ! ! ! " );
            return;
        }

        Point pointPass = new Point(0,0);
        boolean pos = false;
        String strName = InputDati.leggiStringa("insert the name of " +strType +":");
        int massa = InputDati.leggiIntero("insert weight of " + strType+ ":");
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
                Id idS = new Id(strName,typeOfCelestianBody);
                CelestialBody cbS = new CelestialBody(strName,massa,0,pointPass.getX(),pointPass.getY(),idS);
                arrayListCelestianBody.add(0,cbS);
                break;
            case PLANET:
                float x=0;
                float y=0;
                if (pos){
                     x= pointPass.getX() + getCelestialBody(0).getPositionAbs().getX();
                     y= pointPass.getY() + getCelestialBody(0).getPositionAbs().getY();
                }
                Id idP = new Id(strName,typeOfCelestianBody);
                CelestialBody cbP = new CelestialBody(strName,massa,0,x,y,idP);
                arrayListCelestianBody.add(cbP);
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
                float xm=0;
                float ym=0;
                if (pos){
                    xm= pointPass.getX() + getCelestialBody(indexPlanet).getPositionAbs().getX();
                    ym= pointPass.getY() + getCelestialBody(indexPlanet).getPositionAbs().getY();
                }

                Id idM = new Id(strName,typeOfCelestianBody);
                CelestialBody cbM = new CelestialBody(strName,massa,0,xm,ym,idM);
                arrayListCelestianBody.add(indexPlanet+1,cbM);
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
        Point point = new Point(0,0);
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
                    int indexCelestianBody= findIndexCelestianBody(str2);
                    int i;
                    boolean flag =false;
                    i=indexCelestianBody+1;
                    do{
                        if(i==arrayListCelestianBody.size()){
                            break;
                        }

                        if (getCelestialBody(i).getIdCEl().getTypeOfCelestianBody() != typeOfCelestianBody ){
                            System.out.println(getCelestialBody(i).getName());
                        }else {
                            flag=true;
                        }
                        i++;
                    }while (!flag);

                }
                return true;

            case MOON:
                String str3= it.unibs.fp.mylib.InputDati.leggiStringa("Insert the" + strType +" name you want to print the info about ");
                if (findIndexCelestianBody(str3) != -1){
                    int indexCelestianBody= findIndexCelestianBody(str3);
                    int i;
                    boolean flag =false;
                    i=indexCelestianBody-1;
                    do{

                        if (getCelestialBody(i).getIdCEl().getTypeOfCelestianBody() == typeOfCelestianBody){
                            System.out.println(getCelestialBody(0).getName() + "->" + getCelestialBody(i).getName() + str3 + "->" + str3);
                        }else {
                            flag=true;
                        }
                        i--;
                        if(i==1){
                            break;
                        }

                    }while (!flag);

                }
                return true;
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