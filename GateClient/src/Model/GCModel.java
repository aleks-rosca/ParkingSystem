package Model;

import GateClient.IGClient;

public class GCModel implements IGCModel {
    private IGClient gClient;


    public GCModel(IGClient gc) {
        gClient = gc;

    }

    @Override

    public String empCheckIn(String empNo) {
        System.out.println(gClient.empCheckIn(empNo));
        return gClient.empCheckIn(empNo);

    }


}
