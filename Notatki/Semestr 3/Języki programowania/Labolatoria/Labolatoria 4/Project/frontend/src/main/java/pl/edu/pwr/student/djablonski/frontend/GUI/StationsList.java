package pl.edu.pwr.student.djablonski.frontend.GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class StationsList extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StationsList.class.getResource("StationsList.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 710, 625);
        stage.setTitle("Jakość Powietrza");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}