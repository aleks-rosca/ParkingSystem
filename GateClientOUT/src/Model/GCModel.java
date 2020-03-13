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


}
