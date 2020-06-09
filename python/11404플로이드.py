import sys
n=int(sys.stdin.readline())
m=int(sys.stdin.readline())
bus=[[0 for _ in range(n)] for _ in range(n)]
for _ in range(m):
    a,b,c=map(int,sys.stdin.readline().split())
    if (bus[a-1][b-1]!=0 and bus[a-1][b-1]>=c) or bus[a-1][b-1]==0:
        bus[a-1][b-1]=c

for k in range(n):
    for i in range(n):
        if k!=i and bus[k][i]==0:
            bus[k][i]=10000000

for _ in range(n):
    for j in range(n):
        for k in range(n):
            for i in range(n):
                bus[k][i]=min(bus[k][i],bus[k][j]+bus[j][i])

for k in range(n):
    for i in range(n):
        if bus[k][i]==10000000:
            bus[k][i]=0

for i in bus:
    for j in i:
        print(j, end=" ")
    print("")