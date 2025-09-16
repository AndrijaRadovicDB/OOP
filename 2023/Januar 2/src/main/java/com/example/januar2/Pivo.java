package com.example.januar2;

public abstract class Pivo implements Comparable<Pivo> {
    private String zemljaPorekla, naziv;
    private double abv;

    public Pivo(String zemljaPorekla, String naziv, double abv) {
        this.zemljaPorekla = zemljaPorekla;
        this.naziv = naziv;
        this.abv = abv;
    }

    public String getZemljaPorekla() {
        return zemljaPorekla;
    }

    public String getNaziv() {
        return naziv;
    }

    public double getAbv() {
        return abv;
    }

    public abstract double cena(double kolicina);

    @Override
    public int compareTo(Pivo o) {
        if(this.zemljaPorekla.equals(o.zemljaPorekla)) {
            return Double.compare(this.abv, o.abv);
        }
        return this.zemljaPorekla.compareTo(o.zemljaPorekla);
    }

    @Override
    public String toString() {
        return "(" + this.zemljaPorekla + ") " + this.naziv + " " + Math.round(this.abv*100.0)/100.0 + "%";
    }
}
