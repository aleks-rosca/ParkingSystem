package Controller;

        import javafx.event.ActionEvent;
        import javafx.fxml.Initializable;
        import javafx.scene.control.*;
        import javafx.scene.layout.TilePane;

        import java.net.URL;
        import java.util.ResourceBundle;

public class EController implements Initializable {

    public DatePicker choosedate;
    public TextField empNo;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void ECAction(ActionEvent actionEvent) {

    }

    public void addReservation(ActionEvent actionEvent){
      if(empNo.getText().length()==5){
          // create a tile pane
          TilePane r = new TilePane();
          // create a alert
          Alert a1 = new Alert(Alert.AlertType.INFORMATION, "Employee No. is not valid ", ButtonType.OK);
          // show the dialog
          a1.show();
          empNo.clear();
      }
    }
}
