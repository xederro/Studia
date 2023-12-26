package pl.edu.pwr.student.djablonski.frontend.StationCell;

import javafx.event.EventHandler;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import pl.edu.pwr.student.djablonski.frontend.Graph.GraphButtonEvent;
import pl.edu.pwr.student.djablonski.frontend.Graph.GraphFactory;

public class CellButtonEvent implements EventHandler<MouseEvent> {
    private static VBox mainFrame;
    private Integer id;
    private String name;
    public CellButtonEvent(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public static void setMainFrame(VBox mainFrame){
        CellButtonEvent.mainFrame = mainFrame;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        GraphButtonEvent.setReplacedFrame((ListView) mainFrame.getChildren().get(0));
        GraphButtonEvent.setMainFrame(mainFrame);
        mainFrame.getChildren().set(0, GraphFactory.create(id, name));
    }
}
