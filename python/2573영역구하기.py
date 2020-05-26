import sys
sys.setrecursionlimit(10**6)
m,n,k=map(int,sys.stdin.readline().split())

dx=[-1,1,0,0]
dy=[0,0,-1,1]

def dfs(x, y, list1,num):
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if 0 <= nx < m and 0 <= ny < n and list1[nx][ny]==0:
            list1[nx][ny]=2
            num=dfs(nx,ny,list1,num+1)
    return num


rec=[]
for _ in range(k):
    rec.append(list(map(int, sys.stdin.readline().split())))

list1=[[0 for _ in range(n)] for _ in range(m)]

for item in rec:
    for i in range(item[3]-item[1]):
        for j in range(item[2]-item[0]):
            list1[item[1]+i][item[0]+j]=1


answer=[]
for i in range(m):
    for j in range(n):
        if list1[i][j]==0:
            list1[i][j] = 2
            answer.append(dfs(i, j, list1,1))

print(len(answer))
answer.sort()
for item in answer:
    print(item,end=" ")