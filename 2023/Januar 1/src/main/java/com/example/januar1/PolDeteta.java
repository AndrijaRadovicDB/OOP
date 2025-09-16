package com.example.januar1;

public enum PolDeteta {
    MUSKI,
    ZENSKI;

    private char skracenica;

    PolDeteta() {
        this.skracenica = 'M';
    }

    private PolDeteta(char skracenica) {
        this.skracenica = skracenica;
    }

    public char getSkracenica() {
        return skracenica;
    }

    public static PolDeteta odSkracenice(char skracenica) {
        if(skracenica == 'M') {
            return MUSKI;
        }
        else {
            return ZENSKI;
        }
    }
}
