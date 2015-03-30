.data
	msg: .ascii "Sum of 10 + 8 is "
.text
	li $t0, 10
	addi $t0, $t0, 8
	li $v0, 4
	la $a0, msg
	syscall
	li $v0, 1
	move $a0, $t0
	syscall
	li $v0, 10
	syscall