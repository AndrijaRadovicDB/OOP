package com.example.januar2;

public class IPA extends Pivo {
    private int IBU;

    public IPA(String zemljaPorekla, String naziv, double abv, int IBU) {
        super(zemljaPorekla, naziv, abv);
        this.IBU = IBU;
    }

    @Override
    public double cena(double kolicina) {
        return 400*kolicina + 2*this.IBU;
    }

    @Override
    public String toString() {
        return super.toString() + " IBU" + this.IBU;
    }
}
