package ManagerClient;

import Controller.MCController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import serverinterface.IServer;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class StartMC extends Application
{


    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        Client c = new Client();
//            Registry reg = LocateRegistry.getRegistry("localhost", 1099);
//            IServer s = (IServer) reg.lookup("IPMS");
//            s.message("Manager Client Connected");
           // System.out.println("Testing Running");

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

