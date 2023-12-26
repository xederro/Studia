package pl.edu.pwr.student.djablonski.backend.Parser;

import com.google.gson.*;
import pl.edu.pwr.student.djablonski.backend.Data.AQIndex;
import pl.edu.pwr.student.djablonski.backend.Data.Sensor;
import pl.edu.pwr.student.djablonski.backend.Data.SensorData;
import pl.edu.pwr.student.djablonski.backend.Data.Station;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Parser implements IParser {
    private final Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, (JsonDeserializer<LocalDateTime>) (jsonElement, type, jsonDeserializationContext) -> {
        String date = jsonElement.getAsJsonPrimitive().getAsString();
        return LocalDateTime.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }).create();

    @Override
    public Station[] parseStations(String json){
        return gson.fromJson(json, Station[].class);
    }

    @Override
    public AQIndex parseAQIndex(String json){
        return gson.fromJson(json, AQIndex.class);
    }

    @Override
    public Sensor[] parseSensors(String json){
        return gson.fromJson(json, Sensor[].class);
    }

    @Override
    public SensorData parseSensorData(String json) {
        return gson.fromJson(json, SensorData.class);
    }
}
