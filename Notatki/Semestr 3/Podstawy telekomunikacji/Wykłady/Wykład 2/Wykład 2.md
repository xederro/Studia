![](/Notatki/Semestr%203/Podstawy%20telekomunikacji/Wykłady/Wykład%202/PT%20-%20wykład%20nr%202%20(SK).pdf)
hasło: ETEW00004
# Systemy telekomunikacji

Źródło wiadomości -> Nadajnik -> Medium transmisyjne -> Odbiornik -> Odbiorca wiadomości
#kolokwium {kolejność}

---
	**Nadajnik** = Koder źródła -> Koder kanałowy -> Modulator
	**Koder źródła** = Koder kompresji danych -> koder zagęszczenia danych -> koder szyfrujący dane 
	**Koder Kanałowy** 
		Kody blokowe: dzielimy dane na paczki i paczka po paczce kodujemy
		Kodowanie 4B/5B
	**Modulator**
		Modulacja to przeniesienie procesu z częstotliwości sygnału na falę nośną
		sygnał modulujący np. cyfrowy
		sygnał nośny np. wysokiej częstotliwości
		w rezultacie z połączenia mamy sygnał zmodulowany
		Możemy modulować: #kolokwium 
			Amplitude
			Częstotliwość
			Faza
	**Zwielokrotnienie**
		czasowe - możemy nadawać przez jakiś czas
		częstotliwościowe - jedno medium dzielimy na różne częstotliwości 
	**Kanał**
		Media transmisyjne
			Przewodowe - kable miedziane, kable światłowodowe, falowody
			Bezprzewodowe - radiowe, satelitarne, mikrofalowe
		Maksymalna szybkość przesyłania danych
			2Blog(M) - M stanów, B szerokość pasma(Hz)
			Szumy - zakłócenia
				Stosunek sygnał - szum
			więc rzeczywiście M = (S/N) - N - szum, S - sygnał
			ABlog(1+ S/N) #kolokwium  A - ilość anten
			N = kTB #kolokwium zwiększanie B powoduje niezawsze zwiększenie przesyłu
	**Odbiór**
		Detekcja błędów - kontrola parzystości, suma kontrolna, 
		Korekcja błędów - ponowne wysłanie, dodawanie danych dodatkowych
		kodowanie ma zdolność detekcyjną, istnieją też takie która pozwalają na korekcje 
