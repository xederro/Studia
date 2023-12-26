package pl.edu.pwr.student.djablonski.frontend.StationCell;

import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import pl.edu.pwr.student.djablonski.backend.Data.Station;


public class StationCellFactory implements Callback<ListView<Station>, ListCell<Station>> {

    public StationCellFactory() {
        super();
    }

    @Override
    public StationCell call(ListView<Station> param) {
        return new StationCell();
    }
}
