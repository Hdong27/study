import sys

fish=[]
dir=[]
for i in range(4):
    fishTemp=[]
    dirTemp=[]
    temp=list(map(int, sys.stdin.readline().split()))
    for j in range(len(temp)):
        if j%2==0:
            fishTemp.append(temp[j])
        else:
            dirTemp.append(temp[j])
    fish.append(fishTemp)
    dir.append(dirTemp)

print(fish)
print(dir)
shark=[0,0,[0,0]]
shark_out=False
# 1 ↑, 2 ↖, 3 ←, 4 ↙, 5 ↓, 6 ↘, 7 →, 8 ↗

# 0,0에 상어 이동
shark[0]=fish[0][0]
shark[1]=dir[0][0]
shark[2]=[0,0]
fish[0][0]=0
dir[0][0]=0

# 물고기 방향 이동
def fish_dir(i,j):
    global dir, fish, shark
    if dir[i][j] == 1:
        if i - 1 >= 0 and shark[2] != [i - 1, j]:
            if fish[i - 1][j] == 0:
                fish[i - 1][j] = fish[i][j]
                dir[i - 1][j] = dir[i][j]
            else:
                temp1 = fish[i - 1][j]
                fish[i - 1][j] = fish[i][j]
                fish[i][j] = temp1
                temp2 = dir[i - 1][j]
                dir[i - 1][j] = dir[i][j]
                dir[i][j] = temp2
        else:
            dir[i][j] += 1
            fish_dir(i,j)
    elif dir[i][j] == 2:
        if i - 1 >= 0 and j - 1 >= 0 and shark[2] != [i - 1, j - 1]:
            if fish[i - 1][j - 1] == 0:
                fish[i - 1][j - 1] = fish[i][j]
                dir[i - 1][j - 1] = dir[i][j]
            else:
                temp1 = fish[i - 1][j - 1]
                fish[i - 1][j - 1] = fish[i][j]
                fish[i][j] = temp1
                temp2 = dir[i - 1][j - 1]
                dir[i - 1][j - 1] = dir[i][j]
                dir[i][j] = temp2
        else:
            dir[i][j] += 1
            fish_dir(i, j)
    elif dir[i][j] == 3:
        if j - 1 >= 0 and shark[2] != [i, j - 1]:
            if fish[i][j - 1] == 0:
                fish[i][j - 1] = fish[i][j]
                dir[i][j - 1] = dir[i][j]
            else:
                temp1 = fish[i][j - 1]
                fish[i][j - 1] = fish[i][j]
                fish[i][j] = temp1
                temp2 = dir[i][j - 1]
                dir[i][j - 1] = dir[i][j]
                dir[i][j] = temp2
        else:
            dir[i][j] += 1
            fish_dir(i, j)
    elif dir[i][j] == 4:
        if i + 1 < 4 and j - 1 >= 0 and shark[2] != [i + 1, j - 1]:
            if fish[i + 1][j - 1] == 0:
                fish[i + 1][j - 1] = fish[i][j]
                dir[i + 1][j - 1] = dir[i][j]
            else:
                temp1 = fish[i + 1][j - 1]
                fish[i + 1][j - 1] = fish[i][j]
                fish[i][j] = temp1
                temp2 = dir[i + 1][j - 1]
                dir[i + 1][j - 1] = dir[i][j]
                dir[i][j] = temp2
        else:
            dir[i][j] += 1
            fish_dir(i, j)
    elif dir[i][j] == 5:
        if i + 1 < 4 and shark[2] != [i + 1, j]:
            if fish[i + 1][j] == 0:
                fish[i + 1][j] = fish[i][j]
                dir[i + 1][j] = dir[i][j]
            else:
                temp1 = fish[i + 1][j]
                fish[i + 1][j] = fish[i][j]
                fish[i][j] = temp1
                temp2 = dir[i + 1][j]
                dir[i + 1][j] = dir[i][j]
                dir[i][j] = temp2
        else:
            dir[i][j] += 1
            fish_dir(i, j)
    elif dir[i][j] == 6:
        if i + 1 < 4 and j + 1 < 4 and shark[2] != [i + 1, j + 1]:
            if fish[i + 1][j + 1] == 0:
                fish[i + 1][j + 1] = fish[i][j]
                dir[i + 1][j + 1] = dir[i][j]
            else:
                temp1 = fish[i + 1][j + 1]
                fish[i + 1][j + 1] = fish[i][j]
                fish[i][j] = temp1
                temp2 = dir[i + 1][j + 1]
                dir[i + 1][j + 1] = dir[i][j]
                dir[i][j] = temp2
        else:
            dir[i][j] += 1
            fish_dir(i, j)
    elif dir[i][j] == 7:
        if j + 1 < 4 and shark[2] != [i, j + 1]:
            if fish[i][j + 1] == 0:
                fish[i][j + 1] = fish[i][j]
                dir[i][j + 1] = dir[i][j]
            else:
                temp1 = fish[i][j + 1]
                fish[i][j + 1] = fish[i][j]
                fish[i][j] = temp1
                temp2 = dir[i][j + 1]
                dir[i][j + 1] = dir[i][j]
                dir[i][j] = temp2
        else:
            dir[i][j] += 1
            fish_dir(i, j)
    elif dir[i][j] == 8:
        if i - 1 >= 0 and j + 1 < 4 and shark[2] != [i - 1, j + 1]:
            if fish[i - 1][j + 1] == 0:
                fish[i - 1][j + 1] = fish[i][j]
                dir[i - 1][j + 1] = dir[i][j]
            else:
                temp1 = fish[i - 1][j + 1]
                fish[i - 1][j + 1] = fish[i][j]
                fish[i][j] = temp1
                temp2 = dir[i - 1][j + 1]
                dir[i - 1][j + 1] = dir[i][j]
                dir[i][j] = temp2
        else:
            dir[i][j] = 1
            fish_dir(i, j)
    return

# 상어 방향
def shark_dir(x,y):
    global dir, fish, shark, shark_out
    i=shark[2][0]
    j=shark[2][1]
    if shark[1] == 1:
        i-=x
        if i - 1 >= 0:
            if fish[i - 1][j] == 0:
                shark[2]=[i - 1,j]
                shark_dir()
            else:
                shark[0] += fish[i - 1][j]
                shark[1] = dir[i - 1][j]
                fish[i - 1][j] = 0
                dir[i - 1][j] = 0
                shark[2] = [i - 1, j]
        else:
            shark_out = True
            return
    elif shark[1] == 2:
        i -= x
        j -= y
        if i - 1 >= 0 and j - 1 >= 0:
            if fish[i - 1][j - 1] == 0:
                shark[2] = [i - 1, j - 1]
                shark_dir()
            else:
                shark[0] += fish[i - 1][j - 1]
                shark[1] = dir[i - 1][j - 1]
                fish[i - 1][j - 1] = 0
                dir[i - 1][j - 1] = 0
                shark[2] = [i - 1, j - 1]
        else:
            shark_out = True
            return
    elif shark[1] == 3:
        j -= y
        if j - 1 >= 0:
            if fish[i][j - 1] == 0:
                shark[2] = [i, j - 1]
                shark_dir()
            else:
                shark[0] += fish[i][j - 1]
                shark[1] = dir[i][j - 1]
                fish[i][j - 1] = 0
                dir[i][j - 1] = 0
                shark[2] = [i, j - 1]
        else:
            shark_out = True
            return
    elif shark[1] == 4:
        i += x
        j -= y
        if i + 1 < 4 and j - 1 >= 0:
            if fish[i + 1][j - 1] == 0:
                shark[2] = [i + 1, j - 1]
                shark_dir()
            else:
                shark[0] += fish[i + 1][j - 1]
                shark[1] = dir[i + 1][j - 1]
                fish[i + 1][j - 1]= 0
                dir[i + 1][j - 1] = 0
                shark[2] = [i + 1, j - 1]
        else:
            shark_out = True
            return
    elif shark[1] == 5:
        i += x
        if i + 1 < 4:
            if fish[i + 1][j] == 0:
                shark[2] = [i + 1, j]
                shark_dir()
            else:
                shark[0] += fish[i + 1][j]
                shark[1] = dir[i + 1][j]
                fish[i + 1][j] = 0
                dir[i + 1][j] = 0
                shark[2] = [i + 1, j]
        else:
            shark_out = True
            return
    elif shark[1] == 6:
        i += x
        j += y
        if i + 1 < 4 and j + 1 < 4:
            if fish[i + 1][j + 1] == 0:
                shark[2] = [i + 1, j+1]
                shark_dir()
            else:
                shark[0] += fish[i + 1][j+1]
                shark[1] = dir[i + 1][j+1]
                fish[i + 1][j+1] = 0
                dir[i + 1][j+1] = 0
                shark[2] = [i + 1, j+1]
        else:
            shark_out = True
            return
    elif shark[1] == 7:
        j += y
        if j + 1 < 4:
            if fish[i][j + 1] == 0:
                shark[2] = [i, j + 1]
                shark_dir()
            else:
                shark[0] += fish[i][j + 1]
                shark[1] = dir[i][j + 1]
                fish[i][j + 1] = 0
                dir[i][j + 1] = 0
                shark[2] = [i, j + 1]
        else:
            shark_out = True
            return
    elif shark[1] == 8:
        i -= x
        j += y
        if i - 1 >= 0 and j + 1 < 4:
            if fish[i - 1][j + 1] == 0:
                shark[2] = [i-1, j + 1]
                shark_dir()
            else:
                shark[0] += fish[i-1][j + 1]
                shark[1] = dir[i-1][j + 1]
                fish[i-1][j + 1] = 0
                dir[i-1][j + 1] = 0
                shark[2] = [i-1, j + 1]
        else:
            shark_out=True
            return
    return

# 물고기 이동
def fish_move():
    global fish
    for k in range(1,17):
        for i in range(4):
            for j in range(4):
                if fish[i][j]==k:
                    fish_dir(i,j)
    return

max_val=shark[0]

def track():
    global max_val, shark
    x=shark[2][0]
    y=shark[2][1]
    num=0
    if max_val < shark[0]:
        max_val = shark[0]

    fish2=[[0 for i in range(4)] for i in range(4)]
    for i in range(4):
        for j in range(4):
            fish2[i][j]=fish[i][j]
    fish_move()
    dir1=shark[1]
    if dir1==1 or dir1==5:
        num=x
    elif dir1==2 or dir1==4 or dir1==6 or dir1==8:
        num=min(x,y)
    elif dir1==3 or dir1==7:
        num=y
    for i in range(3-num):
        val=[0,0,0]
        for i in range(3):
            val[i]=shark[i]
        shark_dir(i,i)
        if shark_out:
            return
        track()
        for i in range(4):
            for j in range(4):
                fish[i][j] = fish2[i][j]
        for i in range(3):
            shark[i] = val[i]
    return

track()
print(max_val)


