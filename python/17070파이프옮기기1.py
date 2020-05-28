import sys
n=int(sys.stdin.readline())
home=[]
for i in range(n):
    home.append(list(map(int,sys.stdin.readline().split())))

def pipe(r,c,state,cnt):
    if r==n-1 and c==n-1:
        return cnt+1
    if state==0:
        if c<n-1 and home[r][c+1]==0 :
            cnt=pipe(r,c+1,0,cnt)
        if r<n-1 and c<n-1 and home[r+1][c+1]==0 and home[r][c+1]==0 and home[r+1][c]==0 :
            cnt=pipe(r+1,c+1,1,cnt)
        return cnt
    elif state==1:
        if c<n-1 and home[r][c + 1] == 0:
            cnt=pipe(r, c + 1, 0,cnt)
        if r<n-1 and c<n-1 and home[r + 1][c + 1] == 0 and home[r][c + 1] == 0 and home[r + 1][c] == 0:
            cnt=pipe(r + 1, c + 1, 1,cnt)
        if r<n-1 and home[r+1][c] == 0:
            cnt=pipe(r+1, c, 2,cnt)
        return cnt
    elif state==2:
        if r<n-1 and c<n-1 and home[r + 1][c + 1] == 0 and home[r][c + 1] == 0 and home[r + 1][c] == 0:
            cnt=pipe(r + 1, c + 1, 1,cnt)
        if r<n-1 and home[r+1][c] == 0:
            cnt=pipe(r+1, c, 2,cnt)
        return cnt

result=pipe(0,1,0,0)
print(result)
