package Controller;

import model.Employee;
import serverinterface.IServer;

public class MCController implements IMCController {
    private IServer serverInterface;

    public MCController(IServer serverInterface) {
        this.serverInterface = serverInterface;
    }

    public void addEmployee(Employee employee) {

    }
}
