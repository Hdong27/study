import sys
pipe=sys.stdin.readline().split()
stack=[]
answer=0
for i in range(len(pipe[0])):
    if pipe[0][i]=="(":
        if pipe[0][i+1]=="(":
            stack.append("(")
        else:
            answer+=len(stack)
    else:
        if pipe[0][i-1]==")":
            stack.pop()
            answer+=1
        else:
            continue

print(answer)

