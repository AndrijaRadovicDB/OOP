package zadatak1;

public class Dvokrilni extends SvemirskiBrod {
    private float duzina, sirina;

    public Dvokrilni(String ime, String proizvodjac, float snagaMotora, float duzina, float sirina) {
        super(ime, proizvodjac, snagaMotora);
        this.duzina = duzina;
        this.sirina = sirina;
    }

    @Override
    public float cena() {
        return (this.duzina + this.getSnagaMotora())*this.sirina;
    }

    @Override
    public String ispisiInformacije() {
        return "Ime: " + this.getIme() + ", Proizvodjac: " + this.getProizvodjac() + ", Snaga: " + this.getSnagaMotora() + ", Duzina: " + this.duzina + ", Sirina: " + this.sirina + ", Cena: " + this.cena();
    }
}
