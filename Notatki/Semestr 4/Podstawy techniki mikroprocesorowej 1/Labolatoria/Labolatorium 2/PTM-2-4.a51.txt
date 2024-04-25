ljmp start

p6	EQU	0FAH

org 050H
	znaki:  db "0123456789",00	; znaki do wyświetlenia na diodach

	delay:	mov r0, #0FFH		; opóźnienie do mrugania
	one:	mov r1, #0FAH
	dwa:	djnz r1, dwa
		djnz r0, one
		ret

	pszesc:	mov a,p6		; obsługa urządzeń na porcie P6
		cpl acc.0
		cpl acc.4
		cpl acc.6
		mov p6,a
		ret

    	swiec:  clr a			; wyświetlanie znaków zdefiniowanych uprzednio
	    	mov dptr, #znaki
	dalej:	movc a, @a+dptr
		jz koniec
		mov p1, a
		acall delay
		clr a
		inc dptr
		jmp dalej
	koniec: ret
			
org 0100h
	start:	acall swiec
	        mov a, #55H
		cpl p3.2
		mov p1, a
		acall delay
		mov a, #0AAh
		mov p1, a
		acall delay
		cpl p3.2
		acall delay
		cpl p3.2
		acall delay
		acall pszesc
		acall delay
		acall pszesc
		acall delay		
	jmp start
	nop
	nop
	nop
	jmp $
	end start