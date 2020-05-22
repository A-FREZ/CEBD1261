print("********* Alex Frez  -  Exercise 2: ********* ")
# Write a function to compute factorial (5! =5*4*3*2*1)

def factorial(n):       #Definition of the Factorial function.
    if n == 0:
        return 1
    else:
        return n * factorial(n-1)

InputStr=(input("Enter a positive Integer & I'll return its Factorial: "))

if ((float(InputStr)).is_integer()): #Check if input string is an integer
    #print(InputStr)                 #Print input string
    #print((int(InputStr)))          #Returns ValueError when InputStr = 2.0
    #print((float(InputStr)))        #Convert string fo float. ex: 2.000 to 2.0
    #print((int(float(InputStr))))   #Convert float to integer. ex: 2.0 to 2
    print(factorial(int(float(InputStr))))
else:
    print("NA")                     #[return "NA" if the input is not integer]. 