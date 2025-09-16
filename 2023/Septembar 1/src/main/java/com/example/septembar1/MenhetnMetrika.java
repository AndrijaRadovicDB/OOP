package com.example.septembar1;

public class MenhetnMetrika implements Metrika {
    public double rastojanje(Vektor u, Vektor v) {
        double suma = 0.0;
        for(int i = 0; i < u.velicina(); i++) {
            suma += Math.abs(u.uzmiElement(i) - v.uzmiElement(i));
        }
        return suma;
    }
}
