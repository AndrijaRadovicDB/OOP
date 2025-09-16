package zadatak1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Posetilac> posetioci1 = new ArrayList<>();
        List<Posetilac> posetioci2 = new ArrayList<>();
        List<Posetilac> posetioci3 = new ArrayList<>();
        List<Posetilac> posetioci4 = new ArrayList<>();
        List<Bend> bendovi = new ArrayList<>();
        bendovi.add(new Bend("Haldno Pivo", 16, 18, false, posetioci1));
        bendovi.add(new Bend("Goblini", 21, 23, false, posetioci2));
        bendovi.add(new Bend("Assissination", 12, 14, true, posetioci3));
        bendovi.add(new Bend("Harakiri For The Sky", 7, 11, true, posetioci4));

        for(int i = 0; i < 6; i++){
            System.out.println("Unesite ime, pocetak, kraj, broj zanra, i boolean:");
            String ime = sc.next();
            int pocetakSV = sc.nextInt();
            int krajSv = sc.nextInt();
            int brZ = sc.nextInt();
            MuzickiZanr zanr;
            if(brZ == 0) {
                zanr = MuzickiZanr.POP;
            }
            else if(brZ == 1) {
                zanr = MuzickiZanr.ROK;
            }
            else {
                zanr = MuzickiZanr.REP;
            }
            boolean pricaEngleski = sc.nextBoolean();
            if(pricaEngleski) {
                PosetilacKojiZnaEngleski pe = new PosetilacKojiZnaEngleski(ime, zanr, pocetakSV, krajSv);
                for(int j = 0; j < 4; j++) {
                    Bend bend = bendovi.get(j);
                    if(pe.getPocetakSlobodnogVremena() <= bend.getVremePocetka() && pe.getPocetakSlobodnogVremena() <= krajSv) {
                        bend.dodajPosetioca(pe);
                        break;
                    }
                }
            }
            else {
                Posetilac p = new Posetilac(ime, zanr, pocetakSV, krajSv);
                for(int j = 0; j < 4; j++) {
                    Bend bend = bendovi.get(j);
                    if(p.getPocetakSlobodnogVremena() <= bend.getVremePocetka() && p.getPocetakSlobodnogVremena() <= krajSv) {
                        bend.dodajPosetioca(p);
                        break;
                    }
                }
            }
        }

        for(int i = 0; i < 4; i++) {
            System.out.println(bendovi.get(i).toString());
        }
    }
}
