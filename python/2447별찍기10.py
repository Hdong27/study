import sys
n=int(sys.stdin.readline())

def star2(star,n):
    temp = []
    for i in range(len(star)):
        temp.append(i)
    for i in range(len(star)):
        temp[i]=[star[i][0]*3]
    for i in range(len(star)):
        temp.append([star[i][0]+" "*len(star[i][0])+star[i][0]])
    for i in range(len(star)):
        temp.append([star[i][0]*3])
    if n//3==1:
        return temp
    else:
        answer=star2(temp,n//3)
    return answer

star=[["*"]]
answer=star2(star,n)
for i in answer:
    print(i[0])




