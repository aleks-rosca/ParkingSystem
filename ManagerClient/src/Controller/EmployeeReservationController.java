package Controller;

import Model.IMCEModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Employee;
import model.EmployeeRes;

import java.io.IOException;

public class EmployeeReservationController {
    public TextField empReservNumTf;
    public DatePicker empReservDateDp;
    public IMCEModel mceModel;
    @FXML
    TableView<EmployeeRes> empReservTableTv;
    @FXML
    TableColumn<EmployeeRes, Employee> empNameTc;
    @FXML
    TableColumn<EmployeeRes, String> dateTc;
    @FXML
    TableColumn<EmployeeRes, Employee> empNoTc;
    @FXML
    TableColumn<EmployeeRes, String> resNoTc;

    public void init(IMCEModel mceModel) {
        this.mceModel = mceModel;
    }


    public void reservBtnClick(ActionEvent actionEvent) throws IOException {


        if (!(empReservNumTf.getText().isEmpty()) & !(String.valueOf(empReservDateDp.getValue()).equals("null"))) {
            String temp = mceModel.addEmpRes(empReservDateDp.getValue().toString(), empReservNumTf.getText());
            if (temp.equals("Reservation is not created")) {
                Alert a1 = new Alert(Alert.AlertType.INFORMATION, "Reservation is not created", ButtonType.OK);
                a1.show();
            } else if (temp.equals("You can not create reservation for same day or more than 7 days ahead")) {
                Alert a1 = new Alert(Alert.AlertType.INFORMATION, "You can not create reservation for same day or more than 7 days ahead", ButtonType.OK);
                a1.show();
            } else if (temp.equals("Reservation is created")) {
                Alert a1 = new Alert(Alert.AlertType.INFORMATION, "Reservation is created", ButtonType.OK);
                a1.show();
            } else {
                Alert a1 = new Alert(Alert.AlertType.INFORMATION, "Check your connection and try again", ButtonType.OK);
                a1.show();
            }


        } else {
            // create a alert
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Fields are empty");
            alert.setContentText("All of the fields must be filled");
            alert.getButtonTypes();
            alert.show();
        }

    }

    public void onlyManagerReservation(ActionEvent actionEvent) {
        dateTc.setCellValueFactory(new PropertyValueFactory<EmployeeRes, String>("DateFromPicker"));
        empNoTc.setCellValueFactory(new PropertyValueFactory<>("empNo"));

        empReservTableTv.setItems(mceModel.getAllEmpReservationByEmpNo(empReservNumTf.getText()));


    }

    public void showAllEmployeeReservations(ActionEvent actionEvent) {
        dateTc.setCellValueFactory(new PropertyValueFactory<EmployeeRes, String>("DateFromPicker"));
        empNoTc.setCellValueFactory(new PropertyValueFactory<>("empNo"));
        empNameTc.setCellValueFactory(new PropertyValueFactory<EmployeeRes, Employee>("employee"));

        resNoTc.setCellValueFactory(new PropertyValueFactory<>("empNo"));

        empReservTableTv.setItems(mceModel.getAllEmpReservation());
    }

    public void deleteEmployeeReservation(ActionEvent actionEvent) {
        EmployeeRes employeeRes = empReservTableTv.getSelectionModel().getSelectedItem();

        mceModel.deleteEmpRes(employeeRes);
        empReservTableTv.getItems().removeAll(employeeRes);
    }
}