ljmp start

p6	EQU	0FAH

org 050H
	delay:	mov r0, #0FFH		; opóŸnienie do mrugania
	one:	mov r1, #0FFH
	dwa:	djnz r1, dwa
		djnz r0, one
		ret

    	swiec:  clr a

	licz: 	inc a
		cpl p3.2
		mov p1,a
		acall delay
		jz koniec
		jmp licz
		
	koniec: 
		mov p1,#0h
		
	ret
			
org 0100h
	start:	
		acall swiec
		
	jmp start
	nop
	nop
	nop
	jmp $
	end start