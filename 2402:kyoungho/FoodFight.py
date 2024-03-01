def solution(food):

    food_div = [x//2 for x in food]

    result = ''

    for idx in range(len(food)):

        for _ in range(food_div[idx]):
            result += str(idx)

    answer = result + '0' + result[::-1]
    return answer
