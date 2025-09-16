package zadatak3;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Adreser {
    private Map<Paket<String>, String> adrese;

    public Adreser() {
        this.adrese = new TreeMap<>();
    }

    public Adreser(Comparator<Paket<String>> komparator) {
        this.adrese = new TreeMap<>(komparator);
    }

    public void dodaj(Paket<String> paket, String adresa) {
       if(!adrese.containsKey(paket)) {
           adrese.put(paket, adresa);
       }
    }

    public String print() {
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Paket<String>, String> el : adrese.entrySet()) {
            sb.append(el.getKey().toString() + ": " + el.getValue() + "\n");
        }
        return sb.toString();
    }
}
