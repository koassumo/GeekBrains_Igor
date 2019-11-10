package lesson6.serverGUI_FX;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;


// в меню run - edit configuration добавлена строка --module-path "c:\fx\javafx-sdk-11.0.2\lib" --add-modules javafx.controls,javafx.fxml
// с указанием на lib javafx (постоянно слетает !!!!!!)

public class ClientFX_Igor extends Application {

    //------------
    private final String SERVER_ADDR = "localhost";
    private final int SERVER_PORT = 8189;

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;


    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("scene.fxml"));
        Parent root = loader.load();    //  или Parent root = FXMLLoader.load(getClass().getResource("scene.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.setTitle("ClientFX_Igor");         // или stage.setScene(new Scene(root, 600, 500));
        stage.show();


        //-----------------------

        try {
            openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
//         prepareGUI();
    }


    public void openConnection() throws IOException {
        socket = new Socket(SERVER_ADDR, SERVER_PORT);
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        String strFromServer = in.readUTF();
                        if (strFromServer.equalsIgnoreCase("/end")) {
                            break;
                        }
                        System.out.println(strFromServer);
                        // chatArea.append(strFromServer);
                        // chatArea.append("\n");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}


