
import java.lang.System;
import java.util.ArrayList;


public class Utilty {

    public Utilty(){

    }
    //Menu message

    private String msgA = "[A]: Add a celestian body";
    private String msgD = "[D]: Delete a celestian body";
    private String msgE = "[E]: End process";
    private String msgF = "[F]: Find a celestian body";
    private String msgI = "[I]: Info about a celestian body";

    //ADD message
    private String msgAM = "[M]: Add a moon";
    private String msgAS = "[S]: Add a star";
    private String msgAP = "[P]: Add a planet";

    //DELETE message
    private String msgDM = "[M]: Delete a moon";
    private String msgDS = "[S]: Delete a star";
    private String msgDP = "[P]: Delete a planet";

    //Default message
    private String msg1 = "Select one of the following method";
    private String msg2 = "Insert ...";

    //State Initialize
    private State state = State.NULL;

    private String str1,str2,str3, str4 ;


    public boolean menu(){
        System.out.println(msg1 + "\n" + msgA +"\n" + msgD + "\n" + msgF + "\n" + msgI + "\n" + msgE);
        str1 = it.unibs.fp.mylib.InputDati.leggiStringa("\n"+ msg2);

        boolean endProcess = false;

        switch (str1.toUpperCase()){
            case "A":
                System.out.println(msg1 + "\n" + msgAS + "\n" + msgAP + "\n" + msgAM);
                str2= it.unibs.fp.mylib.InputDati.leggiStringa("\n" + msg2);
                switch (str2.toUpperCase()) {
                    case "S":
                        state = State.ADDSTAR;
                        break;
                    case "P":
                        state=State.ADDPLANET;
                        break;
                    case "M":
                        state=State.ADDMOON;

                        break;
                }
                break;

            case "D":
                System.out.println(msg1 + "\n" + msgDS + "\n" + msgDP + "\n" + msgDM);
                str2= it.unibs.fp.mylib.InputDati.leggiStringa("\n" + msg2);
                switch (str2.toUpperCase()) {
                    case "S":
                        state = State.DELETESTAR;
                        break;
                    case "P":
                        state=State.DELETEPLANET;
                        break;
                    case "M":
                        state=State.DELETEMOON;
                        break;
                }
                break;
            case "F":
                state = State.FIND;
                break;
            case "I":
                state = State.INFO;
                break;
            case "E":
                System.out.println("End process");
                endProcess = true;
                break;
            default:
                state = State.NULL;// richiamo utility menu;
                break;
        }
        return endProcess;
    }

    SystemStar systemStar = new SystemStar();
    public void process(){

        int index = 0;

        switch (state) {
            case ADDSTAR:
                systemStar.addCelestialBody(0, "Star");
                break;

            case ADDPLANET:
                systemStar.addCelestialBody(0, "Planet");
                break;

            case ADDMOON:
                systemStar.addCelestialBody(0, "Moon");
                break;

            case DELETEPLANET:
                str3= it.unibs.fp.mylib.InputDati.leggiStringa("Insert the planet name you want to delete: ");
                int i;
                for(i=0; i<=systemStar.arrayListCelestianBody.size(); i++) {
                    if (str3.equals(systemStar.getCelestialBody(i).getName())) {
                        systemStar.arrayListCelestianBody.remove(i);
                    }
                }
                break;

            case DELETEMOON:
                str4= it.unibs.fp.mylib.InputDati.leggiStringa("Insert the moon name you want to delete: ");
                break;
            case FIND:
                break;

            case INFO:
                break;

            default:
                System.out.println("NULL");
                break;
        }
    }

    public void reset(){
        str2 = str1 = str3 = "";
    }


}
