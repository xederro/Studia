ljmp start
			
org 0100h
	start:	mov a, #01h
		mov r0, #02h
		add a, r0

		mov a, #10h
		mov r1, #02h
		clr c
		subb a, r1

		mov a, #02h	; mnożna
		mov b, #04h	; mnożnik
		mul ab		; wynik w b-a

		mov a, #10h	; dzielna
		mov b, #02h	; dzielnik
		div ab		; wynik w a, reszta z dzielenia w b

		mov r1, #02h	; pierwszy argument r1-r0
		mov r0, #0ffh
		
		mov r3, #01h	; drugi argument r3-r2
		mov r2, #02h

		mov a, r0	; dodawanie młodszych części
		add a, r2
		mov r4, a	; młodsza część wyniku

		mov a, r1	; dodawanie starszych części
		addc a, r3
		mov r5, a	; starsza część wyniku
		
	nop
	nop
	nop
	jmp $
	end start