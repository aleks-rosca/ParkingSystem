package Controller;

import Model.IGCEmodel;

public class GController {

    EmployeeCheckInController employeeCheckInController;

    public void init(IGCEmodel model){
        employeeCheckInController.init(model);

    }
}
