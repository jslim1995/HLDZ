def solution(n):
    
    
    # 방향 번호
    direction = 0

    dx = [0, 1, 0, -1]
    dy = [1, 0, -1, 0]

    answer = [[-1] * n for _ in range(n)]

    now_x = 0
    now_y = 0

    for i in range(1, n*n+1):
        # 데이터 삽입하기
        if answer[now_x][now_y] == -1:
            answer[now_x][now_y] = i

        # 다음 방향 정하기
        while True:

            # 마지막의 경우 방향 정하기 X
            if i == n*n :
                break

            diff_x = now_x + dx[direction]
            diff_y = now_y + dy[direction]
            if 0 <= diff_x < n and 0 <= diff_y < n and answer[diff_x][diff_y] == -1:
                now_x = diff_x
                now_y = diff_y
                break
            else :
                direction = (direction + 1)%4


    return answer
