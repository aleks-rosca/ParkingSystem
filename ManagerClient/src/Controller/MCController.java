package Controller;

import ManagerClient.Client;
import ManagerClient.IClient;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;
import model.Employee;
import model.EmployeeRes;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;


public class MCController implements Initializable {
    public TextField empNameSearchTf;
    public TextField empNameAddTf;
    public TextField empNumberAddTf;
    public ListView selectEmployee;
    public Button empShowAllBtn;
    public Button empSearchBtn;
    private Employee employee;
    private EmployeeRes empRes;
    private IClient clientinterface;

    public MCController() throws RemoteException, NotBoundException, MalformedURLException {
        employee = new Employee();
        empRes = new EmployeeRes();
        clientinterface = new Client();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void AddEmp(ActionEvent event) throws IOException {
        //TODO add a try catch to see if the name and number exist already\
        employee.setEmpName(empNameAddTf.getText());
        employee.setEmpNumber(empNumberAddTf.getText());
        if (clientinterface.addEmployee(employee)) {
            Alert a1 = new Alert(Alert.AlertType.INFORMATION, "Employee " + empNameAddTf.getText() + " has been added", ButtonType.OK);
            a1.show();
            empNameAddTf.clear();
            empNumberAddTf.clear();
        } else {

            Alert a1 = new Alert(Alert.AlertType.ERROR, "Employee " + empNameAddTf.getText() + " already exists with " + empNumberAddTf.getText(), ButtonType.OK);

            a1.show();
            empNameAddTf.clear();
            empNumberAddTf.clear();

        }


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
                empNameAddTf.setText(change);
                empNameSearchTf.clear();


            } else {
                System.out.println("No pressed");
            }

        }
    }

    public void selectEmployee(MouseEvent mouseEvent) {


    }
}
