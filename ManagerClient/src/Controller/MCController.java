package Controller;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Employee;
import serverinterface.IServer;


public class MCController implements IMCController {
    public TextField empNameSearchTf;
    public Button empShowAllBtn;
    public Button empSearchBtn;
    private IServer serverInterface;

    public MCController(IServer serverInterface) {
        this.serverInterface = serverInterface;
    }

    public void addEmployee(Employee employee) {

    }

}
