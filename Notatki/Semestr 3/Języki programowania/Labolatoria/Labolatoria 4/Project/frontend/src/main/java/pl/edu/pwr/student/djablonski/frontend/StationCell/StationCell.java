package pl.edu.pwr.student.djablonski.frontend.StationCell;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import pl.edu.pwr.student.djablonski.backend.Data.Sensor;
import pl.edu.pwr.student.djablonski.backend.Data.Station;
import pl.edu.pwr.student.djablonski.frontend.Main;

import java.io.IOException;
import java.util.Objects;

public class StationCell extends ListCell<Station> {
    private Parent itemRoot;
    @FXML
    TitledPane titledPane;
    @FXML
    Button so2;
    @FXML
    Button no2;
    @FXML
    Button pm10;
    @FXML
    Button pm25;
    @FXML
    Button o3;

    @Override
    public void updateItem(Station station, boolean empty) {
        super.updateItem(station, empty);
        if (empty || station == null) {
            setText(null);
            setGraphic(null);
        } else {
            if (itemRoot == null){
                try {
                    itemRoot = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(("StationCell.fxml"))));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                titledPane = (TitledPane) itemRoot.lookup("#titledPane");
                so2 = (Button) titledPane.getContent().lookup("#so2");
                no2 = (Button) titledPane.getContent().lookup("#no2");
                pm10 = (Button) titledPane.getContent().lookup("#pm10");
                pm25 = (Button) titledPane.getContent().lookup("#pm25");
                o3 = (Button) titledPane.getContent().lookup("#o3");
            }
            setGraphic(itemRoot);
            titledPane.setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            Label s = new StationCellTitle(station, empty);
            titledPane.setGraphic(s);

            if (!isVisible()) {
                titledPane.setExpanded(false);
            }

            titledPane.expandedProperty().addListener(new StationCellExpandEvent(station.id(),so2,no2,pm10,pm25,o3));
        }
    }
}
