ljmp start
	
LCDstatus  equ 0FF2EH       ; adres do odczytu gotowosci LCD
LCDcontrol equ 0FF2CH       ; adres do podania bajtu sterujacego LCD
LCDdataWR  equ 0FF2DH       ; adres do podania kodu ASCII na LCD
		  
P5 equ 0F8H
P7 equ 0DBH

RTCxs equ 0FF00H	; seconds
RTCsx equ 0FF01H
RTCxm equ 0FF02H	; minutes
RTCmx equ 0FF03H
RTCxh equ 0FF04H	; hours
RTChx equ 0FF05H
RTCxd equ 0FF06H	; day
RTCdx equ 0FF07H
RTCxn equ 0FF08H	; month
RTCnx equ 0FF09H
RTCxy equ 0FF0AH	; year
RTCyx equ 0FF0BH
RTCdw equ 0FF0CH	; day of week
RTCpf equ 0FF0FH


// linie klawiatury - sterowanie na port P5
#define LINE_1		0x7f	// 0111 1111
#define LINE_2		0xbf	// 1011 1111
#define	LINE_3		0xdf	// 1101 1111
#define LINE_4		0xef	// 1110 1111
#define ALL_LINES	0x0f	// 0000 1111


// bajty sterujace LCD, inne dostepne w opisie LCD na stronie WWW
#define  HOME     0x80     // put cursor to second line  
#define  INITDISP 0x38     // LCD init (8-bit mode)  
#define  HOM2     0xc0     // put cursor to second line  
#define  LCDON    0x0e     // LCD nn, cursor off, blinking off
#define  CLEAR    0x01     // LCD display clear

org 0100H
	Separator: db ":"
	Czas: db "13:40:00"
	Dzien: db "30:05:2022*1"
	Month: db "JanFebMarAprMayJunJulAugSepOctNovDec"
	Week: db "SunMonTueWedThuFriSat"
	TwentyH: db "2"
	TwentyL: db "0"
		
// macro do wprowadzenia bajtu sterujacego na LCD
LCDcntrlWR MACRO x          ; x ? parametr wywolania macra ? bajt sterujacy
           LOCAL loop       ; LOCAL oznacza ze etykieta loop moze sie powt?rzyc w programie
loop: MOV  DPTR,#LCDstatus  ; DPTR zaladowany adresem statusu
      MOVX A,@DPTR          ; pobranie bajtu z biezacym statusem LCD
      JB   ACC.7,loop       ; testowanie najstarszego bitu akumulatora
                            ; ? wskazuje gotowosc LCD
      MOV  DPTR,#LCDcontrol ; DPTR zaladowany adresem do podania bajtu sterujacego
      MOV  A, x             ; do akumulatora trafia argument wywolania macra?bajt sterujacy
      MOVX @DPTR,A          ; bajt sterujacy podany do LCD ? zadana akcja widoczna na LCD
      ENDM
	  
// macro do wypisania znaku ASCII na LCD, znak ASCII przed wywolaniem macra ma byc w A
LCDcharWR MACRO
      LOCAL tutu            ; LOCAL oznacza ze etykieta tutu moze sie powt?rzyc w programie
      PUSH ACC              ; odlozenie biezacej zawartosci akumulatora na stos
tutu: MOV  DPTR,#LCDstatus  ; DPTR zaladowany adresem statusu
      MOVX A,@DPTR          ; pobranie bajtu z biezacym statusem LCD
      JB   ACC.7,tutu       ; testowanie najstarszego bitu akumulatora
                            ; ? wskazuje gotowosc LCD
      MOV  DPTR,#LCDdataWR  ; DPTR zaladowany adresem do podania bajtu sterujacego
      POP  ACC              ; w akumulatorze ponownie kod ASCII znaku na LCD
      MOVX @DPTR,A          ; kod ASCII podany do LCD ? znak widoczny na LCD
      ENDM
	  
// macro do inicjalizacji wyswietlacza ? bez parametr?w
init_LCD MACRO
         LCDcntrlWR #INITDISP ; wywolanie macra LCDcntrlWR ? inicjalizacja LCD
         LCDcntrlWR #CLEAR    ; wywolanie macra LCDcntrlWR ? czyszczenie LCD
         LCDcntrlWR #LCDON    ; wywolanie macra LCDcntrlWR ? konfiguracja kursora
         ENDM

// macro do wypisywania polowki wskazania pozycji czasu lub daty
disp_nibble MACRO
	movx A,@DPTR
	anl A,#0Fh	; select 4-bits
	orl A,#30H	; change to ASCII
	call putcharLCD
	ENDM

// funkcja wypisania liczby dla potrzeb zegara
putdigitLCD:	mov b, #10
				div ab				; uzyskanie cyfry dziesiatek
				add a, #30H			; konwersja cyfry na kod ASCII
				acall putcharLCD
				mov a, b			; ladowanie cyfry jednosci
				add a, #30H			; konwersja na LCD
				acall putcharLCD
				ret


// funkcja wypisywania znaku na LCD
putcharLCD:	LCDcharWR
			ret


keyascii:	mov dptr, #80EBH
			mov a, #0
			movx @dptr, a
			
			mov dptr, #8077H
			mov a, #1
			movx @dptr, a
			
			mov dptr, #807BH
			mov a, #2
			movx @dptr, a
			
			mov dptr, #807DH
			mov a, #3
			movx @dptr, a
			
			mov dptr, #80B7H
			mov a, #4
			movx @dptr, a
			
			mov dptr, #80BBH
			mov a, #5
			movx @dptr, a
			
			mov dptr, #80BDH
			mov a, #6
			movx @dptr, a
			
			mov dptr, #80D7H
			mov a, #7
			movx @dptr, a
			
			mov dptr, #80DBH
			mov a, #8
			movx @dptr, a
			
			mov dptr, #80DDH
			mov a, #9
			movx @dptr, a
			
			mov dptr, #807EH
			mov a, #"A"
			movx @dptr, a
			
			mov dptr, #80BEH
			mov a, #"B"
			movx @dptr, a
			
			mov dptr, #80DEH
			mov a, #"C"
			movx @dptr, a
			
			mov dptr, #80EEH
			mov a, #"D"
			movx @dptr, a
			
			mov dptr, #80E7H
			mov a, #"*"
			movx @dptr, a
			
			mov dptr, #80EDH
			mov a, #"#"
			movx @dptr, a
			
			ret
		 
// wypisywanie czasu
disp_time:
		LCDcntrlWR #HOME
		mov DPTR,#RTChx	; get hours from RTC (higher nibble)
		disp_nibble
		mov DPTR,#RTCxh	; get hours from RTC (lower nibble)
		disp_nibble
		mov A,#':'
		call putcharLCD
		mov DPTR,#RTCmx	; get minutes from RTC (higher nibble)
		disp_nibble
		mov DPTR,#RTCxm	; get minutes from RTC (lower nibble)
		disp_nibble
		mov A,#':'
		call putcharLCD;
		mov DPTR,#RTCsx	; get seconds from RTC (higher nibble)
		disp_nibble
		mov DPTR,#RTCxs	; get seconds from RTC (lower nibble)
		disp_nibble
		RET

// wypisywanie dnia tygodnia slownie
week_word:
		mov DPTR,#RTCdw	; get day of week from RTC
		movx a, @DPTR
		anl a, #0FH
		mov b, #03
		mul ab
		mov r7,a
		mov DPTR,#Week
		movc a,@a+dptr
		push dph
		push dpl
		acall putcharLCD
		pop dpl
		pop dph
		inc dptr
		mov a,r7
		movc a,@a+dptr
		push dph
		push dpl
		acall putcharLCD
		pop dpl
		pop dph
		inc dptr
		mov a,r7
		movc a,@a+dptr
		acall putcharLCD
		ret

delay:		
	mov a, P7
	anl a, r0
	clr c
	subb a, r2
	jz delay
	ret
			
// wypisywanie nazwy miesiaca slownie
month_word:
		mov DPTR,#RTCnx	; get month from RTC (higher nibble)
		movx a, @DPTR
		anl a, #0FH
		mov b, #10
		mul ab
		mov r7,a
		mov DPTR,#RTCxn	; get month from RTC (lower nibble)
		movx a, @DPTR
		anl a, #0FH
		add a,r7
		clr c
		subb a, #01
		mov b, #03
		mul ab
		mov r7,a
		mov DPTR,#Month
		movc a,@a+dptr
		push dph
		push dpl
		acall putcharLCD
		pop dpl
		pop dph
		inc dptr
		mov a,r7
		movc a,@a+dptr
		push dph
		push dpl
		acall putcharLCD
		pop dpl
		pop dph
		inc dptr
		mov a,r7
		movc a,@a+dptr
		acall putcharLCD
		ret

// wypisywanie daty
disp_date:
	LCDcntrlWR #HOM2
	mov DPTR,#RTCdx	; get day from RTC (higher nibble)
	disp_nibble
	mov DPTR,#RTCxd	; get day from RTC (lower nibble)
	disp_nibble
	mov A,#'-'
	call putcharLCD
	acall month_word
	mov A,#'-'
	call putcharLCD;
	clr a
	mov DPTR,#TwentyH
	movc a,@a+dptr
	call putcharLCD;
	clr a
	mov DPTR,#TwentyL
	movc a, @a+dptr
	call putcharLCD;
	mov DPTR,#RTCyx	; get year from RTC (higher nibble)
	disp_nibble
	mov DPTR,#RTCxy	; get year from RTC (lower nibble)
	disp_nibble
	mov A,#" "
	call putcharLCD;
	acall week_word
	RET


dumb_delay:	mov r1, #0FFH
		dwa:	mov r2, #0FFH
		trzy:	djnz r2, trzy
			djnz r1, dwa
			ret
setData:
	LCDcntrlWR #CLEAR // czyszczenie ekranu
	LCDcntrlWR #HOME // ustawienie w pierwszej linii
	clr c
	mov r5, #0H // zaladowanie poczatkowej wartosci dla danych
	mov r3, #1H
	key_1h: mov r0, #LINE_1
		mov a, r0
		mov P5, a
		mov a, P7
		anl a, r0
		mov r2, a
		clr c
		subb a, r0
		jz key_2h // nie wcisnieto tego klawisza, skocz zeby sprawdzic nastepny
		acall delay // czekam zeby wygodniej wciskalo sie klawisze
		mov a, r2
		mov dph, #80h
		mov dpl, a
		movx a,@dptr // konwersja wartosci scaningowej na wartosc przycisku
		djnz r3, mniej1 //jezeli 0 to bedzie wpisana mniej znaczaca wartosc
		clr c
		mov b, #10 // zaladuj 10 do rejestru b
		mul ab // jesli jestesmy tutaj to znaczy ze wpisana np. 2, to tak naprawde 20, przemnoz ja przez 10
		clr c
		mov r5, a // wpisz wartosc danych do r5
		mov r3, #2H // markujemy ze wpisano juz bardziej znaczaco cyfre
		sjmp key_2h
		mniej1:
		clr c
		add a, r5 // dodajemy mniej znaczaca liczbe do bardziej znaczacej ktora juz jest w r5
		clr c
		mov r5, a
		sjmp checkValid // sprawdzamy poprawnosc wpisanych danych

	key_2h: mov r0, #LINE_2
		mov a, r0
		mov P5, a
		mov a, P7
		anl a, r0
		mov r2, a
		clr c
		subb a, r0
		jz key_3h // nie wcisnieto tego klawisza, skocz zeby sprawdzic nastepny
		acall delay // czekam zeby wygodniej wciskalo sie klawisze
		mov a, r2
		mov dph, #80h
		mov dpl, a
		movx a,@dptr // konwersja wartosci scaningowej na wartosc przycisku
		djnz r3, mniej2 //jezeli 0 to bedzie wpisana mniej znaczaca wartosc
		clr c
		mov b, #10 // zaladuj 10 do rejestru b
		mul ab // jesli jestesmy tutaj to znaczy ze wpisana np. 2, to tak naprawde 20, przemnoz ja przez 10
		clr c
		mov r5, a // wpisz wartosc danych do r5
		mov r3, #2H // markujemy ze wpisano juz bardziej znaczaco cyfre
		sjmp key_3h
		mniej2:
		clr c
		add a, r5 // dodajemy mniej znaczoca liczbe do bardziej znaczacej ktora juz jest w r5
		clr c
		mov r5, a
		sjmp checkValid // sprawdzamy poprawnosc wpisanych danych

	key_3h: mov r0, #LINE_3
		mov a, r0
		mov P5, a
		mov a, P7
		anl a, r0
		mov r2, a
		clr c
		subb a, r0
		jz key_4h // nie wcisnieto tego klawisza, skocz zeby sprawdzic nastepny
		acall delay // czekam zeby wygodniej wciskalo sie klawisze
		mov a, r2
		mov dph, #80h
		mov dpl, a
		movx a,@dptr // konwersja wartosci scaningowej na wartosc przycisku
		djnz r3, mniej3 //jezeli 0 to bedzie wpisana mniej znaczaca wartosc
		clr c
		mov b, #10 // zaladuj 10 do rejestru b
		mul ab // jesli jestesmy tutaj to znaczy ze wpisana np. 2, to tak naprawde 20, przemnoz ja przez 10
		clr c
		mov r5, a // wpisz wartosc danych do r5
		mov r3, #2H // markujemy ze wpisano juz bardziej znaczaca cyfre
		sjmp key_4h
		mniej3:
		clr c
		add a, r5 // dodajemy mniej znaczoca liczbe do bardziej znaczacej ktora juz jest w r5
		clr c
		mov r5, a
		sjmp checkValid // sprawdzamy poprawnosc wpisanych danych

	key_4h: mov r0, #LINE_4
		mov a, r0
		mov P5, a
		mov a, P7
		anl a, r0
		mov r2, a
		clr c
		subb a, r0
		jz toTheBeginingH // nie wcisnieto tego klawisza, skocz zeby sprawdzic nastepny
		acall delay // czekam zeby wygodniej wciskalo sie klawisze
		mov a, r2
		mov dph, #80h
		mov dpl, a
		movx a,@dptr // konwersja wartosci scaningowej na wartosc przycisku
		djnz r3, mniej4 //jezeli 0 to bedzie wpisana mniej znaczaca wartosc
		clr c
		mov b, #10 // zaladuj 10 do rejestru b
		mul ab // jesli jestesmy tutaj to znaczy ze wpisana np. 2, to tak naprawde 20, przemnoz ja przez 10
		clr c
		mov r5, a // wpisz wartosc danych do r5
		mov r3, #2H // markujemy ze wpisano juz bardziej znaczaca cyfre
		sjmp toTheBeginingH
		mniej4:
		clr c
		add a, r5 // dodajemy mniej znaczoca liczbe do bardziej znaczacej ktora juz jest w r5
		clr c
		mov r5, a
		sjmp checkValid // sprawdzamy poprawnosc wpisanych danych
		toTheBeginingH:
		jmp key_1h

	// w r6 mamy wartosc maksa z ktora sprawdzamy
	checkValid:
		mov a, r5 // ladujemy godzine do akumulatora
		acall putdigitLCD // wypisujemy na ekranie
		acall dumb_delay  //tylko po to
		acall dumb_delay  //by było widać
		acall dumb_delay  //co wprowadziliśmy
		acall dumb_delay  //przed kolejną cześcią programu
		clr c
		mov a, r6 // ladujemy maks wartosc godziny do akumulatora
		subb a, r5 // odejmujemy nasza wartosc od zapisanej jako max
		jc inBetweenHour // jesli jest flaga carry, to znaczy ze podane dane byly wieksze od max, czyli nieprawidlowe
		clr c
		mov a, r5
		mov b, #10		//rozdzielamy dane na starszą i młodszą część
		div ab
		mov r5, a
		mov r7, b
		ret
		inBetweenHour: jmp setData // wpisano nieprawidlowe dane, podawaj jeszcze raz
	

// inicjalizacja czasu
czas_start:
		
		mov DPTR, #RTCpf ; 24h zegar
		movx a, @DPTR
		orl a, #04H
		movx @DPTR, a
		clr c
		clr a

		//pobieranie danych
		//po setData
		//w r5 mamy starsz? godzine 
		//w r7 mamy m?odsz? godzine
		mov r6, #24
		acall setData
		mov dptr, #RTChx
		mov a, r5
		movx @dptr, a
		clr a
		mov a, r7
		mov dptr, #RTCxh
		movx @dptr, a
		clr a

		//minuta
		mov r6, #60
		acall setData
		mov dptr, #RTCmx
		mov a, r5
		movx @dptr, a
		clr a
		mov a, r7
		mov dptr, #RTCxm
		movx @dptr, a
		clr a
		
		//sekunda
		mov r6, #60
		acall setData
		mov dptr, #RTCsx
		mov a, r5
		movx @dptr, a
		clr a
		mov a, r7
		mov dptr, #RTCxs
		movx @dptr, a
		clr a
		ret

// inicjalizacja daty
data_start:	
		clr c
		clr a
		
		//rok
		mov r6, #99
		acall setData
		mov dptr, #RTCyx
		mov a, r5
		movx @dptr, a
		clr a
		mov a, r7
		mov dptr, #RTCxy
		movx @dptr, a
		clr a
		
		//miesiac
		zero_miesiac:
		mov r6, #12
		acall setData
		mov a, r7
		mov b, #10
		mul ab
		add a, r5 //w akumulatorze mamy teraz pelny miesiac
		jz zero_miesiac // jezeli zero to powrot
		//jezeli nie to ustawiamy
		mov dptr, #RTCnx
		mov a, r5
		movx @dptr, a
		clr a
		mov a, r7
		mov dptr, #RTCxn
		movx @dptr, a
		clr a  

		//sprawdzanie ktory mamy miesiac i ile dni nalezy wprowadzic
		mov a, r7
		mov b, #10
		mul ab
		add a, r5 			//w akumulatorze mamy teraz pelny miesiac
		mov r6, a
		clr c
		subb a, #2
		jz luty
		clr c
		mov a, r6
		subb a, #8
		jc przed_sierpien // jezeli sierpien i potem to dodajemy 1
		inc r6		
		przed_sierpien:
		mov a, r6
		mov b, #2
		div ab
		mov a, #30
		add a, b		  // jezeli jest parzyste (od 8 miesiaca jest +1 wiec wlasnosc jest zachowana)
		clr c
		sjmp nieluty
		luty:
		mov a, #28
		nieluty:
		mov r6, a
		//wpisujemy dni
		acall setData
		mov dptr, #RTCdx
		mov a, r5
		movx @dptr, a
		clr a
		mov a, r7
		mov dptr, #RTCxd
		movx @dptr, a
		clr a  
		// wpisujemy dzien tygodnia
	    mov r6, #7
		acall setData
		mov dptr, #RTCdw
		mov a, r7
		movx @dptr, a 
		clr a
		ret


        ; program gl?wny
start:	init_LCD
		acall keyascii
		acall czas_start
		acall data_start

		
czas_plynie:	acall disp_time
				acall disp_date
				sjmp czas_plynie
		NOP
		NOP
		NOP
		JMP $
END START