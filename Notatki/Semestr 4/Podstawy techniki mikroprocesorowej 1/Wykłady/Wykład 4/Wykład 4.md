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


Pamięć
	pamięć programu i danych - zadania, argumenty rezultaty
	parametry
		pojemność - liczba pamiętanych słów określonej szerokości
		organizacja - dopasowanie do magistrali
		czas dostępu - ile trzeba czekać by otrzymać dane
	ROM
		Read Only Memory - różne typy organizacji, szybkie, różne pojemności, nieulotna
		PROM - szybsze, mniejsze pojemności, raz programowalne
		EPROM - wolne, duże pojemności, programowalna wiele razy, wyczyszczane ultrafioletem, zjawisko fotoelektryczne zewnętrzne, tranzystory z pływającą bramką
		EEPROM - różne typy organizacji, wolne, duże pojemności, programowalne wiele razy, programowanie online w przeciwieństwie do wcześniejszych, elektrycznie kasowalny, kasowanie blokowe
		EAPROM - eeprom ale kasowanie wybiórcze nawet pojedynczych bitów #kolokwium 
	RAM
		SRAM - szybkie, przerzutnik bistabilny, jest prąd jest pamięć, nie trzeba odświeżać, półprzewodnikowe, małe systemy, 
		DRAM - szybkie, różne pojemności, kondensator, jest prąd jest pamięć, trzeba odświerzać, duże systemy otwarte, pamięć półprzewodnikowa
	Cykl odczytu ROM / SRAM
		#kolokwium 
		oczyt
		1. wysterowanie adresu
		2. CS(chip select) dekoder pewien na 1zn i określony układ jest włączany
		3. OE(output enable) czy też memory read i możemy brać się za odczyt (wskazanie kierunku) 
		4. odbieramy dane, pojawiają się na szynie
		5. wyłącza się sterowanie
		zapis
		1. wysterowanie adresu
		2. CS(Chip select) dekoder pewien na 1zn i określony układ jest włączany
		3. ustawiamy ważne dane
		4. OE(output enable) informujemy że można zapisać
		5. wyłączenie sterowania
	DRAM
		oczyt
		1. podajemy adres wiersza
		2. RAS row adres select na 0 informacja że to ważny adres
		3. podajemy adres korumny
		4. CAS column adres select na 0 i mamy ważny adres
		5. linia read mówi że czytamy
		6. mamy pobrane dane
		zapis
		
