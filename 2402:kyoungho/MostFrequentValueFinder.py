def solution(array):
    
    if len(array) == 1:
        return array[0]
    
    frequency = {}
    
    for ele in array:
        # 딕셔너리에 없으면 추가하기
        if ele not in frequency : 
            frequency[ele] = 1
        else :
            frequency[ele] += 1
            
    sorted_dict = dict(sorted(frequency.items(), key=lambda item: item[1], reverse= True))
    sorted_key_list = list(sorted_dict.keys())
    
    
    # 한종류 밖에 안나온 경우 리턴
    if len(sorted_key_list) == 1:
        return sorted_key_list[0]
    
    
    first_key = sorted_key_list[0]
    second_key = sorted_key_list[1]
    
    if frequency[first_key] == frequency[second_key]:
        return -1
    else :
        return first_key

