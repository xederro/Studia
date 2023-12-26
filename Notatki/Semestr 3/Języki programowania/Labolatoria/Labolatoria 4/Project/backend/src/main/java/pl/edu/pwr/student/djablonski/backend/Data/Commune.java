package pl.edu.pwr.student.djablonski.backend.Data;
//          "communeName":"Wrocław",
//          "districtName":"Wrocław",
//          "provinceName":"DOLNOŚLĄSKIE"
public record Commune(String communeName, String districtName, String provinceName) {
    @Override
    public String toString() {
        return communeName + ", " + districtName + ", " + provinceName;
    }
}
