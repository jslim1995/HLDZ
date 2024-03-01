

/*
 * 피자를 나눠먹을 사람의 수 n이 주어질 때, 
 * 모든 사람이 피자를 한 조각 이상 먹기 위해 필요한 피자의 수를 return 하는 solution 함수를 완성해보세요.
 */
class Pizza {
    public int solution(int n) {
        int answer = 0;
        answer = n/7;
        if(n%7 != 0) {
            answer++;
        }

        return answer;
    }
}