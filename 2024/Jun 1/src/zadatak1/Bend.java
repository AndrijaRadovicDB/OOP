package zadatak1;

import java.util.List;

public class Bend {
    private String naziv;
    private int vremePocetka, vremeKraja;
    private boolean strani;
    private List<Posetilac> posetioci;

    public Bend(String naziv, int vremePocetka, int vremeKraja, boolean strani, List<Posetilac> posetioci) {
        this.naziv = naziv;
        this.vremePocetka = vremePocetka;
        this.vremeKraja = vremeKraja;
        this.strani = strani;
        this.posetioci = posetioci;
    }

    public String getNaziv() {
        return naziv;
    }

    public int getVremePocetka() {
        return vremePocetka;
    }

    public int getVremeKraja() {
        return vremeKraja;
    }

    public boolean isStrani() {
        return strani;
    }

    public List<Posetilac> getPosetioci() {
        return posetioci;
    }

    public void dodajPosetioca(Posetilac p) {
        posetioci.add(p);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String jesteStrani = this.isStrani() ? "da" : "ne";
        sb.append("Bend: " + this.getNaziv() + ", vreme: " + this.getVremePocetka() + "-" + this.getVremeKraja() + ", strani: " + jesteStrani + "\n");
        for(Posetilac p : posetioci) {
            sb.append(p + "\n");
        }
        return sb.toString();
    }
}
