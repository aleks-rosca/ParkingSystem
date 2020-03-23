package GateClientOUT;

import Controller.GOController;
import Model.GCModel;
import Model.IGCModel;
import Observer.PropertyChangeSubject;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartGateOUT extends Application
{

    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/GateViewOUT.fxml"));
        Parent main = loader.load();
        GOController ctrl = loader.getController();

        IGClient gc = new GClient();
        IGCModel emodel = new GCModel(gc);
        ctrl.init(emodel);
        primaryStage.setTitle("Gate");
        primaryStage.setScene(new Scene(main, 600, 400));
        primaryStage.show();

    }
}
