package Controller;

import Model.IMCPModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import model.Status;

import java.net.URL;
import java.util.ResourceBundle;

public class ParkingStatusController implements Initializable {
    public PieChart pieChart;
    public Button statusBtn;
    public TableColumn<Status, String> statusDate;
    public TableColumn<Status, Integer> statusSpots;
    public TableView<Status> statusTable;
    private IMCPModel model;

    public void init(IMCPModel model) {
        this.model = model;
        showAllStatues();
        updatePie();

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
                        new PieChart.Data("Public Users - " + model.getNumberOfPublicUsersInParkingLot(), model.getNumberOfPublicUsersInParkingLot()),
                        new PieChart.Data("Available Spots - " + model.getOccupiedSpots(), model.getOccupiedSpots()));

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }
}

