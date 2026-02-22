def postfix_to_infix(s : str) -> str:
    stack = []
    for i in s:
        if i >= 'A' and i<='Z' or i >= 'a' and i<='z' or i >= '0' and i<='9':
            stack.append(i)
        else:
            top2 = stack.pop()
            top1 = stack.pop()
            stack.append("("+top1+i+top2+")")
    
    if stack:
        return stack[-1]
    else:
        return "Nothing"
    
print(postfix_to_infix("ab+c*"))