.data
	welc: .asciiz "Welcome to Wentao's Casino!\n"
	enter: .asciiz "Please enter your name: "
	dealer: .asciiz "The dealer:\n"
	choose: .asciiz "Would you like to \"hit\" or \"stand\"? "
	busted: .asciiz "BUSTED!"
	pbusted: .asciiz "You busted. Dealer wins.\n"
	dbusted: .asciiz "Dealer busted. You win.\n"
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
	
START:
	# Generate Dealer's cards
	la $t2, dcards		# $t2: dealer cards
	jal DGEN
	jal DGEN
	lb $s1, -2($t2)		## $s1 for the ?
	blt $s1, 11, D_NOT_JQK
	li $s1, 10
   D_NOT_JQK:
   	bne $s1, 1, D_NOT_A
   	li $s1, 11
   D_NOT_A:
	jal DCALC
	jal DPRINT
	
	# Generate Player's cards
	la $t3, pcards		# $t3: player cards
	jal PGEN
	jal PGEN
	# calc first card of P
	lb $s5, -2($t3)		## $s3 for the for-sum of player, $s5 for the sum of player
	blt $s5 11, P_NOT_JQK
	li $s5, 10
   P_NOT_JQK:
	bne $s5, 1, P_NOT_A
	li $s5, 11
   P_NOT_A:
	jal PCALC
	jal PPRINT
	
CONTINUE:
#	bgt $s5, 21, PBUST	
#	bgt $s2, 21, DBUST	
	# ask for choice
	la $a0, choose
	syscall
	la $a0, choice
	li $a1, 6
	li $v0, 8
	syscall
	lb $s0, 0($a0)
	bne $s0, 104, STAND	 #compare to h=104
	
	### hit
	jal PGEN
	jal PCALC

   PCHECK_AGAIN:
	bgt $s5, 21, PBUST
   
   DCHECK_AGAIN:
	bgt $s4, 16, NO_NEED_DGEN
	jal DGEN
	jal DCALC
   NO_NEED_DGEN:
   	
   	bgt $2, 21, DBUST
   	jal DPRINT
   	jal PPRINT
	
	j CONTINUE
	

	
	
#########################################################################
#################   FUNCTIONS  ##########################################
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
	
DCALC:
	lb $t4,-1($t2)
	move $t1, $t4
	blt $t1, 11, DNOT_JQK_C
	li $t1, 10
   DNOT_JQK_C:
	add $s2, $s2, $t1
	bne $t1, 1, DNOT_A_C
	addi $t1, $s2, 10
	bgt $t1, 22, DNOT_A_C
	move $s2, $t1
   DNOT_A_C:
   	add $s4, $s1, $s2
   	jr $ra
   	
DPRINT:
	la $a0, dealer
	li $v0, 4
	syscall
	la $a0, qm
	syscall
	la $a0, ps
	syscall
	
	
	
	lb $t1, -1($t2)
	bne $t1, 11, DNOT_J_P
	addi $t1, $t1, 63
	j D_TO_PRINT_LETTER
   DNOT_J_P:
   	bne $t1, 12, DNOT_Q_P
   	addi $t1, $t1, 69
   	j D_TO_PRINT_LETTER
   DNOT_Q_P:	
	bne $t1, 13, DNOT_K_P
	addi $t1, $t1, 62
	j D_TO_PRINT_LETTER
   DNOT_K_P:
   	bne $t1, 1, D_TO_PRINT_NUM
   	addi, $t1, $t1, 64
   	j D_TO_PRINT_LETTER
   D_TO_PRINT_NUM:
   	move $a0, $t1
   	li $v0, 1
   	syscall
   	j DRETURN
   D_TO_PRINT_LETTER:
   	move $a0, $t1
   	li $v0, 11
   	syscall
   DRETURN:
   	la $a0, ln
   	li $v0, 4
   	syscall
   	jr $ra
   	
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
	
PCALC:
	lb $t5, -1($t3)
	move $t1, $t5
	blt $t1, 11, PNOT_JQK_C
	li $t1, 10
   PNOT_JQK_C:
   	move $s3, $s5
   	add $s5, $s3, $t1
   	bne $t1, 1, PNOT_A_C
   	addi $t1, $s5, 10
   	bgt $t1, 21, PNOT_A_C
   	move $s5, $t1
   PNOT_A_C:
   	jr, $ra	
   	

PPRINT:
	la $a0, name
	li $v0, 4
	syscall
	bne $t6, $0, NOT_1ST
	
	lb $t1, -2($t3)
	bne $t1, 11, PNOT_J_P1
	addi $t1, $t1, 63
	j P_TO_PRINT_LETTER1
     PNOT_J_P1:
	bne $t1, 12, PNOT_Q_P1
	addi $t1, $t1, 69
	j P_TO_PRINT_LETTER1
     PNOT_Q_P1:
	bne $t1, 13, PNOT_K_P1
	addi $t1, $t1, 62
	j P_TO_PRINT_LETTER1
     PNOT_K_P1:
   	bne $t1, 1, P_TO_PRINT_NUM1
	addi $t1, $t1, 64
	j P_TO_PRINT_LETTER1
     P_TO_PRINT_NUM1:
     	move $a0, $t1
     	li $v0, 1, 
     	syscall
     	addi $t6, $t6, 1
	j PRINT_2ND
     P_TO_PRINT_LETTER1:
     	move $a0, $t1
     	li $v0, 11,
     	syscall
     	addi $t6, $t6, 1
     	j PRINT_2ND
	
   NOT_1ST:
   	move $a0, $s3
   	li $v0, 1
   	syscall
   	
   
   PRINT_2ND:
   	la $a0, ps
   	li $v0, 4
   	syscall

   	lb $t1, -1($t3)
	bne $t1, 11, PNOT_J_P2
	addi $t1, $t1, 63
	j P_TO_PRINT_LETTER2
     PNOT_J_P2:
	bne $t1, 12, PNOT_Q_P2
	addi $t1, $t1, 69
	j P_TO_PRINT_LETTER2
     PNOT_Q_P2:
	bne $t1, 13, PNOT_K_P2
	addi $t1, $t1, 62
	j P_TO_PRINT_LETTER2
     PNOT_K_P2:
   	bne $t1, 1, P_TO_PRINT_NUM2
	addi $t1, $t1, 64
	j P_TO_PRINT_LETTER2
     P_TO_PRINT_NUM2:
     	move $a0, $t1
     	li $v0, 1, 
     	syscall
	j PRINT_ES
     P_TO_PRINT_LETTER2:
     	move $a0, $t1
     	li $v0, 11,
     	syscall
     	j PRINT_ES
     	
   PRINT_ES:
   	la $a0, es
   	li $v0, 4
   	syscall
   
   	move $a0, $s5
   	li $v0, 1
   	syscall
   	
   	la $a0, ln
   	li $v0, 4
   	syscall
   	jr $ra

STAND:
	#print dealer
	la $a0, dealer
	li $v0, 4
	syscall
	
	move $a0, $s1
	li $v0, 1
	syscall
	
	la $a0, ps
	li $v0, 4
	syscall
	
	move $a0, $s2
	li $v0, 1
	syscall
	
	la $a0, es
	li $v0, 4
	syscall
	
	move $a0, $s4
	li $v0, 1
	syscall
	
	la $a0, ln
	li $v0, 4
	syscall
	
	#print player
	la $a0, name
	li $v0, 4
	syscall
	
	move $a0, $s5
	li $v0, 1
	syscall
	
	la $a0, ln
	li $v0, 4
	syscall
	
	blt $s4, $s5, PWIN
	j DWIN
	
PWIN:
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


PBUST:
	la $a0, pcards
	lb $t1, 0($a0)
	bne $t1, 1, PBUST_NO_A
	li $t1, 11
	sb $t1, 0($a0)
	addi $s5, $s5, -10
	j PCHECK_AGAIN
   PBUST_NO_A:
   	j DPRINT
   	j PPRINT
   	
	la $a0, busted
	li $v0, 4
	syscall
	
	la $a0, ln
	syscall
	
	la $a0, pbusted
	
	
	la $a0, again
	syscall
	la $a0, againcho
	li $a1, 5
	li $v0, 8
	syscall
	lb $s0, 0($a0)
	bne $s0, 121, EXIT   #compare to y=121
	j START

DBUST:
	la $a0, dcards
	lb $t1, 0($t0)
	bne $t1, 1, DBUST_NO_A
	li $t1, 11
	sb $t1, 0($a0)
	addi $s4, $s4, -10
	j DCHECK_AGAIN	
   DBUST_NO_A:
   	jal DPRINT
   	jal PPRINT
   	la $a0, dbusted
   	li $v0, 4
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
################## Exit ############################   	

 EXIT:
 	li $v0, 10
 	syscall