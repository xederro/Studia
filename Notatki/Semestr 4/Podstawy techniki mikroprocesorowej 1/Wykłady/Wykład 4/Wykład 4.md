tts

DMA
	element obsługujący transmisje I/O <-> pamięć
	gdy omija procesor
	gdy jest zadanie to je próbuje wykonać nieważne co
	**Tryby pracy**:
		blokowy
			cały blok przesyłany jednym ciągiem
			dobre jak czas krytyczny
		z wykradaniem taktów
			transmisja poszarpana
			procesor panuje nad magistralą
		zgodnie z zapotrzebowaniem
			informuje ile będzie danych (max blok)
			ile będzie naprawdę to zagadka
	Jak to działa?
		Zamówienie:
			Adresowanie - początek obszaru pamięci
			Licznikowe - ile słów przyjąć, podać
			Sterujące - tryb pracy i kierunek