package com.example.septembar1;

import java.util.ArrayList;
import java.util.Collections;

public class KNNPrediktor {
    private VektorskiProstor vp;
    private Metrika metrika;
    private int k;

    public KNNPrediktor(VektorskiProstor vp, Metrika metrika, int k) {
        this.vp = vp;
        this.metrika = metrika;
        this.k = k;
    }

    public double predvidjanjeCiljnePromen(Vektor targetVektor) {
        double suma = 0.0;
        ArrayList<Vektor> vektori = vp.getVektori();
        Collections.sort(vektori, new KomparatorVektora(targetVektor, this.metrika));
        for(int i = 1; i <= this.k; i++) {
            Vektor vektor = vektori.get(i);
            double poslednjaKord = vektor.uzmiElement(vektor.velicina() - 1);
            suma += poslednjaKord;
        }
        suma *= 1.0/this.k;
        return suma;
    }
}
