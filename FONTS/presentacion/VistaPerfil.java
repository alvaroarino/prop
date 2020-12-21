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
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class VistaPerfil {
    @FXML
    public HBox perfilsRow;

    @FXML
    public Button botonAdd;

    public void initialize() {
        ArrayList<Perfil> perfiles;

        CtrlDomain domain = CtrlDomain.getInstance();
        perfiles = domain.getPerfils();

        for (Perfil p  : perfiles) {
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


                /*
                CtrlPresentacion ctrl = CtrlPresentacion.getInstance();
                ctrl.cambiarVista("/vistaPrincipal.fxml");
*/
            });

            botonAdd.setOnMouseClicked((event) -> {
                Stage popupwindow=new Stage();

                popupwindow.initModality(Modality.APPLICATION_MODAL);
                popupwindow.setTitle("This is a pop up window");

                Label label1= new Label("Pop up window now displayed");
                Button button1= new Button("Close this pop up window");

                button1.setOnAction(e -> popupwindow.close());

                VBox layout = new VBox(10);
                layout.getChildren().addAll(label1, button1);
                layout.setAlignment(Pos.CENTER);

                Scene scene1= new Scene(layout, 300, 250);
                popupwindow.setScene(scene1);
                popupwindow.showAndWait();
            });

        }

    }
}
