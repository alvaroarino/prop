package presentacion;

import domain.usuari.Perfil;
import domaincontrollers.CtrlDomain;
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

public class VistaPerfil {
    CtrlDomain domain = CtrlDomain.getInstance();
    @FXML
    public HBox perfilsRow;

    @FXML
    public Button ButtonAddPerfil;

    public void initialize() {
        updateProfiles();

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
                perfilsRow = new HBox();
                updateProfiles();
            });

            exitButton.setOnAction(e -> {
                popupwindow.close();

            });

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

    private void updateProfiles() {
        ArrayList<Perfil> perfiles;

        perfiles = domain.getPerfils();

        for (Perfil p : perfiles) {
            VBox perfilBox = new VBox();
            Button boton = new Button(p.getNom());
            perfilBox.getChildren().add(boton);
            perfilsRow.getChildren().add(perfilBox);
            boton.setOnMouseClicked((event) -> {
                domain.setPerfilactual(p);

                Node node = (Node) event.getSource();
                Stage thisStage = (Stage) node.getScene().getWindow();
                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("/vistaPrincipal.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Scene scene = new Scene(root);
                thisStage.setTitle("KakuroMasters");
                thisStage.setScene(scene);
                thisStage.show();
            });
        }
    }
}
