package com.example.januar1;

public class Dete {
    private String imePrezime;
    private PolDeteta pol;

    public Dete(String imePrezime, PolDeteta pol) {
        this.imePrezime = imePrezime;
        this.pol = pol;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public PolDeteta getPol() {
        return pol;
    }

    @Override
    public String toString() {
        return this.imePrezime + " (" + this.pol.getSkracenica() + ")";
    }
}
