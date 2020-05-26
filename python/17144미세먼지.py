import sys
sys.setrecursionlimit(100000)
def cycle(C, R, T,munji):
    m = []
    munji2 = []
    for i in range(C):
        temp = []
        for j in range(R):
            temp.append(munji[i][j])
        munji2.append(temp)
    for i in range(C):
        for j in range(R):
            if munji[i][j] == 0:
                continue
            elif munji[i][j] == -1:
                m.append(i)
                continue
            else:
                cnt = 0
                if j > 0 and munji2[i][j - 1]!=-1:
                    cnt = cnt + 1
                    munji2[i][j - 1] += munji[i][j] // 5

                if i > 0 and munji2[i - 1][j]!=-1:
                    cnt = cnt + 1
                    munji2[i - 1][j] += munji[i][j] // 5
                if j < R - 1:
                    cnt = cnt + 1
                    munji2[i][j + 1] += munji[i][j] // 5
                if i < C - 1 and munji2[i + 1][j]!=-1:
                    cnt = cnt + 1
                    munji2[i + 1][j] += munji[i][j] // 5

                munji2[i][j] = munji2[i][j] - (munji[i][j] // 5) * cnt

    for i in range(m[0] - 1, -1, -1):
        if i == 0:
            munji2[i][0] = munji2[i][1]
        else:
            munji2[i][0] = munji2[i - 1][0]
    for i in range(R):
        if i == 0:
            continue
        if i == R - 1:
            munji2[0][i] = munji2[1][i]
        else:
            munji2[0][i] = munji2[0][i + 1]
    for i in range(m[0] + 1):
        if i == 0:
            continue
        if i == m[0]:
            munji2[i][R - 1] = munji2[i][R - 2]
        else:
            munji2[i][R - 1] = munji2[i + 1][R - 1]
    for i in range(R - 1, 0, -1):
        if i == R - 1:
            continue
        if i == 1:
            munji2[m[0]][i] = 0
        else:
            munji2[m[0]][i] = munji2[m[0]][i - 1]

    for i in range(m[1] + 1, C, 1):
        if i == C - 1:
            munji2[i][0] = munji2[i][1]
        else:
            munji2[i][0] = munji2[i + 1][0]
    for i in range(R):
        if i == 0:
            continue
        if i == R - 1:
            munji2[C-1][i] = munji2[C-2][i]
        else:
            munji2[C-1][i] = munji2[C-1][i + 1]
    for i in range(C - 1, m[1] - 1, -1):
        if i == C - 1:
            continue
        if i == m[1]:
            munji2[i][R - 1] = munji2[i][R - 2]
        else:
            munji2[i][R - 1] = munji2[i - 1][R - 1]
    for i in range(R - 1, 0, -1):
        if i == R - 1:
            continue
        if i == 1:
            munji2[m[1]][i] = 0
        else:
            munji2[m[1]][i] = munji2[m[1]][i - 1]
    if T==1:
        return munji2
    else:
        return cycle(C,R,T-1,munji2)



c,r,t=list(map(int, input().split()))
munji=[]
for i in range(c):
    munji.append(list(map(int,input().split())))

munji3 = cycle(c, r, t, munji)
answer = 0
for i in range(c):
    for j in range(r):
        if munji3[i][j] == -1:
            continue
        else:
            answer = answer + munji3[i][j]
print(answer)