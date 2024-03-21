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
x'+y'0=y0z0
x'=y0z0


# Złożoność algorytmów
## Obliczeniowa
czyli ilość zasobów komputera jaką musimy przeznaczyć na przebieg algorytmu T(n)

- optymistyczna - idealne dane
- dane - średnia $\sum^n_{k=1}p_k * t_k(n)$ dla każdej pozycji średnia np.
- pesymistyczna - najgorsze dane


np. sumowanie liczb od 1 do n

```
K1: wczytaj n         t1x1
K2: suma := 0         t2x1
K3: i := 1            t2x1
K4: IF i > n THEN     t3x(n+1)
K5:     goto k9       t4x1
K6: suma := suma+i    t2xn
K7: i := i+1          t2xn
K8: goto K4           t4xn
K9: wyświetl suma     t5x1
K10: koniec           t6x1
```

$T(n)=t_1+t_2+t_2+(n+1)t_3+t_4+n*t_2+n*t_2+n*t_4+t_5+t_6=t_1+t_2(2+2n)+t_3(n+1)+t_4(n+1)+t_5+t_6$
$t_1+2nt_2+nt_3+nt_4+t_5+t_6=n(t_3+2t_2+t_4)+(t_1+2t_2+t_3+t_4+t_5+t_6) = nt_7+t_8$
$T(n)=n$ <-klasa złożoności obliczeniowej

## Pamięciowa
czyli ilość zasobów pamięci jaką musimy przeznaczyć na przebieg algorytmu M(n)




## Klasa złożoności obliczeniowej
**big O notation**, T(n)<=c\*g(n) od pewnej wartości. wybieramy najmniejszą zgadzającą się
O(1) - stała
**notacja omega $\Omega$** T(n)>=c\*g(n) od pewnej wartości.
**Notacja teta $\theta$** c1\*g(n)<=T(n)<=c2\*g(n), asymptotycznie dokładne oszacowanie, jest złożeniem 2 powyższych

zadanie
$n^2/2-3n=\Theta(n^2)$
$c1*n^2 <= n^2/2-3n <= c2*n^2$


Złożenia:
T1+T2 to max(O(T1), O(T2))
T1\*T2 (np. pętle) to O(T1\*T2)

złożoności wielomianowe:
n - liniowa
n^2 - kwadratowa
n^3 - sześcienna

złożoność ograniczone przez wielomian
logn - logarytmiczna - mniejsza od n
nlogn - quasilogarytmiczna - mniejsza od n^2 większa od n

złożowość niewielomianowe
a^n - wykładnicza
n! - silnia


