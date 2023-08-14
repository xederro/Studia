**1)  Przetwarzanie tekstów -  łańcuchów znaków  
**     (_tablica zawierająca przetwarzany tekst powinna być parametrem  
       wejściowo/wyjściowym pisanej funkcji_)

1.  Napisz program, który wczyta łańcuch znaków z klawiatury  
    a następnie usunie z tego łańcucha pierwszą małą literę.
    
2.  Napisz funkcję, która usunie wszystkie początkowe spacje  
    w łańcuchu tekst, który powinien być parametrem wejściowo/wyjściowym tej funkcji.
    
3.  Napisz funkcję formatującą tekst poprzez usunięcie  
    wszystkich początkowych i końcowych spacji  
    z łańcucha zadanego jako parametr wejściowy tej funkcji.
    
4.  Napisz funkcję usuwającą (poprzez skrócenie tekstu)  
    wszystkie spacje z łańcucha podawanego jako parametr tej funkcji.
    
5.  Napisz funkcję usuwającą z zadanego łańcucha (poprzez skrócenie tekstu)  
    wszystkie bezpośrednie powtórzenia liter np. zamieniającą tekst “kommputter” na ”komputer”.
    
6.  Napisz funkcję dodającą zadaną ilość spacji  
    na początku zadanego łańcucha tekst  
    (wcześniejsza zawartość tekstu przesuwana jest na dalsze pozycje).
    
7.  Napisz funkcję usuwającą z łańcucha tekst wszystkie litery  
    poczynając od pozycji pocz do litery na pozycji kon.
    
8.  Napisz funkcję wyrównującą długość zadanego tekst'u do N znaków,  
    poprzez dodanie odpowiedniej ilości spacji na końcu tego łańcucha.
    
9.  Napisz funkcję sprawdzającą czy zadany łańcuch znaków  
    ma symetryczną zawartość tzn, pierwszy znak jest równy ostatniemu,  
    drugi przedostatniemu itd.
    

 **2)  Zadania dotyczące zastosowań typu strukturalnego:  
**       (_przetwarzana tablica struktur oraz ilość danych zapisanych w tej tablicy  
         powinny być przekazywane jako parametry pisanych funkcji_)

1.  Zdefiniuj typ strukturalny oraz 100-elementową tablicę  
    pozwalającą przechowywać informacje o książkach w bibliotece  
    (tytuł, autor, indeks, cena) oraz napisz funkcję, która wyświetli na ekranie  
    wszystkie dane tanich książek (tzn. cena<10zł)
    
2.  Zdefiniuj strukturę przechowującą dane katalogowe ksiażki w bibliotece  
    (tytuł = 50 znaków; autor = 30 znaków;  liczba stron = liczba całkowita dodatnia;  
    wypożyczona = zmienna logiczna) oraz 200-elementową tablicę takich struktur.  
    Napisz funkcję drukującą na ekranie spis wszystkich  
    niewypożyczonych książek, które mają więcej niż 100 stron.
    
3.  Zdefiniuj typ strukturalny oraz 100-elementową tablicę  
    pozwalającą przechowywać informacje o samochodach w auto-komisie  
    (marka, przebieg, kolor, cena)  
    oraz napisz funkcję, która wyświetli na ekranie  
    wszystkie dane samochodu o najmniejszym przebiegu.
    
4.  Zdefiniuj typ struktury przechowującej dane personalne pracownika  
    (nazwisko - 20 znaków; imię - 15 znaków;  pensja - liczba rzeczywista;  
    płeć - znak 'm' lub znak 'k') oraz 100-elementową tablicę takich struktur.  
    Napisz funkcję sprawdzającą czy w danej firmie  
    większa jest średnia pensja kobiet czy mężczyzn.
    
5.  Zdefiniuj typ strukturalny oraz 50-cio elementową tablicę struktur  
    pozwalającą przechowywać informacje o towarach w sklepie RTV  
    (nazwa_towaru, ilosc_sztuk, cena, waga).  
    Napisz funkcję, która wyświetli na ekranie wszystkie dane najtańszego towaru.
    
6.  Zdefiniuj typ struktury przechowującej dane personalne studenta  
    (nazwisko = 30 znaków; imię = 25 znaków;  stypendium = ilość złotych i groszy;  
    zaliczenie = zmienna logiczna) oraz 100-elementowa tablicę takich struktur.  
    Napisz funkcję wyszukującą i zwracającą dane studenta,  
    który zaliczył semestr i ma najniższe stypendium.
    
7.  Zdefiniuj typ struktury przechowującej dane personalne studenta  
    (nazwisko : 25 znaków; imię : 15 znaków;  wiek : liczba o wartościach 0-120;  
    zaliczenie : zmienna logiczna) oraz 50-elementowa tablicę takich struktur.  
    Napisz funkcję wyświetlającą na ekranie dane personalne wszystkich studentów,  
    których nazwiska i imiona zaczynają się na tą samą literę  
    (np. **K**rzysztof **K**owalski, **N**orbert **N**owak )..
    
8.  Zdefiniuj typ struktury przechowującej dane o pociągach w rozkładzie jazdy  
    (Miasto docelowe: 30 znaków; długość trasy : liczba całkowita bez znaku;  
    godzina odjazdu: liczba rzeczy-wista; rodzaj pociągu: znak 'o' - osobowy,  
    'p' - pospieszny, 'e' - ekspres) oraz 50-elementową tablicę takich struktur.  
    Napisz funkcję wyznaczającą średnią długość trasy pociągów osobowych  
    do zadanego miasta.  
    Parametry funkcji: tablica_struktur,  ilość_wpisanych połączeń i nazwa miasta.
    

**3)  Zadania z tematu operacji na plikach dyskowych (binarnych lub tekstowych):**

1.  Napisz funkcję wyznaczającą wartość średnią  
    z ciągu liczb typu rzeczywistych (double)  
    zapisanych na dysku w pliku binarnym "dane.dat".
    
2.  Dany jest plik tekstowy, o nazwie "dane.txt", zawierający liczby rzeczywiste.  
    Napisz funkcję kopiującą zawartość tego pliku do nowego (tekstowego)  
    pliku "wyniki.dat", ale z pominięciem liczb ujemnych.
    
3.  Dany jest plik binarny, o nazwie "liczby.bin",  
    zawierający nieznaną ilość czterobajtowych liczb całkowitych.  
    Napisz funkcję odwracającą kolejność liczb w tym pliku  
    tzn., że pierwsza liczba znajdzie się na końcu pliku  
    a ostatnia liczba na pierwszej pozycji,  
    druga liczba na przedostatniej pozycji a przedostatnia na drugiej, itd.
    
4.  Dany jest plik tekstowy, o nazwie "liczby.txt",  
    zawierający nieznaną ilość liczb rzeczywistych.  
    Napisz funkcję zamieniającą znaki wszystkich liczb w tym pliku na przeciwne.  
    Tzn. liczba dodatnia powinna stać się liczbą ujemną, a liczba ujemna dodatnią.
    
5.  Napisz funkcję wyznaczającą pozycję liczby o maksymalnej wartości  
    w ciągu liczb całkowitych zapisanych na dysku w pliku tekstowym "dane.dat".
    
6.  Na dysku znajduje się plik binarny "liczby.bin"  
    zawierający nieznaną ilość liczb long double.  
    Napisz funkcję zmieniającą w tym pliku wartość N-tej liczby  
    poprzez powiększenie jej o wartość X.  
    N i X powinny być parametrami wejściowymi tej funkcji.
    
7.  Napisz funkcję wyznaczającą liczbę wystąpień sekwencji liter: 'aa' , 'bb' lub 'cc'  
    w ciągu znaków zapisanych na dysku w binarnym pliku "dane.dat".
    

**4)  Zadania z dynamicznej alokacji pamięci:**

1.  Napisz funkcję UTWORZ_TABLICĘ( rozmiar_A )  
    tworzącą dynamiczną tablicę A liczb całkowitych  
    (o rozmiarze zadawanym jako parametr tej funkcji).  
           Następnie napisz funkcję KOPIUJ_DODATNIE(A,rozmiar_A,B,rozmiar_B),  
    która policzy ile z elementów tablicy A jest dodatnich  
    i utworzy nową dynamiczną tablicę B zawierającą kopie tych elementów tablicy A,  
    które mają wartości dodatnie.
    
2.  Napisz funkcje tworzącą dynamiczną tablice struktur  
    opisujących dane osobowe studentów (wcześniej zdefinuj typ tej struktury).  
    Wielkość tej dynamicznie tworzonej tablicy  
    powinna być zadawana przez użytkownika (z klawiatury).  
    Następnie napisz funkcję wczytującą z klawiatury dane do w/w tablicy.
    
3.  Napisz funkcję tworzącą dynamiczną tablicę wskaźników na teksty  
    o maksymalnej dlugości 30 znaków.  
    Wielkość tablicy powinna być zadawana przez użytkownika (z klawiatury).  
    Następnie napisz funkcję wczytującą kolejne teksty z klawiatury  
    i umieszczającą je w tej dynamicznie utworzonej tablicy.

[Wykład 8](/Notatki/Semestr%201/Podstawy%20programowania/Wyk%C5%82ady/Wyk%C5%82ad%208/Wyk%C5%82ad%208.md)
[Wykład 9](/Notatki/Semestr%201/Podstawy%20programowania/Wyk%C5%82ady/Wyk%C5%82ad%209/Wyk%C5%82ad%209.md)
[Wykład 10](/Notatki/Semestr%201/Podstawy%20programowania/Wyk%C5%82ady/Wyk%C5%82ad%2010/Wyk%C5%82ad%2010.md)
[Wykład 11](/Notatki/Semestr%201/Podstawy%20programowania/Wyk%C5%82ady/Wyk%C5%82ad%2011/Wyk%C5%82ad%2011.md)
