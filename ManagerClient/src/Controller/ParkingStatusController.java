package Controller;

import Model.IMCPModel;
import javafx.application.Platform;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Status;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class ParkingStatusController implements Initializable
{
    private IMCPModel model;
    public Label totalSpotsLabel;
    public Button statusBtn;
    public TableColumn<Status,String> statusDate;
    public TableColumn<Status,Integer> statusSpots;
    public TableView<Status> statusTable;


    public void init( IMCPModel model) {
        this.model = model;
        getCurrentStatus();
        showAllStatues();

    }

    public void showAllStatues(){
        statusDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        statusSpots.setCellValueFactory(new PropertyValueFactory<>("occupiedSpots"));

        statusTable.setItems(model.getAllStatues());


    }
    public void getCurrentStatus() {
        int MINUTES = 1;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(()->totalSpotsLabel.setText(String.valueOf(40-model.getOccupiedSpots())));
            }
        }, 0, 1000 * 6 * MINUTES);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
