package GateClient;

import Controller.GController;

import Model.GCEModel;
import Model.IGCEmodel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartGC extends Application
{

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/GateView.fxml"));
        Parent main = loader.load();
        GController ctrl = loader.getController();

        IGClient gc = new GClient();
        IGCEmodel emodel = new GCEModel(gc);
        ctrl.init(emodel);
        primaryStage.setTitle("Gate");
        primaryStage.setScene(new Scene(main, 600, 400));
        primaryStage.show();

    }
}
