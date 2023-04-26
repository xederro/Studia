package org.example.cz1;

public class Ksiegowy extends Pracownik {
    public Ksiegowy(String imie, String nazwisko, Float pensja) {
        super(imie, nazwisko, pensja);
    }
    @Override
    public Float wyplata() {
        return super.getPensja()*1.1f*83/100;
    }
}
