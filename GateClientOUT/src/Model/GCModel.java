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
    }

    @Override
    public String checkClient(String check) {
        if(check.charAt(0)=='G'){
            return "guest";
        }else if(check.charAt(0)=='E'){
            return "employee";
        }else{
            return "dunno who are you";
        }
    }


}
