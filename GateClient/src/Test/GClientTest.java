package Test;

import GateClient.GClient;
import GateClient.IGClient;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import static org.junit.jupiter.api.Assertions.*;

class GClientTest {
    String empNo;
    @org.junit.jupiter.api.BeforeEach

    void setUp() {

        try {
            IGClient g = new GClient();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }


    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {

    }

    @org.junit.jupiter.api.Test
    void empCheckIn() {
        empNo.equals("E1234");

    }
}