package presentacion;

import domain.usuari.Perfil;
import domaincontrollers.CtrlDomain;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class VistaPerfil {
    @FXML
    public HBox perfilsRow;

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

                CtrlPresentacion ctrl = CtrlPresentacion.getInstance();
                ctrl.cambiarVista("/vistaPrincipal.fxml");

            });

        }





    }
}
