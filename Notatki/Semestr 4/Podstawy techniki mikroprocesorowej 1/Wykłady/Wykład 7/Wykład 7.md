ttn16:12
# I/O

transmisja szeregowa
występuje handshaking

## Tryby pracy
- synchroniczny - ważne dane lub niepewne łącze
	- zestawienie łącza
	- ustawienie słów synchronizacji - monosync, bisync (1 czy 2 słowa synchronizacji)
	- zegar
	- dane zaczepione do słowa synchronizacji
	- jak przerwa w transmisji to synchronizacja
- asynchroniczny - bo różna odległość między startami kolejnych ramek nie jedna za drugą
	- zestawienie łącza (info co i jak przesyłane będzie - my jako programiści)
	- ustalenie kształtu ramki
	- zegar
	- start ramki dowolny, ale w rytmie zegara

## Układ czasowo licznikowy

liczniki niezależne, negatywne
pracują w NKB, BCD, stałe 16bit
maksymalna częstotliwość 2MHz

tryby pracy
- tryb 0 - odliczanie jednorazowe - ma upłynąć i dostajemy info że upłynął (linia gate umożliwia pauze)
- tryb 1 - generator pojedynczego impulsu - jak klikniemy gate to zaczyna liczyć do 0, jeżeli puścimy i potem klikniemy gate to resetuje się licznik
- tryb 2 - dzielnik częstotliwości - co jakiś czas wysyła sygnał, gate wstrzymuje odliczanie
- tryb 3 - generator fali prostokątnej - na podstawie zegara i licznika jesteśmy w stanie wygenerować inny sygnał (3 clk trzyma górę 3 clk trzyma w dół)
- tryb 4 - impuls strobujący - start: program - wysyła impuls jednorazowy 
- tryb 5 - impuls strobujący - start: sprzęt - wysyła impuls jednorazowy ale resetuje licznik na gate