package lv0_1;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _120812 {

    public static void main(String[] args) {
        Solution Solution = new Solution();
        System.out.println("-------");
        System.out.println(Solution.solution(new int[]{1, 2, 3, 3, 3, 4}));
        System.out.println(Solution.solution(new int[]{1, 1, 2, 2}));
        System.out.println(Solution.solution(new int[]{1}));
    }
}

class Solution {
    public int solution(int[] array) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int arr : array){
            if(map.containsKey(arr)) {
                map.put(arr,map.get(arr)+1);
            }else {
                map.put(arr,1);
            }
        }

        int key = map.entrySet().stream().max((m1, m2) -> m1.getValue() > m2.getValue() ? m1.getValue() : -1).get().getKey();
        int value = map.get(key);
        map.remove(key);

        if(map.containsValue(value)){
            return -1;
        }

        return key;



    }
}

