def solution(progresses, speeds):
    answer = []
    days=[]
    for i in range(len(progresses)):
        if (100-progresses[i])%speeds[i]==0:
            days.append((100 - progresses[i])//speeds[i])
        else:
            days.append((100 - progresses[i])//speeds[i]+1)

    for i in range(len(days)):
        if days[i]==999:
            continue
        answer.append(1)
        if i==len(days):
            continue
        for j in range(i+1,len(days)):
            if days[i]<days[j]:
                break
            else:
                days[j]=999
                answer[-1] += 1

    return answer