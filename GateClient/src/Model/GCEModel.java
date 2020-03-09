package Model;

import GateClient.IGClient;

public class GCEModel implements IGCEmodel {
    private IGClient gClient;


    public GCEModel(IGClient gc) {
        gClient = gc;

    }

    @Override

    public String empCheckIn(String empNo) {

        return gClient.empCheckIn(empNo);
    }
}
