package presentacion;

import domaincontrollers.CtrlDomain;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class VistaLogIn {
    @FXML
    public Label errorMessage;
    @FXML
    public TextField usernameTextField;
    @FXML
    public TextField passTextField;
    @FXML
    public Button loginButton;
    @FXML
    public Button signupButton;

    public void initialize() {
        errorMessage.setOpacity(0.0);
        loginButton.setOnMouseClicked((event) -> {
            boolean logged = logIn();
            if (logged) {
                // CAMBIO DE PANTALLA
                Node node = (Node) event.getSource();
                Stage thisStage = (Stage) node.getScene().getWindow();
                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("/vistaPerfil.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Scene scene = new Scene(root);
                thisStage.setTitle("KakuroMasters");
                thisStage.setScene(scene);
                thisStage.show();
            } else {
                errorMessage.setOpacity(1.0);
                errorMessage.setText("El usuario o la contraseña contienen errores");
            }
        });

        signupButton.setOnMouseClicked((event) -> {
            boolean signedup = signUp();
            if (signedup) {
                // CAMBIO DE PANTALLA
                Node node = (Node) event.getSource();
                Stage thisStage = (Stage) node.getScene().getWindow();
                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("/vistaPerfil.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Scene scene = new Scene(root);
                thisStage.setTitle("KakuroMasters");
                thisStage.setScene(scene);
                thisStage.show();
            } else {
                errorMessage.setOpacity(1.0);
                errorMessage.setText("Usuario ya registrado");
            }
        });
    }

    boolean logIn() {
        CtrlDomain domain = CtrlDomain.getInstance();
        return domain.checkUsuari("login", usernameTextField.getText(), passTextField.getText());
    }

    boolean signUp() {
        CtrlDomain domain = CtrlDomain.getInstance();
        boolean exists = domain.checkUsuari("signup", usernameTextField.getText(), passTextField.getText());
        if (!exists) {
            domain.addUsuari(usernameTextField.getText(), passTextField.getText());
            return true;
        } else {
            return false;
        }
    }
}