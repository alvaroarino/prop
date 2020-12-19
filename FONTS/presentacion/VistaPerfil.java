package presentacion;

import domain.usuari.Perfil;
import domaincontrollers.CtrlDomain;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class VistaPerfil {

    @FXML
    public HBox perfilsRow;

    public void initialize() {
        ArrayList<Perfil> perfiles = new ArrayList<Perfil>();

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
