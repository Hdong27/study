# def solve(n,fac):
#     fac1 = []
#     for i in range(len(fac)):
#         for j in range(len(fac[i])):
#             fac1.append(fac[i][:j]+"()"+fac[i][j:])
#     fac2=set(fac1)
#     print(fac2)
#     if n!=2:
#         fac2=solve(n-1,list(fac2))
#     return fac2
#
# def solution(n):
#     fac=['()']
#     if n==1:
#         return 1
#     else:
#         fac3=solve(n,fac)
#         print(fac3)
#         return len(fac3)

def binomial(bin, n, k):
   if n==k or k==0 : return 1
   elif bin[n][k] > 0 : return bin[n][k]
   else :
      bin[n][k] = binomial(bin, n-1, k) + binomial(bin, n-1, k-1)
      return bin[n][k]


def solution(n) :
   bin = [[0 for col in range(2*n + 1)] for row in range(2*n + 1)]
   return binomial(bin, 2*n, n) - binomial(bin, 2*n, n+1)

print(solution(5))
