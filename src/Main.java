import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        CDArkiv cdArkiv1 = new CDArkiv(10);
        CDArkiv2 cdArkiv2 = new CDArkiv2();
        Tekstgrensesnitt tekstgrensesnitt = new Tekstgrensesnitt();
        cdArkiv1.leggTilCd(tekstgrensesnitt.lesCD());
        cdArkiv2.leggTilCd(tekstgrensesnitt.lesCD());
        CD[] cder = cdArkiv1.hentCdTabell();
        tekstgrensesnitt.visCD(cder[0]);
        CD[] cder2 = cdArkiv2.hentCdTabell();
        tekstgrensesnitt.visCD(cder2[0]);
        Scanner scanner = new Scanner(System.in);
        tekstgrensesnitt.skrivUtCdArtist(cdArkiv1 ,scanner.nextLine());
        tekstgrensesnitt.skrivUtCdArtist(cdArkiv2, scanner.nextLine());
        tekstgrensesnitt.skrivUtCdDelstrengITittel(cdArkiv1, scanner.nextLine());
        tekstgrensesnitt.skrivUtCdDelstrengITittel(cdArkiv2, scanner.nextLine());
        tekstgrensesnitt.skrivUtStatistikk(cdArkiv1);
        tekstgrensesnitt.skrivUtStatistikk(cdArkiv2);
    }

}
