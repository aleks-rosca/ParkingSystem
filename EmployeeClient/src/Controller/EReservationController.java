package Controller;

import Model.IECModel;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.EmployeeRes;

public class EReservationController {

    public IECModel ecModel;
    public TextField empNoTF;
    public DatePicker choosedate;
    @FXML
    TableView<EmployeeRes> empTw;
    @FXML
    TableColumn<EmployeeRes, String> c1;
    @FXML
    TableColumn<EmployeeRes, String> c2;

    public void init(IECModel ecModel) {
        this.ecModel = ecModel;
    }

    public void empReservation() {
        ecModel.addEmpRes(choosedate.getValue().toString(), empNoTF.getText());
        if (empNoTF.getText().trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Employee Number");
            alert.setHeaderText("Employee number not added");
            alert.setContentText("Please add employee number to reserve a spot for given date");
            alert.getButtonTypes();

            alert.show();
        }
        if (choosedate.getValue() == null) {
            Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setTitle("Date");
            alert1.setHeaderText("Date not chosen");
            alert1.setContentText("Chose a date to reserve a parking on the given date");
            alert1.getButtonTypes();

            alert1.show();
        }
        getReservation();
    }

    public void getReservation() {
        c1.setCellValueFactory(new PropertyValueFactory<EmployeeRes, String>("DateFromPicker"));
        c2.setCellValueFactory(new PropertyValueFactory<>("empNo"));

        empTw.setItems(ecModel.getEmpRes(empNoTF.getText()));

    }

    public void deleteReservation() {
        EmployeeRes employeeRes = empTw.getSelectionModel().getSelectedItem();
        Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Delete " + empTw.getSelectionModel().getSelectedItem().getDateFromPicker() + " ?", ButtonType.YES, ButtonType.NO);
        a.showAndWait();
        if (a.getResult() == ButtonType.YES) {
            ecModel.deleteEmpRes(employeeRes);
            empTw.getItems().removeAll(employeeRes);
        }
    }
}
