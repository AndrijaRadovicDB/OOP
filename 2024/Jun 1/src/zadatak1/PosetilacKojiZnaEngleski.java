package zadatak1;

public class PosetilacKojiZnaEngleski extends Posetilac implements EngleskiJezik {

    public PosetilacKojiZnaEngleski(String ime, MuzickiZanr zanr, int pocetakSlobodnogVremena, int krajSlobodnogVremena) {
        super(ime, zanr, pocetakSlobodnogVremena, krajSlobodnogVremena);
    }

    @Override
    public String pozdravNaEngleskom() {
        return "I am visitor " + this.getIme() + " and I like to listen to " + this.getZanr() + " music";
    }

    @Override
    public String toString() {
        return pozdravNaEngleskom();
    }
}
