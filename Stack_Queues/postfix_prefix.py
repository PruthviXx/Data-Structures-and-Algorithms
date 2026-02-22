def postfix_to_prefix(s : str) -> str:
    stack : str = []
    for i in s:
        if i >= 'A' and i<='Z' or i >= 'a' and i<='z' or i >= '0' and i<='9':
            stack.append(i)
        else:
            if stack:
                top2 = stack.pop()
                top1 = stack.pop()
                stack.append(i+top1+top2)
    
    if stack:
        return stack[-1]
    else:
        return "Nothing"
    
print(postfix_to_prefix("abc*+d-"))