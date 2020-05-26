import sys
n=int(sys.stdin.readline())
vps=[]
for _ in range(n):
    vps.append(sys.stdin.readline().split())

for item in vps:
    while "()" in item[0]:
        item[0]=item[0].replace("()","")
    if item[0]=="":
        print("YES")
    else:
        print("NO")



