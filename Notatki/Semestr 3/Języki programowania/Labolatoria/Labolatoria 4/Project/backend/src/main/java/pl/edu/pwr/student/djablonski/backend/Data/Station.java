package pl.edu.pwr.student.djablonski.backend.Data;
//  {
//    "id":114,
//    "stationName":"Wrocław, ul. Bartnicza",
//    "gegrLat":"51.115933",
//    "gegrLon":"17.141125",
//    "city":{
//
//    },
//    "addressStreet":"ul. Bartnicza"
//  }

public record Station(Integer id, String stationName, Float gegrLat, Float gegrLon, City city, String addressStreet) {
}
