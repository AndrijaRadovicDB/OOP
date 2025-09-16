package com.example.januar1;

public abstract class Poklon implements Comparable<Poklon> {
    private String naziv, ID;
    private int cena;

    public Poklon(String naziv, String ID, int cena) {
        this.naziv = naziv;
        this.ID = ID;
        this.cena = cena;
    }

    public String getNaziv() {
        return naziv;
    }

    public String getID() {
        return ID;
    }

    public int getCena() {
        return cena;
    }

    public abstract boolean prikladanPoklon(PolDeteta polDeteta);

    @Override
    public int compareTo(Poklon o) {
        return Integer.compare(this.getCena(), o.getCena());
    }

    @Override
    public String toString() {
        return this.ID + " - " + this.naziv + ", " + this.cena + " din";
    }
}
