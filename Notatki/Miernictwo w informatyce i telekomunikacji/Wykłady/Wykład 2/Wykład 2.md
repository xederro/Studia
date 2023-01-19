# Przygotowanie, przeprowadzenie, prezentacja i analiza wyników
*premiera*
## 
Eksperyment jakim jest proces pomiaru musi być solidnie zaplanowany i przygotowany 
1. jaki jest cel pomiaru:
  wpływa na wybór metody, dokładności i narzędzi
  Informacja:
  - Zgrubna (szacowanie)
  - o dokładności użytkowej (codzienny)
  - najwyższej dokładności (wzorcowanie, pomiar odniesienia)
  Jakiej info oczekujemy
  - Jakościowej
  - Ilościowej
2. jaki parametr chcemy mierzyć
   - Pomiary wielkości fizycznych: prąd, napięcie itp.
   - Pomiary "systemowe" - dot. jakości usług, analizy danych: bitowa stopa błędów, zadowolenia klientów itp. 
3. jakich metod możemy użyć
   - Konieczność "rozeznania tematu"
   - Znajomość metod pomiarowych przydatnych do danego celu
   - Dobór metody - "mierz siły na zamiary" czy "zamiar według sił"?
     **bezpośrednie** np. przykładanie termometru
     - Wychyłowa - położenie wskazówki w przyrządzie analogowym np. wychylenie wskazówki woltomierza
     - Zerowa (kompensacyjne) - porównanie wartości mierzonej z wzorcem np. waga wzorcowa (w teorii najdokładniejsze)
     - Zerowa (komparacyjna) - potrafimy użyć wielokrotności wzorców - waga wielokrotnościowa
     - Różnicowa - połączenie powyższych wartość wzorca + wartość wychylenia np. waga która do kg działa jako wychyłowa a powyżej wielokrotnościowa, 1.5 kg sera 1kg odważnik i 0.5 kg na wadze
     - Zerowa (przez podstawianie) - mamy skalę z podziałką niewykalibrowaną, i podkładamy wzorzec
     **pośrednie** np. mierzymy napięcie i prąd by znać rezystancje
   - Niezbędna odrobina teorii - metody pomiarowe - różne kryteria podziału, różne możliwości, różne dokładności - różne narzędzia
   - Dokładność pomiaru będzie zależała od wybranej metody(ograniczenia metody i narzędzia pomiarowego(dokładność klasa miernika)
4. jakich narzędzi pomiarowych chcemy użyć
   Środki techniczne używane do pomiaru
   - Wzorce miar - rezystor wzorcowy, wzorzec czasu -
   - Sprawdziany - układy pomiarowe służące do sprawdzenia czy dana wielkość spełnia kryteria
   - Przyrządy pomiarowe - woltomierz, amperomierz, linijka, komputerowa karta pomiarowa
   - Przetwornik pomiarowy - przetwarza wartość wielkości na wartość innej wielkości lub inne wartości tej samej wartości
   - rejestrator - utrwala nietrwały wynik pomiaru
5. jaka jest niezbędna dokładność pomiaru
6.  jak uzyskać wynik "końcowy"
   - Czy jest to pojedyńczy pomiar? napięcie baterii
   - Czy jest to seria pomiarów tej samej wielkości ale o różnych parametrach. napięcie baterii przy różnym obciążeniu
   - Czy będziemy mierzyć jedną metodą czy różnymi metodami?
   - Jedno narzędzie pomiarowe czy kilka?
   - Dlaczego? Użyteczny
   - powinien być wiarygodny i miarodajny
   - użyteczny do określonego celu
   - oszacowana niepewność błąd
   - błąd powinien być adekwatny do potrzeb
7. Jak zaprezentować wynik
   Wynik pomiaru powinien być zachowany, odtwarzalny np. dla późniejszej weryfikacji wyników
   Dokumentujemy:
   - metody
   - sprzęt (nr. miernika)
   - układu pomiarowego (schemat połączeń)
   - warunki pomiaru (o ile istotne)
   - osoby wykonujące pomiar
   - data
   Analizujemy
   - nigdy nie wierz pojedynczemu wynikowi pomiaru
   - podejście formalne, ale zdroworozsądkowe do uzyskanych wyników
   - błąd
   - usuwamy błędy grube
   - waga poszczególnych wyników(Średnia ważona, waga = odwrotność niepewności procentowych)
   - składowe niepewności
   - pierwsze przybliżenie - dobry zwyczaj porównania wyników, najprościej przedziały liczbowe albo graficznie
   
   
   
  



Skala pomiarowa jest całkowicie uporządkowany według relacji nierówności zbiór wartości z danego rodzaju wielkości, np. wzrost w cm porównujemy do kategorii niski, średni, duży. 

Skala nominalna oparta jest tylko na relacji równoważności np. RGB(10,10,10), RAL 1013, możemy powiedzieć że są takie same albo różne

Skala porządkowa - określone są w niej relacje równoważności i ścisłego uporządkowania, cechom obiektów o większej intensywności podaje się wyższe liczby, np. 1 kapitan to nie 5 majtków, skala skala twardości minerałów Mosha

Skala addytywna - odwzorowuje relacje ścisłego uporządkowania i równości interwałów. Różnice między dwiema wartościami w tej skali dają się obliczyć i mają interpretacje w świecie rzeczywistym np. temperatura

Skala ilorazowa, stosunkowa, metryczna - odwzorowuje relacje ścisłego uporządkowania i równości interwałów i równoważności skali np skala Kelwina


Pomiary pojedynczej wartości a pomiary funkcyjne
- pomiary funkcyjne - różnych zależności albo zmiany parametrów określonej wielkości
  
  Określamy zakres zmian parametru wejściowego i wyjściowego
  - pomiar poziomu sygnału Wi-Fi w funkcji odległości - od 1m do odległości dla której poziom spadnie poniżej -70dBm
  - pomiar pasma przenoszenia wzmacniacza akustycznego - zakres częstotliwości od 10hz do 30khz
  
  Określenie zasady doboru punktów pomiarowych ich liczby oraz odstępu między punktami: 
  - stały 1,2,3,4,5
  - rosnący 2,4,8,16,32, najczęściej logarytmiczny - dekadowy, 1,2,5,10,20,50,100,200,500,1000, stosujemy przy dużej rozpiętości wyników
  - Dynamiczny dobór odstępu między punktami - zależnie od gradientu zmian wartości mierzonej
    małe zmiany jeżeli nie ma znacznych zmian
    częste gdy się bardzo zmieniają
    można mierzyć niejednolicie np. wracać 
    nie trzeba zapisywać wszystkich danych
    
  Inżynier posługuje się rysunkiem: tabele, wykresy
  - Użyteczny: prezentuje dane w sposób przydatny dla klienta
  - Czytelny: odpowiednia wielkość wystarczająca liczba danych
  - Jednoznaczny: 
  - odpowiednio wyskalowany
  - Dane na wykresie są próbkami
    - łączymy gdy mamy do czynienia z wielkością ciągłą np. volty
    - nie łączymy gdy między punktami wartość nie istnieje(są dyskretne) i nie możemy założyć że jest ona tam liniowa np. wykres wyników kolejnych rzutów kością
  - typowe wykresy
    - punktowe x-y na osi x wejscie na y wyjście
    - liniowe i kolumnowe x kolejny pomiar y wartość
    - kołowe np. procentowy udział parametrów w całości
    - histogram ,częstość występowania danego wyniku np. rozkład wyników z kolokwium
    - funkcja aproksymująca powinna przechodzić przez punkty niepewności (aproksymacja odcinkowa np. na początku kwadratowa potem liniowa)
  
  
  
  

- wyniki pomiaru pojedyńczej wartości wyznacza
- 1
- 2
- 3
- 4