package pl.edu.pwr.student.djablonski.backend.Client;

import pl.edu.pwr.student.djablonski.backend.Data.AQIndex;
import pl.edu.pwr.student.djablonski.backend.Data.SensorData;
import pl.edu.pwr.student.djablonski.backend.Data.Sensor;
import pl.edu.pwr.student.djablonski.backend.Data.Station;
import pl.edu.pwr.student.djablonski.backend.Parser.IParser;
import pl.edu.pwr.student.djablonski.backend.Parser.Parser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Client implements IClient {
    private final IParser parser;
    private final HttpClient client = HttpClient.newBuilder().build();

    //Cache
    private Station[] stationCache = null;
    private final Map<Integer, AQIndex> AQCache = new HashMap<>();
    private final Map<Integer, Sensor[]> sensorsCache = new HashMap<>();


    public Client(Parser parser) {
        this.parser = parser;
    }

    public static void main(String[] args) {
        Client c = new Client(new Parser());
        System.out.println(Arrays.toString(c.getAllStations()));
        System.out.println(c.getAQIndexOfId(114));
        System.out.println(Arrays.toString(c.getSensorsById(114)));
        System.out.println(Arrays.toString(c.getSensorDataById(642).values()));
    }

    @Override
    public Station[] getAllStations() {
        if (stationCache == null || stationCache.length == 0) {
            stationCache = parser.parseStations(getBody("https://api.gios.gov.pl/pjp-api/rest/station/findAll"));
        }
        return stationCache;
    }


    @Override
    public AQIndex getAQIndexOfId(Integer id) {
        AQIndex aq = AQCache.get(id);
        if (aq != null && (
                aq.stCalcDate() != null ||
                aq.no2CalcDate() != null ||
                aq.so2CalcDate() != null ||
                aq.pm10CalcDate() != null ||
                aq.pm25CalcDate() != null ||
                aq.o3CalcDate() != null
            )
        ){
            LocalDateTime ldt = aq.stCalcDate() != null ? aq.stCalcDate() :
                    aq.no2CalcDate() != null ? aq.no2CalcDate() :
                    aq.so2CalcDate() != null ? aq.so2CalcDate() :
                    aq.pm10CalcDate() != null ? aq.pm10CalcDate() :
                    aq.pm25CalcDate() != null ? aq.pm25CalcDate() :
                    aq.o3CalcDate();
            if (
                    ldt.getMinute() >= LocalDateTime.now().minusMinutes(5).getMinute() ||
                    ldt.getMinute() <= LocalDateTime.now().getMinute()
            ) return aq;
        }
        aq = parser.parseAQIndex(getBody("https://api.gios.gov.pl/pjp-api/rest/aqindex/getIndex/" + id.toString()));
        AQCache.put(id, aq);
        return aq;
    }

    @Override
    public Sensor[] getSensorsById(Integer id) {
        Sensor[] sensors = sensorsCache.get(id);
        if (sensors == null || sensors.length == 0) {
            sensors = parser.parseSensors(getBody("https://api.gios.gov.pl/pjp-api/rest/station/sensors/" + id.toString()));
            sensorsCache.put(id, sensors);
        }
        return sensors;
    }

    @Override
    public SensorData getSensorDataById(Integer id) {
        return parser.parseSensorData(getBody("https://api.gios.gov.pl/pjp-api/rest/data/getData/" + id.toString()));
    }

    private String getBody(String url){
        try {
            HttpResponse<String> response = client
                    .send(
                            createRequest(url),
                            HttpResponse.BodyHandlers.ofString()
                    );

            return response.body();
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    private HttpRequest createRequest(String url){
        return HttpRequest
                .newBuilder()
                .GET()
                .headers("Content-Type", "application/json;charset=UTF-8")
                .uri(URI.create(url))
                .build();
    }
}
