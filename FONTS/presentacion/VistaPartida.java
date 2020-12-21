package presentacion;

import dades.CtrlDades;
import domain.kakuro.Kakuro;
import domain.partida.Partida;
import domaincontrollers.CtrlDomain;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.util.Timer;
import java.util.TimerTask;

public class VistaPartida {
    @FXML
    Label timeLabel;

    @FXML
    Label PuntuacionLabel;

    @FXML
    Label LabelPerfil;

    @FXML
    Button ButtonSalir;

    @FXML
    Button ButtonPausa;

    @FXML
    GridPane KakuroGridPane;

    CtrlDomain domain = CtrlDomain.getInstance();
    Kakuro generated;
    Partida actual;
    Timer timer = new Timer();
    int time = 0;

    public void initialize() {
        LabelPerfil.setText(domain.perfilActual.getNom());
        timeLabel.setText(String.format("%s seg", time));
        TimerTask task = new TimerTask() {
            public void run() {
                time += 1;
                Platform.runLater(() -> timeLabel.setText(String.format("%s seg", time)));
            }
        };
        timer.scheduleAtFixedRate(task, 0, 1000);
    }
}
