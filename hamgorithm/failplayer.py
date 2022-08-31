def solution(participant, completion):
    answer = ''
    t=0
    dic = {}
    for i in participant:
        dic[hash(i)]=i
        t += int(hash(i))
    for i in completion:
        t -= hash(i)
    answer = dic[t]
    return answer