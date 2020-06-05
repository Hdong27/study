import sys
n=int(sys.stdin.readline())


for i in range(n):
    print("*"*(i+1))
for i in range(n-2,-1,-1):
    print("*" * (i + 1))
