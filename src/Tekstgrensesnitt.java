import java.util.Scanner;

class Tekstgrensesnitt {

    // lese opplysningene om en CD fra tastatur
    public CD lesCD(){
        CD cd= new CD();
        String cdinfo2;
        int cdinfo3;
        for(int i= 0; i < 7; i++){
            if(i==1) System.out.println("SKriv CD nr!");
            else if(i==2)System.out.println("Skriv ARtist navn");
            else if(i==3)System.out.println("Skriv album navn ");
            else if(i==4)System.out.println("Skriv utgivelses år");
            else if(i==5)System.out.println(" Skriv album sjanger");
            else if(i==6)System.out.println("Skriv Plateselskap");

            Scanner cdinfo = new Scanner(System.in);
            if(i==1){
                cdinfo2 =  cdinfo.nextLine();
                cdinfo3=Integer.parseInt(cdinfo2);
                cd.setCdNr(cdinfo3);}
            else if (i==2){   cdinfo2 =  cdinfo.nextLine();
                cd.setArtist(cdinfo2);}
            else if(i==3){
                cdinfo2 =  cdinfo.nextLine();
                cd.setNavn(cdinfo2);}
            else if(i==4){
                cdinfo2 =  cdinfo.nextLine();
                cd.setAar(cdinfo2);
                cdinfo2 =  cdinfo.nextLine();}
            else if(i==5){
                cdinfo2 =  cdinfo.nextLine();
                Sjanger enSjanger = new Sjanger();
                enSjanger.setSjangere(cdinfo2);
                cd.setSjanger(enSjanger);}
            else if(i==6){
                cdinfo2 =  cdinfo.nextLine();
                cd.setPlateselskap(cdinfo2);}
        }
        return cd;
    }

    // vise en CD med alle opplysninger på skjerm (husk tekst for sjanger)
    public void visCD(CD cd){
        System.out.println("CD navn " + cd.getNavn());
        System.out.println("CD aarstall " +cd.getAar());
        System.out.println("CD nr " + cd.getCdNr());
        System.out.println("CD sjanger " + cd.getSjanger().getSjangerNavn());
        System.out.println("CD artist " + cd.getArtist());
        System.out.println("CD plateselskap " + cd.getPlateselskap());
    }
    // Skrive ut alle CD-er med en spesiell delstreng i tittelen
    public void skrivUtCdDelstrengITittel(CDarkivADT cda, String delstreng){
        CD[] cder = cda.sokTittel(delstreng);
        for(int i = 0; i<cder.length; i++){
            visCD(cder[i]);
        }
    }
    // Skriver ut alle CD-er av en artist / en gruppe
    public void skrivUtCdArtist(CDarkivADT cda, String delstreng) {
        CD[] cder = cda.sokArtist(delstreng);
        for(int i = 0; i<cder.length; i++){
            visCD(cder[i]);
        }
    }

    // Skrive ut en enkel statistikk som inneholder antall CD-er totalt
// og hvor mange det er i hver sjanger
    public void skrivUtStatistikk(CDarkivADT cda){
        System.out.println(cda.antall());
    }

//… Ev. andre metoder
}//class

