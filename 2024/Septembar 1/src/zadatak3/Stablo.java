package zadatak3;

import java.util.TreeSet;

public class Stablo<T> {
    private TreeSet<T> stablo;

    public Stablo(TreeSet<T> stablo) {
        this.stablo = stablo;
    }

    public void dodaj(T element) {
        this.stablo.add(element);
    }

    public boolean pronadji(T element) {
        for(T el : stablo) {
            if(el.equals(element)) {
                return true;
            }
        }
        return false;
    }

    public void ispisiSortirano() {
        System.out.println(stablo.toString());
    }
}
