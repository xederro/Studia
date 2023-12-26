package pl.edu.pwr.student.djablonski.backend.Data;
//[
//  {
//      "id":642,
//      "stationId":114,
//      "param":{
//          "paramName":"dwutlenek azotu",
//          "paramFormula":"NO2",
//          "paramCode":"NO2",
//          "idParam":6
//      }
//  },
//  {
//      "id":644,
//      "stationId":114,
//      "param":{
//          "paramName":"ozon",
//          "paramFormula":"O3",
//          "paramCode":"O3",
//          "idParam":5
//      }
//  }
//]
public record Sensor(Integer id, Integer stationId, Param param) {
}
