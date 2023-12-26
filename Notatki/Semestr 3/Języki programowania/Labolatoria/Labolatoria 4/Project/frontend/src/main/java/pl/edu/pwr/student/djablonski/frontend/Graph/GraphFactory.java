package pl.edu.pwr.student.djablonski.frontend.Graph;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import pl.edu.pwr.student.djablonski.backend.Data.SensorData;
import pl.edu.pwr.student.djablonski.frontend.Main;

import java.io.IOException;
import java.time.ZoneId;
import java.util.Objects;

public class GraphFactory {
    public static Node create(Integer id, String name){
        AnchorPane itemRoot;
        try {
            itemRoot = FXMLLoader.load(Objects.requireNonNull(GraphFactory.class.getResource(("Graph.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        LineChart lineChart = (LineChart) itemRoot.lookup("#chart");

        lineChart.getXAxis().setLabel("Time");

        lineChart.setTitle(name);
        XYChart.Series series = new XYChart.Series();
        series.setName(name);

        SensorData sd = Main.client.getSensorDataById(id);

        for (int i = sd.values().length-1; i >= 0; i--) {
            if (sd.values()[i].date()==null || sd.values()[i].value() == null) continue;
            series.getData().add(new XYChart.Data(sd.values()[i].date().toString(), sd.values()[i].value()));
        }

        lineChart.getData().add(series);

        itemRoot.lookup("#button").setOnMouseClicked(new GraphButtonEvent());

        return itemRoot;
    }
}
