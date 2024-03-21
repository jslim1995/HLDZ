import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;
class Solution {
    public int solution(int[] nums) {
       int max =  Arrays.stream(nums).boxed()//스트림 생성
            .distinct().count();
        return answer;
    }
}

import java.util.Arrays;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
       String[] a =phone_book;
        int cnt =phone_book.length;
        for(int i =0 ; i<cnt;i++)
        {
            if((int)Arrays.stream(phone_book).filter(x->(x==a[i])).count() <= 2)
            {
                answer=false;
                break;
            }
           
        }
        return answer;
    }
}