package com.example.septembar1;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class VektorskiProstor {
    ArrayList<String> naziviKooridanta;
    ArrayList<Vektor> vektori;

    public VektorskiProstor(ArrayList<String> naziviKooridanta, ArrayList<Vektor> vektori) {
        this.naziviKooridanta = naziviKooridanta;
        this.vektori = vektori;
    }

    public ArrayList<String> getNaziviKooridanta() {
        return this.naziviKooridanta;
    }

    public ArrayList<Vektor> getVektori() {
        return this.vektori;
    }

    public void ucitajIzFajla(String filePath) throws IOException {
        Path ulaz = Paths.get(filePath);
        try(Scanner sc = new Scanner(ulaz)) {
            String linija = null;
            if(sc.hasNextLine()) {
                linija = sc.nextLine();
                String[] split = linija.split(" ");
                for (String el : split) {
                    if (el != null) {
                        this.naziviKooridanta.add(el);
                    }
                }
            }

            int n = this.naziviKooridanta.size();
            while(sc.hasNextLine()) {
                ArrayList<Double> elementi = new ArrayList<>();
                linija = sc.nextLine();
                String[] split = linija.split(" ");
                for(String el : split) {
                    if(el != null) {
                        elementi.add(Double.parseDouble(el));
                    }
                }
                this.vektori.add(new Vektor(elementi, n));
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(String ime : this.naziviKooridanta) {
            sb.append(ime);
            sb.append(" ");
        }
        sb.append("\n");
        for(Vektor v : this.vektori) {
            sb.append(v.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
}
