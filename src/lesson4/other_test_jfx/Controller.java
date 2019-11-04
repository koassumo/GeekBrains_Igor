package lesson4.other_test_jfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class Controller {


//    @FXML
//    private Button enter;

    @FXML
    private TextArea tar;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        tar.setText(tar.getText() + "\n" + "Hello World!");
    }
}
