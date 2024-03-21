# Ponkemon.py
# 2점 정답
def solution(nums):
    answer = 0
    
    unique_list = list(set(nums))   ## 중복값 제거
    
    ## 최대 종류수는 배열의 길이 or 숫자의 종류 갯수 중 작은거
    return min(len(unique_list), len(nums)//2)
