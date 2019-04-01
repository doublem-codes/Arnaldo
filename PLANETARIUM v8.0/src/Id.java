public class Id {
    private String id;
    private TypeOfCelestianBody typeOfCelestianBody ;

    public Id(String strings , TypeOfCelestianBody types){
        this.id = calculateId(strings);
        this.typeOfCelestianBody = types;

    }

    public String getId(){
        return id;
    }

    public TypeOfCelestianBody getTypeOfCelestianBody() {
        return typeOfCelestianBody;
    }

    public String calculateId(String strings ){
        String app1;
        String stringTrim = strings.trim();//delete space from string
        String app = deleteVocal(stringTrim.toUpperCase());//deletevocal from string
        switch (app.length()){ //controllo lunghezza id
            case 0:
                app1 =changeVocal(strings).substring(0,4);
                break;
            case 1:
                app1= app.substring(0,4).trim() + changeVocal(strings).substring(0,3);
                break;
            case 2:
                app1 = app.substring(0, 4) + app.substring(0, 4);
                break;
            case 3:
                app1 = app.substring(0, 4) + changeVocal(strings).substring(0,1);
                break;
            default:
                app1 = app.substring(0, 4);
                break;
        }
        return app1;
    }

    private String changeVocal(String s){
        char[] x = s.toCharArray();
        for (int i=0 ; i < x.length; i++){
            switch (x[i]){
                case 'a':
                    x[i] = 'b';
                    break;
                case 'e':
                    x[i] = 'q';
                    break;
                case 'i':
                    x[i] = 'z';
                    break;
                case 'o':
                    x[i] = 'w';
                    break;
                case 'u':
                    x[i] = 'm';
                    break;
                default:
                    break;
            }
        }
        return x.toString();
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
