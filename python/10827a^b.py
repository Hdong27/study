import sys
from decimal import *
getcontext().prec=3000
a,b=map(str,sys.stdin.readline().split())

print(Decimal(a)**Decimal(b))