import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int solution(int[] array) {
        System.out.println(array.length);
        // 1. 배열 오름차순 정렬
        if(array.length == 1) {
            return array[0];
        } else if(array.length < 0) {
            return 0;
        } else {
            Arrays.sort(array);
        }

        // 2. 배열에서 각 숫자가 몇 개씩 있는지 MAP 에 저장
        // MAP 선언
        // Map<Integer, Integer> numCount = new HashMap<Integer, Integer>();
        List<Integer> listNum = new ArrayList<>();
        List<Integer> listCount = new ArrayList<>();
        // count 선언
        int count = 0;
        // index 0 값(num) 확인
        int num = array[0];
        listNum.add(num);
        listCount.add(count);
        // 배열 크기만큼 반복
        for(int idx = 0; idx <= array.length-1; idx++) {
            if(num == array[idx]) {
                // num 값과 동일하면 count 값 증가
                count++;
            } else {
                // num 값과 다르면 map에 num = count 로 저장 후 num, count 초기화
                // numCount.put(num, count);
                listNum.add(num);
                listCount.add(count);
                // numCount에 값 저장
                num = array[idx];
                count = 1;
            }
        }
        listNum.add(num);
        listCount.add(count);
        // 3. MAP 에서 가장 큰 value 를 갖고 있는 key 를 배열로 저장
        Integer sortCount[] = listCount.toArray(new Integer[listCount.size()]);
        Arrays.sort(sortCount);

        System.out.println(sortCount.length);

        int maxCount = sortCount[sortCount.length-1];

        int maxCountIdx = listCount.indexOf(maxCount);
        int answer = listNum.get(maxCountIdx);
        

        // Set<Integer> keySet =  numCount.keySet();
        // for(int i : keySet) {
            
        // }
        // 4. 배열의 크기가 1이면 해당 값 리턴, 그렇지 않으면 -1 리턴
        if(maxCount == sortCount[sortCount.length-2]) {
            return -1;
        } else {
            return answer;
        }
        
            
    }
}