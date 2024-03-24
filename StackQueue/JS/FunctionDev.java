package StackQueue.JS;

import java.util.ArrayList;
import java.util.List;

/**
 * FunctionDev
 * 8 점...
 */
public class FunctionDev {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> listProgresses = new ArrayList<>();
        for (int value : progresses) {
            listProgresses.add(value);
        }

        List<Integer> listSpeeds = new ArrayList<>();
        for (int value : speeds) {
            listSpeeds.add(value);
        }

        ArrayList<Integer> listDepNum = new ArrayList<>();

        while (listProgresses.size() > 0) {
            for (int i = 0; i < listProgresses.size(); i++) {
                listProgresses.set(i, listProgresses.get(i) + listSpeeds.get(i));
            }
            int count = 0;
            while (listProgresses.size() > 0 && listProgresses.get(0) >= 100) {
                listProgresses.remove(0);
                listSpeeds.remove(0);
                count++;
            }
            if (count > 0) {
                listDepNum.add(count);
            }
        }

        // ArrayList를 int[]로 변환
        int[] answer = new int[listDepNum.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = listDepNum.get(i);
        }
        return answer;
    }
    
}