package pl.edu.pwr.student.djablonski.frontend.StationCell;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import pl.edu.pwr.student.djablonski.backend.Data.Station;
import pl.edu.pwr.student.djablonski.frontend.GUI.StationsList;

import java.io.IOException;
import java.util.Objects;

public class StationCellTitle extends Label {
    private Parent itemRoot;

    @FXML
    Label title;
    @FXML
    Label detail;
    @FXML
    Rectangle st;
    @FXML
    Rectangle so2;
    @FXML
    Rectangle no2;
    @FXML
    Rectangle pm10;
    @FXML
    Rectangle pm25;
    @FXML
    Rectangle o3;

    public StationCellTitle(Station station, boolean empty) {
        super();
        if (empty || station == null) {
            setText(null);
            setGraphic(null);
        } else {
            try {
                itemRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(("StationCellTitle.fxml"))));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            title = (Label) itemRoot.lookup("#title");
            detail = (Label) itemRoot.lookup("#detail");
            st = (Rectangle) itemRoot.lookup("#st");
            so2 = (Rectangle) itemRoot.lookup("#so2");
            no2 = (Rectangle) itemRoot.lookup("#no2");
            pm10 = (Rectangle) itemRoot.lookup("#pm10");
            pm25 = (Rectangle) itemRoot.lookup("#pm25");
            o3 = (Rectangle) itemRoot.lookup("#o3");
            String label = station.city().name();
            if (station.addressStreet() != null) label += ": " + station.addressStreet();

            title.setText(label);
            detail.setText(station.city().commune().toString());
            if (isVisible()) {
                new StationCellUpdate(station,st,so2,no2,pm10,pm25,o3).start();
            }
            setGraphic(itemRoot);
        }
    }
}
