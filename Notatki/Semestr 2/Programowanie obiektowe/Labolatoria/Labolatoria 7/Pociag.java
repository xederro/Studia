package org.example.cz2;

public class Pociag extends AbstractTransport {
    public Pociag(Float wynagrodzenie, Float odleglosc) {
        super(wynagrodzenie, odleglosc);
    }

    public Float getZysk() {
        return wynagrodzenie - odleglosc / 20;
    }

    @Override
    public String toString () {
        return "Pociag - odległość: " + odleglosc + ", wynagrodzenie: " + wynagrodzenie + ", zysk: " + getZysk();
    }
}
