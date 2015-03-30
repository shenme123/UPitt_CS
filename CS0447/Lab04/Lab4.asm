

.text
	li	$a2, 1
	li 	$s1, 0
rows:
	li	$s0, 0
	
columns:
	move	$a0, $s0
	move	$a1, $s1
	
	jal	_setLED
	
	addi	$s0, $s0, 1
	slti	$t0, $s0, 8
	bne	$t0, $0, columns
	
	addi	$s1, $s1, 1
	slti	$t0, $s1, 8
	bne	$t0, $0, rows

#############	delete 2nd row  ###################
	li	$a2, 0
	li	$s1, 1
	li	$s0, 1
del1:	
	move	$a0, $s0
	move	$a1, $s1
	
	jal	_setLED
	
	addi	$s0, $s0, 1
	slti	$t0, $s0, 7
	bne	$t0, $0, del1

############	delete (2, 6) ##########	
	li	$s1, 2
	li	$s0, 6
	
	move	$a0, $s0
	move	$a1, $s1
	
	jal	_setLED

#############	delete 4th row  ###################
	li	$a2, 0
	li	$s1, 3
	li	$s0, 3
del2:	
	move	$a0, $s0
	move	$a1, $s1
	
	jal	_setLED
	
	addi	$s0, $s0, 1
	slti	$t0, $s0, 7
	bne	$t0, $0, del2	

#############	delete 7th row   ###################	
	li	$a2, 0
	li	$s1, 6
	li	$s0, 1
del3:	
	move	$a0, $s0
	move	$a1, $s1
	
	jal	_setLED
	
	addi	$s0, $s0, 1
	slti	$t0, $s0, 6
	bne	$t0, $0, del3
	
#############	delete 2nd col  ###################
	li	$a2, 0
	li	$s1, 4
	li	$s0, 1
del4:	
	move	$a0, $s0
	move	$a1, $s1
	
	jal	_setLED
	
	addi	$s1, $s1, 1
	slti	$t0, $s1, 6
	bne	$t0, $0, del4

#############	delete 5th col  ###################	
	li	$a2, 0
	li	$s1, 4
	li	$s0, 5
del5:	
	move	$a0, $s0
	move	$a1, $s1
	
	jal	_setLED
	
	addi	$s1, $s1, 1
	slti	$t0, $s1, 6
	bne	$t0, $0, del5

#############	delete (3,4)  ###################
	li	$s1, 4
	li	$s0, 3
	
	move	$a0, $s0
	move	$a1, $s1
	
	jal	_setLED
	
#############	set gold (1,3)  ###################
	li	$a2, 2
	li	$s1, 3
	li	$s0, 1
	
	move	$a0, $s0
	move	$a1, $s1
	
	jal	_setLED

#############	set green (0,1)  ###################
	li	$a2, 3
	li	$s1, 1
	li	$s0, 0
	
	move	$a0, $s0
	move	$a1, $s1
	
	jal	_setLED
	
#############	get key and move  ###################
next:	
	li	$v0, 32
	li	$a0, 200
	syscall
	
	jal 	_getKeyPress
	### right?
	bne	$v0, 227, not_right
	
	addi	$a0, $s0, 1
	move	$a1, $s1
	jal	_getLED
	beq	$v0, 2, exit
	beq	$v0, 1, next
	
	li	$a2, 3
	jal	_setLED
	
	li	$a2, 0
	move	$a0, $s0
	jal	_setLED
	
	addi	$s0, $s0, 1
	
not_right:
	### left?
	bne	$v0, 226, not_left
	
	beq	$s0, 0, next
	addi	$a0, $s0, -1
	move	$a1, $s1
	jal	_getLED
	beq	$v0, 2, exit
	beq	$v0, 1, next
	
	li	$a2, 3
	jal	_setLED
	
	li	$a2, 0
	move	$a0, $s0
	jal	_setLED
	
	addi	$s0, $s0, -1
	
not_left:
	### down?
	bne	$v0, 225, not_down
	
	move	$a0, $s0
	addi	$a1, $s1, 1
	jal	_getLED
	beq	$v0, 2, exit
	beq	$v0, 1, next
	
	li	$a2, 3
	jal	_setLED
	
	li	$a2, 0
	move	$a1, $s1
	jal	_setLED
	
	addi	$s1, $s1, 1	
	
not_down:	
	### up
	bne	$v0, 224, next
	
	move	$a0, $s0
	addi	$a1, $s1, -1
	jal	_getLED
	beq	$v0, 2, exit
	beq	$v0, 1, next
	
	li	$a2, 3
	jal	_setLED
	
	li	$a2, 0
	move	$a1, $s1
	jal	_setLED
	
	addi	$s1, $s1, -1	
	
	j	next


exit:	
	li	$a2, 0
	move	$a0, $s0
	move	$a1, $s1
	jal	_setLED
	
	li 	$v0, 10
	syscall



	

	# void _setLED(int x, int y, int color)
	#   sets the LED at (x,y) to color
	#   color: 0=off, 1=red, 2=orange, 3=green
	#
	# warning:   x, y and color are assumed to be legal values (0-63,0-63,0-3)
	# arguments: $a0 is x, $a1 is y, $a2 is color 
	# trashes:   $t0-$t3
	# returns:   none
	#
_setLED:
	# byte offset into display = y * 16 bytes + (x / 4)
	sll	$t0,$a1,4      # y * 16 bytes
	srl	$t1,$a0,2      # x / 4
	add	$t0,$t0,$t1    # byte offset into display
	li	$t2,0xffff0008	# base address of LED display
	add	$t0,$t2,$t0    # address of byte with the LED
	# now, compute led position in the byte and the mask for it
	andi	$t1,$a0,0x3    # remainder is led position in byte
	neg	$t1,$t1        # negate position for subtraction
	addi	$t1,$t1,3      # bit positions in reverse order
	sll	$t1,$t1,1      # led is 2 bits
	# compute two masks: one to clear field, one to set new color
	li	$t2,3		
	sllv	$t2,$t2,$t1
	not	$t2,$t2        # bit mask for clearing current color
	sllv	$t1,$a2,$t1    # bit mask for setting color
	# get current LED value, set the new field, store it back to LED
	lbu	$t3,0($t0)     # read current LED value	
	and	$t3,$t3,$t2    # clear the field for the color
	or	$t3,$t3,$t1    # set color field
	sb	$t3,0($t0)     # update display
	jr	$ra


	# int _getLED(int x, int y)
	#   returns the value of the LED at position (x,y)
	#
	#  warning:   x and y are assumed to be legal values (0-63,0-63)
	#  arguments: $a0 holds x, $a1 holds y
	#  trashes:   $t0-$t2
	#  returns:   $v0 holds the value of the LED (0, 1, 2, 3)
	#
_getLED:
	# byte offset into display = y * 16 bytes + (x / 4)
	sll  $t0,$a1,4      # y * 16 bytes
	srl  $t1,$a0,2      # x / 4
	add  $t0,$t0,$t1    # byte offset into display
	la   $t2,0xffff0008
	add  $t0,$t2,$t0    # address of byte with the LED
	# now, compute bit position in the byte and the mask for it
	andi $t1,$a0,0x3    # remainder is bit position in byte
	neg  $t1,$t1        # negate position for subtraction
	addi $t1,$t1,3      # bit positions in reverse order
    	sll  $t1,$t1,1      # led is 2 bits
	# load LED value, get the desired bit in the loaded byte
	lbu  $t2,0($t0)
	srlv $t2,$t2,$t1    # shift LED value to lsb position
	andi $v0,$t2,0x3    # mask off any remaining upper bits
	jr   $ra


	# int _getKeyPress(void)
	#	returns the key last pressed, unless there is none
	#
	# trashes: $t0-$t1
	# returns in $v0:
	#	0	No key pressed
	# 	0x42	Middle button pressed
	# 	0xE0	Up arrow 
	# 	0xE1	Down arrow 
	# 	0xE2	Left arrow 
	# 	0xE3 Right arrow
	#
_getKeyPress:
	la	$t1, 0xffff0000			# status register
	li	$v0, 0				# default to no key pressed
	lw	$t0, 0($t1)			# load the status
	beq	$t0, $zero, _keypress_return	# no key pressed, return
	lw	$v0, 4($t1)			# read the key pressed
_keypress_return:
	jr $ra
