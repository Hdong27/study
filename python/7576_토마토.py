import sys
from collections import deque
m,n=map(int, sys.stdin.readline().split())
tomato=[]
sum=0
q=deque()
for i in range(n):
    tomato.append(list(map(int, sys.stdin.readline().split())))
    for j in range(m):
        if tomato[i][j]==0:
            sum+=1
        elif tomato[i][j]==1:
            q.append([i,j,0])

dx=[-1,1,0,0]
dy=[0,0,-1,1]
count=0

while q:
    x,y,num=q.popleft()
    count=num
    for i in range(4):
        nx=x+dx[i]
        ny=y+dy[i]

        if 0<=nx<n and 0<=ny<m and tomato[nx][ny]==0:
            tomato[nx][ny]=1
            sum -= 1
            q.append([nx,ny,num+1])

if sum!=0:
    print(-1)
else:
    print(count)
