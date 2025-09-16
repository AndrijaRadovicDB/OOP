import java.util.Optional;

public class MatematickiSkup<T extends Comparable<T>> {
    private String ime;
    private T[] skup;
    private int kapacitet;
    private int popunjeno;

    public MatematickiSkup(String ime,  T[] skup, int kapacitet) {
        this.ime = ime;
        this.skup = skup;
        this.kapacitet = kapacitet;
        this.popunjeno = kapacitet;
    }

    public boolean postoji(T element) {
        for(int i = 0; i < this.popunjeno; i++) {
            if(skup[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    public void dodaj(T element) {
        if(!postoji(element)) {
            if(this.popunjeno == this.kapacitet) {
                this.kapacitet *= 2;
                T[] tmp = (T[]) new Comparable[kapacitet];
                for(int i = 0; i < this.popunjeno; i++) {
                    tmp[i] = skup[i];
                }
                this.skup = tmp;
            }
            this.skup[this.popunjeno] = element;
            this.popunjeno++;
        }
    }

    public Optional<T> nadjiMaksimum() {
        if(this.popunjeno == 0) {
            return Optional.empty();
        }
        T max = this.skup[0];
        for(int i = 1; i < popunjeno; i++) {
            if(max.compareTo(skup[i]) < 0) {
                max = this.skup[i];
            }
        }
        return Optional.ofNullable(max);
    }

    public MatematickiSkup<T> unija(MatematickiSkup<T> s) {
        for(int i = 0; i < s.popunjeno; i++) {
            if(!postoji(s.skup[i])) {
                this.dodaj(s.skup[i]);
            }
        }
        this.ime = this.ime + " u " + s.ime;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.ime + " { ");
        for(int i = 0; i < this.popunjeno - 1; i++) {
            sb.append(this.skup[i] + ", ");
        }
        sb.append(this.skup[this.popunjeno - 1] + " }");
        return sb.toString();
    }
}
