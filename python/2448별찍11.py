import sys
n=int(sys.stdin.readline())

def star2(star,k):
    temp=len(star)
    if k==2:
        for i in range(temp):
            print(" " * (n-temp - 1 - i) +star[i] + " " * len(star[temp - 1 - i]) + star[i]+ " " * (n-temp - 1 - i))
    else:
        for i in range(temp):
            star.append(star[i]+" "*len(star[temp-1-i])+star[i])
            print(" " * (n-temp - 1 - i) + star[i]+" "*len(star[temp-1-i])+star[i] + " " * (n-temp - 1 - i))

    if k//2==1:
        return
    else:
        answer=star2(star,k//2)
    return answer

star=["*","* *","*****"]
for i in range(len(star)):
    print(" " * (n - 1 - i) + star[i] + " " * (n - 1 - i))
if n!=3:
    star2(star,n//3)

