package com.example.septembar1;

public class EuklidskaMetrika implements Metrika {
    public double rastojanje(Vektor u, Vektor v) {
        double suma = 0.0;
        for(int i = 0; i < u.velicina(); i++){
            suma += Math.sqrt(Math.pow(u.uzmiElement(i) - v.uzmiElement(i), 2));
        }
        return suma;
    }
}
