package pl.edu.pwr.student.djablonski.backend.Data;
//{
// "key":"NO2",
// "values":
//  [
//      {
//          "date":"2023-11-22 23:00:00",
//          "value":19.2884
//      },...
//  ]
//}
public record SensorData(String key, Value[] values) {
}
