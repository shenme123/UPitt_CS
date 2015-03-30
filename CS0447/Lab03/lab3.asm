.data
	start:		.asciiz	"Please input an integer n: "
	rec_result:	.asciiz	"Recursive f(n) = "
	iter_result:	.asciiz "Iterative f(n) = "
	ln:		.asciiz "\n"

.text
	la	$a0, start
	li	$v0, 4
	syscall
	li	$v0, 5
	syscall
	move	$s0, $v0		
	la	$a0, rec_result
	li	$v0, 4
	syscall	
	
	move	$a0, $s0		# call the recursive function	
	jal	_fib_rec	
	move	$a0, $v0
	li	$v0, 1
	syscall
	
	
	la	$a0, ln
	li	$v0, 4
	syscall
	la	$a0, iter_result
	syscall
	move	$a0, $s0		# call the iterative function
	jal	_fib_iter
	move	$a0, $v0
	li	$v0, 1
	syscall
	
	li	$v0, 10
	syscall
############################# recursive function ##############################
_fib_rec:
	addi	$sp, $sp, -12		# store registers
	sw	$s0, 0($sp)
	sw	$s1, 4($sp)
	sw	$ra, 8($sp)
	
	move	$s0, $a0		# recursive body
	li	$v0, 1
	blt	$s0, 3, _fib_rec_exit
	addi	$a0, $s0, -1
	jal	_fib_rec
	move 	$s1, $v0
	addi	$a0, $s0, -2
	jal	_fib_rec
	add	$v0, $v0, $s1	
_fib_rec_exit:
	lw	$ra, 8($sp)		# recusive epilogue
	lw	$s1, 4($sp)
	lw	$s0, 0($sp)
	addi	$sp, $sp, 12
	jr	$ra
########################### iterative function ################################
_fib_iter:
	addi	$sp, $sp, -8		# store registers
	sw	$s0, 0($sp)
	sw	$s1, 4($sp)	
	
	li	$s0, 1			# iterative
	li	$s1, 1
_iter:
	blt	$a0, 3, _fib_iter_exit
	move	$t0, $s1
	add	$s1, $s1, $s0
	move	$s0, $t0
	addi	$a0, $a0, -1
	j	_iter
	
_fib_iter_exit:
	move 	$v0, $s1
	lw	$s1, 4($sp)
	lw	$s0, 0($sp)
	addi	$sp, $sp, 8
	jr	$ra
	