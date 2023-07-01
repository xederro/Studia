package org.example.cz2;

public class Samolot extends AbstractTransport {
    public Samolot(Float wynagrodzenie, Float odleglosc) {
        super(wynagrodzenie, odleglosc);
    }

    @Override
    public Float getZysk() {
        return super.wynagrodzenie - super.odleglosc * odleglosc / 100;
    }

    @Override
    public String toString () {
        return "Samolot - odległość: " + odleglosc + ", wynagrodzenie: " + wynagrodzenie + ", zysk: " + getZysk();
    }
}
