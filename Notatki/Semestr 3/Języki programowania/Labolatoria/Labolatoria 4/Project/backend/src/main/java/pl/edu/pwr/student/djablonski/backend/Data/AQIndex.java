package pl.edu.pwr.student.djablonski.backend.Data;

//{
//  "id":114,
//  "stCalcDate":"2023-11-22 23:20:13",
//  "stIndexLevel":{
//      "id":-1,
//      "indexLevelName":"Brak indeksu"
//  },
//  "stSourceDataDate":"2023-11-22 23:00:00",
//  "so2CalcDate":null,
//  "so2IndexLevel":null,
//  "so2SourceDataDate":null,
//  "no2CalcDate":"2023-11-22 23:20:13",
//  "no2IndexLevel":{
//      "id":0,
//      "indexLevelName":"Bardzo dobry"
//  },
//  "no2SourceDataDate":"2023-11-22 23:00:00",
//  "pm10CalcDate":null,
//  "pm10IndexLevel":null,
//  "pm10SourceDataDate":null,
//  "pm25CalcDate":null,
//  "pm25IndexLevel":null,
//  "pm25SourceDataDate":null,
//  "o3CalcDate":"2023-11-22 23:20:13",
//  "o3IndexLevel":{
//      "id":0,
//      "indexLevelName":"Bardzo dobry"
//  },
//  "o3SourceDataDate":"2023-11-22 23:00:00",
//  "stIndexStatus":false,
//  "stIndexCrParam":"PYL"
//  }


import java.time.LocalDateTime;

public record AQIndex(
        Integer id,
        LocalDateTime stCalcDate,
        IndexLevel stIndexLevel,
        LocalDateTime stSourceDataDate,
        LocalDateTime so2CalcDate,
        IndexLevel so2IndexLevel,
        LocalDateTime so2SourceDataDate,
        LocalDateTime no2CalcDate,
        IndexLevel no2IndexLevel,
        LocalDateTime no2SourceDataDate,
        LocalDateTime pm10CalcDate,
        IndexLevel pm10IndexLevel,
        LocalDateTime pm10SourceDataDate,
        LocalDateTime pm25CalcDate,
        IndexLevel pm25IndexLevel,
        LocalDateTime pm25SourceDataDate,
        LocalDateTime o3CalcDate,
        IndexLevel o3IndexLevel,
        LocalDateTime o3SourceDataDate
) {
}
