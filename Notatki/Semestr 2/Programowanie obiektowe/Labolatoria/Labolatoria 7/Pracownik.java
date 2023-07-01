package org.example.cz1;

public abstract class Pracownik {
    private String imie;
    private String nazwisko;
    private Float pensja;

    public Pracownik (String imie, String nazwisko, Float pensja){
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pensja = pensja;
    }
    public abstract Float wyplata();

    protected Float getPensja () {
        return pensja;
    }

    @Override
    public String toString() {
        return imie + " " + nazwisko + ": " + wyplata();
    }
}
