begin:  
  SET R2, 0           // R2 = 0
loop:
  SET R1, 128         // R1 = 128
  STORE R2, R1, 0     // M[128] = R2
  SET R1, 1           // R1 = 1
  ADD R2, R2, R1      // R2++
  SET R15, loop       // R15 = loop, R15 is return address 
  SET R0, delay       // goto delay
delay:
  SET R11, 0          // R11 = 0
  SET R12, 0          // R12 = 0
  SET R13, 0          // R13 = 0
  SET R1, 1           // R1 = 1
delay_loop:
  ADD R11, R11, R1    // R11++
  BEQ R11, 0          // skip next if (R11 == 0)
  SET R0, delay_loop  // goto delay_loop
  ADD R12, R12, R1    // R12++
  BEQ R12, 0          // skip next if (R12 == 0)
  SET R0, delay_loop  // goto delay_loop
  ADD R13, R13, R1    // R13++
  BEQ R13, 0          // skip next if (R13 == 0)
  SET R0, delay_loop  // goto delay_loop
  SET R1, 0           // R1 = 0
  ADD R0, R15, R1     // R0 = R15 (return)