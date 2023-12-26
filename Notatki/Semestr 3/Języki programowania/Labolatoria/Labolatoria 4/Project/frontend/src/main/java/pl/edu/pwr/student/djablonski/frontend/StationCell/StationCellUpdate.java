package pl.edu.pwr.student.djablonski.frontend.StationCell;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import pl.edu.pwr.student.djablonski.backend.Data.AQIndex;
import pl.edu.pwr.student.djablonski.backend.Data.Station;
import pl.edu.pwr.student.djablonski.frontend.Main;

public class StationCellUpdate extends Thread {
    private Station station;
    private Rectangle st;
    private Rectangle so2;
    private Rectangle no2;
    private Rectangle pm10;
    private Rectangle pm25;
    private Rectangle o3;
    public StationCellUpdate(Station station, Rectangle st, Rectangle so2, Rectangle no2, Rectangle pm10, Rectangle pm25, Rectangle o3) {
        this.station = station;
        this.st = st;
        this.so2 = so2;
        this.no2 = no2;
        this.pm10 = pm10;
        this.pm25 = pm25;
        this.o3 = o3;
    }

    @Override
    public void run() {
        AQIndex airQuality = Main.client.getAQIndexOfId(station.id());
        try {
            st.setFill(matchColour(airQuality.stIndexLevel().id()));
        } catch (NullPointerException ignore) {

        }
        try {
            so2.setFill(matchColour(airQuality.so2IndexLevel().id()));
        } catch (NullPointerException ignore) {

        }
        try {
            no2.setFill(matchColour(airQuality.no2IndexLevel().id()));
        } catch (NullPointerException ignore) {

        }
        try {
            pm10.setFill(matchColour(airQuality.pm10IndexLevel().id()));
        } catch (NullPointerException ignore) {

        }
        try {
            pm25.setFill(matchColour(airQuality.pm25IndexLevel().id()));
        } catch (NullPointerException ignore) {

        }
        try {
            o3.setFill(matchColour(airQuality.o3IndexLevel().id()));
        } catch (NullPointerException ignore) {

        }
    }

    private Paint matchColour(Integer i){
        return switch (i) {
            case 0 -> Color.GREEN;
            case 1 -> Color.GREENYELLOW;
            case 2 -> Color.YELLOW;
            case 3 -> Color.ORANGE;
            case 4 -> Color.RED;
            case 5 -> Color.DARKVIOLET;
            default -> Color.GAINSBORO;
        };
    }
}
