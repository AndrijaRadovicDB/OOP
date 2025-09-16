package com.example.zadatak2;

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
import java.util.ArrayList;
import java.util.Scanner;

public class zadatak2 extends Application {

    private class Automobil {
        private String model, gorivo;

        public Automobil(String model, String gorivo) {
            this.model = model;
            this.gorivo = gorivo;
        }

        public String getModel() {
            return model;
        }

        public String getGorivo() {
            return gorivo;
        }

        @Override
        public String toString() {
            return model + ", " + gorivo;
        }
    }

    private ArrayList<Automobil> ucitajDatoteku() throws IOException {
        ArrayList<Automobil> automobili = new ArrayList<>();

        Path ulaz = Paths.get("automobili.txt");

        try(Scanner sc = new Scanner(ulaz)) {
            while(sc.hasNextLine()) {
                String linija = sc.nextLine();
                String model = linija.split(", ")[0];
                String gorivo = linija.split(", ")[1];
                automobili.add(new Automobil(model, gorivo));
            }
        }

        return automobili;
    }

    @Override
    public void start(Stage stage) throws IOException {

        VBox root = new VBox(10);
        root.setPadding(new Insets(10, 10, 10, 10));

        Label lbGorivo = new Label("Gorivo");
        TextArea taIspis = new TextArea();

        HBox hb1 = new HBox(10);
        ToggleGroup tg = new ToggleGroup();
        RadioButton rbDizel = new RadioButton("dizel");
        rbDizel.setToggleGroup(tg);
        RadioButton rbBenzin = new RadioButton("benzin");
        rbBenzin.setToggleGroup(tg);
        hb1.getChildren().addAll(rbDizel, rbBenzin);

        HBox hb2 = new HBox(10);
        Button btIspisi = new Button("Ispisi");
        Button btFiltriraj = new Button("Filtriraj");
        Button btOcisti = new Button("Ocisti");
        hb2.getChildren().addAll(btIspisi, btFiltriraj, btOcisti);

        root.getChildren().addAll(lbGorivo, hb1, hb2, taIspis);

        ArrayList<Automobil> automobili = ucitajDatoteku();

        btIspisi.setOnAction(e -> {
            StringBuilder sb = new StringBuilder();
            for(Automobil automobil : automobili) {
                sb.append(automobil.toString());
                sb.append("\n");
            }
            taIspis.setText(sb.toString());
        });

        btFiltriraj.setOnAction(e -> {
            StringBuilder sb = new StringBuilder();
            for(Automobil automobil : automobili) {
                if(rbDizel.isSelected() && automobil.getGorivo().equals("dizel")) {
                    sb.append(automobil);
                    sb.append("\n");
                }
                else if (rbBenzin.isSelected() && automobil.getGorivo().equals("benzin")) {
                    sb.append(automobil);
                    sb.append("\n");
                }
                else if(!rbDizel.isSelected() && !rbBenzin.isSelected()) {
                    sb.append(automobil);
                    sb.append("\n");
                }
            }
            taIspis.setText(sb.toString());
        });

        btOcisti.setOnAction(e -> {
            rbDizel.setSelected(false);
            rbBenzin.setSelected(false);
            taIspis.setText("");
        });

        Scene scene = new Scene(root, 520, 440);
        stage.setTitle("Polovni automobili");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}