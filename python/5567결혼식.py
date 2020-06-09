import sys
n=int(sys.stdin.readline())
m=int(sys.stdin.readline())
bus=[[0 for _ in range(n)] for _ in range(n)]
for _ in range(m):
    a,b=map(int,sys.stdin.readline().split())
    bus[a - 1][b - 1] = 1
    bus[b - 1][a - 1] = 1

for j in range(1,n):
    for k in range(1, n):
        if (bus[0][k]==0 or bus[k][j]) and bus[0][k] + bus[k][j]==2 and bus[0][j]!=1:
            bus[0][j] = 2

temp=0
for i in bus[0]:
    if i!=0:
        temp+=1

print(temp)