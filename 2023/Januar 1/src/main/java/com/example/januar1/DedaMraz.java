package com.example.januar1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class DedaMraz extends Application {
    private List<Paketic> paketici = new ArrayList<>();
    private List<UredjeniPar<Poklon, Integer>> spisakPoklona;

    private List<UredjeniPar<Poklon, Integer>> ucitajDatoteku() throws IOException {
        List<UredjeniPar<Poklon, Integer>> pokloni = new ArrayList<>();

        Path ulaz = Paths.get("pokloni.txt");
        try(Scanner sc = new Scanner(ulaz)) {
            Random rand = new Random();
            while (sc.hasNextLine()) {
                String linija = sc.nextLine();
                String ID = linija.split(", ")[0];
                String naziv = linija.split(", ")[1];
                int cena = Integer.parseInt(linija.split(", ")[2]);
                String prefiks = ID.substring(0, 2);
                UredjeniPar<Poklon, Integer> up;
                int randKolicina = rand.nextInt(11);
                if(prefiks.equals("ST")) {
                    Slatkis slatkis = new Slatkis(naziv, ID, cena);
                    up = new UredjeniPar<>(slatkis, randKolicina);
                }
                else if(prefiks.equals("SN")) {
                    Slanis slanis = new Slanis(naziv, ID, cena);
                    up = new UredjeniPar<>(slanis, randKolicina);
                }
                else if(prefiks.equals("IM")) {
                    Igracka igracka = new Igracka(naziv, ID, cena, VrstaIgracke.MUSKA);
                    up = new UredjeniPar<>(igracka, randKolicina);
                }
                else if(prefiks.equals("IZ")) {
                    Igracka igracka = new Igracka(naziv, ID, cena, VrstaIgracke.ZENSKA);
                    up = new UredjeniPar<>(igracka, randKolicina);
                }
                else {
                    Igracka igracka = new Igracka(naziv, ID, cena, VrstaIgracke.NEUTRALNA);
                    up = new UredjeniPar<>(igracka, randKolicina);
                }
                pokloni.add(up);
            }
        }

        Collections.sort(pokloni, new Comparator<UredjeniPar<Poklon, Integer>>() {
            public int compare(UredjeniPar<Poklon, Integer> p1, UredjeniPar<Poklon, Integer> p2) {
                if(p1.getPrvi().equals(p2.getPrvi())) {
                    return p1.getDrugi().compareTo(p2.getDrugi());
                }
                return p1.getPrvi().compareTo(p2.getPrvi());
            }
        });
        return pokloni;
    }

    @Override
    public void start(Stage stage) throws IOException {
        HBox root = new HBox(10);
        root.setPadding(new Insets(10, 10, 10, 10));

        VBox vb1 = new VBox(10);
        Label lbImePrezime = new Label("Ime i prezime:");
        TextArea taImePrezime = new TextArea();
        Label lbPol = new Label("Pol deteta:");
        ToggleGroup tgPol = new ToggleGroup();
        RadioButton rbMuski = new RadioButton("Muski");
        rbMuski.setToggleGroup(tgPol);
        RadioButton rbZenski = new RadioButton("Zenski");
        rbZenski.setToggleGroup(tgPol);
        Label lbBudzet = new Label("Budzet za paketic:");
        TextArea taBudzet = new TextArea();
        Button btNapuni = new Button("Napuni paketic");
        vb1.getChildren().addAll(lbImePrezime, taImePrezime, lbPol, rbMuski, rbZenski, lbBudzet, taBudzet, btNapuni);

        VBox vb2 = new VBox(10);
        TextArea taIspis = new TextArea();
        HBox hb1 = new HBox(10);
        Button btUcitaj = new Button("Ucitaj poklone");
        Button btPrikazi = new Button("Prikazi spisak za Deda Mraza");
        hb1.getChildren().addAll(btUcitaj, btPrikazi);
        vb2.getChildren().addAll(taIspis, hb1);

        root.getChildren().addAll(vb1, vb2);

        btNapuni.setOnAction(e -> {
            if(taImePrezime.getText().isEmpty()) {
                taIspis.setText("Nije uneto ime i prezime deteta!");
            }
            else if(!rbMuski.isSelected() && !rbZenski.isSelected()) {
                taIspis.setText("Nije izabrat pol deteta!");
            }
            else if(taBudzet.getText().isEmpty()) {
                taIspis.setText("Nije unet budzet za paketic!");
            }
            else if(!btUcitaj.isDisable()) {
                taIspis.setText("Nije ucitan spisak poklona!");
            }
            else {
                PolDeteta pol = rbMuski.isSelected() ? PolDeteta.MUSKI : PolDeteta.ZENSKI;
                Dete dete = new Dete(taImePrezime.getText(), pol);
                int budzet = Integer.parseInt(taBudzet.getText());
                Paketic paketic = new Paketic(dete, budzet);
                paketic.napuniPaketic(spisakPoklona);
                List<Poklon> pokloni = paketic.getPokloni();
                paketici.add(paketic);

                StringBuilder sb = new StringBuilder();
                sb.append(dete);
                sb.append("\n");
                for(Poklon p : pokloni) {
                    sb.append(p);
                    sb.append("\n");
                }
                taIspis.setText(sb.toString());
            }
        });

        btUcitaj.setOnAction(e -> {
            try {
                spisakPoklona = ucitajDatoteku();
                btUcitaj.setDisable(true);
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        btPrikazi.setOnAction(e -> {
                StringBuilder sb = new StringBuilder();
                for(UredjeniPar<Poklon, Integer> up : spisakPoklona) {
                    Poklon p = up.getPrvi();
                    int brKomada = up.getDrugi();
                    sb.append(p);
                    sb.append(" - kom ");
                    sb.append(brKomada);
                    sb.append("\n");
                }
                taIspis.setText(sb.toString());
        });

        Scene scene = new Scene(root, 540, 320);
        stage.setScene(scene);
        stage.setTitle("Deda Mrazov Pomocnik");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}