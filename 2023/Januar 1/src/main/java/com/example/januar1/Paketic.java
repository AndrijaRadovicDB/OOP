package com.example.januar1;

import java.util.*;

public class Paketic {
    private Dete dete;
    private int budzet;
    private List<Poklon> pokloni = new ArrayList<>();

    public Paketic(Dete dete, int budzet) {
        this.dete = dete;
        this.budzet = budzet;
    }

    public Dete getDete() {
        return dete;
    }

    public List<Poklon> getPokloni() {
        return pokloni;
    }

    public void napuniPaketic(List<UredjeniPar<Poklon, Integer>> spisakPoklona) {
        Random rand = new Random();

        Collections.sort(spisakPoklona, new Comparator<UredjeniPar<Poklon, Integer>>() {
            public int compare(UredjeniPar<Poklon, Integer> p1, UredjeniPar<Poklon, Integer> p2) {
                if(p1.getPrvi().equals(p2.getPrvi())) {
                    return p1.getDrugi().compareTo(p2.getDrugi());
                }
                return p1.getPrvi().compareTo(p2.getPrvi());
            }
        });

        int minCena = spisakPoklona.getFirst().getPrvi().getCena();
        while(budzet >= minCena) {
            int indeks = rand.nextInt(spisakPoklona.size());
            Poklon p = spisakPoklona.get(indeks).getPrvi();
            int brojac = spisakPoklona.get(indeks).getDrugi();
            String ID = p.getID().substring(0, 2);

            VrstaIgracke vrsta = VrstaIgracke.NEUTRALNA;
            if(ID.equals("IM")) {
                vrsta = VrstaIgracke.MUSKA;
            }
            else if(ID.equals("IZ")) {
                vrsta = VrstaIgracke.ZENSKA;
            }
            Igracka igracka = new Igracka(p.getNaziv(), p.getID(), p.getCena(), vrsta);
            boolean prikladan = igracka.prikladanPoklon(this.dete.getPol());

            if(prikladan && brojac != 0) {
                budzet -= p.getCena();
                if(budzet >= 0) {
                    pokloni.add(p);
                    UredjeniPar<Poklon, Integer> tmp = new UredjeniPar<>(p, brojac - 1);
                    spisakPoklona.set(indeks, tmp);
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Poklon p : pokloni) {
            sb.append(p);
            sb.append("\n");
        }
        return sb.toString();
    }
}
