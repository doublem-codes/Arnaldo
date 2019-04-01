import it.unibs.fp.mylib.InputDati;
import java.util.ArrayList;

public class SystemStar {
   ArrayList<CelestialBody> arrayListCelestianBody = new ArrayList<>();
   private static int  numPlanet = 0;

    public CelestialBody getCelestialBody(int index) {
        return arrayListCelestianBody.get(index);
    }

    //metod used to add element at arrayList
    public void addCelestialBody( String strType, TypeOfCelestianBody typeOfCelestianBody){

        if (typeOfCelestianBody == TypeOfCelestianBody.PLANET && numPlanet > 26000){//check number max planet
            System.out.println("! ! ! ERROR reached maximum number of planets ! ! ! " );
            return;
        }

        Point pointPass = new Point(0,0);
        boolean pos ;
        String strName = InputDati.leggiStringa("insert the name of " + strType + ":"); //input name of celestilbody
        int weight = InputDati.leggiIntero("insert weight of " + strType + ":"); //input weight of celestilbody
        // make choose of insert position
        switch (InputDati.leggiStringa("insert the position \n [R] if relative \n [A] if absolute" + "\nInsert ...\n").toUpperCase()){
            case "A":
                pos = false;
                break;
            case "R":
                pos = true;
                break;
             default:
                 pos = false;
                 System.out.println("NUll");
        }
        //input point of celestilbody
        pointPass.setY(InputDati.leggiIntero("Insert the x of " + strType + ":"));
        pointPass.setX(InputDati.leggiIntero("Insert the y of " + strType + ":"));

        switch (typeOfCelestianBody){
            case STAR:
                Id idS = new Id(strName,typeOfCelestianBody); //generate ID
                CelestialBody cbS = new CelestialBody(strName, weight,0, pointPass.getX(), pointPass.getY(), idS);
                arrayListCelestianBody.add(0,cbS);//add star at arrayList
                break;
            case PLANET:
                float x = 0;
                float y = 0;
                if (pos){ // convertion position if point is relative
                     x = pointPass.getX() + getCelestialBody(0).getPositionAbs().getX();
                     y = pointPass.getY() + getCelestialBody(0).getPositionAbs().getY();
                }
                Id idP = new Id(strName,typeOfCelestianBody);//generate ID
                CelestialBody cbP = new CelestialBody(strName, weight,0, x, y, idP);
                arrayListCelestianBody.add(cbP);//add plane at arrayList
                numPlanet++; //increment number of planet
                break;
            case MOON:
                String strNamePlanet = InputDati.leggiStringa("Insert the planet: "); // input name planet of moon
                int indexPlanet = findIndexCelestianBody(strNamePlanet);// extract index of planet
                if(getCelestialBody(indexPlanet).getNumMoon()>5000){//check number max moon
                    System.out.println("! ! ! ERROR reached maximum number of moon for this planet ! ! ! " );
                    return;
                }
                int num = getCelestialBody(indexPlanet).getNumMoon()+1;//change value of moon of planet current
                getCelestialBody(indexPlanet).setNumMoon(num);
                float xm = 0;
                float ym = 0;
                if (pos){ // convertion position if point is relative
                    xm = pointPass.getX() + getCelestialBody(indexPlanet).getPositionAbs().getX();
                    ym = pointPass.getY() + getCelestialBody(indexPlanet).getPositionAbs().getY();
                }
                Id idM = new Id(strName,typeOfCelestianBody);//generate ID
                CelestialBody cbM = new CelestialBody(strName,weight,0,xm,ym,idM);
                arrayListCelestianBody.add(indexPlanet+1,cbM);//add moon at arrayList
                break;
        }
    }

    public boolean deleteCelestianBody(String strType,TypeOfCelestianBody typeOfCelestianBody){
        String str2 = it.unibs.fp.mylib.InputDati.leggiStringa("Insert the" + strType +" name you want to delete: ");//name of element to remove
        arrayListCelestianBody.remove(findIndexCelestianBody(str2));// delete celstialbody
        switch (typeOfCelestianBody){
            case STAR:
                break;
            case PLANET:
                --numPlanet;//decrement number of planet
                break;
            case MOON:
                String strNamePlanet = InputDati.leggiStringa("Insert the planet: ");//input name plane of moon
                int indexPlanet = findIndexCelestianBody(strNamePlanet);// extract index of planet
                int num = getCelestialBody(indexPlanet).getNumMoon() - 1;//change value of moon of planet current
                getCelestialBody(indexPlanet).setNumMoon(num);
                break;
        }
        return true;
    }

    public int findIndexCelestianBody(String strCelestianbody){
        int i;
        for(i = 0; i < arrayListCelestianBody.size(); i++) {//used for scroll array to chek and find index of celestyalbody
            if (strCelestianbody.equals(getCelestialBody(i).getName())) {
                return i;
            }
        }
        return -1;
    }

    public Point calculateMiddle(){//calculate weighted average
        Point point = new Point(0,0);
        float x = 0, y = 0;
        float sommaMasse = 0;
        for (int i = 0; i < arrayListCelestianBody.size(); i++){
            sommaMasse += getCelestialBody(i).getMassa(); //sum weight of all celestyalbody
            x += (getCelestialBody(i).getMassa() * getCelestialBody(i).getPositionAbs().getX()); //partialx sum weight*position
            y += (getCelestialBody(i).getMassa() * getCelestialBody(i).getPositionAbs().getY());//partialy sum weight*position
        }
        point.setX(x / sommaMasse);//generate right point of middle centeer weigth
        point.setY(y / sommaMasse);
        return point;
    }

    public boolean printInfoBody(String strType, TypeOfCelestianBody typeOfCelestianBody){

        switch (typeOfCelestianBody) {
            case PLANET:
                String str2= it.unibs.fp.mylib.InputDati.leggiStringa("Insert the" + strType +" name you want to print the info about ");//input name of planet
                if (findIndexCelestianBody(str2) != -1){ //if don't found return -1
                    int indexCelestianBody = findIndexCelestianBody(str2); //find index of planet
                    int i;
                    boolean flag = false;
                    i = indexCelestianBody+1;
                    do{
//_______________________________________________________________________________________________________________________
//_______________________________________________________________________________________________________________________
//___________________________________________UTILITA IF__________________________________________________________________
//_______________________________________________________________________________________________________________________
//_______________________________________________________________________________________________________________________
                        if(i == arrayListCelestianBody.size()){
                            break;
                        }
                        if (getCelestialBody(i).getIdCEl().getTypeOfCelestianBody() != typeOfCelestianBody ){
                            System.out.println(getCelestialBody(i).getName());// print all moon of planet
                        }else {
                            flag=true;
                        }
                        i++;
                    }while (!flag);

                }
                break;

            case MOON:

                break;
        }

        return false;
    }

    public boolean findCelestialBody (String strType, TypeOfCelestianBody typeOfCelestianBody) {
        //metod used for find celestyalbody in arrayList
        switch (typeOfCelestianBody) {
            case PLANET:
                String str2 = it.unibs.fp.mylib.InputDati.leggiStringa("Insert the" + strType +" name you want to find: ");//input name of planet
                if (findIndexCelestianBody(str2) != -1){//if don't found return -1
                    System.out.println("planet found");
                    return true;
                }
                break;

            case MOON:
                String str3 = it.unibs.fp.mylib.InputDati.leggiStringa("Insert the" + strType +" name you want to find: ");//input name of moon
                if (findIndexCelestianBody(str3) != -1){//if don't found return -1
                    System.out.println("moon planet found");
                    int i;
                    boolean flag = false;
                    for(i = findIndexCelestianBody(str3); flag; i--){//check name of planet of moon
                        if(getCelestialBody(i).getIdCEl().getTypeOfCelestianBody() == TypeOfCelestianBody.PLANET){
                            System.out.println("The planet is:" + getCelestialBody(i).getName());
                            flag = true;
                        }
                    }
                    return true;
                }
                break;
        }
        return false;
    }
}