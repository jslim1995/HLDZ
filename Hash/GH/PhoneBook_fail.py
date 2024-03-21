#PhoneBook.py
#시간초과

def solution(phone_book):
    answer = True
    
    ## 반복문 수행
    for idx in range(len(phone_book)-1):
        
        for jdx in range(idx+1,len(phone_book)):
            
            ## 앞에 전화번호랑 뒤에 전화번호 길이 작은거 기준으로 비교
            telA = phone_book[idx]
            telB = phone_book[jdx]
            
            minLen = min(len(telA), len(telB))
            
            ## 짧은거 기준으로 비교
            if telA[:minLen] == telB[:minLen] :
                return False
               
    
    return answer
