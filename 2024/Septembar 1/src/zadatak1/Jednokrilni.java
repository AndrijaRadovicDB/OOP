package zadatak1;

public class Jednokrilni extends SvemirskiBrod {
    private float duzina;

    public Jednokrilni(String ime, String proizvodjac, float snagaMotora, float duzina) {
        super(ime, proizvodjac, snagaMotora);
        this.duzina = duzina;
    }

    @Override
    public float cena() {
        return this.duzina + this.getSnagaMotora();
    }

    @Override
    public String ispisiInformacije() {
        return "Ime: " + this.getIme() + ", Proizvodjac: " + this.getProizvodjac() + ", Snaga: " + this.getSnagaMotora() + ", Duzina: " + this.duzina + ", Cena: " + this.cena();
    }
}
