import sys
m,n=map(int,sys.stdin.readline().split())

s=[]
def cal(m,n):
    if m==0:
        s.append("0")
        return
    if n==10:
        s.append(str(m))
        return
    temp1=str(m%n)
    if temp1=='10':
        temp1="A"
    elif temp1=='11':
        temp1="B"
    elif temp1=='12':
        temp1="C"
    elif temp1=='13':
        temp1="D"
    elif temp1=='14':
        temp1="E"
    elif temp1=='15':
        temp1="F"
    s.append(temp1)
    temp=m//n
    if temp>=n:
        cal(temp,n)
    else:
        if temp == 10:
            s.append("A")
        elif temp == 11:
            s.append("B")
        elif temp == 12:
            s.append("C")
        elif temp == 13:
            s.append("D")
        elif temp == 14:
            s.append("E")
        elif temp == 15:
            s.append("F")
        elif 0<temp<10 :
            s.append(str(temp))
    return

cal(m,n)
print("".join(reversed(s)))

