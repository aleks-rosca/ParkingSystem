package ManagerClient;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;


public class StartMC extends Application
{

    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {

        launch(args);
    }

    public void start(Stage primaryStage) throws Exception
    {
        Parent main = FXMLLoader.load(getClass().getResource("/View/MCClient.fxml"));
        primaryStage.setTitle("IPMS");
        primaryStage.setScene(new Scene(main, 600, 400));
        primaryStage.show();
    }
}

