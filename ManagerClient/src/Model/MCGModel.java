package Model;

import ManagerClient.IManagerClient;
import model.GuestRes;

public class MCGModel implements IMCGModel{

    private IManagerClient cl;
    private GuestRes guestRes;

    public MCGModel(IManagerClient client){
        client = cl;
    }

    @Override
    public String addGuestRes(String name, String purpose, String date) {
        guestRes = new GuestRes(name, purpose, date);
        return cl.addGuestRes(guestRes);
    }
}
