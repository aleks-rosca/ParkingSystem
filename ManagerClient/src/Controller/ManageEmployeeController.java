package Controller;

import Model.IMCEModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import model.Employee;

import java.io.IOException;
import java.util.Optional;

public class ManageEmployeeController {
    public TextField empFirstNameAddTf;
    public TextField empLastNameAddTf;
    public TextField empNameSearchTf;
    public TextField empNumberAddTf;
    public IMCEModel mceModel;
    @FXML
    TableView<Employee> manageEmpTableTv;
    @FXML
    TableColumn<Employee, String> manageEmpFirstName;
    @FXML
    TableColumn<Employee, String> manageEmpLastName;
    @FXML
    TableColumn<Employee, String> manageEmpNo;

    public void init(IMCEModel mceModel) {
        this.mceModel = mceModel;
        manageEmpTableTv.setEditable(true);
        manageEmpFirstName.setCellFactory(TextFieldTableCell.forTableColumn());
        manageEmpLastName.setCellFactory(TextFieldTableCell.forTableColumn());
        manageEmpNo.setCellFactory(TextFieldTableCell.forTableColumn());
    }


    public void AddEmp(ActionEvent actionEvent) throws IOException {
        //TODO add a try catch to see if the name and number exist already\
        if (!(empFirstNameAddTf.getText().isEmpty()) & !(empLastNameAddTf.getText().isEmpty()) & !(empNumberAddTf.getText().isEmpty())) {
            if (mceModel.checkFirstChar(empNumberAddTf.getText())) {
                String temp = mceModel.createEmp(mceModel.rearrangeChars(empFirstNameAddTf.getText()), empLastNameAddTf.getText(), empNumberAddTf.getText());
                if (temp.equals("Employee added")) {
                    Alert a1 = new Alert(Alert.AlertType.INFORMATION, "Employee " + empFirstNameAddTf.getText() + " has been added!", ButtonType.OK);
                    a1.show();
                    empFirstNameAddTf.clear();
                    empNumberAddTf.clear();
                } else if (temp.equals("Duplicate key")) {
                    Alert a1 = new Alert(Alert.AlertType.INFORMATION, "Employee " + empFirstNameAddTf.getText() + " already exists!", ButtonType.OK);
                    a1.show();
                } else {
                    Alert a1 = new Alert(Alert.AlertType.INFORMATION, "Error 404", ButtonType.OK);
                    a1.show();
                }
            } else {
                Alert a1 = new Alert(Alert.AlertType.INFORMATION, "Employee number should start from E", ButtonType.OK);
                a1.show();
            }
        } else {
            Alert a1 = new Alert(Alert.AlertType.INFORMATION, "All of the fields should be filled", ButtonType.OK);
            a1.show();
        }


        showAllEmployee(actionEvent);
    }

    public void empSearchBtn(ActionEvent actionEvent) {
         /*   try
        {
            //TODO display empNameSearchTf.getText() in the ListView
        }
        catch (Exception e)
        { */
        if (empNameSearchTf.getText().trim().isEmpty()) {
            // create a alert
            Alert a1 = new Alert(Alert.AlertType.ERROR, "Employee Search field is empty ", ButtonType.OK);
            a1.show();

        } else {
            // create a alert
            Alert a1 = new Alert(Alert.AlertType.ERROR, "Employee " + empNameSearchTf.getText() + " does not exist in the system" + " \n\nAdd Employee to the system? ", ButtonType.YES, ButtonType.NO);

            Optional<ButtonType> result = a1.showAndWait();
            ButtonType button = result.orElse(ButtonType.NO);
            if (button == ButtonType.YES) {

                String change = empNameSearchTf.getText();
                empFirstNameAddTf.setText(change);
                empNameSearchTf.clear();
            } else {
                System.out.println("No pressed");
            }
        }
    }

    public void showAllEmployee(ActionEvent actionEvent) {
        manageEmpFirstName.setCellValueFactory(new PropertyValueFactory<>("empFirstName"));
        manageEmpLastName.setCellValueFactory(new PropertyValueFactory<>("empLastName"));
        manageEmpNo.setCellValueFactory(new PropertyValueFactory<>("empNumber"));

        manageEmpTableTv.setItems(mceModel.getAllEmployee());
    }

    public void onEditFirstname(TableColumn.CellEditEvent<Employee, String> employeeStringCellEditEvent) {
        Employee employee = manageEmpTableTv.getSelectionModel().getSelectedItem();
        employee.setEmpFirstName(employeeStringCellEditEvent.getNewValue());
        mceModel.updateEmployee(employee, employee.getEmpNumber());
    }

    public void onEditLastName(TableColumn.CellEditEvent<Employee, String> employeeStringCellEditEvent) {
        Employee employee = manageEmpTableTv.getSelectionModel().getSelectedItem();
        employee.setEmpLastName(employeeStringCellEditEvent.getNewValue());
        mceModel.updateEmployee(employee, employee.getEmpNumber());
    }

    public void onEditEmpNum(TableColumn.CellEditEvent<Employee, String> employeeStringCellEditEvent) {
        Employee employee = manageEmpTableTv.getSelectionModel().getSelectedItem();
        String oldEmpNo = employee.getEmpNumber();
        employee.setEmpNumber(employeeStringCellEditEvent.getNewValue());
        mceModel.updateEmployee(employee, oldEmpNo);
    }

    public void deleteEmp(ActionEvent actionEvent) {
        Employee employee = manageEmpTableTv.getSelectionModel().getSelectedItem();
        Alert a = new Alert(Alert.AlertType.CONFIRMATION, "Delete " + manageEmpTableTv.getSelectionModel().getSelectedItem().getEmpFirstName() + " ?", ButtonType.YES, ButtonType.NO);
        a.showAndWait();
        if (a.getResult() == ButtonType.YES) {
            mceModel.deleteEmployee(employee);
            manageEmpTableTv.getItems().removeAll(employee);
        }

    }
}