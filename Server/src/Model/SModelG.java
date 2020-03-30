package Model;

import DB.*;
import model.Status;

import java.util.List;

public class SModelG implements ISModelG{
    private IEmpCheckDAO empcheck;
    private IGuestCheckDAO guestCheckDAO;
    private IPublicDAO publicDAO;
    private IStatusDAO statusDAO;

    public SModelG(){
        empcheck = new EmpCheckDAO();
        guestCheckDAO = new GuestCheckDAO();
        publicDAO = new PublicDAO();
        statusDAO = new StatusDAO();
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
    @Override
    public int getParkingStatus() {
        return statusDAO.getCurrentStatus();
    }

    @Override
    public List<Status> getAllStatuses() {
        return statusDAO.getAllStatuses();
    }

    @Override
    public int getNumberOfGuestsInParkingLot() {
        return statusDAO.getNumberOfGuestsInParkingLot();
    }

    @Override
    public int getNumberOfEmployeesInParkingLot() {
        return statusDAO.getNumberOfEmployeesInParkingLot();
    }

    @Override
    public int getNumberOfPublicUsersInParkingLot() {
        return statusDAO.getNumberOfPublicUsersInParkingLot();
    }

}
