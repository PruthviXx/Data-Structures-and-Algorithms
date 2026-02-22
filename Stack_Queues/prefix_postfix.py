def prefix_to_postfix(s : str) -> str:
    stack : str = []
    for i in reversed(s):
        if i >= 'A' and i<='Z' or i >= 'a' and i<='z' or i >= '0' and i<='9':
            stack.append(i)
        else:
            if stack:
                top1 = stack.pop()
                top2 = stack.pop()
                stack.append(top1+top2+i)
    
    if stack:
        return stack[-1]
    else:
        return "Nothing"
    
print(prefix_to_postfix("*+ab-cd"))