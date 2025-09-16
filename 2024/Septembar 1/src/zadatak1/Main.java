package zadatak1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<SvemirskiBrod> brodovi = new ArrayList<>();
        brodovi.add(new Dvokrilni("XLR8", "Azmut", 12, 20, 30));
        brodovi.add(new Jednokrilni("Dragan", "Bubreg", 30, 50));
        brodovi.add(new Okrugli("Krug", "Lopta", 50, 20));

        Cenovnik cenovnik = new Cenovnik(brodovi);
        System.out.println(cenovnik.ukupnaCena());
        for(SvemirskiBrod brod : brodovi) {
            System.out.println(brod.ispisiInformacije());
        }
        cenovnik.kupiBrod("fdsgfs");
    }
}
