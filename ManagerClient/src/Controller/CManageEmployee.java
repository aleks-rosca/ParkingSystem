package Controller;

import Model.Model;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Optional;

public class CManageEmployee
{
    public TextField empNameSearchTf;
    public TextField empNameAddTf;
    public TextField empNumberAddTf;
    private Model model;

    public CManageEmployee() throws RemoteException, NotBoundException, MalformedURLException {
        model = new Model();
    }


    public void AddEmp(ActionEvent actionEvent) throws IOException
    {
        //TODO add a try catch to see if the name and number exist already\
        model.createEmp(empNameAddTf.getText(), empNumberAddTf.getText());
//        if (model.createEmp();)) {
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
        if (empNameSearchTf.getText().trim().isEmpty()) {
            // create a alert
            Alert a1 = new Alert(Alert.AlertType.ERROR, "Employee Search field is empty ", ButtonType.OK);
            a1.show();

        }
        else
            {
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
}
