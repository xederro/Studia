ljmp start
			
org 0100h
	start:	mov a, #55h
		mov r0, #0aah
		anl a, r0

		mov a, #10h
		orl a, #02h
		
		mov a, #22h
		xrl a, 20h

		cpl a

		clr a
		
	nop
	nop
	nop
	jmp $
	end start