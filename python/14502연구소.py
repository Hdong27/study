from itertools import combinations

dx=[-1,1,0,0]
dy=[0,0,-1,1]

n,m=list(map(int, input().split()))

def dfs(x, y, virus):
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if 0 <= nx < n and 0 <= ny < m and not visited[nx][ny] and virus[nx][ny]==0:
            visited[nx][ny] = True
            global len1
            len1 -= 1
            dfs(nx,ny,virus)

virus=[]
for i in range(n):
    virus.append(list(map(int,input().split())))

empty=[]
virus2=[]
for i in range(n):
    for j in range(m):
        if virus[i][j]==0:
            empty.append([i,j])
        if virus[i][j]==2:
            virus2.append([i,j])

list1=[]

for i in range(len(empty)-2):
    for j in range(i+1,len(empty)-1):
        for k in range(j+1,len(empty)):
            list1.append([i,j,k])

list1=list(combinations(len(empty),3))


answer=0
for item in list1:
    len1 = len(empty) - 3
    for j in item:
        virus[empty[j][0]][empty[j][1]]=1
    visited = [[False for _ in range(m)] for _ in range(n)]
    for item2 in virus2:
        visited[item2[0]][item2[1]]=True
        dfs(item2[0],item2[1], virus)

    if answer<len1:
        answer=len1

    for j in item:
        virus[empty[j][0]][empty[j][1]] = 0

print(answer)