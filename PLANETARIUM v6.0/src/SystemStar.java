import java.util.ArrayList;

public class SystemStar {

    ArrayList<CelestialBody> arrayListCelestianBody = new ArrayList<>();
    Point pointMiddle = new Point();


    public ArrayList getArrayListCelestianBody() {
        return arrayListCelestianBody;
    }

    public CelestialBody getCelestialBody(int index) {
        return arrayListCelestianBody.get(index);
    }

    public void setCelestialBody(int index, CelestialBody celestialBody){
        arrayListCelestianBody.set(index,celestialBody);
    }

    public void setArrayListPlanet(ArrayList arrayListPlanet) {
        this.arrayListCelestianBody = arrayListPlanet;
    }

    public void addCelestialBody(String strType, TypeOfCelestianBody typeOfCelestianBody){



        switch (typeOfCelestianBody){
            case STAR:

                break;
            case PLANET:
                String str= it.unibs.fp.mylib.InputDati.leggiStringa("Nome pianeta: ");
                CelestialBody cb = new CelestialBody();
                arrayListCelestianBody.add(cb);
                break;
            case MOON:

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
                    for (i=findIndexCelestianBody(str2);i<getArrayListCelestianBody().size();i++){
                        if (getCelestialBody(i).id.typeOfCelestianBody != TypeOfCelestianBody.PLANET){
                            System.out.println(getCelestialBody(i).getName());
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
                    for (i=findIndexCelestianBody(str3)-1;i<getArrayListCelestianBody().size();i--){
                        if (getCelestialBody(i).id.typeOfCelestianBody == TypeOfCelestianBody.PLANET) {
                            System.out.println(getCelestialBody(0).getName() + "->" +getCelestialBody(i).getName() + str3);
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
