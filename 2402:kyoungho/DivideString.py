def solution(s):
    
    answer = 0
    
    len_string = len(s)
    flag = False
    choose_char = None
    choose_char_count = 0
    another_char_count = 0
    
    
    for idx ,input_char in enumerate(s):
        
        # 마지막 문자일때 무조건 종료
        if idx == len_string -1 :
            answer += 1
        
        # 플래그가 초기화 되었을떄
        elif flag == False :
            choose_char = input_char
            choose_char_count = 1
            another_char_count = 0
            flag = True
            
        else :
            # 선택한 문자랑 같은 문자가 들어올때
            if input_char == choose_char:
                choose_char_count += 1
            
            # 선택한 문자랑 다른 문자가 들어올때
            else :
                another_char_count += 1
                
                # 종료 조건 만족시
                if another_char_count == choose_char_count:
                    flag = False
                    choose_char = None
                    choose_char_count = 0
                    another_char_count = 0
                    answer += 1
                    
    return answer
