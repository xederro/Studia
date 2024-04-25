tts 16:15
# IO v3

## porty równoległe
8051 nie ma linii handshakingowych
## port szeregowy
tryby pracy
- tryb 0: w zasadzie synchroniczny, podłączony do rejestru przesuwnego
- tryb 1, 2, 3: asynchroniczne, 8 bitów, w trybie 1 nie ma opcji na bit parzystości, jest bit startu i stopu, 
## układy czasowo licznikowe


# Współadresowanie pamięci i I/O
przekazujemy część adresów które by adresowały pamięć w celu adresowania I/O

# Adresowanie izolowane pamięci i I/O
osobna przestrzeń adresowa dla pamięci i dla I/O, odrębne też sterowanie


# Magistrala IEC-625 (IEEE-488)
kanał komunikacyjny 16 urządzeń
długość przewodów do 20m
logika ujemna, poziomy TTL
mamy 8 linii danych, potwierdzenie transmisji (handshaking), linie sterowania
przegląd równoległy, 1 z 8 na DIO, jeżeli >8 po 2 na 1 adres
przegląd szeregowy, rozróżnienie urządzeń na 1 adresie
odrębność części interface i obliczeniowej
kontroler magistrali = komputer