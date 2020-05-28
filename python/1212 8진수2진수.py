import sys
n=sys.stdin.readline().split()

answer=[]
for i in n[0]:
    if i == '0':
        if len(answer)==0:
            answer.append("0")
        else:
            answer.append("000")
    if i == '1':
        if len(answer)==0:
            answer.append("1")

        else:
            answer.append("001")
    if i == '2':
        if len(answer)==0:
            answer.append("10")
        else:
            answer.append("010")
    if i == '3':
        if len(answer)==0:
            answer.append("11")
        else:
            answer.append("011")
    if i == '4':
        answer.append("100")
    if i == '5':
        answer.append("101")
    if i == '6':
        answer.append("110")
    if i == '7':
        answer.append("111")

print("".join(answer))