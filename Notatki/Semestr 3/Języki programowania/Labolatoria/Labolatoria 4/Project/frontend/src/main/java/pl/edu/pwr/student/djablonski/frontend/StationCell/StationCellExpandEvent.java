package pl.edu.pwr.student.djablonski.frontend.StationCell;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventType;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import pl.edu.pwr.student.djablonski.backend.Data.Sensor;
import pl.edu.pwr.student.djablonski.frontend.GUI.FXController;
import pl.edu.pwr.student.djablonski.frontend.Main;

public class StationCellExpandEvent implements ChangeListener<Boolean> {

    private Integer id;
    private Button so2;
    private Button no2;
    private Button pm10;
    private Button pm25;
    private Button o3;

    public StationCellExpandEvent(Integer id, Button so2, Button no2, Button pm10, Button pm25, Button o3){
        this.id = id;
        this.so2 = so2;
        this.no2 = no2;
        this.pm10 = pm10;
        this.pm25 = pm25;
        this.o3 = o3;
    }

    @Override
    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
        if(newValue){
            new StationCellExpandUpdate(id, so2, no2, pm10, pm25, o3).start();
        }
    }
}
