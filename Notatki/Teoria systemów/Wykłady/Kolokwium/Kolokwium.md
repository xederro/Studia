> W jakim celu tworzymy (budujemy) model systemu?
---

Przede wszystkim by pracować na modelu a nie na rzeczywistym systemie poza tym 3 systemy:
- Fenomenologiczny - aby opisać i wyjaśnić funkcjonowanie systemu
- Predykcja - aby przewidzieć zachowanie systemu w przyszłości po podaniu na wejście różnych danych wejściowych
- Decyzyjny - aby wybrać odpowiednie wielkości wejściowe tak, by zrealizować wybrane zadanie sterowania

---
> Wyjaśnij różnicę pomiędzy zadaniem analizy ilościowej i sterowania docelowego na przykładzie układu ze sprzężeniem zwrotnym (metoda analityczna)
---

Zadanie analizy - Liczymy rozwiązanie dla zadanych wejściowe i zawsze mamy jedno rozwiązanie. Zadanie syntezy - szukamy takiego wejścia, by osiągnąć zadane dane wyjściowe, możemy szukać jednego rozwiązania, nierówności lub rozwiązania optymalnego (ekstremum), nie musi mieć rozwiązania w dopuszczalnym przedziale.

---
>Kiedy stosujemy metody identyfikacji (np. metodę najmniejszych kwadratów)?
---

Metodę identyfikacji stosujemy, gdy mamy o modelu matematycznym wiedzę eksperymentalną, wiedzę eksperta i na ich podstawie chcemy odtworzyć model. W samej metodzie najmniejszych kwadratów chodzi o wyznaczenie parametrów w ten sposób, by suma kwadratów różnicy między wartością oczekiwaną a obserwowaną była jak najmniejsza.

---
> Co to jest agregacja i na przykładzie przedstawić metodę graficzną

---
Agregacja to wyznaczanie modelu zintegrowanego, równoważnego algebraicznie opisujący zespół połączonych ze sobą elementów. Stosuje się to do upraszczania modeli matematycznych i ułatwia pracę związaną z zadaniami analizy lub syntezy

---
> Wyjaśnij różnicę pomiędzy systemami statycznymi a dynamicznymi.

---
Z systemem statycznym mamy do czynienia, gdy po wprowadzeniu danych wejściowych, właściwie bez opóźnienia system reaguje i zmienia dane. W dynamicznym systemie to jest bardziej płynne, wywołane z opóźnieniem, nie przebiega nagle, tylko rozkłada się w różny sposób w czasie. W układach dynamicznych określa się, czy są stabilne, niestabilne lub na granicy stabilności i wprowadza się transmitancję.

---







Wzmocnienie to a/1 ± ab

System, obiekt (przedstawiany w prostokątach), człon – to samo, używane do podkreślenia skali
Przedmiot rozważań:
• urządzenie fizyczne – model/opis matematyczny
• proces
wejście (we, u), wyjście (wy, y)
4 przypadki:
• bez wejść/wyjść
• wejście, brak wyjść
• wyjście, brak wejść
• wejście I wyjście (nazywany systemem, układ wejściowo-wyjściowy)
 ̄a - wektor parametru F
y=F(u , ̄a)
może ich być wiele, wtedy zapisywane jako wektory  ̄u oraz  ̄y
możliwe kombinacje:
• mimo
• miso
• simo
• siso (nazywany jednowymiarowym, inne przypadki są wielowymiarowe)
inne podziały:
• Jeśli F jest zależnością liniową, to obiekt jest nazywany liniowym
• kiedy parametry opisu mogą się zmieniać w czasie to obiekt nazywamy nieliniowym
obiekt:
• statyczny – niezależny od czasu (zależy tylko od wartości wejścia w danej chwili)
• dynamiczny - “pamięta historię” (do opsiu potrzebny jest stan wewnętrzny oraz oraz opis zmian
stanów wewnętrznych)
Metody opisu systemów dynamicznych:
• równanie różniczkowe
• funkcja przejścia (transmitacja)
• opis w przestrzeni stanów
system:
• prosty – całość objęta jednolitym zapisem
• złożony – znamy F I  ̄a
• ciągły – zmienia się w każdej chwili czasu
• dyskretny – zmienia się lub może być obserwowany w ściśle określonych momentach czasu
agregacja – łączenie obiektów w całość
dekompozycja – działanie odwrotne do agregacji

agregacja założenia:
• obiekty są 1-wymiarowe (skalary) lub wielowymiarowe (macierze)
• liniowe (rozpatrywane, mogą występować nieliniowe)
• o opisie y=au
• oznaczone w odmienny sposób
Analiza – znamy u, możemy wyznaczyć y. Jeżeli znamy przebieg zmienności parametrów, to jest ok,
dokonując obliczeń uwzględniamy aktualną wartość. Niestety często wiemy tylko, że parametry
zmieniają się w czasie.
Układy, których parametry zmieniają się w czasie nazywamy niestacjonarnymi. (np. parametry
zmieniają się na skutek zużycia)
Wyznaczanie sterowania
założenia: y (t)=f ( ̄a ,u (t))
zadanie jest proste: u(t)=f
−1
( ̄a, y (t))

• Stopień trudności zależy od postaci funkcji f.
• Niekoniecznie istenieje jedna wartość u* zapewniająca y*
zbiór rozwiązań dopuszczalnych – można użyć wartości tylko z zadanego przedziału
ograniczenia na sterowanie – dodatkowe wymagania
y*:
• wartość zadana
• może być przedziałem
W układach dynamicznych ograniczenia lub dodatkowe wymagania są o wiele bardziej rozbudowane.
Rozwiązanie może nie istnieć
Sterowanie ekstremalne – nie interesuje nas konkretna wartość, a wartość ekstremalna (min lub max).
Aby skutecznie zastosować sterowanie ekstremalne zakładamy, że funkcja jest unimodalna – posiada
w rozważanym obszarze jedno, najlepiej wyraźne, ekstremum.
Dwa przypadki:
• dyskretny – krokowe dostrajanie
• ciągłe
wersja z próbkowaniem
un+1=a⋅
f (un+Δ)−f (u0−Δ)
2Δ

Na początku przyjmujemy duże wartości, a jak się pary zaczynają szybko zmieniać to zmniejszamy.
Można zauważyć, że próbkowanie może być “stratą czasu”. Dlatego inna wersja nie zakłada kroków
próbnych.
un+1=un−a(f (un
)−f (un−1
))⋅sgn(f (un
)−f (un−1
)) bardzo ważne jest odpowiednio dobrane a
Duże kroki – szybko dochodzimy do ekstremum I zaczynamy oscylować w okół niego. Im większy
współczynnik tym większe oscylacje.
Metoda nie zapewnia osiągnięcia ekstremum, ale doprowadza nas możliwie blisko.
Mały współczynnik – kroki małe, ale bardziej zbliżamy się do ekstremum.

Metoda nadaje się również do sterowania ekstremalnego wolnozmiennych obiektów niestacjonarnych
• wtedy nie stosujemy warunku stopu, ale staramy się nadążyć za zmianami parametrów obiektu,
utrzymując wartość zbliżoną do ekstremum
Warunek stopu (np. po 3-krotnych zmiannach znaku różnicy I efektywności mniejszej od założonej)
• warto stosować dla obiektów stacjonarnych
Dynamiczna zmiana współczynników
• metoda jest gradientową metodą poszukiwania ekstremum
• można uzależnić wielkość współczynnika od wartości różnicy pomiędzy wartościami
otrzymanymi w kolejnych krokach
◦ duża różnica – duży następny krok
◦ mała różnica - mały następny krok
• pozwala na osiągnięcie wartości zbliżonych do ekstremum, niż współczynnik stały
ze sterowaniem ekstremalnym spotykamy się na co dzień, np. autmatyczne dostrajanie częstotliowści I
wzmocnienia (radio)
Aproksymacja parametrów
Znamy postać funkcji F, ale nie znamy jej parametrów.
• Musimy dysponować zbiorem obserwacji
• pomiary w trakcie działania układu
• aproksymacja, bo pomiary zwykle są obarczone błędem
• kryterium aproksymacji
◦ ocenia jednoznacznie odległość F przy konkretnych parametrach od zbioru obserwacji
▪ szukamy takich parametrów, dla których odległość jest najmniejsza
• jeśli zmienimy funkcję Q to otrzymane parametry mogą być inne
▪ zaznaczamy, że otrzymane parametry są optymalne dla przyjętego kryterium I użytego
zbioru obserwacji
◦ jeśli nie mamy zbioru obserwacji
▪ uzyskujemy zbiór na drodze eksperymentu
• testujemy dla wymuszonych wartości wejścia
▪ plan eksperymentu – ustalenie takich wartości podawanych na wejście, aby uzyskane
obserwacje możliwie dokładnie odzwierciedlały charakterystykę obiektu

Wybór najlepszego modelu
Nie znamy funkcji F I nie znamy parametrów
• proponujemy kilka postaci F1...Fn
• dla każdej z nich szukamy parametrów optymalnych (aproksymacja)
• Jako model wybieramy funkcję, dla której udało się uzyskać najmniejszą wartość Q
◦ Q jest najmniejszą odległością Fk od On
• dla każdej funkcji musimy używać tego samego kryterium I tego samego zbioru obserwacji
Analiza własności
• wykonywane dla obiektów dynamicznych
• badane własności np.:
◦ stabilność
◦ zbieżność
◦ sterowalność

Zadanie syntezy – projektowanie układów, systemów o określonych wartościach
Aproksymacja parametrów
metoda najmniejszych kwadratów:
• metoda minimalizacji sumy kwadratów błędów
• metoda minimalnej sumy kwadratów błędów
• obiekt
• cecha obiektu
◦ napis, prawa własności
• rodzaje cech – wyróżnikiem są wartości takie jakie cechy może przyjmować
▪ ciągłe
▪ dyskretne
• binarne
▪ opisowe (wyliczeniowe)
• wartości cechy
• atrybuty obiektu
◦ para (cecha wartości)
wektor cech – zbiór cech
przestrzeń cech:
• zbiór wszystkich możliwych wartości wektora cech
• iloczyn kartezjański dziedzin wszystkich składowych wektora cech
klasa – podzbiór obiektów wyznaczony przez zależność, warunki określone na cechach obiektów
definicja klasy:
• jawna – znamy wprost warunki opisujące klasę/y
• przez przykłady
zbiór przykładów (ciąg uczący) – zbiór par ( ̄xn
, ci
) ,  ̄xn
- wartość wektora cech, ci – klasa do której

należy
algorytm klasyfikacji/rozpoznania – algorytm, który na podstawie znajomości wektora cech obiektu
(jego wartości) przypisuje obiekt klasy. Algorytm klasyfikacji powinien dzielić przestrzeń cech na tzw.
obszary decyzyjne Di
Obszar decyzyjny – obszar, którego wszystkie punkty należą do tej samej klasy I który zwiera
wszystkie punkty należące do tej klasy (z punktu widzenia algorytmu klasyfikującego).
Cechy obszarów:
• ∀
i≠j
Di∧Dj=∅
• uDi=x
• obszary decyzyjne nie muszą być spójne

Podział algorytmów klasyfikacji:
• klasyczne
◦ probabilistyczne - “Sprawdź, do której klasy prawdopodobieństwo przynależności jest
największe”
◦ deterministyczne – tutaj jedną z licznie reprezentowanych grup są tzw. algorytmy
minimalno-odległościowe
• zaliczone do metod tzw. sztucznej inteligencji:
◦ drzewa decyzyjne
◦ sztuczne sieci neuronowe
◦ algorytmy budowy drzew decyzyjnych
◦ (rzadziej) algorytmy genetyczne
Algorytm NN – Nearest Neighbor (najbliższy sąsiad)
1. Wyznaczyć jego odległość od wszystkich obiektów z ciągu uczącego
2. Znajdujemy odległość najmniejszą z wyliczonych
3. Przydzielamy badany obiekt do tej klasy, do której należy jego najbliższy sąsiad
Cechy metody NN:
• nieskomplikowane obliczeniowo
• duży nakład obliczeniowy
• czuła na błędy w ciągu uczącym
• nie gwarantuje klasyfikacji
Metoda αNN (kNN) – k Nearest Neighbor (k najbliższych sąsiadów)
Zamiast brać pod uwagę tylko jednego, decyzję opieramy na k najbliższych sąsiadach.
1. Liczymy wszystkie odległości
2. wyszukujemy k-najbliższych sąsiadów
3. Sprawdzamy z której klasy znalazło się najwięcej I do tej zaliczamy rozpatrywany obiekt
Cechy metody kNN:
• duży nakład obliczeniowy
• zdecydowanie mniej czuła na błędy w ciągu uczącym niż NN
• nie gwarantuje klasyfikacji
Metoda NM – Nearest Mean (najbliższa średnia)
1. Tworzymy obiekt, którego cechy mają wartości średnie po wszystkich obiektach z każdej klasy
2. obliczamy odległość badanego obiektu tylko od reprezentantów klas
3. obiekt przydzielamy do tej klasy, do której reprezentanta jest mu najbliżej
Cechy metody NM:
• drastycznie zmniejszamy nakład obliczeniowy
• nie gwarantuje klasyfikacji
• błędy mają wpływ na położenie reprezentantów
• w pewnych przypadkach drastycznie zmienia granice obszarów decyzyjnych

Miary odległości:
• miara Minkowskiego
◦ euklidesowa
◦ euklidesowa unormowana
◦ Czebyszewa
◦ taksówkowa
◦ pochodne miary Minkowskiego
• miara rzeka
• metryka dworcowa (węzła kolejowego)
• metryka dyskretna
• metryka Mahalanobisa
3 popularne zalgorytmizowane metody tworzenia opisu przestrzeni stanów:
• bezpośrednia
• równoległa
• iteracyjna