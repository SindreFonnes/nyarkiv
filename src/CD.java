public class CD {
    private int cdNr;
    private String Artist;
    private String Navn;
    private String Aar;
    private String Sjanger;
    private String Plateselskap;



    public CD(){

    }
    public CD (int cdNr, String Artist, String Navn, String Aar, String Sjanger, String Plateselskap){

        this.cdNr = cdNr;

        this.Artist = Artist;

        this.Navn = Navn;

        this.Aar = Aar;

        this.Sjanger = Sjanger;

        this.Plateselskap = Plateselskap;
    }

    public String getNavn() {
        return Navn;
    }

    public void setNavn(String navn) {
        Navn = navn;
    }
    public int getCdNr() {
        return cdNr;
    }

    public void setCdNr(int cdNr) {
        this.cdNr = cdNr;
    }

    public String getArtist() {
        return Artist;
    }

    public void setArtist(String artist) {
        Artist = artist;
    }

    public String getAar() {
        return Aar;
    }

    public void setAar(String aar) {
        Aar = aar;
    }

    public String getSjanger() {
        return Sjanger;
    }

    public void setSjanger(String sjanger) {
        Sjanger = sjanger;
    }

    public String getPlateselskap() {
        return Plateselskap;
    }

    public void setPlateselskap(String plateselskap) {
        Plateselskap = plateselskap;
    }

}
