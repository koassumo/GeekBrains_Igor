package lesson6.serverGUI_FX;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

// ВАЖНО !!! не забыть в файле fxml подключить контроллер в первом контейнере типа fx:controller="lesson4.sample.Controller"

public class Controller {


    @FXML
    private Button enter;

    @FXML
    private TextArea textar;

    @FXML
    private TextField textField;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        textar.setText(textar.getText() + "\n" + textField.getText());
        textField.clear();
    }
}
