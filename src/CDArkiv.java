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

    public void slettCD(String cdTittel){
        for(int i = 0; i< cdArray.length; i++){
            if(cdArray[i].getNavn()==cdTittel) {
                cdArray[i] = null;
                return;
            }
        }
        System.out.println("Fant ingen cder med det navnet");
    }

    @Override
    public CD[] hentCdTabell() {
        return new CD[0];
    }

    @Override
    public void leggTilCd(CD nyCd) {

    }

    @Override
    public boolean slettCd(int cdNr) {
        return false;
    }

    @Override
    public CD[] sokTittel(String delstreng) {
        return new CD[0];
    }

    @Override
    public CD[] sokArtist(String delstreng) {
        int[] cdnummere= new int[cdArray.length];
        int teller = 0;
        for(int i = 0; i<cdArray.length; i++){
            if(cdArray[i].getArtist()==delstreng){
                cdnummere[teller] = i;
                teller ++;
            }
        }
        int teller2 = 0;
        for(int i = 0; i< cdnummere.length; i++){
            if(cdnummere[i]!=0){
                teller2++;
            }
        }
        return new CD[0];
    }

    @Override
    public int antallSjanger(Sjanger sjanger) {
        return 0;
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
