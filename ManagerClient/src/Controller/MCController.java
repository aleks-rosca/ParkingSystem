package Controller;

import Model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.TilePane;
import serverinterface.IServer;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;


public class MCController implements Initializable {
    public TextField empNameSearchTf;
    public TextField empNameAddTf;
    public TextField empNumberAddTf;
    public ListView selectEmployee;
    public Button empShowAllBtn;
    public Button empSearchBtn;
    private IServer serverInterface;
    private Model model;

    public MCController() {
        model = new Model();


    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public void AddEmp(ActionEvent event) throws IOException {
        //TODO add a try catch to see if the name and number exist already\
        model.setNameEmp(empNameAddTf.getText());
        model.setNumEmp(empNumberAddTf.getText());
        System.out.println(model.getNameEmp() + model.getNumEmp());



//        try {
//            // create a tile pane
//            TilePane r = new TilePane();
//            // create a alert
//            Alert a1 = new Alert(Alert.AlertType.INFORMATION, "Employee " + empNameAddTf.getText() + " has been added", ButtonType.OK);
//            // show the dialog
//            a1.show();
//            empNameAddTf.clear();
//            empNumberAddTf.clear();
//
//
//        } catch (Exception e) {
//            TilePane r = new TilePane();
//            // create a alert
//            Alert a1 = new Alert(Alert.AlertType.ERROR, "Employee " + empNameAddTf.getText() + " already exists with " + empNumberAddTf.getText(), ButtonType.OK);
//            // show the dialog
//            a1.show();
//            empNameAddTf.clear();
//            empNumberAddTf.clear();
//            e.printStackTrace();

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
