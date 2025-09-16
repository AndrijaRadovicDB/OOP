package zadatak1;

public abstract class Osoba {
    private String ime;
    private MuzickiZanr zanr;

    public Osoba(String ime, MuzickiZanr zanr) {
        this.ime = ime;
        this.zanr = zanr;
    }

    public String getIme() {
        return ime;
    }

    public MuzickiZanr getZanr() {
        return zanr;
    }
}
