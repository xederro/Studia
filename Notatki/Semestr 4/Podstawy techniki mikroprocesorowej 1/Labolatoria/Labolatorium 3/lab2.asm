ljmp start

LCDstatus  equ 0FF2EH       ; adres do odczytu gotowosci LCD
LCDcontrol equ 0FF2CH       ; adres do podania bajtu sterujacego LCD
LCDdataWR  equ 0FF2DH       ; adres do podania kodu ASCII na LCD

// bajty sterujace LCD, inne dostepne w opisie LCD na stronie WWW
#define  HOME     0x80     // put cursor to second line  
#define  INITDISP 0x38     // LCD init (8-bit mode)  
#define  HOM2     0xc0     // put cursor to second line  
#define  LCDON    0x0e     // LCD nn, cursor off, blinking off
#define  CLEAR    0x01     // LCD display clear

org 0100H
	
// deklaracje tekstów
	text1:  db "swiecie sobie 1",00
	text2:	db "swiecie sobie 2",00
	text3:	db "swiecie sobie 3",00
	text4: db "swiecie sobie 4",00
		
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
         ENDM

// funkcja opóznienia
	delay:	mov r0, #15H
	one:	mov r1, #0FFH
	dwa:	mov r2, #0FFH
    trzy:	djnz r2, trzy
			djnz r1, dwa
			djnz r0, one
			ret
	
			
//funkcja wypisania lancucha znaków		
putstrLCD:  clr a
			movc a, @a+dptr
			jz koniec1
			push dph
			push dpl
			acall putcharLCD
			pop dpl
			pop dph
			inc dptr
			sjmp putstrLCD
	koniec1: ret

			
// funkcja wypisania znaku
putcharLCD:	LCDcharWR
			ret

loadText1: 
	LCDcntrlWR #CLEAR
	mov dptr, #text1
	jmp pisz
loadText2: 
	LCDcntrlWR #CLEAR
	mov dptr, #text2
	jmp pisz
loadText3: 
	LCDcntrlWR #CLEAR
	mov dptr, #text3
	jmp pisz
loadText4: 
	LCDcntrlWR #CLEAR
	mov dptr, #text4
	jmp pisz
	start:		
		init_LCD
		loop:
			mov a, p3
			mov r0, #00111100b
			anl a, r0
			mov p1, a
			mov r0, a
			subb a, #0Ch
			jz koniec
			mov a, r0
			jnb acc.5, loadText1
			jnb acc.4, loadText2
			jnb acc.3, loadText3
			jnb acc.2, loadText4
			sjmp loop	

		pisz:
			
			acall putstrLCD
			LCDcntrlWR #HOME
			jmp loop			
koniec:	
	LCDcntrlWR #CLEAR		
	nop
	nop
	nop
	jmp $
	end start