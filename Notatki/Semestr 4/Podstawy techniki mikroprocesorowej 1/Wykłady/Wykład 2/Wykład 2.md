![](/Notatki/Semestr%204/Podstawy%20techniki%20mikroprocesorowej%201/Wykłady/Wykład%202/PTM-wyk-2.pdf)
# Architektura Intel 8051

CISC - kompleksowa lista rozkazów
RISC - zredukowana lista rozkazów

XRAM - pamięć zewnętrzna 64KB 0000 -> FFFF
IRAM - pamięć wewnątrzna 128B 00 -> FF
Code - pamięć na kod 64KB 0000 -> FFFF
DPTR - data pointer - wskaźnik na ram
PC - process counter - zlicza na której operacji jesteśmy

r0 i r1 może być wskaźnikiem na pamięć

są 4 rejestry i rs1 rs0 mówi nam które używamy



#kolokwium
S1 - pobranie rozkazu (na 3 razy jak 3 bajtowy)
S2 - dekodowanie
S3 - wyznaczenie efektywnego rozkazu (skąd brać dane do rozkazu i gdzie zapisać wynik)
S4 - ładowanie argumentów 
S5 - egzekucja
S6 - pamiętanie rezultatów

procesor - każde
pamięć - S1, S3, S4, S6




S3 - tryby adresowania #kolokwium
- rejestrowy bezpośredni
- rejestrowy pośredni - rejestry są pośrednikami np. pc
	- movx @dpts, a //x external
	- mov a, @r0
- bezpośredni
	- mov a, 10H
- natychmiastowy ?czy sprawdzenie parzystości byłoby natyczhmiastowe w pierwszej połowie
- bazowo-indeksowy
	- movc A, @A+DPTR // c - kod programu



