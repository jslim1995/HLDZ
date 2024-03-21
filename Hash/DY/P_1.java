package Hash.DY;
//푸드파이터 대회
class Solution {
    public String solution(int[] food) {
        String answer = "";
        //숫자가 1인 경우는 물 
        // 홀수 인 경우는 짝수 갯수로 맞춰야함
        int cnt  =food.length;//전체 음식의 갯수
        answer = "0";//가운데 물 
        for(int i=cnt-1;i>0;i--)//큰 칼로리부터
        {
            if(food[i]!=1)//1은 물이기 때문에 제외
          {
            int c = food[i]/2;//짝수개의 음식의 양
            for(int j=0;j<c;j++ )
           {
            answer=i+answer+i;//왼쪽사람 큰 칼로리 부터 작은 칼로리 더하기
           }
          }
        }  
        return answer;
    }
}

//피자나눠먹기
class Solution {
    public int solution(int n) {    
        return n/7+(n%7>0?1:0);
    }
}
//옷가게할인
class Solution {
    public int solution(int price) {
        return (int)(price>=100000?(price>=300000?(price>=500000?price-((price*0.2)):price-(price*0.1)):price-((price*0.05))):price);
    }
}
