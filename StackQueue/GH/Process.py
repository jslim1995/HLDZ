# 8점 프로세스
from collections import deque

def solution(priorities, location):
    answer = 0
    waiting_process = deque(enumerate(priorities))
    
    while waiting_process:
        current_process = waiting_process.popleft()
        current_index, current_priority = current_process
        
        # 현재 프로세스의 우선순위가 남은 프로세스 중에서 가장 높은 우선순위인지 확인
        if any(current_priority < priority for _, priority in waiting_process):
            waiting_process.append(current_process)  # 더 높은 우선순위가 있으면 다시 큐에 넣음
        else:
            answer += 1  # 실행한 프로세스 수 증가
            
            # 실행한 프로세스가 목표 위치인지 확인
            if current_index == location:
                break
    
    return answer
