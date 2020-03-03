package Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import model.Employee;
import serverinterface.IServer;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class MCController implements IMCController, Initializable {
    public TextField empNameSearchTf;
    public TextField empNameAddTf;
    public Button empShowAllBtn;
    public Button empSearchBtn;
    private IServer serverInterface;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public MCController(){

    }

    public MCController(IServer serverInterface) {
        this.serverInterface = serverInterface;
    }

    public void addEmployee(Employee employee) {

    }

    public void AddEmp(ActionEvent event) throws IOException
    {
        //TODO add a try catch to see if the name and number exist already

        // create a tile pane
        TilePane r = new TilePane();
        // create a alert
        Alert a1 = new Alert(Alert.AlertType.NONE, "Employee "+ empNameAddTf.getText() + " has been added", ButtonType.OK);
        // show the dialog
        a1.show();

     /*   Parent AddWindowParent = FXMLLoader.load(getClass().getResource("/view/AddWindow.fxml"));
        Scene AddWindowScene = new Scene(AddWindowParent , 300, 250);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(AddWindowScene);
        stage.show(); */
    }
}
