def prefix_to_infix(s : str) -> str:
    stack : str = []
    for indx in range(len(s) -1,-1,-1):
        i = s[indx]
        if i >= 'A' and i<='Z' or i >= 'a' and i<='z' or i >= '0' and i<='9':
            stack.append(i)
        else:
            if stack:
                top1 = stack.pop()
                top2 = stack.pop()
                stack.append("("+top1+i+top2+")")
    
    if stack:
        return stack[-1]
    else:
        return "Nothing"
    
print(prefix_to_infix("*+ab-cd"))