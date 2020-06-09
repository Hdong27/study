def solution(N):
    answer = [0, 1]

    for i in range(2, N + 1):
        answer.append(answer[i - 1] + answer[i - 2])

    return answer[-1]*4+answer[-2]*2

print(solution(6))