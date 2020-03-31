package Model;

import DB.*;

public class SModelG implements ISModelG{
    private IEmpCheckDAO empcheck;
    private IGuestCheckDAO guestCheckDAO;
    private IPublicDAO publicDAO;


    public SModelG(){
        empcheck = new EmpCheckDAO();
        guestCheckDAO = new GuestCheckDAO();
        publicDAO = new PublicDAO();

    }
    @Override
    public String empCheckIn(String empNo) {
        return empcheck.empCheckIn(empNo);
    }

    @Override
    public String empCheckOut(String empNo) {
        return empcheck.empCheckOut(empNo);
    }

    @Override
    public String guestCheckIn(String resNo) {
        return guestCheckDAO.guestCheckIn(resNo);
    }

    @Override
    public String guestCheckOut(String resNo) {
        return guestCheckDAO.guestCheckOut(resNo);
    }

    @Override
    public String publicUserIn(String licencePlate) {
        return publicDAO.PublicCheckIn(licencePlate);
    }

    @Override
    public String publicUserOut(String licencePlate) {
        return publicDAO.PublicCheckOut(licencePlate);
    }


}
