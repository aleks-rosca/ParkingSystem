package Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ParkingStatusController implements Initializable
{
    @FXML
    PieChart statusPieChart;
    private Label totalSpotsLabel;
    private Label guestSpotsLabel;
    private Label empSpotLabel;
    public Label pieChartLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Total Available ", 40),
                        new PieChart.Data("Guest Spots Available ", 20),
                        new PieChart.Data("Employee Spots Available ", 20));


        statusPieChart.setData(pieChartData);

        for (PieChart.Data data : statusPieChart.getData())
        {
            data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>()
            {
                @Override
                public void handle(MouseEvent event)
                {

                    pieChartLabel.setText(String.valueOf(data.getPieValue()));
                }
            });
        }
    }
}
