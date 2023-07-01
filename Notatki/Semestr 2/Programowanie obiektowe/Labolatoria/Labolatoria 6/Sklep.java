package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class Sklep {
    public static void main(String[] args) {
        // obiekty stworzone "osobno"
        Warzywa itemBlad = new Warzywa(); //konstruktor domyślny
        Warzywa itemPomidor = new Warzywa("Pomidor", .5f,4, "2012-12-12"); // konstruktor z parametrami
        Warzywa itemPomidorGalazka = new Warzywa(itemPomidor);// konstruktor kopiujacy

        // uzycie tablicy
        Warzywa []tab = new Warzywa[3];
//        for (int i = 0; i < tab.length; i++) {
//            tab[i].showFields(); //null pointer exception
//        }
        // co sie stanie gdy sprobujesz wypisac elementy od razu po tutaj, po zdefiniowaniu tablicy?
        Arrays.fill(tab, new Warzywa()); // uzupełnienie tab za pomoca metody fill // to kopie tego samego


        // uzycie kolekcji
        ArrayList<Warzywa> list = new ArrayList<Warzywa>();
        list.add(new Warzywa("Pomidor1", .54f,1, "2012-12-12")); // uzupełnienie kolekcji o obiekt stworzony za pomoca konstruktora domyślnego
        list.add(new Warzywa("Pomidor2", .55f,2, "2012-12-12")); // uzupełnienie kolekcji o obiekt stworzony za pomoca konstruktora z parametrami
        list.add(new Warzywa("Pomidor3", .56f,3, "2012-12-12")); // uzupełnienie kolekcji o obiekt stworzony za pomoca konstruktora kopiujacego

        itemBlad.showFields();
        System.out.println("ID: " + itemBlad.getStaticCount());
        itemPomidor.showFields();
        System.out.println("ID: " + itemPomidor.getStaticCount());
        itemPomidorGalazka.showFields();
        System.out.println("ID: " + itemPomidorGalazka.getStaticCount());

        for (int i = 0; i < tab.length; i++) {
            tab[i].showFields();
            System.out.println("ID: " + tab[i].getStaticCount());
        }

        for (int i = 0; i < list.size(); i++) {
            list.get(i).showFields();
            System.out.println("ID: " + list.get(i).getStaticCount());
        }
    }
}
