.text
	#generate random # in (0, 9)
	li $a1, 10
	li $v0, 42
	syscall
	
	#add 1, print
	addi $a0, $a0, 1
	li $v0, 1
	syscall
	
	#exit
	li $v0, 10
	syscall