package com.example.januar2;

public class Psenicno extends Pivo {
    private int procenatPsenice;

    public Psenicno(String zemljaPorekla, String naziv, double abv, int procenatPsenice) {
        super(zemljaPorekla, naziv, abv);
        this.procenatPsenice = procenatPsenice;
    }

    @Override
    public double cena(double kolicina) {
        return 300*kolicina + 10*this.getAbv() + this.procenatPsenice;
    }
}
