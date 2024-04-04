
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

Cache - pamięć podręczna
