import java.util.Arrays;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        //stream을 활용하여 중복 없애기 // 배열안의 포켓몬 총 종류의 수
        int max =  (int)Arrays.stream(nums).boxed()//스트림 생성
            .distinct().count();
        answer = (nums.length/2) <=max?(nums.length/2):max;
        return answer;
    }
}