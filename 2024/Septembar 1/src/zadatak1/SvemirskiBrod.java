package zadatak1;

public abstract class SvemirskiBrod implements Informacije {
    private String ime, proizvodjac;
    private float snagaMotora;

    public SvemirskiBrod(String ime, String proizvodjac, float snagaMotora) {
        this.ime = ime;
        this.proizvodjac = proizvodjac;
        this.snagaMotora = snagaMotora;
    }

    public String getIme() {
        return ime;
    }

    public String getProizvodjac() {
        return proizvodjac;
    }

    public float getSnagaMotora() {
        return snagaMotora;
    }

    public abstract float cena();

    @Override
    public String toString() {
        return "Ime: " + this.ime + ", Proizvodjac: " + this.proizvodjac + ", Snaga motora: " + this.snagaMotora;
    }
}
