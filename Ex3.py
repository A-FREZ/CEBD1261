print("*************** Alex Frez  -  Exercise 3: *************** ")
# Write a function that computes the factorial of a number
# and that accepts Double (Float) numbers into the factorial.

def factorial(n):       #Definition of the Factorial function.
    if n == 0:
        return 1
    else:
        return n * factorial(n-1)

InputStr=(input("Enter a Float number & I'll return its Integer Factorial: "))

if ((float(InputStr)).is_integer()): #When string is an Integer:
    #print((int(InputStr)))          #Convert string to integer Returns Error when InputStr = 2.0
    #print((float(InputStr)))        #Convert string fo float. ex: InputStr = 2.0 is accepted, ok.
    print(factorial(float(InputStr)))
else:                                       #When string is a Float: Convert float to integer
    print(factorial(int(float(InputStr))))  #before calling factorial function. ex: 2.0 to 2