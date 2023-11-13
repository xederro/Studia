![](/Notatki/Semestr%203/Niezawodność%20i%20diagnostyka%20układów%20cyfrowych%201/Wykłady/Wykład%203/NIDUC_w4.pdf)

# Badania niezawodności i analiza statystyczna wyników

1. Co to są badania niezawodnościowe i jak się je prowadzi
   Celem jest określenie rozkładu zmiennej losowej opisującej czas życia elementu
	1. Pobranie próby losowej
	2. Notowanie chwili uszkodzenia kolejnych elementów oraz sprawdzanie czy nie jest spełnione kryterium zakończenia badania
   **Kryterium zakończenia zadań**
	   - Uszkodzenie wszystkich n elementów
	   - przekroczenie dopuszczalnego czasu badania $T_{test}$ (type 1 censoring)
	   - uszkodzenie zadanej liczby elementów (type 2 censoring)
	   - uszkodzenie zadanej liczby lub czasu badania
2. Sposoby prezentacji danych z eksperymentu
   - Histogram (kształt gęstości)
   - Dystrybuanta empiryczna (odwzorowanie/przybliżenie dystrybuanty)
     Funkcja schodkowa od 0 do 1 lewostronnie domknięta
     Twierdzenie Gliwienko-Cantelli: $D_n=sup_{-\infty<t<+\infty}|F^-_n(t)-F(t)|$ wówczas $P(\lim_{n\rightarrow\infty}D_n=0)=1$. Im większa próba tym lepsze przybliżenie dystrybuanty do teoretycznej

1. Sposoby wyznaczania rozkłady zmiennej losowej na podstawie danych z eksperymentu
   - Estymacja parametryczna:
     Sformułowanie zadania estymacji parametrycznej. Zakładamy, że wektor T=T1,T2...Tn opisują próbę losową został pobrany z parametrycznej rodziny rozkładów
     $$\set{F_\theta:\theta\subset\Theta}$$
     przy czym wartość parametru (parametrów) $\theta$ 
     
     Estymacja $\theta$ metodą największej wiarygodności **(MLE)**
     Jako wartość parametru $\theta$ przyjąć wartość $\theta^-$, która maksymalizuje funkcję wiarygodności
     $$L(t_1,t_2...t_n,\theta)=\prod_{i=1}^nf(t_i,\theta)$$
     gdzie f(t,$\theta$) - gęstość rozkładu populacji
     likelyhood i log likelyhood (są małe liczby więc lepiej się używa logarytmów)
     
     
     
     Estymacja $\theta$ metodą największej wiarygodności
     W przypadku prób obciętych parametr $\theta^-$ wyznaczamy przez maksymalizacje wyrażenia:
     $$L(t_1,t_2,...,t_n,T_1,T_2,...,T_{n-k},\theta)=\prod_{i=1}^kf(t_i,\theta)\times\prod_{j=1}^{n-k}(1-F(T_j,\theta))$$
     Używamy np. Matlab, R
     Przykładowa procedura(dane niepełne):
     1. Sporządzić wykres probabilistyczny dla wybranych rozkładów prawdopodobieństwa
     2. Jeśli dane pochodzą z danego rozkładu, wówczas naniesienie na wykres powinien się ułożyć mniej więcej wzdłuż linii prostej
     3. Wyznaczamy parametry rozkładu (np. metoda największej wiarygodności)
     
     Przykładowa procedura(dane pełne):
     1. Sporządzić histogram dla zarejestrowanych danych
     2. Na podstawie kształtu histogramu założyć możliwy rozkład prawdopodobieństwa czasu życia
     3. dla wytypowanego rozkładu wyznaczamy parametry np. MLE
     4. sprawdzamy jakość dopasowania(goodness-of-fit), poprzez weryfikację hipotezy H0 o zgodności danych z założonym rozkładem
        Procedura testowa:
        jeżeli p< 0.05 - wówczas odrzucamy hipotezę o zgodności przyjętego rozkładu z danymi. Należy wtedy poszukać innego rozkładu
     5. Możemy również posłużyć się wykresami probabilistycznymi 

CRISP-DM