package Model;

import GateClient.IGClient;


public class GCModel implements IGCModel {
    private IGClient gClient;

    public GCModel(IGClient gc) {
        gClient = gc;

    }

    @Override

    public String empCheckIn(String empNo) {
        return gClient.empCheckIn(empNo);
    }

    @Override
    public String guestCheckIn(String resNo) {
        return gClient.guestCheckin(resNo);
    }

    @Override
    public String publicUserIn(String licencePlate) {
        return gClient.publicUserIn(licencePlate);
    }



    @Override
    public String checkClient(String res) {
        if (res.length() == 7) {
            return "public";
        } else if (res.isEmpty()) {
            return "empty";
        } else if (res.charAt(0) == 'G') {
            return "guest";
        } else if (res.charAt(0) == 'E') {
            return "employee";
        } else {
            return "error";
        }
    }

    @Override
    public int getParkingStatus() {
        return 40 - gClient.getParkingStatus();
    }


}
