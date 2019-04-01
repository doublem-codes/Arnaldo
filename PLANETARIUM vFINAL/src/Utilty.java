import java.lang.System;
import java.util.ArrayList;

public class Utilty {
    // MENU message
    private String msgA = "[A]: Add a celestian body";
    private String msgD = "[D]: Delete a celestian body";
    private String msgE = "[E]: End process";
    private String msgF = "[F]: Find a celestian body";
    private String msgI = "[I]: Info about a celestian body";
    private String msgC = "[C]: Calculate system mass middle";
    //ADD message
    private String msgAM = "[M]: Add a moon";
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
    private TypeOfCelestianBody typeOfCelestianBody = TypeOfCelestianBody.NULL;
    private boolean bool = true;

    SystemStar systemStar = new SystemStar();
    Point middle = new Point(0,0);

    public boolean menu(){
        System.out.println(msg1 + "\n" + msgA +"\n" + msgD + "\n" + msgF + "\n" + msgI + "\n" + msgC+ "\n" + msgE);
        boolean endProcess = false;

        switch (it.unibs.fp.mylib.InputDati.leggiStringa("\n"+ msg2).toUpperCase()){
            case "A":
                System.out.println(msg1);
                if(bool){
                    String msgAS = "[S]: Add a star";
                    System.out.print("\n" + msgAS);
                }
                System.out.print( "\n" + msgAP +"\n" +msgAM);
                switch (it.unibs.fp.mylib.InputDati.leggiStringa("\n" + msg2).toUpperCase()) {
                    case "S":
                        state = State.ADDSTAR;
                        bool = false;
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
                switch (it.unibs.fp.mylib.InputDati.leggiStringa("\n" + msg2).toUpperCase()) {
                    case "S":
                        state = State.DELETESTAR;
                        bool = true;
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

            case "C":
                state=State.CALCULATEMIDDLE;
                break;
            default:
                state = State.NULL;
                break;
        }
        return endProcess;
    }

    public void process(){

        switch (state) {

            case ADDSTAR:
                systemStar.addCelestialBody( "Star", TypeOfCelestianBody.STAR);
                break;

            case ADDPLANET:
                systemStar.addCelestialBody( "Planet",TypeOfCelestianBody.PLANET);
                break;

            case ADDMOON:
                systemStar.addCelestialBody("Moon",TypeOfCelestianBody.MOON);
                break;

            case DELETEPLANET:
                if(! systemStar.deleteCelestianBody("planet",TypeOfCelestianBody.PLANET)){
                    System.out.println("Planet not found");
                }
                break;

            case DELETEMOON:
                if(!systemStar.deleteCelestianBody("moon",TypeOfCelestianBody.MOON)){
                    System.out.println("Moon not found");
                }
                break;

            case FIND:
                System.out.println("Select a type of celestial body you want to find:" + "\n" + "[P]: planet"+ "\n" + "[M]: moon");

                switch (it.unibs.fp.mylib.InputDati.leggiStringa("\n" + msg2).toUpperCase()) {

                    case "P":
                        typeOfCelestianBody=TypeOfCelestianBody.PLANET;
                        break;
                    case "M":
                        typeOfCelestianBody=TypeOfCelestianBody.MOON;
                        break;
                }
                String strType = "";
                if (typeOfCelestianBody==TypeOfCelestianBody.PLANET){
                    strType="planet";
                }else if(typeOfCelestianBody == TypeOfCelestianBody.MOON){
                    strType="moon";
            }
                if(! systemStar.findCelestialBody(strType,typeOfCelestianBody)){
                    System.out.println(strType + "not found");
                }
                break;

            case INFO:
                System.out.println("Select a type of celestial body you want to print the info about:" + "\n" + "[P]: planet"+ "\n" + "[M]: moon");
                switch (it.unibs.fp.mylib.InputDati.leggiStringa("\n" + msg2).toUpperCase()) {

                    case "P":
                        typeOfCelestianBody=TypeOfCelestianBody.PLANET;
                        break;
                    case "M":
                        typeOfCelestianBody=TypeOfCelestianBody.MOON;
                        break;
                }
                String strType2 = "";
                if (typeOfCelestianBody==TypeOfCelestianBody.PLANET){
                    strType2="planet";
                }else if(typeOfCelestianBody == TypeOfCelestianBody.MOON){
                    strType2="moon";
                }
                if(!systemStar.printInfoBody(strType2,typeOfCelestianBody)){
                    System.out.println(strType2 + "not found");
                }
                break;

            case CALCULATEMIDDLE:
                middle = systemStar.calculateMiddle();
                System.out.println(middle.getX());
                System.out.println(middle.getY());
                break;

            default:
                System.out.println("NULL");
                break;
        }
    }
}
