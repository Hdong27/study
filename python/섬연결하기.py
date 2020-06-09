
d = [i for i in range(100)]

def find(node):
    if node==d[node]:
        return node
    else:
        d[node] = find(d[node])
        return d[node]

def solution(n, costs):
    answer=0
    costs=sorted(costs, key= lambda x : x[2])
    for i in costs:
        start=find(i[0])
        end=find(i[1])
        cost=i[2]

        if start!=end:
            d[start]=end
            answer+=cost

    return answer

print(solution(5,[[0,1,1],[0,2,2],[1,2,5],[1,3,1],[2,3,8],[0,3,1],[2,4,1],[1,4,2]]))