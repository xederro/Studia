![](/Notatki/Semestr%204/Podstawy%20techniki%20mikroprocesorowej%201/Wykłady/Wykład%2012/PTM-wyk-12.pdf)

# Magistrale szeregowe

## $I^2C$
Inter-Integrated Circuit
szeregowa
SDA - dane 
SCL - clock
OC(OD) - terminowany na końcu
może być połączonych do 32 urządzeń
komunikacja dwukierunkowa synchroniczna
na magistrali pozaczepiane są kolejne urządzenia
zmiana danych kiedy na zegarze jest stan niski
mamy sekwencje startu i stopu
8 bitów i potwierdzenie
adresuje; daje r czy w, dane a, dane ack, dane ack,

strony danych #kolokwium 
możemy przesyłać wiele bajtów bez powtórnego adresowania
możemy adresować daną
master + slave


## $D^2BUS$
Digital Data Bus
iic ale do spinania wielu urządzeń
100kb/s
150m
4096 urządzeń
po skrętce
master slave
start i stop
potwierdzenia
bit parzystości

## CAN
Controller Area Network - intel + bosh
asynchroniczna
dużo nadajników i odbiorników do 500mln
dynamiczne dodawanie i usuwanie urządzenia
1Mb/s
skrętka
tylko 1 linia transmisyjna can_h i can_l
CSMA/CD - carrier sense multiple access with collision detection


## SPI
Serial Peripherial Interface - motorola
do 10 Mb/s
3 linie transmisyjne i linia wyboru
4 tryby transmisji
master + slave
interface SPI, łączymy 2 elementy szeregowo i każdy element podaje dalej
3 funkcje: talker, listener, repeater
rotująca maszyna z danymi

## SMBUS
system menagement bus intel
zbliżony do I2C i kompatybilny z nim

## Microwire
National Semiconductor
650kb/s
3 linie wejscia wyjścia i zegara
zgodna z spi w trybie 0

## 1-wire
dallas Semiconductor/maxim
master slave

## USB
universal serial bus
+,- d+, d-
skrętka ekranowana
nrzi - nadajemy ten sam stan jak 1 i zmieniamy jak 0
crc
