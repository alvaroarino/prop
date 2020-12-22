import domaincontrollers.CtrlDomain;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class VistaGaleria {
    @FXML
    public GridPane PanelGaleria;

    public void initialize() {
        CtrlDomain domain = CtrlDomain.getInstance();

        int n = 20;


            int x = 1;
            for (int i = 0; i < 10; i++) {
                Button button = new Button();
                button.setText("Easy");
                button.setPrefWidth(100);
                PanelGaleria.add(button,i,0);
                ++x;
            }
        for (int i = 0; i < 5; i++) {
            Button button = new Button();
            button.setText("Medium");
            button.setPrefWidth(100);
            PanelGaleria.add(button,i,1);
            ++x;
        }

        for (int i = 0; i < 5; i++) {
            Button button = new Button();
            button.setText("Hard");
            button.setPrefWidth(100);
            PanelGaleria.add(button,i,2);
            ++x;
        }





    }
}
