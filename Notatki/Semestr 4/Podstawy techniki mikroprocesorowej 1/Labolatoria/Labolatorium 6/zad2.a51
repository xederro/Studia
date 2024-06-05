ljmp start

P5 equ 0F8H
P7 equ 0DBH

LCDstatus  equ 0FF2EH       ; adres do odczytu gotowosci LCD
LCDcontrol equ 0FF2CH       ; adres do podania bajtu sterujacego LCD
LCDdataWR  equ 0FF2DH       ; adres do podania kodu ASCII na LCD

// bajty sterujace LCD, inne dostepne w opisie LCD na stronie WWW
#define  HOME     0x80     // put cursor to second line  
#define  INITDISP 0x38     // LCD init (8-bit mode)  
#define  HOM2     0xc0     // put cursor to second line  
#define  LCDON    0x0e     // LCD nn, cursor off, blinking off
#define  CLEAR    0x01     // LCD display clear

// linie klawiatury - sterowanie na port P5
#define LINE_1		0x7f	// 0111 1111
#define LINE_2		0xbf	// 1011 1111
#define	LINE_3		0xdf	// 1101 1111
#define LINE_4		0xef	// 1110 1111

ORG 000BH     ; obsluga przerwania
	CPL P3.2	; ruch membran¹ brzêczyka
	PUSH ACC	; na wszelki wypadek
	MOV A, R6	; prze³adowanie
	MOV TH0, A 	; stalej timera
	MOV A, R7
	MOV TL0, A
	POP ACC      	; odtworzenie akumulatora
	RETI          ; powrót z przerwania


org 0050H
// deklaracje tekstów
	C1:      db "C",00
	CIS:	db "CIS",00
	D:	db "D",00
	DIS:	db "DIS",00
	E:      db "E",00
	F:	db "F",00
	FIS:	db "FIS",00
	G:	db "G",00
	GIS:    db "GIS",00
	A1:	db "A",00
	B1:	db "B",00
	H:	db "H",00
	C2:	db "C2",00
	CIS2:   db "CIS2",00
	D2:     db "D2",00
	DIS2:   db "DIS2",00

org 0100H
		
// tablica przekodowania klawisze - dŸwiêki w XRAM


keymuz:		
			mov dptr, #8077H
			mov a, #89H
			movx @dptr, a
			
			mov dptr, #807BH
			mov a, #0F4H
			movx @dptr, a
			
			mov dptr, #807DH
			mov a, #5AH
			movx @dptr, a

			mov dptr, #807EH
			mov a, #0B9H
			movx @dptr, a

			mov dptr, #80B7H
			mov a, #13H
			movx @dptr, a
			
			mov dptr, #80BBH
			mov a, #68H
			movx @dptr, a
			
			mov dptr, #80BDH
			mov a, #0B9H
			movx @dptr, a

			mov dptr, #80BEH
			mov a, #04H
			movx @dptr, a

			mov dptr, #80D7H
			mov a, #4CH
			movx @dptr, a

			mov dptr, #80DBH
			mov a, #90H
			movx @dptr, a

			mov dptr, #80DDH
			mov a, #0CFH
			movx @dptr, a

			mov dptr, #80DEH
			mov a, #0CH
			movx @dptr, a

			mov dptr, #80E7H
			mov a, #45H
			movx @dptr, a

			mov dptr, #80EBH
			mov a, #7AH
			movx @dptr, a
			
			mov dptr, #80EDH
			mov a, #0ADH
			movx @dptr, a

			mov dptr, #80EEH
			mov a, #0DDH
			movx @dptr, a
			
			mov dptr, #8177H
			mov a, #0F8H
			movx @dptr, a
			
			mov dptr, #817BH
			mov a, #0F8H
			movx @dptr, a
			
			mov dptr, #817DH
			mov a, #0F9H
			movx @dptr, a

			mov dptr, #817EH
			mov a, #0F9H
			movx @dptr, a

			mov dptr, #81B7H
			mov a, #0FAH
			movx @dptr, a
			
			mov dptr, #81BBH
			mov a, #0FAH
			movx @dptr, a
			
			mov dptr, #81BDH
			mov a, #0FAH
			movx @dptr, a

			mov dptr, #81BEH
			mov a, #0FBH
			movx @dptr, a

			mov dptr, #81D7H
			mov a, #0FBH
			movx @dptr, a

			mov dptr, #81DBH
			mov a, #0FBH
			movx @dptr, a

			mov dptr, #81DDH
			mov a, #0FBH
			movx @dptr, a

			mov dptr, #81DEH
			mov a, #0FCH
			movx @dptr, a

			mov dptr, #81E7H
			mov a, #0FCH
			movx @dptr, a

			mov dptr, #81EBH
			mov a, #0FCH
			movx @dptr, a
			
			mov dptr, #81EDH
			mov a, #0FCH
			movx @dptr, a

			mov dptr, #81EEH
			mov a, #0FCH
			movx @dptr, a
////////
			mov dptr, #8277H
			mov a, #C1
			movx @dptr, a
			
			mov dptr, #827BH
			mov a, #CIS
			movx @dptr, a
			
			mov dptr, #827DH
			mov a, #D
			movx @dptr, a

			mov dptr, #827EH
			mov a, #DIS
			movx @dptr, a

			mov dptr, #82B7H
			mov a, #E
			movx @dptr, a
			
			mov dptr, #82BBH
			mov a, #F
			movx @dptr, a
			
			mov dptr, #82BDH
			mov a, #FIS
			movx @dptr, a

			mov dptr, #82BEH
			mov a, #G
			movx @dptr, a

			mov dptr, #82D7H
			mov a, #GIS
			movx @dptr, a

			mov dptr, #82DBH
			mov a, #A1
			movx @dptr, a

			mov dptr, #82DDH
			mov a, #B1
			movx @dptr, a

			mov dptr, #82DEH
			mov a, #H
			movx @dptr, a

			mov dptr, #82E7H
			mov a, #C2
			movx @dptr, a

			mov dptr, #82EBH
			mov a, #CIS2
			movx @dptr, a
			
			mov dptr, #82EDH
			mov a, #D2
			movx @dptr, a

			mov dptr, #82EEH
			mov a, #DIS2
			movx @dptr, a

			//
			mov dptr, #8377H
			mov a, #0AH
			movx @dptr, a
			
			mov dptr, #837BH
			mov a, #34H
			movx @dptr, a
			
			mov dptr, #837DH
			mov a, #5CH
			movx @dptr, a

			mov dptr, #837EH
			mov a, #82H
			movx @dptr, a

			mov dptr, #83B7H
			mov a, #0A6H
			movx @dptr, a
			
			mov dptr, #83BBH
			mov a, #0C8H
			movx @dptr, a
			
			mov dptr, #83BDH
			mov a, #0E8H
			movx @dptr, a

			mov dptr, #83BEH
			mov a, #06H
			movx @dptr, a

			mov dptr, #83D7H
			mov a, #22H
			movx @dptr, a

			mov dptr, #83DBH
			mov a, #3DH
			movx @dptr, a

			mov dptr, #83DDH
			mov a, #56H
			movx @dptr, a

			mov dptr, #83DEH
			mov a, #6EH
			movx @dptr, a

			mov dptr, #83E7H
			mov a, #85H
			movx @dptr, a

			mov dptr, #83EBH
			mov a, #9AH
			movx @dptr, a
			
			mov dptr, #83EDH
			mov a, #0AEH
			movx @dptr, a

			mov dptr, #83EEH
			mov a, #0C1H
			movx @dptr, a
			
			mov dptr, #8477H
			mov a, #0FDH
			movx @dptr, a
			
			mov dptr, #847BH
			mov a, #0FDH
			movx @dptr, a
			
			mov dptr, #847DH
			mov a, #0FDH
			movx @dptr, a

			mov dptr, #847EH
			mov a, #0FDH
			movx @dptr, a

			mov dptr, #84B7H
			mov a, #0FDH
			movx @dptr, a
			
			mov dptr, #84BBH
			mov a, #0FDH
			movx @dptr, a
			
			mov dptr, #84BDH
			mov a, #0FDH
			movx @dptr, a

			mov dptr, #84BEH
			mov a, #0FEH
			movx @dptr, a

			mov dptr, #84D7H
			mov a, #0FEH
			movx @dptr, a

			mov dptr, #84DBH
			mov a, #0FEH
			movx @dptr, a

			mov dptr, #84DDH
			mov a, #0FEH
			movx @dptr, a

			mov dptr, #84DEH
			mov a, #0FEH
			movx @dptr, a

			mov dptr, #84E7H
			mov a, #0FEH
			movx @dptr, a

			mov dptr, #84EBH
			mov a, #0FEH
			movx @dptr, a
			
			mov dptr, #84EDH
			mov a, #0FEH
			movx @dptr, a

			mov dptr, #84EEH
			mov a, #0FEH
			movx @dptr, a	
			ret

// macro do wprowadzenia bajtu sterujacego na LCD
LCDcntrlWR MACRO x          ; x – parametr wywolania macra – bajt sterujacy
           LOCAL loop       ; LOCAL oznacza ze etykieta loop moze sie powtórzyc w programie
loop: MOV  DPTR,#LCDstatus  ; DPTR zaladowany adresem statusu
      MOVX A,@DPTR          ; pobranie bajtu z biezacym statusem LCD
      JB   ACC.7,loop       ; testowanie najstarszego bitu akumulatora
                            ; – wskazuje gotowosc LCD
      MOV  DPTR,#LCDcontrol ; DPTR zaladowany adresem do podania bajtu sterujacego
      MOV  A, x             ; do akumulatora trafia argument wywolania macra–bajt sterujacy
      MOVX @DPTR,A          ; bajt sterujacy podany do LCD – zadana akcja widoczna na LCD
      ENDM
	  
// macro do wypisania znaku ASCII na LCD, znak ASCII przed wywolaniem macra ma byc w A
LCDcharWR MACRO
      LOCAL tutu            ; LOCAL oznacza ze etykieta tutu moze sie powtórzyc w programie
      PUSH ACC              ; odlozenie biezacej zawartosci akumulatora na stos
tutu: MOV  DPTR,#LCDstatus  ; DPTR zaladowany adresem statusu
      MOVX A,@DPTR          ; pobranie bajtu z biezacym statusem LCD
      JB   ACC.7,tutu       ; testowanie najstarszego bitu akumulatora
                            ; – wskazuje gotowosc LCD
      MOV  DPTR,#LCDdataWR  ; DPTR zaladowany adresem do podania bajtu sterujacego
      POP  ACC              ; w akumulatorze ponownie kod ASCII znaku na LCD
      MOVX @DPTR,A          ; kod ASCII podany do LCD – znak widoczny na LCD
      ENDM
	  
// macro do inicjalizacji wyswietlacza – bez parametrów
init_LCD MACRO
         LCDcntrlWR #INITDISP ; wywolanie macra LCDcntrlWR – inicjalizacja LCD
         LCDcntrlWR #CLEAR    ; wywolanie macra LCDcntrlWR – czyszczenie LCD
         LCDcntrlWR #LCDON    ; wywolanie macra LCDcntrlWR – konfiguracja kursora
	 LCDcntrlWR #HOME
         ENDM

// funkcja opóznienia
	delay:	mov r3, #15H
	one:	mov r4, #0FFH
	dwa:	mov r5, #0FFH
    trzy:	djnz r5, trzy
			djnz r4, dwa
			djnz r3, one
			ret
			
// funkcja wypisania znaku
putcharLCD:	LCDcharWR
			ret
			
//funkcja wypisania lancucha znaków		
putstrLCD:  clr a
			movc a, @a+dptr
			jz koniec
			push dph
			push dpl
			acall putcharLCD
			pop dpl
			pop dph
			inc dptr
			sjmp putstrLCD
	koniec: ret

wypisz:	mov dph, #82h
	mov dpl, a
	movx a,@dptr
	mov dph, #00h
	mov dpl, a
	acall putstrLCD
	ret
			
//https://i.sadistic.pl/pics/ed7a0bc8fd36.jpg
// program glówny
    start:  		init_LCD
    			acall keymuz
			mov r5, #81
			mov r3, #80
			MOV TMOD, #01H ; konfiguracja
			MOV IE, #82H  ; przerwania wlacz
	graj:		MOV r4, #00H  ; dotychczasowy klawisz
 			CLR TR0      ; timer stop
		

			//CZY JEST KLIKNIETE
			//JEZELI TAK ZAMIENIAMY REJESTR

	przestroj2:
		jb P3.5, przestroj1
		mov r5, #84
		mov r3, #83
	przestroj1:
		jb P3.4, key_1
		mov r5, #81
		mov r3, #80

	key_1:	mov r0, #LINE_1
			mov	a, r0
			mov	P5, a
			mov a, P7
			anl a, r0
			mov r2, a
			clr c
			subb a, r0	; sprawdzenie czy coœ naciœniête
			jz key_2
			mov a, r2
			clr c
			subb a, r4	; sprawdzenie czy ten sam guzik znów naciœniêty
			jz key_1
			LCDcntrlWR #CLEAR
			LCDcntrlWR #HOME
			mov a, r2
			acall wypisz
			mov a, r2
			mov r4,a	; aktualizacja nowego guzika naciœniêtego
			mov dph, r5	; ³adowanie wartoœci TH0 i R6
			mov dpl, a
			movx a,@dptr
			mov R6, a
			mov TH0, a
			mov a, r2
			mov dph, r3	; ³adowanie wartoœci TL0 i R7
			mov dpl, a
			movx a,@dptr
			mov R7, a
			mov TL0, a
			setb TR0	; w³¹czenie timera - w³¹czenie dŸwiêku
			jmp key_1
			
	key_2:	mov r0, #LINE_2
			mov	a, r0
			mov	P5, a
			mov a, P7
			anl a, r0
			mov r2, a
			clr c
			subb a, r0
			jz key_3
			mov a, r2
			clr c
			subb a, r4
			jz key_2
			LCDcntrlWR #CLEAR
			LCDcntrlWR #HOME
			mov a, r2
			acall wypisz
			mov a, r2
			mov r4, a
			mov a, r2
			mov dph, r5
			mov dpl, a
			movx a,@dptr
			mov R6, a
			mov TH0, a
			mov a, r2
			mov dph, r3
			mov dpl, a
			movx a,@dptr
			mov R7, a
			mov TL0, a
			setb TR0
			jmp key_2
			
	key_3:	mov r0, #LINE_3
			mov	a, r0
			mov	P5, a
			mov a, P7
			anl a, r0
			mov r2, a
			clr c
			subb a, r0
			jz key_4
			mov a, r2
			clr c
			subb a, r4
			jz key_3
			LCDcntrlWR #CLEAR
			LCDcntrlWR #HOME
			mov a, r2
			acall wypisz
			mov a, r2
			mov r4,a
			mov dph, r5
			mov dpl, a
			movx a,@dptr
			mov R6, a
			mov TH0, a
			mov a, r2
			mov dph, r3
			mov dpl, a
			movx a,@dptr
			mov R7, a
			mov TL0, a
			setb TR0
			jmp key_3
			
	key_4:	mov r0, #LINE_4
			mov	a, r0
			mov	P5, a
			mov a, P7
			anl a, r0
			mov r2, a
			clr c
			subb a, r0
			jz dalej
			mov a, r2
			clr c
			subb a, r4
			jz key_4
			LCDcntrlWR #CLEAR
			LCDcntrlWR #HOME
			mov a, r2
			acall wypisz
			mov a, r2
			mov r4,a
			mov dph, r5
			mov dpl, a
			movx a,@dptr
			mov R6, a
			mov TH0, a
			mov a, r2
			mov dph, r3
			mov dpl, a
			movx a,@dptr
			mov R7, a
			mov TL0, a
			setb TR0
			jmp key_4	
	dalej:		
	
			LCDcntrlWR #CLEAR
			LCDcntrlWR #HOME
			jmp graj    
 
    nop
    nop
    nop
    jmp $
    end start
