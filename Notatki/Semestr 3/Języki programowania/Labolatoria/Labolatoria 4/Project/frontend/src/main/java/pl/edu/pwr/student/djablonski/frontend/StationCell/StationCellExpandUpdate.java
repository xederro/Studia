package pl.edu.pwr.student.djablonski.frontend.StationCell;

import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import pl.edu.pwr.student.djablonski.backend.Data.AQIndex;
import pl.edu.pwr.student.djablonski.backend.Data.Sensor;
import pl.edu.pwr.student.djablonski.backend.Data.Station;
import pl.edu.pwr.student.djablonski.frontend.Main;

public class StationCellExpandUpdate extends Thread {
    private Integer id;
    private Button so2;
    private Button no2;
    private Button pm10;
    private Button pm25;
    private Button o3;
    public StationCellExpandUpdate(Integer id, Button so2, Button no2, Button pm10, Button pm25, Button o3) {
        this.id = id;
        this.so2 = so2;
        this.no2 = no2;
        this.pm10 = pm10;
        this.pm25 = pm25;
        this.o3 = o3;
    }

    @Override
    public void run() {
        so2.setDisable(true);
        no2.setDisable(true);
        pm10.setDisable(true);
        pm25.setDisable(true);
        o3.setDisable(true);
        Sensor[] s = Main.client.getSensorsById(id);
        for (int i = s.length-1; i >= 0; i--) {
            switch (s[i].param().paramCode()){
                case "SO2" -> {
                    so2.setDisable(false);
                    so2.setOnMouseClicked(new CellButtonEvent(s[i].id(), s[i].param().paramCode()));
                }
                case "NO2" -> {
                    no2.setDisable(false);
                    no2.setOnMouseClicked(new CellButtonEvent(s[i].id(), s[i].param().paramCode()));
                }
                case "PM10" -> {
                    pm10.setDisable(false);
                    pm10.setOnMouseClicked(new CellButtonEvent(s[i].id(), s[i].param().paramCode()));
                }
                case "PM25" -> {
                    pm25.setDisable(false);
                    pm25.setOnMouseClicked(new CellButtonEvent(s[i].id(), s[i].param().paramCode()));
                }
                case "O3" -> {
                    o3.setDisable(false);
                    o3.setOnMouseClicked(new CellButtonEvent(s[i].id(), s[i].param().paramCode()));
                }
            }
        }
    }
}
