package pl.edu.pwr.student.djablonski.frontend.Graph;

import javafx.event.EventHandler;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class GraphButtonEvent implements EventHandler<MouseEvent> {
    private static VBox mainFrame;
    private static ListView replacedFrame;

    public GraphButtonEvent() {

    }

    public static void setMainFrame(VBox mainFrame){
        GraphButtonEvent.mainFrame = mainFrame;
    }
    public static void setReplacedFrame(ListView replacedFrame){
        GraphButtonEvent.replacedFrame = replacedFrame;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        mainFrame.getChildren().set(0, replacedFrame);
    }
}
