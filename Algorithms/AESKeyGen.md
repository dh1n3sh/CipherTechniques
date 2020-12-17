Algorithm for AES Key Expansion
```
KeyExpansion (byte key[16])  
{  
  word w[44]
  word temp  
  for (i = 0; i < 4; i++) 
    w[i] = (key[4*i], key[4*i+1], key[4*i+2], key[4*i+3]);  
  for (i = 4; i < 44; i++)  
  {  
    temp = w[i − 1];  
    if (i mod 4 = 0) temp = SubWord (RotWord (temp)) ⊕ Rcon[i/4];  
    w[i] = w[i−4] ⊕ temp  
  }
  return w
}
```
The AES key Expansion algorithm reads a 16 byte (4 words) key and expands it to 176 bytes (44 words).  
A Byte contains two Hex values.   
A Word contains four bytes (i.e) four pairs of hex values.   
**RotWord(word)** preforms a one byte left circular shift.  
**Subword(word)** substitutes each byte in the word with the corresponding byte in S-box.  
**Rcon[]** is a round constant array.  


