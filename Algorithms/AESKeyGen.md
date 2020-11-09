Algorithm for AES Key Expansion
```
KeyExpansion (byte key[16], word w[44])  
{  
  word temp  
  for (i = 0; i < 4; i++) 
    w[i] = (key[4*i], key[4*i+1], key[4*i+2], key[4*i+3]);  
  for (i = 4; i < 44; i++)  
  {  
    temp = w[i − 1];  
    if (i mod 4 = 0) temp = SubWord (RotWord (temp)) ⊕ Rcon[i/4];  
    w[i] = w[i−4] ⊕ temp  
  }  
}
```
