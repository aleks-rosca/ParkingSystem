package Controller;

import Model.IMCPModel;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.Status;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

public class ParkingStatusController implements Initializable {
    public PieChart pieChart;
    public Label chartLabel;
    public Label totalSpotsLabel;
    public Button statusBtn;
    public TableColumn<Status, String> statusDate;
    public TableColumn<Status, Integer> statusSpots;
    public TableView<Status> statusTable;
    private IMCPModel model;

    public void init(IMCPModel model) {
        this.model = model;
        getCurrentStatus();
        showAllStatues();
        updatePie();
        System.out.println(model.getNumberOfEmployeesInParkingLot());
        System.out.println(model.getNumberOfGuestsInParkingLot());
        System.out.println(model.getNumberOfPublicUsersInParkingLot());

    }

    public void showAllStatues() {
        statusDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        statusSpots.setCellValueFactory(new PropertyValueFactory<>("occupiedSpots"));

        statusTable.setItems(model.getAllStatues());


    }

    public void updatePie() {

        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Employees - " + model.getNumberOfEmployeesInParkingLot(), model.getNumberOfEmployeesInParkingLot()),
                        new PieChart.Data("Guests - " + model.getNumberOfGuestsInParkingLot(), model.getNumberOfGuestsInParkingLot()),
                        new PieChart.Data("Public Users - " + model.getNumberOfPublicUsersInParkingLot(), model.getNumberOfPublicUsersInParkingLot()));


        pieChart.setData(pieChartData);
        pieChart.setLabelsVisible(false);

        for (PieChart.Data data : pieChart.getData()) {
            data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {

                    updatePie();
                }
            });
        }
    }

    public void getCurrentStatus() {
        int MINUTES = 1;
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> totalSpotsLabel.setText(String.valueOf(40 - model.getOccupiedSpots())));
            }
        }, 0, 1000 * 6 * MINUTES);

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }
}

