import sys
n=sys.stdin.readline().split()
m=''.join(reversed(n[0]))
s=[m[i:i+3] for i in range(0, len(m), 3)]
result=''
for item in s:
    answer=0
    for i in range(len(item)):
        answer+=int(item[i])*(2**i)
    result+=str(answer)
print(''.join(reversed(result)))