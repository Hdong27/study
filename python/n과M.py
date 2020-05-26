from itertools import combinations

n,m=list(map(int, input().split()))

list1=list(range(1,n+1))
list2=list(combinations(list1,m))

for item in list2:
    for i in range(m):
        print(item[i],end=" ")
    print("")