package lesson4.sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {


    @FXML
    public Button enter;

    @FXML
    public void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
    }
}
