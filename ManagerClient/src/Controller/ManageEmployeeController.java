package Controller;

import Model.IMCEModel;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.Optional;

public class ManageEmployeeController {
    public TextField empFirstNameAddTf;
    public TextField empLastNameAddTf;
    public TextField empNameSearchTf;
    public TextField empNumberAddTf;
    public IMCEModel mceModel;


    public void init(IMCEModel mceModel) {
        this.mceModel = mceModel;
    }


    public void AddEmp(ActionEvent actionEvent) throws IOException {
        //TODO add a try catch to see if the name and number exist already\

        if(mceModel.checkFirstChar(empNumberAddTf.getText())){

            if(mceModel.createEmp(mceModel.rearrangeChars(empFirstNameAddTf.getText()), empNumberAddTf.getText()).equals("Employee added")){
                Alert a1 = new Alert(Alert.AlertType.INFORMATION, "Employee " + empFirstNameAddTf.getText() + " has been added!", ButtonType.OK);
                a1.show();
                empFirstNameAddTf.clear();
                empNumberAddTf.clear();
            } else if(mceModel.createEmp(empFirstNameAddTf.getText(), empNumberAddTf.getText()).equals("Duplicate key")) {
                Alert a1 = new Alert(Alert.AlertType.INFORMATION, "Employee " + empFirstNameAddTf.getText() + " already exists!", ButtonType.OK);
                a1.show();
            }else {
                Alert a1 = new Alert(Alert.AlertType.INFORMATION, "Error 404", ButtonType.OK);
                a1.show();
            }
        }else {
            Alert a1 = new Alert(Alert.AlertType.INFORMATION, "Employee number should start from E ", ButtonType.OK);
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
}
