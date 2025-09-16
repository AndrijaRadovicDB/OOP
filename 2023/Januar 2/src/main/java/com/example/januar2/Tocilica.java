package com.example.januar2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Tocilica extends Application {
    private List<Bure> burad;
    private Map<String, Double> popijeno = new TreeMap<>();

    private List<Bure> ucitajDatoteku() throws IOException {
        List<Bure> buradi = new ArrayList<>();

        Path ulaz = Paths.get("piva.txt");
        try(Scanner sc = new Scanner(ulaz)) {
            while(sc.hasNextLine()) {
                String linija = sc.nextLine();
                String tipPiva = linija.split(" ")[0];
                double kolicina = Double.parseDouble(linija.split(" ")[1]);
                String naziv = linija.split(" ")[2];
                double abv = Double.parseDouble(linija.split(" ")[3]);
                String zemljaPorekla = linija.split(" ")[4];

                if(tipPiva.equals("Psenicno")) {
                    int procenatPsenice = Integer.parseInt(linija.split(" ")[5]);
                    Psenicno pivo = new Psenicno(zemljaPorekla, naziv, abv, procenatPsenice);
                    buradi.add(new Bure(pivo, kolicina));
                    popijeno.put(pivo.toString(), 0.0);
                }
                else if(tipPiva.equals("IPA")) {
                    int IBU = Integer.parseInt(linija.split(" ")[5]);
                    IPA pivo = new IPA(zemljaPorekla, naziv, abv, IBU);
                    buradi.add(new Bure(pivo, kolicina));
                    popijeno.put(pivo.toString(), 0.0);
                }
                else {
                    Lager pivo = new Lager(zemljaPorekla, naziv, abv);
                    buradi.add(new Bure(pivo, kolicina));
                    popijeno.put(pivo.toString(), 0.0);
                }
            }
        }

        return buradi;
    }

    @Override
    public void start(Stage stage) throws IOException {
        VBox root = new VBox(10);
        root.setPadding(new Insets(10, 10, 10, 10));

        HBox hb1 = new HBox(10);
        TextArea taIspis = new TextArea();
        hb1.getChildren().addAll(taIspis);

        HBox hb2 = new HBox(10);

        VBox vb1 = new VBox(10);
        Label lbVrsta = new Label("Vrsta piva:");
        ToggleGroup tg = new ToggleGroup();
        RadioButton rbLager = new RadioButton("Lager");
        rbLager.setToggleGroup(tg);
        RadioButton rbPsenicno = new RadioButton("Psenicno");
        rbPsenicno.setToggleGroup(tg);
        RadioButton rbIPA = new RadioButton("IPA");
        rbIPA.setToggleGroup(tg);

        HBox vb2 = new HBox(10);
        TextArea taL = new TextArea();
        Label lbL = new Label("L");
        vb2.getChildren().addAll(taL, lbL);
        Button btNatoci = new Button("Natoci");
        vb1.getChildren().addAll(lbVrsta, rbLager, rbPsenicno, rbIPA, vb2, btNatoci);

        hb1.getChildren().addAll(vb1);

        HBox vb3 = new HBox(10);
        vb3.setAlignment(Pos.CENTER);
        Button btStanje = new Button("Stanje na kolicini");
        Button btPopijeno = new Button("Popijeno");
        vb3.getChildren().addAll(btStanje, btPopijeno);

        root.getChildren().addAll(hb1, hb2, vb3);

        burad = ucitajDatoteku();

        btStanje.setOnAction(e -> {
            Collections.sort(burad);
            StringBuilder sb = new StringBuilder();
            for(Bure b : burad) {
                sb.append(b);
                sb.append("\n");
            }
            taIspis.setText(sb.toString());
        });

        btPopijeno.setOnAction(e -> {
            StringBuilder sb = new StringBuilder();
            sb.append("Do sada popijeno:\n");
            for(Map.Entry<String, Double> entry : popijeno.entrySet()) {
                sb.append(entry.getValue());
                sb.append(" litara ");
                sb.append(entry.getKey());
                sb.append("\n");
            }
            taIspis.setText(sb.toString());
        });

        btNatoci.setOnAction(e -> {
            if(taL.getText().isEmpty()) {
                throw new NumberFormatException("Nije uneta kolicina");
            }
            else if(!rbLager.isSelected() && !rbPsenicno.isSelected() && !rbIPA.isSelected()) {
                throw new UnsupportedOperationException("Nije izabrana vrsta piva");
            }

            String ispis = "";
            double kolicina = Double.parseDouble(taL.getText());
            String vrsta;
            if(rbLager.isSelected()) {
                vrsta = "Lager";
            }
            else if(rbPsenicno.isSelected()) {
                vrsta = "Psenicno";
            }
            else {
                vrsta = "IPA";
            }

            boolean uspesno = false;
            for(Bure b : burad) {
                String vrstaPiva = b.getVrstaPiva();
                if(vrstaPiva.equals(vrsta)) {
                    try {
                        double cena = b.natoci(kolicina);
                        popijeno.put(b.getPivo().toString(), kolicina);
                        uspesno = true;
                        ispis = "Natocili ste " + kolicina + " litara " + b.getPivo() + "\nVas racun je: " + cena + "din\n";
                    }
                    catch(UnsupportedOperationException ex) {
                        uspesno = false;
                    }
                    if(uspesno) {
                        break;
                    }
                }
            }
            if(!uspesno) {
                ispis = "Nema dovoljno trazenog piva!";
            }
            taIspis.setText(ispis);
        });

        Scene scene = new Scene(root, 320, 240);
        stage.setTitle("Tocilica");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}