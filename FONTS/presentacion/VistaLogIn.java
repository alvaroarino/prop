package presentacion;

import domaincontrollers.CtrlDomain;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The type Vista log in.
 */
public class VistaLogIn {
    /**
     * The Error message.
     */
    @FXML
    public Label errorMessage;
    /**
     * The Username text field.
     */
    @FXML
    public TextField usernameTextField;
    /**
     * The Pass text field.
     */
    @FXML
    public PasswordField passTextField;
    /**
     * The Login button.
     */
    @FXML
    public Button loginButton;
    /**
     * The Signup button.
     */
    @FXML
    public Button signupButton;

    /**
     * Initialize.
     */
    public void initialize() {
        errorMessage.setOpacity(0.0);
        loginButton.setOnMouseClicked((event) -> {
            boolean logged = logIn();
            if (logged) {
                // CAMBIO DE PANTALLA
                Node node = (Node) event.getSource();
                Stage thisStage = (Stage) node.getScene().getWindow();
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("/vistaPerfil.fxml"));
                    Scene scene = new Scene(root);
                    thisStage.setTitle("KakuroMasters");
                    thisStage.setScene(scene);
                    thisStage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }

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
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("/vistaPerfil.fxml"));
                    Scene scene = new Scene(root);
                    thisStage.setTitle("KakuroMasters");
                    thisStage.setScene(scene);
                    thisStage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else {
                errorMessage.setOpacity(1.0);
                errorMessage.setText("Usuario ya registrado");
            }
        });
    }

    /**
     * Log in boolean.
     *
     * @return the boolean
     */
    boolean logIn() {
        CtrlDomain domain = CtrlDomain.getInstance();
        return domain.checkUsuari("login", usernameTextField.getText(), passTextField.getText());
    }

    /**
     * Sign up boolean.
     *
     * @return the boolean
     */
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