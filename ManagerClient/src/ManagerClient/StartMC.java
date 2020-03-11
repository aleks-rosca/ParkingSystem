package ManagerClient;

import Controller.MCController;
import Model.IMCEModel;
import Model.IMCGModel;
import Model.MCEModel;
import Model.MCGModel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartMC extends Application {

    public static void main(String[] args) {

        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/MCClient.fxml"));
        Parent main = loader.load();
        MCController ctrl = loader.getController();
        IManagerClient cl = new ManagerClient();
        IMCEModel model = new MCEModel(cl);
        ctrl.init(model);
        primaryStage.setTitle("IPMS");
        primaryStage.setScene(new Scene(main, 600, 400));
        primaryStage.show();
    }
}

