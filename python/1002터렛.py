import sys
from sympy import Symbol, solve

n=int(sys.stdin.readline())
for i in range(n):
    x = Symbol('x')
    y = Symbol('y')
    x1,y1,r1,x2,y2,r2=map(int,sys.stdin.readline().split())
    equation1=(x - x1) ** 2 + (y - y1) ** 2 - r1 ** 2
    equation2=(x - x2) ** 2 + (y - y2) ** 2 - r2 ** 2

    result=solve((equation1,equation2),dict=True)
    if len(result)>2:
        print(-1)
    else:
        print(len(result))