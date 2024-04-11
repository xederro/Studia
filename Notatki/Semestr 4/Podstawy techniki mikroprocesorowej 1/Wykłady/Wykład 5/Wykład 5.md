![](/Notatki/Semestr%204/Podstawy%20techniki%20mikroprocesorowej%201/Wykłady/Wykład%205/PTM-wyk-5.pdf)
Odświeżanie pamięci DRAM
- tryb skupiony "trójpolówka" - część jest nieużywana i automatycznie odświerzana przez proces
- **tryb sygnałem ras - wrzucamy tylko wiersz i losowa kolumna jest odświeżona** #kolokwium 
- **ukryte - cas jest aktywna a ras zmienia się wysoki i niski wiec się odświeżają losowo**
- **cas przed ras - ustawienie najpierw cas potem ras to zrobi odświerzenie losowej rzeczy**

Specjalne tryby pracy DRAM #kolokwium 
- odczyt - modyfikacja - zapis
- tryb stronnicowy - blokujemy wiersz i aktualizujemy tylko adresy kolumny
- tryb nibble - czyta z kolejnych kolumn od adresu pierwotnego

Bloki
nie możewy w 1 układ dać wszystkich danych więc dzielimy na ileś układów do których zapisujemy po części
dekoder dekoduje adresy dostane z procesora (całą pamięć) i przekształca ją na odpowiedni adres do odpowiedniego układu i adres tam

Cache - pamięć podręczna #kolokwium 
1. Direct mapping cache - linia co jakiś odstęp do a idzie a, a+1024, a+2024... tam potencjalnie w cache może być pamięć z xram, musimy sprawdzić tylko 1 linie by wiedzieć że ni ma
2. Dully associative cache - nie ma żadnego wstępnego przypisania / klucza, trzeba sprawdzić cały cache
3. Set associative cache - dzielimy cache na podzbiory i im przypisujemy część xramu

Cache - nominacje
1. z uwzględnieniem tagów
   - MIN - jak długo nie będzie potrzebne to out 
   - LRU - jak długo nie było     potrzebne to out
2. bez uwzględnienia tagów
   - FIFO - które pierwsze wleciało wywalamy
   - Random - losowo

możemy łączyć cache do xram zawsze i aktualizować dane na bierząco
lub aktualizować xram jak z cache się wynosi
lub jeżeli nigdy nie zapisano do cache to out bez niczego


Pamięć główna
- stronnicowanie - dzielimy pamięć na zunifikowane fragmenty - najmniejszy jaki proces może dostać. łatwa do gospodarowania. marnuje. może być przydział statyczny (prosimy na początku i tylko to mamy) i dynamiczny (nowa akcja to dzielimy)
- segmentacja - po fragmencie co kto potrzebuje, trudna gospodarka, nie marnuje miejsca, przydział statyczny i dynamiczny (na bierząco dajemy ale prubujemy skleić fragmenty by było ich jak najmniej)

mamy pamięć półprzewodnikową i udawaną (programy proszą na zapas wiec dają wiele razy to samo bo co, wiec jak chce użyć to ojej), może użyć dysk jak się ram skończy.




8081 organizacja pamięci
podział na strony wielkości 0..7FF (2048)


Układy wejścia / wyjścia
- równoległy - n bitów naraz
  tryby pracy:
  - tryb 0:
    niestrobowane wejście-wyjście, nie interesuje nas czy ktoś odebrał czy nie
  - tryb 1:
    strobowane wejście-wyjście, z komunikacją potwierdzającą nadanie i odebranie. jest handshake
  - tryb 2
    dwukierunkowa magistrala danych, kanał może nadawać i odbierać, nadbudowanie trybu 1
- szeregowy - bit po bicie
- czasowo-licznikowy - 