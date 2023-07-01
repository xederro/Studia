package org.example;

public class Warzywa {
    private String name;
    private Float price;
    private Integer count;

    private static int countStatic_ = 0;
    //    public int countNonStatic_ = 0;

    //    public static int idStatic_ = 0;
    private int idNonStatic_ = 0;

    private DataPrzydatnosci dataPrzydatnosci;


    public Warzywa(String name, Float price, Integer count, String dataPrzydatnosci) {
        this.name = name;
        this.price = price;
        this.count = count;

        countStatic_++;
//        countNonStatic_++;

//        idStatic_++;
        idNonStatic_ = countStatic_;

        this.dataPrzydatnosci = new DataPrzydatnosci(dataPrzydatnosci);

        log("Good");
    }
    public Warzywa(Warzywa warzywa) {
        this.name = warzywa.name;
        this.price = warzywa.price;
        this.count = warzywa.count;

        this.dataPrzydatnosci = new DataPrzydatnosci(warzywa.dataPrzydatnosci.getDate().toString());

        countStatic_++;
//        countNonStatic_++;

//        idStatic_++;
        idNonStatic_ = countStatic_;

        log("Copy");
    }
    public Warzywa() {
        this.name = "ERROR";
        this.price = -1.0f;
        this.count = -1;

        this.dataPrzydatnosci = new DataPrzydatnosci("1970-01-01");

        countStatic_++;
//        countNonStatic_++;

//        idStatic_++;
        idNonStatic_ = countStatic_;

        log("Bad");
    }

    public void showFields() {
        System.out.println("Name: " + this.name);
        System.out.println("Price: " + this.price);
        System.out.println("Count: " + this.count);
        System.out.println("CountStatic: " + countStatic_);
//        System.out.println("CountNonStatic: " + countNonStatic_);
//        System.out.println("IdStatic: " + idStatic_);
        System.out.println("IdNonStatic: " + idNonStatic_);
        System.out.println("DataPrzydatnosci: " + this.getDataPrzydatnosci());
    }

    public Integer getStaticCount() {
        return countStatic_;
    }

    private String getDataPrzydatnosci() {
        return dataPrzydatnosci.getDate().toString();
    }

    private void log (String type) {
        System.out.println("Used: " + type);
    }
}
