def solution(N, number):
    S = [{N}]
    for i in range(2, 9):
        case_set = {int(str(N)*i)}
        for x_idx in range(int(i/2)):
            for x in S[x_idx]:
                for y in S[i - x_idx - 2]:
                    case_set.add(x+y)
                    case_set.add(x-y)
                    case_set.add(y-x)
                    case_set.add(x*y)
                    if x!=0:
                        case_set.add(y//x)
                    if y!=0:
                        case_set.add(x//y)
        if number in case_set:
            return i
        S.append(case_set)
    return -1

print(solution(5,11))