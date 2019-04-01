public class Id {

    private String id;
    TypeOfCelestianBody typeOfCelestianBody ;

    public String getId(){
        return id;
    }


    public TypeOfCelestianBody getTypeOfCelestianBody() {
        return typeOfCelestianBody;
    }

    public void setId(String strings , TypeOfCelestianBody types){

        String stringTrim = strings.trim();//delete space from string
        String app = deleteVocal(stringTrim.toUpperCase());//deletevocal from string
        String app1 = app.substring(0, 4);
        this.id= app1;// return index + substring of 4 element
        this.typeOfCelestianBody = types;
    }

    private static String deleteVocal(String s) {

        if (s.equals("")) return "";
        else if (s.charAt(0)=='A'||
                s.charAt(0)=='E'||
                s.charAt(0)=='I'||
                s.charAt(0)=='O'||
                s.charAt(0)=='U'
        ) return deleteVocal(s.substring(1));
        else return s.substring(0,1) + deleteVocal(s.substring(1));
    }

}
