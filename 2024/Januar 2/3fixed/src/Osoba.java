
public class Osoba implements Comparable<Osoba> {
    private String ime, prezime;

    public Osoba(String ime, String prezime) {
        this.ime = ime;
        this.prezime = prezime;
    }

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    @Override
    public boolean equals(Object o) {
        Osoba osoba = (Osoba) o;
        if(osoba.getIme().equals(this.getIme()) && osoba.getPrezime().equals(this.getPrezime())) {
            return true;
        }
        return false;
    }

    @Override
    public int compareTo(Osoba o) {
        if(this.getIme().equals(o.getIme())) {
            return this.getPrezime().compareTo(o.getPrezime());
        }
        return this.getIme().compareTo(o.getIme());
    }

    @Override
    public String toString() {
        return this.getIme() + " " + this.getPrezime();
    }
}
