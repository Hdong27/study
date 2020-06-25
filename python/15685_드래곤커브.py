import sys
n=int(sys.stdin.readline())

dragon=[]

for i in range(n):
    dragon.append(list(map(int,sys.stdin.readline().split())))

# dragon : [ x, y, 방향, 세대]
# 0 : 우 , 1 : 상 , 2 : 좌 , 3 : 하
curve_place=[[False for i in range(101)] for i in range(101)]

def gene(x, y, dir, k):
    global curve
    curve.append([x,y])
    if dir == 0 and x+1<101:
        x1=x+1
        y1=y
        curve.append([x1, y1])
        for i in range(k):
            m=len(curve)
            for j in range(m-2,-1,-1):
                if 0<=-(curve[j][1]-y1)+x1<101 and 0<=(curve[j][0]-x1)+y1<101:
                    curve.append([-(curve[j][1]-y1)+x1, (curve[j][0]-x1)+y1])
            x1 = curve[-1][0]
            y1 = curve[-1][1]
    elif dir == 1 and y-1>=0:
        x1 = x
        y1 = y-1
        curve.append([x1, y1])
        for i in range(k):
            m = len(curve)
            for j in range(m - 2, -1, -1):
                if 0 <= -(curve[j][1] - y1) + x1 < 101 and 0 <= (curve[j][0] - x1) + y1 < 101:
                    curve.append([-(curve[j][1] - y1) + x1, (curve[j][0] - x1) + y1])
            x1 = curve[-1][0]
            y1 = curve[-1][1]
    elif dir == 2 and x-1>=0:
        x1 = x - 1
        y1 = y
        curve.append([x1, y1])
        for i in range(k):
            m = len(curve)
            for j in range(m - 2, -1, -1):
                if 0 <= -(curve[j][1] - y1) + x1 < 101 and 0 <= (curve[j][0] - x1) + y1 < 101:
                    curve.append([-(curve[j][1] - y1) + x1, (curve[j][0] - x1) + y1])
            x1 = curve[-1][0]
            y1 = curve[-1][1]
    elif dir == 3 and y+1<101:
        x1 = x
        y1 = y+1
        curve.append([x1, y1])
        for i in range(k):
            m = len(curve)
            for j in range(m - 2, -1, -1):
                if 0 <= -(curve[j][1] - y1) + x1 < 101 and 0 <= (curve[j][0] - x1) + y1 < 101:
                    curve.append([-(curve[j][1] - y1) + x1, (curve[j][0] - x1) + y1])
            x1 = curve[-1][0]
            y1 = curve[-1][1]


for i in range(len(dragon)):
    curve = []
    gene(dragon[i][0], dragon[i][1], dragon[i][2], dragon[i][3])
    for j in range(len(curve)):
        curve_place[curve[j][1]][curve[j][0]]=True

count=0
for i in range(101):
    for j in range(101):
        if 0<=j<100 and 0<=i<100 and curve_place[i][j] and curve_place[i+1][j] and curve_place[i][j+1] and curve_place[i+1][j+1]:
            count+=1

print(count)