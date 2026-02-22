def priority(c : chr):
    if c == '^':
        return 3
    elif c == '*' or c == '/':
        return 2
    elif c == '+' or c == '-':
        return 1
    else:
        return -1
    
def infix_to_postfix(str : str) -> str:
    ans = ""
    stack = []
    for i in str: # O(N)
        # operand
        if i >= 'A' and i<='Z' or i >= 'a' and i<='z' or i >= '0' and i<='9':
            ans += i
        # brackets
        elif i == '(':
            stack.append('(')
        # closing
        elif i == ')': # O(N)
            while stack and stack[-1]!='(':
                ans+=stack.pop()
            stack.pop()
        # operators
        else:
            if i=='^':
                while stack and priority(stack[-1]) >= priority(i): # O(N)
                    ans+=stack.pop()
                stack.append(i)
            else:
                while stack and priority(stack[-1]) > priority(i): # O(N)
                    ans+=stack.pop()
                stack.append(i)

    while stack: # O(N)
        ans+=stack.pop()
        
    return ans    

def infix_to_prefix(str : str) -> str:
    # reverse the infix expression
    str = str[::-1]
    # replace the )( with ()
    str.replace('(','temp').replace(')','(').replace('temp',')')
    # infix to postfix
    str = infix_to_postfix(str)
    # reverse the postfix expression
    return str[::-1]

str = "x+y*z/w+u"
# str = "(p+q)*(m-n)"
print(infix_to_prefix(str))