ljmp start
			
org 0100h
	dane:	db 01,02,03,04,05,00

	start:	mov dptr, #8000h	; pamięć zewnętrzna danych
		movx a, @dptr		; tryb adresowania rejestrowego pośredniego
		add a, #07h
		movx @dptr, a

		mov a, 10h		; pamięć wewnętrzna danych
		add a, #02h
		mov 10h, a		; tryb adresowania bezpośredniego

		mov r0, #11h		; pamięć wewnętrzna danych
		mov a, @r0		; tryb adresowania rejestrowego pośredniego
		add a, #10h		; tryb adresowania bezpośredniego
		mov @r0, a

		mov r0, #10h		; przepisujemy z pamięci kodu do pamięci wewnętrzenj danych
		mov dptr, #dane
	next:	mov a, #00h
		movc a, @a+dptr
		jz koniec
		mov @r0, a
		inc r0
		inc dptr
		sjmp next

	koniec:	nop
		nop
		nop
		nop
		jmp $
	end start