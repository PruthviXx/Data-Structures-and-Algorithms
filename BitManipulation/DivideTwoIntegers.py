import sys

def optimal(dividend,divisor):
    if(dividend==divisor):
        return 1
    
    sign= True
    if(dividend>0 and divisor<0):
        sign = False
    if(dividend<0 and divisor>0):
        sign = False

    n= dividend
    d= divisor
    quotient= 0

    while n>=d:
        cnt =0
        while n>=(d<<(cnt+1)):
            cnt+=1

        quotient += 1<<cnt
        n-= d << cnt

    if quotient == (1<<31) and sign:
        return sys.maxsize
    if quotient == (1<<31) and (not sign):
        return -sys.maxsize - 1
    
    if(sign):
        return quotient
    
    else:
        return quotient*-1 
    
def divide(self, dividend, divisor):
        return optimal(dividend,divisor)
    
print(divide(0,-2147483648,-1))