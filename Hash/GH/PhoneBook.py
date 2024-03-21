# PhoneBook.py
# 13점
def solution(phone_book):
    
    phone_book.sort()
    
    # 하나씩 순회
    for idx in range(len(phone_book)-1):
        
        
        # 파이썬의 슬라이싱은 인덱스의 범위를 넘어가도 에러가 발생하지 않는다.
        if phone_book[idx]==phone_book[idx+1][:len(phone_book[idx])]:
            return False
        
    return True
