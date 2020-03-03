package Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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

    public void AddEmp(ActionEvent actionEvent)
    {
        Button btn = new Button();
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Parent root;
                try {
                    root = FXMLLoader.load(getClass().getClassLoader().getResource("MCClient.fxml"));
                    Stage stage = new Stage();
                    stage.setTitle("Employee Added");
                    stage.setScene(new Scene(root, 450, 450));
                    stage.show();
                    // Hide this current window (if this is what you want)
                    ((Node)(event.getSource())).getScene().getWindow().hide();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
