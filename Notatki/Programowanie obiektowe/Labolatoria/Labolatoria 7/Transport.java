package org.example.cz2;

public class Transport {
    public static final byte SAMOLOT = 0;
    public static final byte POCIAG = 1;

    private byte typ;
    private Float wynagrodzenie;
    private Float odleglosc;

    public Transport (Float wynagrodzenie, Float odleglosc, byte typ) {
        this.typ = typ;
        this.wynagrodzenie = wynagrodzenie;
        this.odleglosc = odleglosc;
    }

    public Float getZysk() {
        switch (typ) {
            case SAMOLOT -> {
                return wynagrodzenie - odleglosc * odleglosc / 100;
            }

            case POCIAG -> {
                return wynagrodzenie - odleglosc / 20;
            }
        }

        return 0f;
    }

    public String toString() {
        switch (typ) {
            case SAMOLOT -> {
                return "Samolot - odległość: " + odleglosc + ", wynagrodzenie: " + wynagrodzenie + ", zysk: " + getZysk();
            }

            case POCIAG -> {
                return "Pociag - odległość: " + odleglosc + ", wynagrodzenie: " + wynagrodzenie + ", zysk: " + getZysk();
            }
        }

        return "Error";
    }
}
