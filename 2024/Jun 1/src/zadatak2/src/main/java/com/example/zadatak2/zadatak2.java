package com.example.zadatak2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class zadatak2 extends Application {
    TreeSet<Osoba> osobe;
    boolean ucitaj = false;

    private class Osoba implements Comparable<Osoba> {
        private String ime, prezime;
        private double prosek;

        public Osoba(String ime, String prezime, double prosek) {
            this.ime = ime;
            this.prezime = prezime;
            this.prosek = prosek;
        }

        public double getProsek() {
            return prosek;
        }

        @Override
        public int compareTo(Osoba o) {
            return Double.compare(o.prosek, this.prosek);
        }

        @Override
        public String toString() {
            return this.ime + " " + this.prezime + ": " + this.prosek;
        }
    }

    private TreeSet<Osoba> ucitajIzDatoteke() throws IOException {
        TreeSet<Osoba> osobe = new TreeSet<>();

        Path ulaz = Paths.get("studenti.txt");

        try(Scanner sc = new Scanner(ulaz)) {
            while(sc.hasNextLine()) {
                int brOcena = 0, suma = 0;
                String linija = sc.nextLine();
                String[] podela = linija.split(", ");
                String ime = podela[0];
                String prezime = podela[1];
                for(int i = 2; i < podela.length; i++) {
                    suma += Integer.parseInt(podela[i]);
                    brOcena++;
                }
                double prosek = (double)suma/brOcena;
                Osoba osoba = new Osoba(ime, prezime, prosek);
                osobe.add(osoba);
            }
        }

        return osobe;
    }

    @Override
    public void start(Stage stage) throws IOException {

        VBox root = new VBox(10);
        root.setPadding(new Insets(10, 10, 10, 10));

        Button btUcitaj = new Button("Ucitaj");
        HBox hb1 = new HBox(10);
        TextArea taProsek = new TextArea();
        Button btPrikazi = new Button("Prikazi");
        hb1.getChildren().addAll(taProsek, btPrikazi);
        TextArea taIspis = new TextArea();

        root.getChildren().addAll(btUcitaj, hb1, taIspis);

        btUcitaj.setOnAction(e -> {
            try {
                osobe = ucitajIzDatoteke();
                ucitaj = true;
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        btPrikazi.setOnAction(e -> {
            if(ucitaj) {
                StringBuilder sb = new StringBuilder();
                try {
                    double prosek = Double.parseDouble(taProsek.getText());
                    for (Osoba osoba : osobe) {
                        if (osoba.getProsek() >= prosek) {
                            sb.append(osoba);
                            sb.append("\n");
                        }
                    }
                }
                catch (NumberFormatException ex) {
                    for(Osoba osoba : osobe) {
                        sb.append(osoba);
                        sb.append("\n");
                    }
                }
                taIspis.setText(sb.toString());
            }
        });

        Scene scene = new Scene(root, 340, 220);
        stage.setTitle("Hypatia");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}