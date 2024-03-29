package StackQueue.JS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Process
 * 9점...
 */
public class Process {
    public int solution(int[] priorities, int location) {
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> locations = new LinkedList<>();
        int num = 0;
        int count = 1;
        for (int priority : priorities) {
            queue.add(priority);
            locations.add(num++);
        }
        Arrays.sort(priorities);
        while (queue.peek() != null) {
            if (queue.peek() == priorities[priorities.length - count]) {
                queue.poll();
                if (locations.poll().equals(location)) {
                    break;
                } else {
                    count++;
                }
            } else {
                queue.add(queue.poll());
                locations.add(locations.poll());
            }

        }
        return count;
    }
    
}