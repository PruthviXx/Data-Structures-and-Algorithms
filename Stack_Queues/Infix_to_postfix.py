def priority(c : chr):
    if c == '^':
        return 3
    elif c == '*' or c == '/':
        return 2
    elif c == '+' or c == '-':
        return 1
    else:
        return -1
    
def infix_to_postfix(str : str):
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
            while stack and priority(stack[-1]) >= priority(i): # O(N)
                ans+=stack.pop()
            stack.append(i)

    while stack:
        ans+=stack.pop()
        
    return ans

str = "a+b*(c^d-e)^(f+g*h)-i"
# str = "(p+q)*(m-n)"
print(infix_to_postfix(str))