# BestAlbum.py
# 점수 기억안남
def solution(genres, plays):
    answer = []
    
    # 장르 횟수
    genre_count = {}
    new_array = []
    
    
    # 장르 카운팅 및 새로운 배열 (장르, 횟수, 인덱스) 생성
    for idx in range(len(genres)):
        
        genre = genres[idx]
        count = plays[idx]
        
        if genre not in genre_count:
            genre_count[genre] = count
        else:
            genre_count[genre] += count
            
        new_array.append([genre, count, idx])
            
    for ele in new_array:
        ele[0] = genre_count[ele[0]]
    
    sorted_new_array = sorted(new_array, key=lambda x: (-x[0], -x[1], x[2]))
    
    # 선택된 장르
    picked = {}
    
    # 장르 전체 재생횟수(장르), 현재곡 재생 횟수, 앨범 인덱스
    for genre_total_count, count, idx  in sorted_new_array:
        
        if genre_total_count not in picked :
            picked[genre_total_count] = 1 # 하나 들어왔다는 의미
            answer.append(idx)
            
        elif picked[genre_total_count] == 1:
            picked[genre_total_count] += 1 # 두개 들어옴
            answer.append(idx)
            
    
    return answer

