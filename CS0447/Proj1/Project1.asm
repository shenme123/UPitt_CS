.data
	welc: .asciiz "Welcome to Wentao's Casino!\n"
	enter: .asciiz "Please enter your name: "
	dealer: .asciiz "The dealer:\n"
	choose: .asciiz "Would you like to \"hit\" or \"stand\"? "
	busted: .asciiz "BUSTED!"
	pbusted: .asciiz "You busted. Dealer wins."
	dbusted: .asciiz " Dealer busted. You win"
	pwin: .asciiz "You win!"
	dwin: .asciiz "Dealer wins!"
	again: .asciiz "Would you like to play again? (yes/no): "
	qm: .asciiz "?"
	ps: .asciiz " + "
	es: .asciiz " = "
	co: .asciiz ":"
	ln: .asciiz "\n"
	name: .space 30
	counter: .space 13
	dcards: .space 10
	pcards: .space 10
	choice: .space 6
	againcho: .space 5


	
	
.text
	#starting information
	la $a0, welc
	li $v0, 4
	syscall
	la $a0, enter
	syscall
	li $v0, 8
	la $a0, name
	li $a1, 30
	syscall
	
	#initalize counter
	# $t0: counter
	la $t0, counter
	addi $t1, $t0, 13
INITIAL:
	sb $0, 0($t0)
	addi $t0, $t0, 1
	bne $t1, $t0, INITIAL

START:
	# Generate Dealer's cards
	la $t2, dcards		# $t2: dealer cards
	jal DGEN
	jal DGEN
	lb $s1, -2($t2)		## $s1 for the ?
	blt $s1, 11, NOADJ1
	li $s1, 10
NOADJ1:
	move $s2, $0		## $s2 for the sum of dealer except the ?
	jal DPRINT
	
	# Generate Player's cards
	la $t3, pcards
	jal PGEN
	jal PGEN
	lb $s3, -2($t3)		## $s3 for the sum of player
	blt $s3, 11, NOADJ2
	li $s3, 10
NOADJ2:
	jal PPRINT

CONTINUE:	
	bgt $s3, 21, PDONE
	add $s4, $s1, $s2    ## $s4 for sum of dealer
	bgt $s2, 21, DDONE
	# ask for choice
	la $a0, choose
	syscall
	la $a0, choice
	li $a1, 6
	li $v0, 8
	syscall
	lb $s0, 0($a0)

	bne $s0, 104, STAND   #compare to h=104
	
	# if hit
	# add card and check player again	
	jal PGEN

	jal DPRINT
	jal PPRINT
	j CONTINUE
	
	
		
	j EXIT	
	# Print Player's		
PPRINT:
	la $a0, name
	li $v0, 4
	syscall
	move $a0, $s3
	li $v0, 1
	syscall
	la $a0, ps
	li $v0, 4
	syscall
	lb $t1, -1($t3)
	blt $t1, 11, NOADJ4
	li $t1, 10
NOADJ4:
	move $a0, $t1
	li $v0, 1
	syscall	
	la $a0, es
	li $v0, 4
	syscall

	add $s3, $s3, $t1
	move $a0, $s3
	li $v0, 1
	syscall
	la $a0, ln
	li $v0, 4
	syscall	
	jr $ra

	# Generate Player's
PGEN:
	la $t0, counter
	li $a1, 13
	li $v0, 42
	syscall
	#change counter
	add $t0, $t0, $a0
	lb $t1, 0($t0)
	beq $t1, 4, PGEN
	addi $t1, $t1, 1
	sb $t1, 0($t0)
	addi $a0, $a0,1
	sb $a0, 0($t3)
	addi $t3, $t3, 1
	jr $ra	
	
	
	# Print Dealer's
DPRINT:	
	la $a0, dealer
	li $v0, 4
	syscall
	la $a0, qm
	syscall
	la $a0, ps
	syscall
	lb $t1, -1($t2)
	blt $t1, 11, NOADJ3
	li $t1, 10
NOADJ3:
	add $s2, $s2, $t1
	move $a0, $s2
	li $v0, 1
	syscall
	la $a0, ln
	li $v0, 4
	syscall	
	jr $ra

	# Generate Dealer's
DGEN:
	la $t0, counter
	li $a1, 13
	li $v0, 42
	syscall
	#change counter
	add $t0, $t0, $a0
	lb $t1, 0($t0)
	beq $t1, 4, DGEN
	addi $t1, $t1, 1
	sb $t1, 0($t0)
	
	addi $a0, $a0, 1
	
	sb $a0, 0($t2)
	addi $t2, $t2, 1
	jr $ra

PDONE:
	
	la $a0, busted
	li $v0, 4
	syscall
	la $a0, pbusted
	syscall
	la $a0, again
	syscall
	la $a0, againcho
	li $a1, 5
	li $v0, 8
	syscall
	lb $s0, 0($a0)
	bne $s0, 121, EXIT   #compare to y=121
	j START
	
DDONE:
	
	li $v0, 4
	la $a0, dbusted
	syscall
	
	la $a0, again
	syscall
	la $a0, againcho
	li $a1, 5
	li $v0, 8
	syscall
	lb $s0, 0($a0)
	bne $s0, 121, EXIT   #compare to y=121
	j START
	
PWIN:
	#print D
	la $a0, dealer
	li $v0, 4
	syscall
	move $a0, $s4
	li $v0, 1
	syscall
	la $a0, ln
	li $v0, 4
	syscall
	#print P
	la $a0, name
	li $v0, 4
	syscall	
	move $a0, $s3
	li $v0, 1
	syscall
	la $a0, ln
	li $v0, 4
	syscall
	# pirnt pwin
	li $v0, 4
	la $a0, pwin
	syscall
	# again
	la $a0, again
	syscall
	la $a0, againcho
	li $a1, 5
	li $v0, 8
	syscall
	lb $s0, 0($a0)
	bne $s0, 121, EXIT   #compare to y=121
	j START
	
DWIN:
	#print D
	la $a0, dealer
	li $v0, 4
	syscall
	move $a0, $s4
	li $v0, 1
	syscall
	la $a0, ln
	li $v0, 4
	syscall
	#print P
	la $a0, name
	li $v0, 4
	syscall	
	move $a0, $s3
	li $v0, 1
	syscall
	la $a0, ln
	li $v0, 4
	syscall
	#print dwin
	li $v0, 4
	la $a0, dwin
	syscall
	
	la $a0, again
	syscall
	la $a0, againcho
	li $a1, 5
	li $v0, 8
	syscall
	lb $s0, 0($a0)
	bne $s0, 121, EXIT   #compare to y=121
	j START
	
STAND:
	bgt $s4, 17, NOGEN
	jal DGEN
NOGEN:
	add $s4, $s1, $s2 
	bgt $s4, 21, DDONE
	blt $s4, $s3, PWIN
	j DWIN
	
EXIT:
	li $v0, 10
	syscall