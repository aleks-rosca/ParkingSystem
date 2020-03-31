package EmployeeClient;

import Controller.EReservationController;
import Model.ECModel;
import Model.IECModel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartEC extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/View/EClient.fxml"));
        Parent main = loader.load();
        EReservationController ctrl = loader.getController();
        IEmployeeClient cl = new EmployeeClient();
        IECModel model = new ECModel(cl);
        ctrl.init(model);
        primaryStage.setTitle("IMPS");
        primaryStage.setScene(new Scene(main, 600, 400));
        primaryStage.show();
    }
}
