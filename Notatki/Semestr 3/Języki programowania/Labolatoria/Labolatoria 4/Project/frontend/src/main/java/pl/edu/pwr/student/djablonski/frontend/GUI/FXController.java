package pl.edu.pwr.student.djablonski.frontend.GUI;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import pl.edu.pwr.student.djablonski.backend.Data.City;
import pl.edu.pwr.student.djablonski.backend.Data.Commune;
import pl.edu.pwr.student.djablonski.backend.Data.Station;
import pl.edu.pwr.student.djablonski.frontend.Main;
import pl.edu.pwr.student.djablonski.frontend.StationCell.CellButtonEvent;
import pl.edu.pwr.student.djablonski.frontend.StationCell.StationCellFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class FXController implements Initializable {
    @FXML
    VBox mainPane;

    @FXML
    ListView<Station> stationsList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        CellButtonEvent.setMainFrame(this.mainPane);
        stationsList.setCellFactory(new StationCellFactory());
        stationsList.getItems().addAll(Main.client.getAllStations());
    }
}