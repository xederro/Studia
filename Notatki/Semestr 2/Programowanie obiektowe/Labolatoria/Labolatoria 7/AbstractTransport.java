package org.example.cz2;

public abstract class AbstractTransport implements Transport{
    Float wynagrodzenie;
    Float odleglosc;
    public AbstractTransport (Float wynagrodzenie, Float odleglosc) {
        this.wynagrodzenie = wynagrodzenie;
        this.odleglosc = odleglosc;
    }

    @Override
    public abstract Float getZysk();
}
