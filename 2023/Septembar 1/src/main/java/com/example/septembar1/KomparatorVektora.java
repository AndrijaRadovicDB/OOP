package com.example.septembar1;

import java.util.Comparator;

public class KomparatorVektora implements Comparator<Vektor> {
    private Vektor targetVektor;
    private Metrika metrika;

    public KomparatorVektora(Vektor targetVektor, Metrika metrika) {
        this.targetVektor = targetVektor;
        this.metrika = metrika;
    }

    @Override
    public int compare(Vektor u, Vektor v) {
        int velicina = targetVektor.velicina();
        Vektor podvektorU = u.podvektor(0, velicina - 1);
        Vektor podVektorV = v.podvektor(0, velicina - 1);
        return Double.compare(metrika.rastojanje(podvektorU, this.targetVektor), metrika.rastojanje(podVektorV, this.targetVektor));
    }
}
