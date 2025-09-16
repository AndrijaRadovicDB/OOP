package com.example.januar1;

public enum VrstaIgracke {
    MUSKA,
    ZENSKA,
    NEUTRALNA;

    private char skracenica;

    VrstaIgracke() {
        this.skracenica = 'M';
    }

    VrstaIgracke(char skracenica) {
        this.skracenica = skracenica;
    }

    public char getSkracenica() {
        return skracenica;
    }

    static VrstaIgracke odSkracenice(char skracenica) {
        if(skracenica == 'M') {
            return MUSKA;
        }
        else if(skracenica == 'Z') {
            return ZENSKA;
        }
        else {
            return NEUTRALNA;
        }
    }
}
