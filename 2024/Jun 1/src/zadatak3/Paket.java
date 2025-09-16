package zadatak3;

public class Paket<T extends Comparable<T>> implements Comparable<Paket<T>> {
    private T sadrzaj;
    private double tezina;

    public Paket(T sadrzaj, double tezina) {
        this.sadrzaj = sadrzaj;
        this.tezina = tezina;
    }

    public double getTezina() {
        return this.tezina;
    }

    @Override
    public int compareTo(Paket<T> o) {
        return this.sadrzaj.compareTo(o.sadrzaj);
    }

    @Override
    public String toString() {
        return sadrzaj.toString() + " - " + tezina + "kg";
    }
}
