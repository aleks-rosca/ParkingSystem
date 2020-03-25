package Model;

import javafx.collections.ObservableList;
import model.Status;

public interface IMCPModel {
    ObservableList<Status> getAllStatues();
    int getOccupiedSpots();
}
