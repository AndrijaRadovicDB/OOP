package com.example.januar1;

public class Igracka extends Poklon {
    private VrstaIgracke vrsta;

    public Igracka(String naziv, String ID, int cena, VrstaIgracke vrsta) {
        super(naziv, ID, cena);
        this.vrsta = vrsta;
    }

    public VrstaIgracke getVrsta() {
        return vrsta;
    }

    public void setVrsta(VrstaIgracke vrsta) {
        this.vrsta = vrsta;
    }

    @Override
    public boolean prikladanPoklon(PolDeteta pol) {
        char skracenicaP = pol.getSkracenica();
        char skracenicaV = 'N';
        String ID = super.getID();
        if(ID.charAt(1) == 'M') {
            skracenicaV = 'M';
        }
        else if(ID.charAt(1) == 'Z') {
            skracenicaV = 'Z';
        }
        if(skracenicaV == 'N' || (skracenicaP == skracenicaV)) {
            return true;
        }
        return false;

    }
}
