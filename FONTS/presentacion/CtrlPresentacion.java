package presentacion;

import dades.CtrlDataAventura;
import domain.usuari.Usuari;
import domaincontrollers.CtrlDomain;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class CtrlPresentacion extends Application {
    private static CtrlPresentacion singletonObject;

    public static CtrlPresentacion getInstance() {
        if (singletonObject == null)
            singletonObject = new CtrlPresentacion() {
            };
        return singletonObject;
    }

    Stage presentacionStage;

    @Override
    public void start(Stage primaryStage) throws Exception {

        CtrlDomain domain = CtrlDomain.getInstance();
        domain.initData();

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/vistaPrincipal.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setTitle("KakuroMasters");
            primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/icon.png")));
            primaryStage.setScene(scene);
            primaryStage.show();
            presentacionStage = primaryStage;
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    public void main(String[] args) {
        launch(args);
    }

    public void cambiarVista(String vistaFile) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(vistaFile));
            Scene scene = new Scene(root);
            presentacionStage.setTitle("KakuroMasters");
            presentacionStage.setScene(scene);
            presentacionStage.show();
        } catch (NullPointerException | IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
