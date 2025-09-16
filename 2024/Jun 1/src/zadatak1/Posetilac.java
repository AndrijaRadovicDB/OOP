package zadatak1;

public class Posetilac extends Osoba implements Cloneable {
    private int pocetakSlobodnogVremena, krajSlobodnogVremena;

    public Posetilac(String ime, MuzickiZanr zanr, int pocetakSlobodnogVremena, int krajSlobodnogVremena) {
        super(ime, zanr);
        this.pocetakSlobodnogVremena = pocetakSlobodnogVremena;
        this.krajSlobodnogVremena = krajSlobodnogVremena;
    }

    public int getPocetakSlobodnogVremena() {
        return pocetakSlobodnogVremena;
    }

    public int getKrajSlobodnogVremena() {
        return krajSlobodnogVremena;
    }

    @Override
    public String toString() {
        return "Ja sam posetilac " + this.getIme() + " i volim da slusam " + this.getZanr() + " muziku";
    }

    @Override
    public Posetilac clone() throws CloneNotSupportedException {
        return (Posetilac)super.clone();
    }
}
