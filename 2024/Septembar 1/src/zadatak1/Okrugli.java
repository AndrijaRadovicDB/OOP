package zadatak1;

public class Okrugli extends SvemirskiBrod {
    private float poluprecnik;

    public Okrugli(String ime, String proizvodjac, float snagaMotora, float poluprecnik) {
        super(ime, proizvodjac, snagaMotora);
        this.poluprecnik = poluprecnik;
    }

    @Override
    public float cena() {
        float povrsinaKruga = (float)(this.poluprecnik * this.poluprecnik * Math.PI);
        return povrsinaKruga * this.getSnagaMotora();
    }

    @Override
    public String ispisiInformacije() {
        return "Ime: " + this.getIme() + ", Proizvodjac: " + this.getProizvodjac() + ", Snaga: " + this.getSnagaMotora() + ", Poluprecnik: " + this.poluprecnik + ", Cena: " + this.cena();
    }
}
