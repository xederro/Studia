ljmp start

P5 equ 0F8H
P7 equ 0DBH
	
// linie klawiatury - sterowanie na port P5
#define LINE_1		0x7f	// 0111 1111
#define LINE_2_3	0x9f	// 1001 1111
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


// przekodowanie kodów skaningowych na dźwięki dla klawiatury 3-kolumnowej - THO i R6
org 04EEH
 jedynka_H: db 0F8H
org 04EDH
 dwojka_H: db 0F9H
org 04EBH
 trojka_H: db 0FAH
org 049EH
 czworka_H: db 0FAH
org 049DH
 piatka_H: db 0FBH
org 049BH
 szostka_H: db 0FBH
org 047EH
 gwiazdka_H: db 0FCH
org 047DH
 zerowka_H: db 0FCH
org 047BH
 hasz_H: db 0FCH

// przekodowanie kodów skaningowych na dźwięki dla klawiatury 3-kolumnowej - TLO i R7
org 03EEH
 jedynka_L: db 89H
org 03EDH
 dwojka_L: db 5AH
org 03EBH
 trojka_L: db 13H
org 039EH
 czworka_L: db 68H
org 039DH
 piatka_L: db 04H
org 039BH
 szostka_L: db 90H
org 037EH
 gwiazdka_L: db 0CH
org 037DH
 zerowka_L: db 45H
org 037BH
 hasz_L: db 0ADH


org 0100H

 
// program glówny
    start:  		
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
			mov dph, #04h	; ładowanie wartości TH0 i R6
			mov dpl, a
			clr a
			movc a,@a+dptr
			mov R6, a
			mov TH0, a
			mov a, r2
			mov dph, #03h	; ładowanie wartości TL0 i R7
			mov dpl, a
			clr a
			movc a,@a+dptr
			mov R7, a
			mov TL0, a
			setb TR0	; włączenie timera - włączenie dźwięku
			jmp key_1
			
	key_2:	mov r0, #LINE_2_3
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
			jz key_2
			mov a, r2
			mov r4, a
			mov dph, #04h
			mov dpl, a
			clr a
			movc a,@a+dptr
			mov R6, a
			mov TH0, a
			mov a, r2
			mov dph, #03h
			mov dpl, a
			clr a
			movc a,@a+dptr
			mov R7, a
			mov TL0, a
			setb TR0
			jmp key_2
			
			
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
			mov dph, #04h
			mov dpl, a
			clr a
			movc a,@a+dptr
			mov R6, a
			mov TH0, a
			mov a, r2
			mov dph, #03h
			mov dpl, a
			clr a
			movc a,@a+dptr
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
