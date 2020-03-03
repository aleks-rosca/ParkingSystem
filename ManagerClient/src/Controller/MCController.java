package Controller;
import View.AddWindow;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Employee;
import serverinterface.IServer;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class MCController implements IMCController, Initializable {
    public TextField empNameSearchTf;
    public Button empShowAllBtn;
    public Button empSearchBtn;
    private IServer serverInterface;
    @FXML private Button addEmpBtn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public MCController(IServer serverInterface) {
        this.serverInterface = serverInterface;
    }

    public void addEmployee(Employee employee) {

    }

    public void AddEmp(ActionEvent event) throws IOException
    {
        Parent AddWindowParent = FXMLLoader.load(getClass().getResource("AddWindow.fxml"));
        Scene AddWindowScene = new Scene(AddWindowParent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(AddWindowScene);
        window.show();
    }
}
