import sys
sys.setrecursionlimit(100000)
sudoku1=[]
for i in range(9):
    sudoku1.append(sys.stdin.readline())
sudoku=[]
for j in range(9):
    temp = []
    for i in range(9):
        temp.append(int(sudoku1[j][i]))
    sudoku.append(temp)

ch=True

def track(x,y):
    global sudoku, ch
    if x==9:
        ch=True
        return
    if sudoku[x][y]==0:
        for s in range(1,10):
            sudoku[x][y] = s
            for i in range(0,9):
                if x!=i and sudoku[i][y]==s:
                    sudoku[x][y] = 0
                    break
            if sudoku[x][y]==0:
                ch = False
                continue
            for j in range(0,9):
                if y!=j and sudoku[x][j]==s:
                    sudoku[x][y]=0
                    break
            if sudoku[x][y]==0:
                ch = False
                continue
            for i in range(3):
                for j in range(3):
                    if (x != (x // 3) * 3 + i or y != (y // 3) * 3 + j) and sudoku[(x // 3) * 3 + i][(y // 3) * 3 + j] == s:
                        sudoku[x][y] = 0
                        break
            if sudoku[x][y]==0:
                ch = False
                continue
            else:
                if y==8:
                    track(x+1,0)
                else:
                    track(x,y+1)
                if ch:
                    break
        if not ch:
            sudoku[x][y] = 0
        return
    else:
        if y == 8:
            track(x + 1, 0)
        else:
            track(x, y + 1)
        return
track(0,0)
for i in sudoku:
    for j in i:
        print(j,end="")
    print()