package Controller;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Employee;
import serverinterface.IServer;

import java.net.URL;
import java.util.ResourceBundle;


public class MCController implements IMCController, Initializable {
    public TextField empNameSearchTf;
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

}
