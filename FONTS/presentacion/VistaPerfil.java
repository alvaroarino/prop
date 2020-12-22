package presentacion;

import domain.ranking.Stat;
import domain.usuari.Perfil;
import domaincontrollers.CtrlDomain;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

/**
 * The type Vista perfil.
 */
public class VistaPerfil {
    /**
     * The Domain.
     */
    CtrlDomain domain = CtrlDomain.getInstance();
    /**
     * The Perfils row.
     */
    @FXML
    public HBox perfilsRow;

    /**
     * The Button add perfil.
     */
    @FXML
    public Button ButtonAddPerfil;

    /**
     * The Perfiles.
     */
    ObservableList<Perfil> perfiles = FXCollections.observableArrayList();

    /**
     * Initialize.
     */
    public void initialize() {
        perfiles.addAll(domain.getPerfils());

        for (Perfil p : perfiles) {
            VBox perfilBox = new VBox();
            Button boton = new Button(p.getNom());
            perfilBox.getChildren().add(boton);
            perfilsRow.getChildren().add(perfilBox);
            boton.setOnMouseClicked((event) -> {
                domain.setPerfilactual(p);
                Node node = (Node) event.getSource();
                Stage thisStage = (Stage) node.getScene().getWindow();
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("/vistaPrincipal.fxml"));
                    Scene scene = new Scene(root);
                    thisStage.setTitle("KakuroMasters");
                    thisStage.setScene(scene);
                    thisStage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }

        ButtonAddPerfil.setOnMouseClicked((event) -> {
            Stage popupwindow = new Stage();

            popupwindow.initModality(Modality.APPLICATION_MODAL);
            popupwindow.setTitle("Creacion del perfil");

            Button saveButton = new Button("Guardar");
            Button exitButton = new Button("Salir sin guardar");
            TextField nameField = new TextField();
            nameField.setText("Nombre");

            saveButton.setOnAction(e -> {
                String name = nameField.getText();
                domain.crearPerfil(name);
                popupwindow.close();
                try {
                    Node node = (Node) event.getSource();
                    Stage stage = (Stage) node.getScene().getWindow();
                    Parent root = FXMLLoader.load(getClass().getResource("/vistaPerfil.fxml"));
                    Scene scene = new Scene(root);
                    stage.setTitle("KakuroMasters");
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException exception) {
                    exception.printStackTrace();
                }

            });

            exitButton.setOnAction(e -> popupwindow.close());

            HBox buttons = new HBox(10);
            buttons.getChildren().addAll(saveButton, exitButton);

            VBox layout = new VBox(10);
            layout.getChildren().addAll(nameField, buttons);
            layout.setAlignment(Pos.CENTER);

            Scene scene1 = new Scene(layout, 300, 250);
            popupwindow.setScene(scene1);
            popupwindow.showAndWait();
        });
    }
}
