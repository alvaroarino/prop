package presentacion;

import domaincontrollers.CtrlDomain;
import javafx.application.Application;
import javafx.application.HostServices;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The type Ctrl presentacion.
 */
public class CtrlPresentacion extends Application {
    private static CtrlPresentacion singletonObject;

    /**
     * Gets instance.
     *
     * @return the instance
     */
    public static CtrlPresentacion getInstance() {
        if (singletonObject == null)
            singletonObject = new CtrlPresentacion() {
            };
        return singletonObject;
    }

    /**
     * The Presentacion stage.
     */
    Stage presentacionStage;

    @Override
    public void start(Stage primaryStage) throws Exception {

        CtrlDomain domain = CtrlDomain.getInstance();
        domain.initData();

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/vistaLogIn.fxml"));
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

    /**
     * Main.
     *
     * @param args the args
     */
    public void main(String[] args) {
        launch(args);
    }
}
