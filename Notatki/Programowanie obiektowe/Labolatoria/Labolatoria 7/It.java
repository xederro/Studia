package org.example.cz1;

public class It extends Pracownik {
    private Integer przepracowaneLata;

    public It(String imie, String nazwisko, Float pensja, Integer przepracowaneLata) {
        super(imie, nazwisko, pensja);
        this.przepracowaneLata = przepracowaneLata;
    }

    @Override
    public Float wyplata() {
        float dodatek;

        if (przepracowaneLata < 2) dodatek = 500.0f;
        else if (przepracowaneLata < 5) dodatek = 2000.0f;
        else dodatek = 5000.0f;

        return (super.getPensja()+dodatek)*83/100;
    }

    protected Integer getPrzepracowaneLata () {
        return przepracowaneLata;
    }
}
