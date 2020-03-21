package Controller;

import Model.IMCEModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.GridPane;
import model.Employee;

import java.io.IOException;
import java.util.Optional;

public class ManageEmployeeController
{
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

    public void init(IMCEModel mceModel)
    {
        this.mceModel = mceModel;
        manageEmpTableTv.setEditable(true);
        manageEmpFirstName.setCellFactory(TextFieldTableCell.forTableColumn());
        manageEmpLastName.setCellFactory(TextFieldTableCell.forTableColumn());
        manageEmpNo.setCellFactory(TextFieldTableCell.forTableColumn());
    }


    public void AddEmp(ActionEvent actionEvent) throws IOException
    {
        //TODO add a try catch to see if the name and number exist already\
        if (!(empFirstNameAddTf.getText().isEmpty()) & !(empLastNameAddTf.getText().isEmpty()) & !(empNumberAddTf.getText().isEmpty()))
        {
            if (mceModel.checkFirstChar(empNumberAddTf.getText()))
            {
                String temp = mceModel.createEmp(mceModel.rearrangeChars(empFirstNameAddTf.getText()), empLastNameAddTf.getText(), empNumberAddTf.getText());
                if (temp.equals("Employee added"))
                {
                    Alert a1 = new Alert(Alert.AlertType.INFORMATION, "Employee " + empFirstNameAddTf.getText() + " has been added!", ButtonType.OK);
                    a1.show();
                    empFirstNameAddTf.clear();
                    empNumberAddTf.clear();
                } else if (temp.equals("Duplicate key"))
                {
                    Alert a1 = new Alert(Alert.AlertType.INFORMATION, "Employee " + empFirstNameAddTf.getText() + " already exists!", ButtonType.OK);
                    a1.show();
                } else
                {
                    Alert a1 = new Alert(Alert.AlertType.INFORMATION, "Error 404", ButtonType.OK);
                    a1.show();
                }
            } else
            {
                Alert a1 = new Alert(Alert.AlertType.INFORMATION, "Employee number should start from E", ButtonType.OK);
                a1.show();
            }
        } else
        {
            Alert a1 = new Alert(Alert.AlertType.INFORMATION, "All of the fields should be filled", ButtonType.OK);
            a1.show();
        }


//        if (model.createEmp()) {
//            Alert a1 = new Alert(Alert.AlertType.INFORMATION, "Employee " + empNameAddTf.getText() + " has been added", ButtonType.OK);
//            a1.show();
//            empNameAddTf.clear();
//            empNumberAddTf.clear();
//        } else {
//
//            Alert a1 = new Alert(Alert.AlertType.ERROR, "Employee " + empNameAddTf.getText() + " already exists with " + empNumberAddTf.getText(), ButtonType.OK);
//
//            a1.show();
//            empNameAddTf.clear();
//            empNumberAddTf.clear();
//
//        }
    }

    public void empSearchBtn(ActionEvent actionEvent)
    {
         /*   try
        {
            //TODO display empNameSearchTf.getText() in the ListView
        }
        catch (Exception e)
        { */
        if (empNameSearchTf.getText().trim().isEmpty())
        {
            // create a alert
            Alert a1 = new Alert(Alert.AlertType.ERROR, "Employee Search field is empty ", ButtonType.OK);
            a1.show();

        } else
        {
            // create a alert
            Alert a1 = new Alert(Alert.AlertType.ERROR, "Employee " + empNameSearchTf.getText() + " does not exist in the system" + " \n\nAdd Employee to the system? ", ButtonType.YES, ButtonType.NO);

            Optional<ButtonType> result = a1.showAndWait();
            ButtonType button = result.orElse(ButtonType.NO);
            if (button == ButtonType.YES)
            {

                String change = empNameSearchTf.getText();
                empFirstNameAddTf.setText(change);
                empNameSearchTf.clear();
            } else
            {
                System.out.println("No pressed");
            }
        }
    }

    public void showAllEmployee(ActionEvent actionEvent)
    {
        manageEmpFirstName.setCellValueFactory(new PropertyValueFactory<>("empFirstName"));
        manageEmpLastName.setCellValueFactory(new PropertyValueFactory<>("empLastName"));
        manageEmpNo.setCellValueFactory(new PropertyValueFactory<>("empNumber"));

        manageEmpTableTv.setItems(mceModel.getAllEmployee());
    }

    public void editEmp(ActionEvent actionEvent)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Editing Employee");
        alert.setHeaderText("Chose the edits you want to do");

        Label label1 = new Label("Employee First Name: ");
        Label label2 = new Label("Employee Last Name: ");
        Label label3 = new Label("Employee Number: ");
        TextField text1 = new TextField();
        TextField text2 = new TextField();
        TextField text3 = new TextField();

        GridPane grid = new GridPane();
        grid.add(label1, 1, 1);
        grid.add(text1, 2, 1);
        grid.add(label2, 1, 2);
        grid.add(text2, 2, 2);
        grid.add(label3, 1, 3);
        grid.add(text3, 2, 3);
        alert.getDialogPane().setContent(grid);

        ButtonType updateButton = new ButtonType("Confirm");
        ButtonType deleteButton = new ButtonType("Delete");
        ButtonType dontsave = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(updateButton, deleteButton, dontsave);

        alert.showAndWait().ifPresent(type ->
        {
            if (type == updateButton)
            {
                if (!(text1.getText().isEmpty()) & !(text2.getText().isEmpty()) & !(text3.getText().isEmpty()))
                {

                } else
                {
                    Alert a1 = new Alert(Alert.AlertType.INFORMATION, "All of the fields should be filled", ButtonType.OK);
                    a1.show();

                }

                System.out.println("Updated");
            } else if (type == deleteButton)
            {
                if (!(text1.getText().isEmpty()) & !(text2.getText().isEmpty()) & !(text3.getText().isEmpty()))
                {
                    System.out.println("Deleting....");

                    Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION);
                    alert2.setTitle("Confirmation Dialog");
                    alert2.setHeaderText("Look, a Confirmation Dialog");
                    alert2.setContentText("Are you ok with this?");

                    Optional<ButtonType> result = alert2.showAndWait();
                    if (result.get() == ButtonType.YES)
                    {
                        System.out.println("Deleted");
                    } else if (result.get() == ButtonType.NO)
                    {
                        System.out.println("Not Deleted");
                    }
                } else
                {
                    Alert a1 = new Alert(Alert.AlertType.INFORMATION, "All of the fields should be filled", ButtonType.OK);
                    a1.show();
                }
            }
        });


    }

    public void onEditFirstname(TableColumn.CellEditEvent<Employee, String> employeeStringCellEditEvent)
    {
        Employee employee = manageEmpTableTv.getSelectionModel().getSelectedItem();
        employee.setEmpFirstName(employeeStringCellEditEvent.getNewValue());
    }

    public void onEditLastName(TableColumn.CellEditEvent<Employee, String> employeeStringCellEditEvent)
    {
        Employee employee = manageEmpTableTv.getSelectionModel().getSelectedItem();
        employee.setEmpLastName(employeeStringCellEditEvent.getNewValue());
    }

    public void onEditEmpNum(TableColumn.CellEditEvent<Employee, String> employeeStringCellEditEvent)
    {
        Employee employee = manageEmpTableTv.getSelectionModel().getSelectedItem();
        employee.setEmpNumber(employeeStringCellEditEvent.getNewValue());
    }
}