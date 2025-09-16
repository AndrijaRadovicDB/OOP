package zadatak1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class Cenovnik {
    private List<SvemirskiBrod> brodovi;

    public Cenovnik(ArrayList<SvemirskiBrod> brodovi) {
        this.brodovi = brodovi;
    }

    public float ukupnaCena() {
        float suma = 0;
        for(SvemirskiBrod b : brodovi) {
            suma += b.cena();
        }
        return suma;
    }

    public void kupiBrod(String ime) {
        String imeDatoteke = ime + ".txt";
        Path izlaz = Paths.get(imeDatoteke);
        try {
            SvemirskiBrod brod = null;
            for (SvemirskiBrod b : brodovi) {
                if (b.getIme().equals(ime)) {
                    brod = b;
                    brodovi.remove(brod);
                    break;
                }
            }
            if (brod != null) {
                List<String> linije = new ArrayList<>();
                linije.add(brod.ispisiInformacije());
                Files.write(izlaz, linije, StandardOpenOption.CREATE);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
