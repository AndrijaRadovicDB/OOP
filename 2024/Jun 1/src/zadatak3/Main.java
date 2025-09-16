package zadatak3;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Adreser adreser = new Adreser();
        adreser.dodaj(new Paket<>("Paket5", 4), "adresa1");
        adreser.dodaj(new Paket<>("Paket2", 8), "adresa2");
        adreser.dodaj(new Paket<>("Paket3", 12), "adresa3");
        adreser.dodaj(new Paket<>("Paket4", 16), "adresa4");
        System.out.println(adreser.print());

        Adreser adreserT  = new Adreser(new Comparator<Paket<String>>() {
            @Override
            public int compare(Paket<String> p1, Paket<String> p2) {
                return Double.compare(p1.getTezina(), p2.getTezina());
            }
        });
        adreserT.dodaj(new Paket<>("Paket5", 16), "adresa5");
        adreserT.dodaj(new Paket<>("Paket6", 19), "adresa6");
        adreserT.dodaj(new Paket<>("Paket7", 24), "adresa7");
        adreserT.dodaj(new Paket<>("Paket8", 12), "adresa8");
        System.out.println(adreserT.print());
    }
}
