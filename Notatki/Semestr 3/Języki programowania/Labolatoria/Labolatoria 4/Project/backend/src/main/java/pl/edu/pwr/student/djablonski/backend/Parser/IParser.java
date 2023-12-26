package pl.edu.pwr.student.djablonski.backend.Parser;

import pl.edu.pwr.student.djablonski.backend.Data.AQIndex;
import pl.edu.pwr.student.djablonski.backend.Data.SensorData;
import pl.edu.pwr.student.djablonski.backend.Data.Sensor;
import pl.edu.pwr.student.djablonski.backend.Data.Station;

public interface IParser {
    public Station[] parseStations(String json);
    public AQIndex parseAQIndex(String json);
    public Sensor[] parseSensors(String json);
    public SensorData parseSensorData(String json);
}
