# Element nienaprawialny, podstawy matematyczne, miary niezawodności, rozkłady

F(t) - dystrybuanta
f(t) - gęstość rozkłądu


1. Model niezawodności elementu nienaprawialnego
	   element - niepodzielny model układu, zaczyna pracę w 0 i po pewnym czasie life time ulega uszkodzenia.
	   czas życia - dodatnia, ciągła zmienne losowa T
2. Miary niezawodności - charakterystyki liczbowe i funkcyjne
	   1. Funkcja niezawodności
		   R(t) prawdopodobieństwo, że element przeżyje chwile t, hazard
		   R(t) = P(T>=t)
		   R(t) = 1-P(T<t)=1-F(t)
		2. Funkcja intensywności uszkodzeń
		   $\lambda (t)$ granica(o ile istnieje) prawdopodobieństwa warunkowego, że uszkodzenie elementu nastąpi w \[t,t+$\delta$\], pod warunkiem że nie nastąpiło w t
		   $\lambda(t)=\lim_{\Delta->0}\frac{1}{\Delta}P(t\lt= T\lt= t+\Delta | T\gt t)$ 
		   $\lambda(t)=\frac{f(c)}{1-F(t)}$
		   $\lambda(t)=\frac{-R'(t)}{R(t)}$
		   $\lambda(t)=e^{-\int_0^t\lambda(u)du}$
		   dla $\lambda(t)=\lambda$ - nie zależy od t, funkcja niezawodności dla rozkładu wykładniczego rozkładu wykładniczego -> rozkład bez pamięci, taki element się nie starzeje,
		   W praktyce często rozkład ma intensywność uszkodzeń w kształcie bathtub curve
		   ![](/Notatki/Semestr%203/Niezawodność%20i%20diagnostyka%20układów%20cyfrowych%201/Wykłady/Wykład%202/Pasted%20image%2020231030075748.png)
		3. Średni czas życia
		   $T_{FF} = E(T) = \int_0^\infty tf(t)dt = \int_0^\infty R(t)dt$ 
		   Dla rozkładu wykładniczego $T_{FF} = \frac{1}{\lambda}$ 
3. Rozkłady zmiennych losowych stosowane w opisie niezawodności elementów
	1. Rozkład wykładniczy 
		   $F(t)=1-e^{-\lambda t}$
		   $f(t)=\lambda e^{-\lambda t}$
		   dla $t\gt=0; \lambda\gt0$ -gęstość rozkładu
	2. Rozkład Weibulla
		   $F(t)=1-e^{(-\lambda t)^\beta}$
		   $f(t)=\lambda\beta(\lambda t)^{\beta-1} e^{(-\lambda t)^\beta}$
		   dla $t\gt0; F(0)=0$ - gęstość rozkładu
	3. Rozkład Gamma
	4. Rozkład Erlanga (Rozkład gamma dla $\beta=n=2,3,...$) (Suma n zmiennych losowych o rozkładzie wykładniczych)
	5. Rozkład normalny