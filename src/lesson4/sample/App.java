package lesson4.sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


// в меню run - edit configuration добавлена строка --module-path "c:\fx\javafx-sdk-11.0.2\lib" --add-modules javafx.controls,javafx.fxml
// с указанием на lib javafx (постоянно слетает !!!!!!)

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("scene.fxml"));
        Parent root = loader.load();    //  или Parent root = FXMLLoader.load(getClass().getResource("scene.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("Chat");         // или stage.setScene(new Scene(root, 600, 500));
        stage.show();
    }



}
