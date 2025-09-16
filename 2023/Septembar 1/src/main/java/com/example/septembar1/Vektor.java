package com.example.septembar1;

import java.util.ArrayList;

public class Vektor {
    private ArrayList<Double> elementi;
    private int n;

    public Vektor(ArrayList<Double> elementi, int n) {
        this.elementi = elementi;
        this.n = n;
    }

    public int velicina() {
        return this.n;
    }

    public void setVelicina(int n) {
        this.n = n;
    }

    public void dodajElement(Double e) {
        this.elementi.add(e);
        this.setVelicina(this.elementi.size());
    }

    public Double uzmiElement(int ind) {
        if(!elementi.isEmpty() && ind >= 0 && ind < this.elementi.size()) {
            return this.elementi.get(ind);
        }
        else {
            throw new IndexOutOfBoundsException("Losi indeksi");
        }
    }

    public Vektor podvektor(int i, int j) {
        if(i < j && i < this.elementi.size() && i >= 0 && j < this.elementi.size()) {
            ArrayList<Double> noviElementi = new ArrayList<>();
            for(int m = i; m <= j; m++) {
                noviElementi.add(this.uzmiElement(m));
            }
            return new Vektor(noviElementi , j - i + 1);
        }
        else {
            throw new IndexOutOfBoundsException("Losi indeksi");
        }
    }

    @Override
    public String toString() {
        return this.elementi.toString();
    }
}
