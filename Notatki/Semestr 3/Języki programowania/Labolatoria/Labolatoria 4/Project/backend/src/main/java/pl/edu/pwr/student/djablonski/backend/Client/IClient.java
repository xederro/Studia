package pl.edu.pwr.student.djablonski.backend.Client;

import pl.edu.pwr.student.djablonski.backend.Data.AQIndex;
import pl.edu.pwr.student.djablonski.backend.Data.Sensor;
import pl.edu.pwr.student.djablonski.backend.Data.SensorData;
import pl.edu.pwr.student.djablonski.backend.Data.Station;

public interface IClient {
    public Station[] getAllStations();
    public AQIndex getAQIndexOfId(Integer id);
    public Sensor[] getSensorsById(Integer id);
    public SensorData getSensorDataById(Integer id);
}
