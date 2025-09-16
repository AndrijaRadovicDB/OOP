package com.example.januar2;

public class Bure<T extends Pivo> implements Comparable<Bure<T>> {
    private T pivo;
    private double kolicina;

    public Bure(T pivo, double kolicina) {
        this.pivo = pivo;
        this.kolicina = kolicina;
    }

    public T getPivo() {
        return pivo;
    }

    public double getKolicina() {
        return kolicina;
    }

    public void setKolicina(double kolicina) {
        this.kolicina = kolicina;
    }

    public boolean dovoljnoZaTocenje(double kolicina) {
        if(this.kolicina - kolicina >= 0.5) {
            return true;
        }
        return false;
    }

    public double natoci(double kolicina) {
        if(dovoljnoZaTocenje(kolicina)) {
                this.setKolicina(this.kolicina - kolicina);
                return this.pivo.cena(kolicina);
        }
        else {
            throw new UnsupportedOperationException("Nema dovoljno piva u buretu");
        }
    }

    public String getVrstaPiva() {
        if(pivo instanceof Psenicno) {
            return "Psenicno";
        }
        else if(pivo instanceof IPA) {
            return "IPA";
        }
        else {
            return "Lager";
        }
    }

    @Override
    public int compareTo(Bure<T> o) {
        return this.pivo.compareTo(o.pivo);
    }

    @Override
    public String toString() {
        return this.kolicina + " L " + this.pivo.toString();
    }
}
