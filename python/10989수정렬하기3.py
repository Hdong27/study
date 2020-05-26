import sys
n=int(sys.stdin.readline())
num=[0 for _ in range(10000)]
for _ in range(n):
    temp=int(sys.stdin.readline())
    num[temp-1]+=1

for i in range(10000):
    if num[i]==0:
        continue
    for j in range(num[i]):
        print(i+1)