.data
	higher: .asciiz "higher\n"
	lower: .asciiz "lower\n"
	correct: .asciiz "correct\n"
	
.text
	#generate random # in (1, 10)
	li $a1, 10
	li $v0, 42
	syscall
	addi $t0, $a0, 1

Loop:
	li $v0, 5
	syscall
	move $t1, $v0
	beq $t0, $t1, Exit
	slt $t3, $t1, $t0
	bne $t3, $0, Less
	
	la $a0, lower
	j Print
	
Less: 
	la $a0, higher
	j Print
	
Print:
	li $v0, 4
	syscall
	j Loop
	
Exit:
	la $a0, correct
	li $v0, 4
	syscall
	li $v0, 10
	syscall
