ljmp start

P5 equ 0F8H
P7 equ 0DBH
	
// linie klawiatury - sterowanie na port P5
#define LINE_1		0x7f	// 0111 1111
#define LINE_2		0xbf	// 1011 1111
#define	LINE_3		0xdf	// 1101 1111
#define LINE_4		0xef	// 1110 1111

ORG 000BH     ; obsluga przerwania
	CPL P3.2	; ruch membraną brzęczyka
	PUSH ACC	; na wszelki wypadek
	MOV A, R6	; przeładowanie
	MOV TH0, A 	; stalej timera
	MOV A, R7
	MOV TL0, A
	POP ACC      	; odtworzenie akumulatora
	RETI          ; powrót z przerwania


org 0100H
		
// tablica przekodowania klawisze - dźwięki w XRAM

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
					
			ret
 
// program glówny
    start:  		acall keymuz
			MOV TMOD, #01H ; konfiguracja
			MOV IE, #82H  ; przerwania wlacz
	graj:		MOV r4, #00H  ; dotychczasowy klawisz
 			CLR TR0      ; timer stop
		
	key_1:	mov r0, #LINE_1
			mov	a, r0
			mov	P5, a
			mov a, P7
			anl a, r0
			mov r2, a
			clr c
			subb a, r0	; sprawdzenie czy coś naciśnięte
			jz key_2
			mov a, r2
			clr c
			subb a, r4	; sprawdzenie czy ten sam guzik znów naciśnięty
			jz key_1
			mov a, r2
			mov r4,a	; aktualizacja nowego guzika naciśniętego
			mov dph, #81h	; ładowanie wartości TH0 i R6
			mov dpl, a
			movx a,@dptr
			mov R6, a
			mov TH0, a
			mov a, r2
			mov dph, #80h	; ładowanie wartości TL0 i R7
			mov dpl, a
			movx a,@dptr
			mov R7, a
			mov TL0, a
			setb TR0	; włączenie timera - włączenie dźwięku
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
			mov a, r2
			mov r4, a
			mov a, r2
			mov dph, #81h
			mov dpl, a
			movx a,@dptr
			mov R6, a
			mov TH0, a
			mov a, r2
			mov dph, #80h
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
			mov a, r2
			mov r4,a
			mov dph, #81h
			mov dpl, a
			movx a,@dptr
			mov R6, a
			mov TH0, a
			mov a, r2
			mov dph, #80h
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
			mov a, r2
			mov r4,a
			mov dph, #81h
			mov dpl, a
			movx a,@dptr
			mov R6, a
			mov TH0, a
			mov a, r2
			mov dph, #80h
			mov dpl, a
			movx a,@dptr
			mov R7, a
			mov TL0, a
			setb TR0
			jmp key_4	
	dalej:		jmp graj    
 
    nop
    nop
    nop
    jmp $
    end start
