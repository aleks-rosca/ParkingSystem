package View;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MCClient extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent main = FXMLLoader.load(getClass().getResource("MCClient.fxml"));
        primaryStage.setTitle("IPMS");
        primaryStage.setScene(new Scene(main, 600, 400));
        primaryStage.show();


    }

}
