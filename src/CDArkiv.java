import java.util.Scanner;

public class CDArkiv implements CDarkivADT {
    private CD[] cdArray;

    public CDArkiv(int antallCDPlasser){
        cdArray = new CD[antallCDPlasser];
    }
    public void addCDToArray(CD enCD){
        for(int i= 0; i < cdArray.length; i++){
            if(cdArray[i]==null){
                cdArray[i]=enCD;
                return;
            }
        }
        System.out.println("Arkivet er fult, slett en cd først!");
    }

    @Override
    public CD[] hentCdTabell() {
        return cdArray;
    }

    @Override
    public void leggTilCd(CD nyCd) {
        for (int i = 0; i < cdArray.length; i++){
            if(cdArray[i]== null){
                cdArray[i] = nyCd;
                return;
            }
        }
    }



    @Override
    public boolean slettCd(int cdNr) {
        for(int i = 0; i<cdArray.length; i++){
            if(cdArray[i].getCdNr()==cdNr){
                cdArray[i] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public CD[] sokTittel(String delstreng) {
        int counter = 0;
        for(int i = 0; i<cdArray.length; i++){
            if(cdArray[i].getNavn().contains(delstreng)){
                counter++;
            }
        }
        if(counter>0){
            CD[] relevantCDs = new CD[counter];
            counter = 0;
            for(int i = 0; i<cdArray.length; i++){
                if(cdArray[i].getNavn().contains(delstreng)){
                    relevantCDs[counter]= cdArray[i];
                    counter++;
                }
            }
            return relevantCDs;
        }
        return null;
    }

    @Override
    public CD[] sokArtist(String delstreng) {
        int counter = 0;
        for(int i = 0; i<cdArray.length; i++){
            if(cdArray[i].getArtist().contains(delstreng)){
                counter++;
            }
        }
        if(counter>0){
            CD[] relevantCDs = new CD[counter];
            counter = 0;
            for(int i = 0; i<cdArray.length; i++){
                if(cdArray[i].getArtist().contains(delstreng)){
                    relevantCDs[counter]= cdArray[i];
                    counter++;
                }
            }
            return relevantCDs;
        }
        return null;
    }

    @Override
    public int antallSjanger(Sjanger sjanger) {
        int counter = 0;
        for(int i = 0; i<cdArray.length; i++){
            if(cdArray[i].getSjanger().getSjangerNavn()==sjanger.getSjangerNavn()){
                counter++;
            }
        }
        return counter;
    }

    @Override
    public int antall() {
        int antall = 0;
        for(int i = 0; i<cdArray.length; i++){
            if(cdArray[i].getNavn()!=null){
                antall++;
            }
        }
        return antall;
    }
}
