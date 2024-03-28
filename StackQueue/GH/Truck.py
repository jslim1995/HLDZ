# 다리건너기 11점
from collections import deque
def solution(bridge_length, weight, truck_weights):
    answer = 0

    # 다리 선언 (옆으로 하나씩 밀어내기 위해 큐 선언)
    bridge = deque([0] * bridge_length)
    total_bridge_weight = 0

    while truck_weights or total_bridge_weight > 0:

        # 시간초 추가
        answer += 1
        # 다리 전체에 무게 계산
        total_bridge_weight -= bridge.popleft()

        enable_bridge_weight = weight - total_bridge_weight

        if len(truck_weights) > 0 and enable_bridge_weight >= truck_weights[0] :
            new_truck = truck_weights.pop(0)
            bridge.append(new_truck)
            total_bridge_weight += new_truck

        else :
            bridge.append(0)


    return answer
