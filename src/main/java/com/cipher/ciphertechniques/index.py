import os
base  = 'src/main/java/com/cipher/ciphertechniques/'
for i,file in enumerate(os.listdir()):
    print(str(i+1)+' '+'['+file.split('.')[0]+']'+'('+base+file+')   ')
