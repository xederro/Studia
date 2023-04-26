package org.example.cz1;

public class Programista extends It {

    public Programista (String imie, String nazwisko, Float pensja, Integer przepracowaneLata) {
        super(imie, nazwisko, pensja, przepracowaneLata);
    }
    @Override
    public Float wyplata() {
        float dodatek;

        if (super.getPrzepracowaneLata() < 2) dodatek = 500.0f;
        else if (super.getPrzepracowaneLata() < 5) dodatek = 2000.0f;
        else dodatek = 5000.0f;

        return (float) ((super.getPensja()+dodatek)*91.5/100);
    }
}
