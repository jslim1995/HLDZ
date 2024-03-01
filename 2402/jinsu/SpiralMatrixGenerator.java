class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int num = 1;    // 나선으로 들어갈 값
        int i = 0;      // 행
        int j = 0;      // 열
        int count = 1;  // 현재 반복 횟수
        int loopCount = (n+1)/2; // 반복 횟수
        for(; count <= loopCount ; count++) {
            for(; j < n - count ; j++) {
                answer[i][j] = num++;
            }
            for(; i < n - count ; i++) {
                answer[i][j] = num++;
            }
            for(; j >= count ; j-- ) {
                answer[i][j] = num++;
            }
            for(; i >= count ; i--) {
                answer[i][j] = num++;
            }
            i++;
            j++;
        }
        // 홀수면 가운대 값 추가...
        if(n%2 == 1) {
            answer[loopCount-1][loopCount-1] = num++;
        }
        return answer;
    }
}