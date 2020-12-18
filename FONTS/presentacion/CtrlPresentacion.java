package presentacion;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class CtrlPresentacion extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/vistaPrincipal.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setTitle("KakuroMasters");
            primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/icon.png")));
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {launch(args);
    }

}
