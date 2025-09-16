package com.example.septembar1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class CenaNekretninaKNN extends Application {
    ArrayList<String> naziviKoordinata = new ArrayList<>();
    ArrayList<Vektor> vektori = new ArrayList<>();
    VektorskiProstor vp = new VektorskiProstor(naziviKoordinata, vektori);

    @Override
    public void start(Stage stage) throws IOException {
        VBox root = new VBox(10);
        root.setPadding(new Insets(10, 10, 10, 10));

        HBox hb1 = new HBox(10);

        VBox vb1 = new VBox(10);
        Label lbKvadratura = new Label("Kvadratura:");
        Label lbStruktura = new Label("Struktura:");
        Label lbSpratnost = new Label("Spratnost:");
        Label lbUdaljenost = new Label("Udaljenost od centra:");
        vb1.getChildren().addAll(lbKvadratura, lbStruktura, lbSpratnost, lbUdaljenost);

        VBox vb2 = new VBox(10);
        TextArea taKvadratura = new TextArea();
        taKvadratura.setPrefSize(250, 1);
        TextArea taStruktura = new TextArea();
        taStruktura.setPrefSize(250, 1);
        TextArea taSpratnost = new TextArea();
        taSpratnost.setPrefSize(250, 1);
        TextArea taUdaljenost = new TextArea();
        taUdaljenost.setPrefSize(250, 1);
        vb2.getChildren().addAll(taKvadratura, taStruktura, taSpratnost, taUdaljenost);

        VBox vb3 = new VBox(10);
        Label lbMetrike = new Label("Izbor metrike:");
        ToggleGroup tg = new ToggleGroup();
        RadioButton rbEuklidska = new RadioButton("Euklidska metrika");
        rbEuklidska.setToggleGroup(tg);
        RadioButton rbMenhetn = new RadioButton("Menhetn metrika");
        rbMenhetn.setToggleGroup(tg);
        Label lbParamter = new Label("Vrednost paramtera k:");
        TextArea taVrednost = new TextArea();
        taVrednost.setPrefSize(250, 1);
        vb3.getChildren().addAll(lbMetrike, rbEuklidska, rbMenhetn, lbParamter, taVrednost);

        hb1.getChildren().addAll(vb1, vb2, vb3);

        HBox hb2 = new HBox(10);
        Button btPredvidi = new Button("Predvidi cenu");
        Label lbCena = new Label("");
        hb2.getChildren().addAll(btPredvidi, lbCena);

        HBox hb3 = new HBox(10);
        Label lbGreska = new Label("");
        hb3.getChildren().add(lbGreska);

        HBox hb4 = new HBox(10);
        hb4.setAlignment(Pos.BOTTOM_RIGHT);
        Button btUcitaj = new Button("Ucitaj bazu podataka");
        hb4.getChildren().add(btUcitaj);

        root.getChildren().addAll(hb1, hb2, hb3, hb4);

        btUcitaj.setOnAction(e -> {
            try {
                vp.ucitajIzFajla("nekretnine.txt");
                ArrayList<Vektor> vektori = vp.getVektori();
            }
            catch (IOException e1) {
                e1.printStackTrace();
                System.exit(1);
            }
            btUcitaj.setDisable(true);
        });

        btPredvidi.setOnAction(e -> {
            if(btUcitaj.isDisable()) {
                try {
                    double kvadratura = Integer.parseInt(taKvadratura.getText());
                    double struktura = Double.parseDouble(taStruktura.getText());
                    double spratnost = Integer.parseInt(taSpratnost.getText());
                    double udaljenost = Double.parseDouble(taUdaljenost.getText());
                    int vrednostK = Integer.parseInt(taVrednost.getText());
                    ArrayList<Double> elementi = new ArrayList<>();
                    elementi.add(kvadratura);
                    elementi.add(struktura);
                    elementi.add(spratnost);
                    elementi.add(udaljenost);
                    Vektor v = new Vektor(elementi, elementi.size());
                    if (rbEuklidska.isSelected()) {
                        KNNPrediktor knn = new KNNPrediktor(vp, new EuklidskaMetrika(), vrednostK);
                        double cena = knn.predvidjanjeCiljnePromen(v);
                        lbCena.setText("" + cena);
                        lbCena.setTextFill(Color.BLUE);
                    } else if (rbMenhetn.isSelected()) {
                        KNNPrediktor knn = new KNNPrediktor(vp, new MenhetnMetrika(), vrednostK);
                        double cena = knn.predvidjanjeCiljnePromen(v);
                        lbCena.setText("" + cena);
                        lbCena.setTextFill(Color.BLUE);
                    } else {
                        lbGreska.setText("Nije izabrano ni jedno dugme");
                        lbGreska.setTextFill(Color.RED);
                    }
                } catch (NumberFormatException e1) {
                    lbGreska.setText("Nedozvoljen format brojcanih unosa");
                    lbGreska.setTextFill(Color.RED);
                }
            }
            else {
                lbGreska.setText("Nije ucitana baza podataka!");
                lbGreska.setTextFill(Color.RED);
            }
        });

        Scene scene = new Scene(root, 520, 440);
        stage.setTitle("KNN prediktor cena nekretnina");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}