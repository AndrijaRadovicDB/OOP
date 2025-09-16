import java.util.Optional;

public class Test {
    public static void main(String[] args) {
        Osoba[] osobe1 = new Osoba[4];
        osobe1[0] = new Osoba("Marko", "Markovic");
        osobe1[1] = new Osoba("Juan", "Juan");
        osobe1[2] = new Osoba("Maria", "Maria");
        osobe1[3] = new Osoba("Petar", "Petrovic");
        MatematickiSkup<Osoba> s1 = new MatematickiSkup<Osoba>("s1", osobe1, 4);
        Osoba[] osobe2 = new Osoba[4];
        osobe2[0] = new Osoba("Juan", "Juan");
        osobe2[1] = new Osoba("Pero", "Peric");
        osobe2[2] = new Osoba("Mitar", "Miric");
        osobe2[3] = new Osoba("Petar", "Xing");
        MatematickiSkup<Osoba> s2 = new MatematickiSkup<Osoba>("s2", osobe2, 4);

        System.out.println(s1.toString());
        System.out.println(s2.toString());

        MatematickiSkup<Osoba> unija = s1.unija(s2);
        System.out.println(unija.toString());
        Optional<Osoba> maxOsoba = unija.nadjiMaksimum();
        if(maxOsoba.isPresent()) {
            System.out.println(maxOsoba.get());
        }
        else {
            System.out.println("Maksimum ne postoji!");
        }
    }
}