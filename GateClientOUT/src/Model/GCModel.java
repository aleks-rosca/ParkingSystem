package Model;

import GateClientOUT.IGClient;

public class GCModel implements IGCModel {
    private IGClient gClient;


    public GCModel(IGClient gc) {
        gClient = gc;

    }
    @Override

    public String empCheckOut(String empNo) {

        return gClient.empCheckOut(empNo);
    }

    @Override
    public String guestCheckOut(String resNo) {
        return gClient.guestCheckOut(resNo);
    } @Override

    public String publicCheckOut(String plate) {
        return gClient.publicCheckOut(plate);
    }

    @Override
    public String checkClient(String check) {
        if (check.length() == 7) {
            return "public";
        } else if (check.isEmpty()) {
            return "empty";
        } else if (check.charAt(0) == 'G') {
            return "guest";
        } else if (check.charAt(0) == 'E') {
            return "employee";
        } else {
            return "error";
        }
    }




}
