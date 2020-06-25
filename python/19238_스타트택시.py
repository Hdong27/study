import sys
n,m,fuel=list(map(int, sys.stdin.readline().split()))

road=[]
for i in range(n):
    road.append(list(map(int, sys.stdin.readline().split())))

a,b=list(map(int, sys.stdin.readline().split()))

customer=[]
for i in range(m):
    customer.append(list(map(int, sys.stdin.readline().split())))


dx=[-1,0,1,0]
dy=[0,-1,0,1]
visited=[[False for i in range(n)] for i in range(n)]
dist=0
def dfs(x,y,x1,y1):
    global fuel, road, dist, visited, max_dist
    for i in range(4):
        nx=x+dx[i]
        ny=y+dy[i]

        if 0<=ny<n and 0<=nx<n and road[nx][ny]!=1 and not visited[nx][ny]:
            visited[nx][ny]=True
            temp = dist
            dist+=1
            if nx==x1-1 and ny==y1-1:
                visited[nx][ny] = False
                max_dist=[dist,nx,ny]
                return
            if max_dist[0]<dist:
                dist = temp
                visited[nx][ny]=False
                continue

            dfs(nx,ny,x1,y1)
            dist=temp
            visited[nx][ny]=False
    return


for j in range(len(customer)):
    min_dist = [400,n,n]
    min_cust = []
    for i in range(len(customer)):
        max_dist = [400,n,n]
        dist = 0
        dfs(a-1, b-1, customer[i][0], customer[i][1])
        visited = [[False for i in range(n)] for i in range(n)]
        if min_dist[0]>max_dist[0]:
            for k in range(3):
                min_dist[k]=max_dist[k]
            min_cust=customer[i]
        elif min_dist[0]==max_dist[0] and  max_dist[1]<min_dist[1]:
            for k in range(3):
                min_dist[k]=max_dist[k]
            min_cust=customer[i]
        elif min_dist[0]==max_dist[0] and  max_dist[1]==min_dist[1] and max_dist[2]<min_dist[2]:
            for k in range(3):
                min_dist[k]=max_dist[k]
            min_cust=customer[i]
    if min_cust==[]:
        fuel=-1
        break
    customer.remove(min_cust)
    if fuel>=min_dist[0]:
        fuel=fuel-min_dist[0]
    else:
        fuel = -1
        break
    max_dist = [400,n,n]
    a,b=min_cust[2], min_cust[3]
    dist=0
    dfs(min_cust[0]-1, min_cust[1]-1, min_cust[2], min_cust[3])
    if max_dist[0]==400:
        fuel=-1
        break
    if fuel >= max_dist[0]:
        fuel = fuel + max_dist[0]
    else:
        fuel = -1
        break

print(fuel)