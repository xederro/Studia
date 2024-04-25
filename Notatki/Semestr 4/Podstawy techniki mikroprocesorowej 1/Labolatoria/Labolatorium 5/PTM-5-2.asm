LJMP START

ORG 000BH     ; obsluga przerwania
	MOV TH0, #3CH ; przeladowanie
	MOV TL0, #0B0H ; stalej timera
	DEC R0        ; korekta licznika
	RETI          ; powrót z przerwania
	
ORG 0100H        ; program glówny
START:
		MOV TMOD, #01H ; konfiguracja
		MOV TH0, #3CH ; ladowanie
		MOV TL0, #0B0H ; stalej timera
		SETB TR0      ; timer start
		MOV IE, #82H  ; przerwania wlacz
		MOV A, #00H   ; zapalenie
		MOV P1, A     ; diód
DALEJ:  MOV R0, #14H ; licznik odmierzen
CZEKAM: MOV A, R0    ; czekam, a timer
		JNZ CZEKAM   ; mierzy laczny czas
		MOV A, P1    ; zmiana
		CPL A        ; swiecenia
		MOV P1, A    ; diód
		JMP DALEJ    ; licze od nowa
		NOP
		NOP
		NOP
		JMP $
END START