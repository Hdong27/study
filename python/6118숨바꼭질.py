import sys
import heapq

def dijkstra(graph, start):
    distances = [float('inf') for i in range(n + 1)]
    distances[start] = 0
    queue = []
    heapq.heappush(queue, [distances[start], start])

    while queue:
        current_distance, current_node = heapq.heappop(queue)

        if distances[current_node] < current_distance:
            continue

        for adjacent, weight in graph[current_node]:
            distance = current_distance + weight

            if distance < distances[adjacent]:
                distances[adjacent] = distance
                heapq.heappush(queue, [distance, adjacent])

    return distances

n,m=map(int,sys.stdin.readline().split())
graph=[[] for i in range(n + 1)]
for _ in range(m):
    a,b=map(int,sys.stdin.readline().split())
    graph[a].append([b, 1])
    graph[b].append([a, 1])

dist = dijkstra(graph,1)

max_dist=max(dist[1:])
print(dist.index(max_dist),max_dist,dist.count(max_dist))


# plc=[[False for _ in range(n)] for _ in range(n)]
# plc1=[0 for i in range(n)]
# for _ in range(m):
#
#      = True
#     plc[b - 1][a - 1] = True
#     if a==1:
#         plc1[b-1]=1
#
# for _ in range(n):
#     for i in range(1,n):
#         for j in range(1,n):
#             if plc[0][j] and plc[j][i]:
#                 if plc[0][i]:
#                     if plc[j][i]:
#                         plc1[i]=min(plc1[i],plc1[j]+plc1[i])
#                     plc[0][i]=True
#                 else:
#                     plc1[i] = plc1[j] + plc1[i]
#                     plc[0][i] = True
# for i in plc:
#     print(i)
#
# print(plc1)
#
# val=max(plc1)
# temp=0
# for i in range(len(plc1)):
#     if val==plc1[i]:
#         if temp==0:
#             print(i+1,val,end=" ")
#         temp+=1
# print(temp)