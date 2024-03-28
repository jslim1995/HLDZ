# 기능개발 (7점)
def solution(progresses, speeds):
    
    answer = []
    
    # 현재 progresses 진행중인 인덱스
    curt_idx = 0
    
    last_idx = len(progresses) - 1
    
    while curt_idx <= last_idx :
        
        # 하루량 진행
        progresses = [ x + y for x, y in zip(progresses, speeds)]
        
        # 하루 완료량 계산
        count = 0
        
        while curt_idx <= last_idx and progresses[curt_idx] >= 100  :
            count += 1
            curt_idx += 1
            
        # 완료량이 0 이 아닌 경우 추가
        if count != 0:
            answer.append(count)
    
    

    return answer
