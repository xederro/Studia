# Kryteria analizy algorytmów

- poprawność - czy daje dobry wynik
	- własność stopu
	- częściowa niezmienność
	- niezmienniki
- złożoność obliczeniowa - czasowa czy pamięciowa
- optymalność
- efektywność



## Niezmienniki
zmienne które nie zmieniają się po pętli

zadanie
y0, z0 początkowe y,z

x+yz = y0z0

gdy z nieparzyste x'=x+y, y'=2y, z'=(z-1)/2
$$x'+y'+z' = (x+y)+2y*(z-1)/2=(x+y)+y(z-1)=x+y+yz-y= x+yz$$

gdy z parzyste x'=x, y'=2y, z'=z/2
$$x'+y'+z' = x+2y*z/2=x+yz=x+yz= x+yz$$

wiec mamy udowodnione że sie nie zmienia
teraz sprawdzamy czy algorytm faktycznie wykonuje mnożenie

x+yz=0+y0z0
po ostatnim przebiegu pętli
x'+y'z'=y0z0